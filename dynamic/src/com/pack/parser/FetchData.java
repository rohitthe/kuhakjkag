package com.pack.parser;

import com.pack.service.Service;
import com.pack.utility.FetchProperty;

public class FetchData {
private static String message=null;
private static String data="";

public static String getData(String url)
{
	if(url==null)
	{
		
		try {
			
			message=FetchProperty.readProperty("URL_ERROR");
			throw new Exception(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else
	{
		try {
			data=Service.sendGET(url);

			return data;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	return data;
}
public static String getMessage() {
	return message;
}
public static void setMessage(String message) {
	FetchData.message = message;
}
public static String getData() {
	return data;
}
public static void setData(String data) {
	FetchData.data = data;
}

}
