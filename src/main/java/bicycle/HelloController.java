package bicycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Controller
public class HelloController {
	private static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
	private static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
	private static final String MANAGER_PHONENUM = System.getenv("MANAGER_PHONENUM");
	private static final String MY_PHONENUM = System.getenv("MY_PHONENUM");
	
	@GetMapping("/")
	public String hello() {
		 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		 
		 Message message = Message.creator( 
				 new PhoneNumber(MY_PHONENUM), 
				 new PhoneNumber(MANAGER_PHONENUM),
				 "This is the ship that made the Kessel Run in fourteen parsecs?") 
				 .create();
		 
		 System.out.println(message.getSid());
	    
		return "hello";
	}
}
