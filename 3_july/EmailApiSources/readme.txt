The api consists of three classes
1.EmailValidation
               This class contains a single static function "boolean test(String Email)" email is passed as an arguement and if its valid it returns true else false
2.EmailVerification
              This class contains one construcor and one public function .
		The constructor is used to intiliase which email address will send the verification code 
			"EmailVerification(String email,String Password)"
 		The function "String getVerificationCode(String email)" genrates a random code and sends to 		the given email and returns the generated code.
3.EmailCompose
	This class contains one construcor and seven public function .
		The constructor is used to intiliase which email address will send the mail. 
			"EmailCompose(String email,String Password)"
		The function "void setSubject(String sub)" is used to set the subject of the mail
		The function "void setMessage(String msg)" is used to set the message/body 		of the mail
		The function "void addRecievers(String[ ] rec)"  and "void addRecievers(String[] rec)" are used to set the recievers of the mail
		The function "void addCarbonCopy(String[ ] rec)"  and "void addCarbonCopy(String[ ] rec)" are used to set the recievers of the 		mail who will recieve carbon coby.
		The function "void sendMail()" is used to send the mail