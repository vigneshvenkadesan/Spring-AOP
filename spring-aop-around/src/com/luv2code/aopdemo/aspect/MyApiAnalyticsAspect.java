package com.luv2code.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.AroundAdviceWithLoggingDemoApp;

@Aspect
@Component
@Order(-99)
public class MyApiAnalyticsAspect {

	public static Logger myLogger = Logger.getLogger(AroundAdviceWithLoggingDemoApp.class.getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.FortuneService.getFortune())")
	public Object aroundAdvice(
					ProceedingJoinPoint theJoinPoint) throws Throwable {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();

		
		long begin = System.currentTimeMillis();
		
		Object result = theJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		long duration = end-begin;
		
		myLogger.info("\n ====> Around Advice");
		myLogger.info("\n \t Duration  "+ duration/1000 +"secs");
		
		return result;
		
	}

	@Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		myLogger.info("\n=====>>> Performing API analytics");		
	}
}
