package com.vanggame.admin.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DataSourceAspect {

	@Pointcut("execution(* com.vanggame.sns.service..*(..))")
	public void sns(){};
	
	@Pointcut("execution(* com.vanggame.faq.service..*(..))")
	public void faq(){};
	
	@Before("sns()")
	public void setSnsDataSource(JoinPoint jp){	
			DynamicDataSource.setDBType(DynamicDataSource.DATASOURCE_SNS);
	}
	
	@Before("faq()")
	public void setFaqDataSource(JoinPoint jp){	
			DynamicDataSource.setDBType(DynamicDataSource.DATASOURCE_FAQ);
	}
}
