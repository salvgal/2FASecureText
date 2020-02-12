# Two Factor Authentication - Securing Text Message (Information Security)

This project requirement is to implement a 2 Factor Authentication, finding a solution to make the text factor secure.
It is designed using MVC pattern in Spring Framework.

Outcome: This tool offer a viable alternative solution to improve security in a multi factor authentication system.

Process:
The login page show the login form, after submitted correct input, the app creates an hash code saved in session, and send the OPT via mobile text. The opt is also the key for the hash code, and it is verified by the browser and in case of a match, the user is authenticated.
If the text part is hacked, it is not possible to login due to the hash code saved in the browser session. Hence, the text part of the 2FA is made secure.
