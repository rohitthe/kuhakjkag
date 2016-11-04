package com.pack.utilitySDP;

import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class ReadXMLFile {
	private static  String xmlData=null;
	
	public  String  filePath(String data)
	{
	
		String path=getClass().getClassLoader().getResource(data).getPath();
		return path;
	}
	
  public static String XmlDataRetriver(String data) {

    try {
    	
	File fXmlFile = new File(new ReadXMLFile().filePath(data));
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
	
	doc.getDocumentElement().normalize();
	  OutputFormat format    = new OutputFormat (doc); 
      // as a String
      StringWriter stringOut = new StringWriter ();    
      XMLSerializer serial   = new XMLSerializer (stringOut,format);
      serial.serialize(doc);
      // Display the XML
      xmlData=stringOut.toString();
      System.out.println(stringOut.toString());
    } catch (Exception e) {
	e.printStackTrace();
	return xmlData;
    }
    
	return xmlData;
	
  }

}