package com.pack.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.DatatypeConverter;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;



public class Service {
	
	public static String sendGET(String GET_URL) throws IOException {
    	

    	HttpClient client = HttpClientBuilder.create().build();
    	HttpGet request = new HttpGet(GET_URL);
    	StringBuffer result = new StringBuffer();
    	String encoded = DatatypeConverter.printBase64Binary(("rohit" + ":" + "rohit").getBytes("UTF-8"));
    	request.addHeader("AUTHORIZATION", "Basic " + encoded);
    	request.addHeader("Accept","application/json");
    	

	HttpResponse response = client.execute(request);

	System.out.println("Response Code : " 
		        + response.getStatusLine().getStatusCode());

	BufferedReader rd = new BufferedReader(
		new InputStreamReader(response.getEntity().getContent()));

	
	String line = "";
	while ((line = rd.readLine()) != null) {
		result.append(line);
	}
	System.out.println("Data*** "+result);
    	return result.toString();
    }
	
	
	public static void buildJob(String jobName)
    {
		try
		{
		URL url = new URL (jobName);
		String encoded = DatatypeConverter.printBase64Binary(("rohit" + ":" + "rohit").getBytes("UTF-8"));
        	HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoded);
            InputStream content = connection.getInputStream();
            BufferedReader in   =
                new BufferedReader (new InputStreamReader (content));
            String line;
            while ((line = in.readLine()) != null) {
              System.out.println(line);
            }
          } catch(Exception e) {
            e.printStackTrace();
          }
        }
	public static void stop(String jobName)
    {String strBuildNo = "";
		try
		{
		String buildNoUrl = jobName+"/api/xml?xpath=//lastBuild/number";
		URL url = new URL (buildNoUrl);
		String encoded = DatatypeConverter.printBase64Binary(("rohit" + ":" + "rohit").getBytes("UTF-8"));
        	HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoded);
            InputStream content = connection.getInputStream();
            BufferedReader in   =
                new BufferedReader (new InputStreamReader (content));
            String line;
            String line1="";
            while ((line = in.readLine()) != null) {
              System.out.println(line);
              line1=line1+line;
            }
            strBuildNo = line1.substring(line1.indexOf('>') + 1,line1.lastIndexOf('<'));
   	    	System.out.println(strBuildNo);
   	    	String stopBuildUrl = buildNoUrl+ "/" + strBuildNo + "/stop";
   	    	URL url1 = new URL (stopBuildUrl);
   	    	HttpURLConnection connection1 = (HttpURLConnection)url1.openConnection();
            connection1.setRequestMethod("POST");
            connection1.setDoOutput(true);
            connection1.setRequestProperty("Authorization", "Basic " + encoded);
            InputStream content1 = connection1.getInputStream();
            BufferedReader in1   =
                new BufferedReader (new InputStreamReader (content1));
            String line5;
            while ((line5= in1.readLine()) != null) {
              System.out.println(line);
            }
          } catch(Exception e) {
            e.printStackTrace();
          }
        }


          
	
	public static void deleteJob(String jobName,String url) {
			  // http://JENKINSURL/job/JOBNAME/doDelete
		String jobUrl = url+"/job/"+jobName+"/doDelete";
		try {
			URL url2 = new URL(jobUrl);
				 
			String encoded = DatatypeConverter.printBase64Binary(("rohit" + ":" + "rohit").getBytes("UTF-8"));
        	HttpURLConnection connection = (HttpURLConnection)url2.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoded);
            InputStream content = connection.getInputStream();
            BufferedReader in   =
                new BufferedReader (new InputStreamReader (content));
            String line;
            while ((line = in.readLine()) != null) {
              System.out.println(line);
            }
          } catch(Exception e) {
            e.printStackTrace();
          }
        
        }
	
	public static void ServiceCall(String url, String data)
	 {
		  
		StringBuffer result = new StringBuffer();

	 	
	 	
	 	    CloseableHttpClient client = HttpClients.createDefault();
	 	    HttpPost httpPost = new HttpPost(url);
	 
	 	    try {
	 	    StringEntity se=new StringEntity(data);
	 	    se.setContentType("application/xml");  
	 	    httpPost.setHeader("Content-Type","application/xml;charset=UTF-8");
	 	    httpPost.setEntity(se);
 	      UsernamePasswordCredentials creds = 
 	      new UsernamePasswordCredentials("rohit", "rohit");
	    try {
				httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));
			} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
				
				System.out.println(e);
			}
	 	 
	 	    CloseableHttpResponse response = client.execute(httpPost);
	 	    BufferedReader rd = new BufferedReader(
	 				new InputStreamReader(response.getEntity().getContent()));

	 	  	
	 	  	String line = "";
	 	  	while ((line = rd.readLine()) != null) {
	 				result.append(line);
	 	  	}
	 	  	System.out.println("Data*** "+result);
		
	 		    
		} catch (Exception e) {
				// TODO: handle exception
			
	  }


	 }
	}
