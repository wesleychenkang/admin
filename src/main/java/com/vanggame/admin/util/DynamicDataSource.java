package com.vanggame.admin.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource{

	public static final String DATASOURCE_FAQ="faqSource";
	public static final String DATASOURCE_SNS="snsSource";
	
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	
	public static void setDBType(String dbType) {  
        contextHolder.set(dbType);  
    }
	
	 public static String getDBType() {  
	        return contextHolder.get();  
	    }
	
	public static void clearDBType() {  
        contextHolder.remove();  
    }
	
	@Override
	protected Object determineCurrentLookupKey() {
		return getDBType();
	}
	
}
