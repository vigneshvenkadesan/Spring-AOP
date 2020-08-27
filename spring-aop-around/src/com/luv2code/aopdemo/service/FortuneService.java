package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class FortuneService {

	public String getFortune()
	{
		try {
			TimeUnit.SECONDS.sleep(3);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return "It's time to have tea";
	
	}
	
	
}
