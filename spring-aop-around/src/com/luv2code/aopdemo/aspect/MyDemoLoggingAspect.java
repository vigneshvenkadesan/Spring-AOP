package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(10)
public class MyDemoLoggingAspect {
	
	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning="result")
	public void afterExecution(JoinPoint theJoinPoint, List<Account> result)
	{
		
		
		String method = theJoinPoint.getSignature().toShortString();
		
		System.out.println("\n \t @After Execution ====>   "+ method);
		
		System.out.println("\n \t @After printing Execution  result====>   "+ result);
		
		
		modifyName(result);
		
		System.out.println("\n \t @After Execution Modified Name result====>   "+ result);
		
		
	}
	
	private void modifyName(List<Account> result) {
		// TODO Auto-generated method stub
		
		for(Account temp: result)
		{
			String name = temp.getName();
			name= "Mr." + name;
			temp.setName(name);
			
		}
		
	}

	@Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {		
		System.out.println("\n=====>>> Executing @Before advice on method hello");		
	}
	
	
}










