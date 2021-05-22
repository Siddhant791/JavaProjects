package com.siddhant.demo;

import com.siddhant.interfaces.Coach;
import com.siddhant.interfaces.FortuneServices;

public class BaseBallCoach implements Coach {
	
	public FortuneServices fortuneService;
	
	public BaseBallCoach(FortuneServices fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public void getDailyWorkout() {
		System.out.println("Run 100 meters as warmup");
	}
	
	@Override
	public String getFortuneService() {return this.fortuneService.getFortune();}

	@Override
	public String getEmailAddress() {
		// TODO Auto-generated method stub
		return null;
	}
}
