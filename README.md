# 2FA Secure Text

This is a project made for the University class: 780 - Internet Security.

It has been asked to implement a 2 Factor Authentication, trying to find a solution to make the text factor secure.
It is designed using MVC pattern in Spring Framework. The login page show the login form, after submitted correct input, the app creates an hash code saved in session, and send the text with the OPT. The opt is verified by the browser and double checked with the hash code.
If the text part is hacked, it is impossible to login due to the hash code saved in the browser session.
Hence, the text part of the 2FA is more secure.
