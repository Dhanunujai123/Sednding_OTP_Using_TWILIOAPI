package com.project.sendOtpToPhone.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sendOtpToPhone.conifiguration.OtpTwilioConfiguration;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Service
public class OtpService {

    @Autowired
    private OtpTwilioConfiguration OtpTwilioConfiguration;
    
    Map<String,String> otpMap=new HashMap<String,String>();

    public String sendOtpToPhone( String mobileNumber) {
        // use otpTwilioConfiguration here
    	
    	String otp=generateOtp();
    	PhoneNumber reciepientPhoneNumber=new PhoneNumber(mobileNumber);
    	PhoneNumber senderPhoneNumber=new PhoneNumber(OtpTwilioConfiguration.getPhoneNumber());
    	String msgBody="Your One time password is :" +otp;
    	Message message= Message.creator(reciepientPhoneNumber,senderPhoneNumber,msgBody).create();
    	otpMap.put(msgBody, otp);
        return "OTP is  send successfully to the Mobile Number !";
    }
    private String generateOtp() {
    	int otp=(int) (Math.random() * 1000000);
    	return String.format("%06d",otp);
    	//return null;
    }
	public String validateOtp(String otp) {
		// TODO Auto-generated method stub
		Set<String> keys=otpMap.keySet();
		String value=null;
		for(String key:keys)
			value=otpMap.get(key);
		if(value.equals(otp))
			return " OTP Validated Successfully !";
		else
			return "Invalid OTP";		
		
	}
}
