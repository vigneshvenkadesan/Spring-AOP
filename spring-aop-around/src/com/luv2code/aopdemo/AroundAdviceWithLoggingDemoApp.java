package com.luv2code.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.FortuneService;

public class AroundAdviceWithLoggingDemoApp {
	
	public static Logger myLogger = Logger.getLogger(AroundAdviceWithLoggingDemoApp.class.getName());
	

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		FortuneService theFortuneService = context.getBean("fortuneService", FortuneService.class);
		
		// call method to find the accounts
		
		myLogger.info("\n==> Running Main Class");
		
		String data=theFortuneService.getFortune();
		myLogger.info("\n");
		
		myLogger.info(data);
		
		
		
		myLogger.info("\n Closed");
		
		// close the context
		context.close();
	}

}










