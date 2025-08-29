package com.project.sendOtpToPhone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.sendOtpToPhone.conifiguration.OtpTwilioConfiguration;
import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SendOtpToPhoneApplication {

	@Autowired
	private OtpTwilioConfiguration otpTwilioConfiguration;
	
	@PostConstruct
	public void setup() {
		Twilio.init(otpTwilioConfiguration.getAccountsid(), otpTwilioConfiguration.getAuthToken());
	}
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(SendOtpToPhoneApplication.class, args);
	}

}
