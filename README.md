# Two Factor Authentication - Securing Text Message (Information Security)

This project requirement is to implement a 2 Factor Authentication, finding a solution to make the text factor more secure.
It is designed using MVC pattern in Spring Framework.

## Outcome: 
This tool offer a viable alternative solution to improve security in a multi factor authentication system.

## Process:
The login page show the login form. After correct credentials are submitted, the server side of the application generates a random salt and a Session Key, this last is saved in the client browser session. Finally the server send the OPT via mobile text.

In addition to its use as second factor, the OTP is used in conjunction with the random salt to re-generate and verify the Session Key stored in the browser. In case of a match, the user is authenticated.

## Results:
If the text part is hacked, it is not possible to login. This happens due to the fact that the Session Key initially saved in the browser session will not match with the one generate with the OTP. In this way the text part of the 2FA is made secure.

## 
### Final considerations: 
The downside of this implementation is that in case both the client browser session and the OTP are compromised (i.e. session hijacking + man in the middle for the second factor), this may create a vulnerability on the system with a real way of exploitation. But this implementation is fare more robust than a plain basic implementation of 2FA.
