package com.jcg.examples.viewBean;

public class LoginBean
{
		private String username;
		
		private String password;
		
		private String otp;
		
		private String salt;
		
		public String getUsername()
		{
				return this.username;
		}

		public void setUsername(String username)
		{
				this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getOtp() {
			return otp;
		}

		public void setOtp(String otp) {
			this.otp = otp;
		}

		public String getSalt() {
			return salt;
		}

		public void setSalt(String salt) {
			this.salt = salt;
		}
		
}
