package com.project.sendOtpToPhone.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.sendOtpToPhone.service.OtpService;

@RestController
public class HomeController {
	
	@Autowired
	private OtpService otpService;
	//Test API
	
	@GetMapping("/welcome")
	public String home() {
		return "Welcome to Spring boot project for sending OTP  to the Mobile Number.";
	}
	@PostMapping("/sendOtp")
	public String sendOtp( @RequestParam String mobileNumber) {
		return otpService.sendOtpToPhone(mobileNumber);
	}

	@PostMapping("/verifyOtp")
	public String verifyOtp( @RequestParam String otp) {
		return otpService.validateOtp(otp);
}
}
