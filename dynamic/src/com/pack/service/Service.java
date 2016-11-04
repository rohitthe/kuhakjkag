package com.pack.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

import com.pack.parser.XmlDataCreation;
import com.pack.utility.FetchProperty;


public class Service {
	
	 
	  //  private static final String USER_AGENT = "Mozilla/5.0";
	 
	   
	 
	 //   private static final String POST_PARAMS = "userName=Pankaj";
	 
	   
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
	 
	    public static void sendPOST(String POST_URL,String buildName,String jobID,String vcsId,String buildId,String buildStepsId,String path,String option) throws IOException {
//	    	HttpClient httpclient =HttpClientBuilder.create().build();
//	        HttpPost httppost = new HttpPost("http://chdsez376619d/httpAuth/app/rest/projects");
////	        List<NameValuePair> paarams = new ArrayList<NameValuePair>();
////	        paarams.add(new BasicNameValuePair("username", "rohit"));
////	        paarams.add(new BasicNameValuePair("password", "rohit"));
//	        try {
//	            StringEntity se = new StringEntity( "<newProjectDescription name='New Project Name13' id='newProjectId13'><parentProject locator='id:Digvijay'/></newProjectDescription>", HTTP.UTF_8);
//	        //    httppost.setEntity(new UrlEncodedFormEntity(paarams, "UTF-8"));
////	            httppost.addHeader("username", "rohit");
////	            httppost.addHeader("password", "rohit");
//	            String encoded = DatatypeConverter.printBase64Binary(("rohit" + ":" + "rohit").getBytes("UTF-8"));
//	          
//	            httppost.addHeader("Authorization", "Basic" + Base64.encodeBase64("rohit:rohit".getBytes()));  
////	            httppost.setHeader("Authorization","TRUETEST username=rohit & password=rohit");  
////	            String encoded = DatatypeConverter.printBase64Binary(("rohit" + ":" + "rohit").getBytes("UTF-8"));
////	            httppost.addHeader("AUTHORIZATION", "Basic " + encoded);
//	            se.setContentType("text/xml");
//	            httppost.setEntity(se);
//
//	            HttpResponse httpresponse = httpclient.execute(httppost);
//	            HttpEntity resEntity = httpresponse.getEntity();
//	            System.out.print(EntityUtils.toString(resEntity)+"***********");
//
//	        } catch (ClientProtocolException e) {
//	            // TODO Auto-generated catch block
//	            e.printStackTrace();
//	        } catch (IOException e) {
//	            // TODO Auto-generated catch block
//	            e.printStackTrace();
//	        
//	        }
	    	StringBuffer result = new StringBuffer();
	    	try {
				
			
	    	 CloseableHttpClient client = HttpClients.createDefault();
	    	 System.out.println(FetchProperty.readProperty("buildProjectUrl"));

	    	 System.out.println(FetchProperty.readProperty("buildProjectUrl"));

	    	 System.out.println(FetchProperty.readProperty("buildProjectUrl"));

	    	 System.out.println(FetchProperty.readProperty("buildProjectUrl"));
	    	    HttpPost httpPost = new HttpPost(FetchProperty.readProperty("buildProjectUrl"));
	    	    System.out.println(buildName);
	    	    System.out.println(buildName);
	    	    System.out.println(buildName);
	    	    StringEntity se=new StringEntity("<newProjectDescription name='"+buildName+"' id='newProjectId'></newProjectDescription>");
//	    	    se.setContentType("application/xml");  
	    	    httpPost.setHeader("Content-Type","application/xml");
	    	    httpPost.setEntity(se);
	    	    UsernamePasswordCredentials creds = 
	    	      new UsernamePasswordCredentials("rohit", "rohit");
	    	    try {
					httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost));
				} catch (AuthenticationException e) {
					// TODO Auto-generated catch block
					System.out.println("###ERrorr");
					e.printStackTrace();
				}
	    	 
	    	    CloseableHttpResponse response = client.execute(httpPost);
	    	    BufferedReader rd = new BufferedReader(
	    				new InputStreamReader(response.getEntity().getContent()));

	    	  	
	    	  	String line = "";
	    	  	while ((line = rd.readLine()) != null) {
	    				result.append(line);
	    				
	    	  	}
	    	  	System.out.println("build******** "+result);
	    	Thread.sleep(6000);
	    	  	sendPOSTVcs(POST_URL,buildName,jobID,vcsId,path,option);
	    	  	sendPOSTBuildType(POST_URL,buildName,jobID,vcsId,buildId,option);
	    	  	sendPOSTBuildsSteps(POST_URL, buildName, jobID, vcsId, buildStepsId, buildId,path,option);
	    	  	sendPOSTTrigger(buildId);
	    	  	sendPOSTParameter(buildId);
	    	} catch (Exception e) {
				// TODO: handle exception
			}
	     }
	    public static void sendPOSTVcs(String POST_URL,String buildName,String jobID,String vcsId,String path,String option) throws Exception {
	    
	    	StringBuffer result = new StringBuffer();
	    	String xmlData=null;
	    	
	    	System.out.println("Vcs is running **");
	    	 CloseableHttpClient client = HttpClients.createDefault();
	    	    HttpPost httpPost = new HttpPost(FetchProperty.readProperty("buildVcsUrl"));
	    	    try {
	    	    	xmlData=XmlDataCreation.xmlVcsRoot(jobID, buildName,vcsId,path,option);
	    	    	if (xmlData==null) {
						throw new Exception(FetchProperty.readProperty("Error"));
					} 
	    	    	
		else {
		
	    	    StringEntity se=new StringEntity(xmlData);
	    	    se.setContentType("application/xml");  
	    	    httpPost.setHeader("Content-Type","application/xml;charset=UTF-8");
	    	    httpPost.setEntity(se);
	    	    UsernamePasswordCredentials creds = 
	    	      new UsernamePasswordCredentials("rohit", "rohit");
	    	    try {
					httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost));
				} catch (AuthenticationException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
				}
	    	 
	    	    CloseableHttpResponse response = client.execute(httpPost);
	    	    BufferedReader rd = new BufferedReader(
	    				new InputStreamReader(response.getEntity().getContent()));

	    	  	
	    	  	String line = "";
	    	  	while ((line = rd.readLine()) != null) {
	    				result.append(line);
	    	  	}
	    	  	System.out.println("VCS******** "+result);
		}
	    		    
		} catch (Exception e) {
				// TODO: handle exception
			
	     }
	    	 }
	    public static void sendPOSTBuildType(String POST_URL,String buildName,String jobID,String vcsId,String buildId,String option) throws Exception {
		    
	    	StringBuffer result = new StringBuffer();
	    	String xmlData=null;
	    	
	    	
	    	 CloseableHttpClient client = HttpClients.createDefault();
	    	    HttpPost httpPost = new HttpPost(FetchProperty.readProperty("createBuildTypeUrl")+jobID+"/buildTypes/");
	    	    try {
	    	    	xmlData=XmlDataCreation.xmlBuildType(jobID, buildName, vcsId, buildId,option);
	    	    	if (xmlData==null) {
						throw new Exception(FetchProperty.readProperty("Error"));
					} 
	    	    	
		else {
		
	    	    StringEntity se=new StringEntity(xmlData);
	    	    se.setContentType("application/xml");  
	    	    httpPost.setHeader("Content-Type","application/xml;charset=UTF-8");
	    	    httpPost.setEntity(se);
	    	    UsernamePasswordCredentials creds = 
	    	      new UsernamePasswordCredentials("rohit", "rohit");
	    	    try {
					httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost));
				} catch (AuthenticationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	 
	    	    CloseableHttpResponse response = client.execute(httpPost);
	    	    BufferedReader rd = new BufferedReader(
	    				new InputStreamReader(response.getEntity().getContent()));

	    	  	
	    	  	String line = "";
	    	  	while ((line = rd.readLine()) != null) {
	    				result.append(line);
	    	  	}
	    	  	System.out.println("Data*** "+result);
		}
	    		    
		} catch (Exception e) {
				// TODO: handle exception
			
	     }
	    	 }
 public static void sendPOSTBuildsSteps(String POST_URL,String buildName,String jobID,String vcsId,String buildStepsId,String buildId,String path,String option) throws Exception {
		    
	    	StringBuffer result = new StringBuffer();
	    	String xmlData=null;
	    	String xmlDataSonar=null;
	    	String url=null;
	    	String xmlDataDeploy=null;
	    	
	    	 CloseableHttpClient client = HttpClients.createDefault();
	    	    HttpPost httpPost = new HttpPost(FetchProperty.readProperty("buildstepurl")+buildId+"/steps");
	    	  url=FetchProperty.readProperty("buildstepurl")+buildId+"/steps";
	    	    try {
	    	    	xmlData=XmlDataCreation.xmlBuildSteps(jobID, buildName, vcsId,buildStepsId,path,option);
	    	    	xmlDataSonar=(XmlDataCreation.xmlBuildStepsSonar(jobID+1, buildName, vcsId,buildStepsId,path,option));
	    	    	xmlDataDeploy=XmlDataCreation.xmlBuildStepsDeploy(jobID, buildName, vcsId, buildStepsId, path,option);
	    	    	if (xmlData==null) {
						throw new Exception(FetchProperty.readProperty("Error"));
					} 
	    	    	
		else {
		
	    	    StringEntity se=new StringEntity(xmlData);
	    	    se.setContentType("application/xml");  
	    	    httpPost.setHeader("Content-Type","application/xml;charset=UTF-8");
	    	    httpPost.setEntity(se);
	    	    UsernamePasswordCredentials creds = 
	    	      new UsernamePasswordCredentials("rohit", "rohit");
	    	    try {
					httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost));
				} catch (AuthenticationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	 
	    	    CloseableHttpResponse response = client.execute(httpPost);
	    	    BufferedReader rd = new BufferedReader(
	    				new InputStreamReader(response.getEntity().getContent()));

	    	  	
	    	  	String line = "";
	    	  	while ((line = rd.readLine()) != null) {
	    				result.append(line);
	    	  	}
	    	  	System.out.println("Data*** "+result);
		}
	    	    	ServiceCall(url,xmlDataSonar);
	    	    	ServiceCall(url,xmlDataDeploy);
		} catch (Exception e) {
				// TODO: handle exception
			
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
				httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost));
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
 public static void  sendPOSTTrigger(String buildId)
 {
		String url=null;
		String xmlData=null;
 	try {
		 url=FetchProperty.readProperty("triggerUrl")+buildId+"/triggers";
		 xmlData=XmlDataCreation.xmlTrigger();
		 ServiceCall(url,xmlData);
		 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 public static void  sendPOSTParameter(String buildId)
 {
		String url=null;
		String xmlData=null;
 	try {
 		System.out.println("The build is id " +buildId);
		 url=FetchProperty.readProperty("triggerUrl")+"id:"+buildId+"/parameters";
		 xmlData=XmlDataCreation.xmlParameter();
		 ServiceCall(url,xmlData);
		 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}