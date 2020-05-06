# Two Factor Authentication - Securing Text Message (Information Security)

This project requirement is to implement a 2 Factor Authentication, and finding a solution to make the text factor more secure.
It is designed using MVC pattern in Spring Framework.

## Outcome: 
This tool offer a viable alternative solution to improve security in a multi factor authentication system.

## Process:
The login page show the login form. After correct credentials are submitted, the server side of the application generates a random salt and a Session Key, this last is saved in the client browser session. Finally the server send the OPT via mobile text.

The OTP is additionally used in conjunction with the random salt to verify the Session Key in the browser. In case of a match, the user is authenticated.

## Results:
If the text part is hacked, it is not possible to login due to the Session Key saved in the browser session will not match with the one generate with the OTP. In this way the text part of the 2FA is made secure.

### Final considerations: 
The downside of this implementation is that if both the OTP and the client browser session is compromised (i.e. session hijacking), this may create a real vulnerability on the system.
