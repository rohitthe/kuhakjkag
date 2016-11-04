package com.pack.utilitySDP;

import java.io.InputStream;
import java.util.Properties;

public class FetchData {
	
	public InputStream filePath()
	{
	
		InputStream path=getClass().getClassLoader().getResourceAsStream("config.properties");
		return path;
	}
	public   static String readProperty(String propertyName) throws Exception
	{
		String propertyValue=null;
		Properties property=new Properties();
		InputStream inputStream=null;
		try {
			inputStream= new FetchData().filePath();
			property.load(inputStream);
			propertyValue=property.getProperty(propertyName);
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		throw  new Exception("Error in reading property file");
		}
		return propertyValue;
	}
}
