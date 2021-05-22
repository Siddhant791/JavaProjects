package com.siddhant.main;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.siddhant.interfaces.Coach;

public class App {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Coach coach = new Cricket();
//		coach.getDailyWorkout();
		Map<String,String> x = new LinkedHashMap<String, String>();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach baseBallCoach = context.getBean("myBaseBallCoach", Coach.class);
		Coach cricketCoach = context.getBean("myCriketCoach",Coach.class);
		baseBallCoach.getDailyWorkout();
		System.out.println(baseBallCoach.getFortuneService());
		System.out.println(cricketCoach.getFortuneService()+" "+cricketCoach.getEmailAddress());
		context.close();
	}

}
