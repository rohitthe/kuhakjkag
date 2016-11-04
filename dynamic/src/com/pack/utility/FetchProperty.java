package com.pack.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

public class FetchProperty {

	public   static String readProperty(String propertyName) throws Exception
	{
		String propertyValue=null;
		Properties property=new Properties();
		InputStream inputStream=null;
		try {
			inputStream= new FetchProperty().filePath();
			property.load(inputStream);
			propertyValue=property.getProperty(propertyName);
						
		} catch (Exception e) {
			// TODO: handle exception
			//Logger log =Logger.getLogger(FetchProperty.class);
			//log.error(e);
			e.printStackTrace();
			throw  new Exception("Error in reading property file");
		}
		return propertyValue;
	}
	public InputStream filePath()
	{
	
		InputStream path=getClass().getClassLoader().getResourceAsStream("config.properties");
		return path;
	}
	
	public String filePathOutput()
	{
	
		String path="C:\\Users\\Digvijay_Singh07\\workspace\\TestingWeb\\resouces\\config.properties";
		return path;
	}

	public static    void writeProperty(String propertyName,String propertyValue) throws Exception
	{
	
		Properties property=new Properties();
		FileOutputStream output = null;
		File f = new File(new FetchProperty().filePathOutput());
		InputStream inputStream=null;
		try {
			
			inputStream= new FetchProperty().filePath();
		
			property.load(inputStream);
			output = new FileOutputStream(f);
			// set the properties value
			property.put(propertyName, propertyValue);
			//property.setProperty(propertyName, propertyValue);
			

			// save properties to project root folder
			property.store(output, null);
			inputStream.close();
						
		}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	throw  new Exception("Error in writing property file");
	}
		 finally {

	            try {
	            	output.close();
	            } catch (Exception ex) {
	            	ex.printStackTrace();
	        		throw  new Exception("Error in closing Fileputputstream file");
	            }
	        }
	}
	}

