package com.jcg.examples.controller;

import java.security.SecureRandom;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jcg.examples.delegate.LoginDelegate;
import com.jcg.examples.utils.HmacGenerator;
import com.jcg.examples.utils.HttpClient;
import com.jcg.examples.viewBean.LoginBean;



@Controller
public class LoginController
{
		@Autowired
		private LoginDelegate loginDelegate;

		@RequestMapping(value="/login",method=RequestMethod.GET)
		public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, LoginBean loginBean)
		{
			ModelAndView model = new ModelAndView("login");
			//LoginBean loginBean = new LoginBean();
			model.addObject("loginBean", loginBean);
			return model;
		}
		@RequestMapping(value="/login",method=RequestMethod.POST)
		public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean)
		{
				ModelAndView model= null;
				try
				{
						//Check if user is valid
						boolean isValidUser = loginDelegate.isValidUser(loginBean.getUsername());
						if(isValidUser)
						{
								String phoneNumber = loginDelegate.getPhoneNumber(loginBean.getUsername());
								
								//1. Generate random salt
								SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
							    byte[] salt = new byte[16];
							    sr.nextBytes(salt);
							    String printedSalt = "";
							    for(int i = 0; i<16; i++) {
							        printedSalt+=salt[i];
							        printedSalt+=",";
							    }
								
								//3. Generating OTP used 
								Random r = new Random();
								String otp = new String();
								for(int i=0 ; i < 8 ; i++) {
									otp += r.nextInt(10);
								}
								
								//Generate Session KEY
								String key = HmacGenerator.generateHmacSHA256Signature(printedSalt, otp);
								loginDelegate.setKey(key);
								
								//send OTP via SMS
								HttpClient http = new HttpClient();
								System.out.println("Testing 1 - Send Http GET request");
								http.sendGet(otp, phoneNumber);
								
							    //Random salt sent in login page of the client
								request.getSession().setAttribute("loggedInUser", loginBean.getUsername());
								request.getSession().setAttribute("salt", printedSalt);
								model = new ModelAndView("login2");
								
						}
						else
						{
								model = new ModelAndView("login");
								request.setAttribute("message", "Invalid credentials!!");
						}

				}
				catch(Exception e)
				{
						e.printStackTrace();
				}

				return model;
		}
		
		
		@RequestMapping(value="/login2",method=RequestMethod.POST)
		public ModelAndView executeLogin2(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean)
		{
				ModelAndView model= null;
				try
				{			
						//Received salt from client
						String salt = loginBean.getSalt();
						
						//Received otp from client
						String otp = loginBean.getOtp();
												
						if(otp!=null && salt!=null){
							
							//Case when otp field left empty
							if(otp.equals("")){
								model = new ModelAndView("login2");
								request.setAttribute("message", "Invalid OTP!!");
							}
							else{
								//Compare Session Key from client with the one saved in session
								String keyCheck = HmacGenerator.generateHmacSHA256Signature(salt, otp);
								boolean checker = keyCheck.equals(loginDelegate.getKey());
		
								if(checker){
									//show welcome page
									model = new ModelAndView("welcome");
								}
								else
								{
										//wrong key - show login page again
										model = new ModelAndView("login2");
										request.setAttribute("message", "Invalid OTP!!");
								}
							}
						}
				}
				catch(Exception e)
				{
						e.printStackTrace();
				}

				return model;
		}
		
		
}