package com.pack.parser;

import java.io.File;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.pack.jobscreation.JobBuild;
import com.pack.utility.FetchProperty;


@ManagedBean
@RequestScoped
public class ConfigParser {

public static String message=null;
private static String buildName=null;
private static String path=null;
private static String option=null;
	public static String parser(String url,String jobId,String vcsId,String buildId,String buildStepsId)
	{
		try {
			
			JobBuild job=new JobBuild();
			File xmlFile=new File(url);
			int i=0;
			for (File file : xmlFile.listFiles()) {
//				+"\\"+FetchProperty.readProperty("STANDARD_FILENAME");
			
					
				
				
			buildName=file.getName();
	
			file=new File(file.getAbsolutePath()+"\\"+FetchProperty.readProperty("STANDARD_FILENAME"));
		
			String fileName=file.getAbsolutePath();
			if (buildName==null)
			{
			message=FetchProperty.readProperty("FILE_NAME_ERROR");
			throw new Exception(FetchProperty.readProperty("FILE_NAME_ERROR"));	
			}
			path=parseConfig(fileName)+"\\workspace";
			option=parseConfigThreshold(fileName);
		
			Thread.sleep(3000);
			++i;
			job.build(fileName, buildName,jobId+i,vcsId+i,buildId+i,buildStepsId+i,path,option);
			
		}
			return "Success";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			return "failure";
		
		
		
	}
	public static String parseUrl(String url) throws Exception 
	
	{
		String filename=null;
		if(url==null)
		{
			message=FetchProperty.readProperty("URL_ERROR");
			
			throw new Exception(FetchProperty.readProperty("URL_ERROR"));
		}
		else
		{
		
			try {
				filename=url.substring(url.lastIndexOf("\\")+1,url.length());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		return filename;
	}

public  String getMessage() {
		return message;
	}
	public  void setMessage(String message) {
		ConfigParser.message = message;
	}
	
	public static String parseConfig(String fileName)
	{
		String vcs=null;
		String path=null;
		File xmlFile=new File(fileName);
		try
		{
		DocumentBuilderFactory dbfactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder  documentBuilder=dbfactory.newDocumentBuilder();
		Document document=documentBuilder.parse(xmlFile);
		document.getDocumentElement().normalize();
		NodeList nList = document.getElementsByTagName("scm");
		vcs=nList.item(0).getAttributes().getNamedItem("plugin").getNodeValue();
		
		if (vcs.contains(FetchProperty.readProperty("pluginSubversion")))
		{
			 nList = document.getElementsByTagName("remote");
			 path=nList.item(0).getTextContent();
		}
		else if(vcs.contains(FetchProperty.readProperty("pluginFileSystem")))
		{
			 nList = document.getElementsByTagName("path");
			 path=nList.item(0).getTextContent();
		}
		
		
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return path;
		
	}
	public static String parseConfigThreshold(String fileName)
	{
		String ordinal=null;
		String option="0";
		File xmlFile=new File(fileName);
//		for (File file : xmlFile.listFiles()) {
////			+"\\"+FetchProperty.readProperty("STANDARD_FILENAME");
//			try {
//				file=new File(file.getAbsolutePath()+"\\"+FetchProperty.readProperty("STANDARD_FILENAME"));
//				System.out.println("+++++File name is +++++++"+file.getName());
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
		
		try
		{
		DocumentBuilderFactory dbfactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder  documentBuilder=dbfactory.newDocumentBuilder();
		Document document=documentBuilder.parse(xmlFile);
		document.getDocumentElement().normalize();
		NodeList nList = document.getElementsByTagName("ordinal");
		ordinal=nList.item(1).getTextContent();
		System.out.println("*** ordinal** "+ordinal);
		if (ordinal.equals(FetchProperty.readProperty("ordinalZero")))
		{
			 nList = document.getElementsByTagName("ordinal");
			 option=nList.item(1).getTextContent();
		}
		else if(ordinal.equals(FetchProperty.readProperty("ordinalOne")))
		{
			 nList = document.getElementsByTagName("ordinal");
			 option=nList.item(1).getTextContent();
		}
		else if(ordinal.equals(FetchProperty.readProperty("ordinalTwo")))
		{
			 nList = document.getElementsByTagName("ordinal");
			 option=nList.item(1).getTextContent();
		}
		
		
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("** check option** "+option);
		return option;
		
	}
}
