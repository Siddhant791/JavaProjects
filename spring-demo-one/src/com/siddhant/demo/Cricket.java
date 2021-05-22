package com.siddhant.demo;

import com.siddhant.interfaces.Coach;
import com.siddhant.interfaces.FortuneServices;

public class Cricket implements Coach{
	
	private FortuneServices fortuneService;
	private String emailAddress;
	
	public void getDailyWorkout() {
		System.out.println("I am cricket coach");
	}

	@Override
	public String getFortuneService() {
		// TODO Auto-generated method stub
		return this.fortuneService.getFortune();
	}

	public void setFortuneService(FortuneServices fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
}
