package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.FortuneService;

public class AroundAdviceDemoApp {
	
	

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		FortuneService theFortuneService = context.getBean("fortuneService", FortuneService.class);
		
		// call method to find the accounts
		
		System.out.println("\n==> Running Main Class");
		
		String data=theFortuneService.getFortune();
		System.out.println("\n");
		
		System.out.println(data);
		
		
		
		System.out.println("\n Closed");
		
		// close the context
		context.close();
	}

}










