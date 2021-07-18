package OOP;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class tWILLOtEST {
    

    public static void main(String[] args) {
        Twilio.init("ACd4239cce1ba6582685cd0ba7023d57e9", "d7e9e55ce09a7ff3ab7b94c648beb20f");
        Message message = Message.creator(
            new PhoneNumber("+919537670547"),
            new PhoneNumber("+15103909234"),
            "OTP")
        .create();
        System.out.println(message.getTo());
    }
}
