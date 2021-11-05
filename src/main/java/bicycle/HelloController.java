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
	
	@GetMapping("/")
	public String hello() {
		 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		 
		 Message message = Message.creator( 
				 new PhoneNumber("+821056271824"), 
				 new PhoneNumber("+19528007566"),
				 "This is the ship that made the Kessel Run in fourteen parsecs?") 
				 .create();
		 
		 System.out.println(message.getSid());
	    
		return "hello";
	}
}
