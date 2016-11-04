package com.pack.parser;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.pack.utility.FetchProperty;

public class XmlDataCreation {

	static String dataXmlVcs=null;
	static String dataXmlStep=null;
	static String dataXmlBuild=null;
	
	public static String xmlVcsRoot(String projectId,String buildName,String vcsId,String path,String option)
	{
		 try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("vcs-root");
		doc.appendChild(rootElement);
		
		
		Attr attr=doc.createAttribute("name");
		attr.setValue(vcsId);
		rootElement.setAttributeNode(attr);
		
		//
		attr=doc.createAttribute("vcsName");
		attr.setValue(FetchProperty.readProperty("vcsName"));
		rootElement.setAttributeNode(attr);
		System.out.println("*** running 2");
		

		
		
		//
		attr=doc.createAttribute("href");
		attr.setValue(FetchProperty.readProperty("buildvcsidhref")+vcsId);
		rootElement.setAttributeNode(attr);
		
		
		//
		attr=doc.createAttribute("href");
		attr.setValue(FetchProperty.readProperty("buildVcshref")+projectId);
		rootElement.setAttributeNode(attr);
		
		
		
		// staff elements
		Element project = doc.createElement("project");
		rootElement.appendChild(project);
		
		attr=doc.createAttribute("id");
		attr.setValue(projectId);
		project.setAttributeNode(attr);
		
		//
		attr=doc.createAttribute("name");
		attr.setValue(buildName);
		project.setAttributeNode(attr);
		System.out.println("*** running 2");
		
		//
		
		attr=doc.createAttribute("href");
		attr.setValue(FetchProperty.readProperty("buildVcshref")+projectId);
		project.setAttributeNode(attr);
		
		//
		Element properties = doc.createElement("properties");
		rootElement.appendChild(properties);

		
		
		Element property1 = doc.createElement("property");
		properties.appendChild(property1);
		
		//
		try {
		
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("externals-mode"));
		property1.setAttributeNode(attr);

		attr=doc.createAttribute("name");
		attr.setValue("externals-mode");
		property1.setAttributeNode(attr);
		
		Element property2 = doc.createElement("property");
		properties.appendChild(property2);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("labelingMessage"));
		property2.setAttributeNode(attr);

		attr=doc.createAttribute("name");
		attr.setValue("labelingMessage");
		property2.setAttributeNode(attr);
		
		//
		Element property3 = doc.createElement("property");
		properties.appendChild(property3);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("labelingPatterns"));
		property3.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("labelingPatterns");
		property3.setAttributeNode(attr);
		
		
		
		Element property4 = doc.createElement("property");
		properties.appendChild(property4);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("svn-config-directory"));
		property4.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("svn-config-directory");
		property4.setAttributeNode(attr);
		
		Element property5 = doc.createElement("property");
		properties.appendChild(property5);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("svn-use-default-config-directory"));
		property5.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("svn-use-default-config-directory");
		property5.setAttributeNode(attr);
		
		
		Element property6 = doc.createElement("property");
		properties.appendChild(property6);
		
		//
		attr=doc.createAttribute("value");

		attr.setValue(path);
		property6.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("url");
		property6.setAttributeNode(attr);
		
		
		
		Element property7 = doc.createElement("property");
		properties.appendChild(property7);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("user"));
		property7.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("user");
		property7.setAttributeNode(attr);
		
		//
		Element property8 = doc.createElement("property");
		properties.appendChild(property8);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("securesvn-password"));
		property8.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("secure:svn-password");
		property8.setAttributeNode(attr);
		
		//
		
		Element property9 = doc.createElement("property");
		properties.appendChild(property9);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("working-copy-format"));
		property9.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("working-copy-format");
		property9.setAttributeNode(attr);
		
		System.out.println("*** running 5");
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		System.out.println("***** document element "+doc.getElementsByTagName("project"));
		
		   StringWriter writer = new StringWriter();
		
		StreamResult result = new StreamResult(writer);
		System.out.println("*** running 6");
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);
		dataXmlVcs=writer.toString();
		System.out.println("File saved!");
		return dataXmlVcs;
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
		 } catch (Exception e) {
				// TODO: handle exception
			}
		 
		 return dataXmlVcs;
	}

	public InputStream filePath()
	{
		InputStream path=getClass().getClassLoader().getResourceAsStream("config.properties");
		return path;
	}
	public static String xmlBuildSteps(String projectId,String buildName,String vcsId,String buildStepId,String path,String option)
	{
		 try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("step");
		doc.appendChild(rootElement);
		
		
		Attr attr=doc.createAttribute("name");
		attr.setValue(vcsId);
		rootElement.setAttributeNode(attr);
		
		//
		attr=doc.createAttribute("id");
		attr.setValue(buildStepId);
		rootElement.setAttributeNode(attr);
		System.out.println("*** running 2");
		

		
		
		//
		attr=doc.createAttribute("type");
		attr.setValue(FetchProperty.readProperty("type"));
		rootElement.setAttributeNode(attr);
		
		
		//
		
		
		
	

		//
		Element properties = doc.createElement("properties");
		rootElement.appendChild(properties);

		
		
		Element property1 = doc.createElement("property");
		properties.appendChild(property1);
		
		//
		try {
			
		
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("goals"));
		property1.setAttributeNode(attr);

		attr=doc.createAttribute("name");
		attr.setValue("goals");
		property1.setAttributeNode(attr);
		
		Element property2 = doc.createElement("property");
		properties.appendChild(property2);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("mavenSelection"));
		property2.setAttributeNode(attr);

		attr=doc.createAttribute("name");
		attr.setValue("mavenSelection");
		property2.setAttributeNode(attr);
		
		//
		Element property3 = doc.createElement("property");
		properties.appendChild(property3);
		
		//
		attr=doc.createAttribute("value");
	
		if(option.equals("0"))
		{
		attr.setValue(FetchProperty.readProperty("option0"));
		property3.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("teamcity.step.mode");
		property3.setAttributeNode(attr);
		} else 
			if(option.equals("1"))
			{
			attr.setValue(FetchProperty.readProperty("option1"));
			property3.setAttributeNode(attr);
			
			attr=doc.createAttribute("name");
			attr.setValue("teamcity.step.mode");
			property3.setAttributeNode(attr);
			} else 
				if(option.equals("2"))
				{
				attr.setValue(FetchProperty.readProperty("option2"));
				property3.setAttributeNode(attr);
				
				attr=doc.createAttribute("name");
				attr.setValue("teamcity.step.mode");
				property3.setAttributeNode(attr);
				} 
		
		
		
		
		Element property4 = doc.createElement("property");
		properties.appendChild(property4);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("userSettingsSelection"));
		property4.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("userSettingsSelection");
		property4.setAttributeNode(attr);
		
		
		//
		
		Element property5 = doc.createElement("property");
		properties.appendChild(property5);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("pathToPom")+"\\pom.xml");
		property5.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("pomLocation");
		property5.setAttributeNode(attr);
		
		
		//
		
		Element property6 = doc.createElement("property");
		properties.appendChild(property6);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("customPath"));
		property6.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("maven.home");
		property6.setAttributeNode(attr);
		
		
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		
		   StringWriter writer = new StringWriter();
		
		StreamResult result = new StreamResult(writer);
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);
		dataXmlStep=writer.toString();
		System.out.println("File saved!");
		return dataXmlStep;
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
		 } catch (Exception e) {
				// TODO: handle exception
			}
		 
		 return dataXmlStep;
	}
	public static String xmlBuildType(String projectId,String buildName,String vcsId,String buildId,String option)
	{
		 try {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("newBuildTypeDescription");
		doc.appendChild(rootElement);
		
		
		Attr attr=doc.createAttribute("id");
		attr.setValue(buildId);
		rootElement.setAttributeNode(attr);
		
		//
		attr=doc.createAttribute("name");
		attr.setValue(FetchProperty.readProperty("package"));
		rootElement.setAttributeNode(attr);
		System.out.println("*** running 2");
		

		
		
		//
		attr=doc.createAttribute("webUrl");
		attr.setValue(FetchProperty.readProperty("webUrl")+buildId);
		rootElement.setAttributeNode(attr);
		
		
		//
		attr=doc.createAttribute("paused");
		attr.setValue(FetchProperty.readProperty("paused"));
		rootElement.setAttributeNode(attr);
		
		//
		
		
		Element builds = doc.createElement("builds");
		rootElement.appendChild(builds);
		
		attr=doc.createAttribute("href");
		attr.setValue(FetchProperty.readProperty("buildshref")+buildId+"/builds/");
		builds.setAttributeNode(attr);
		
		
		// staff elements
		Element project = doc.createElement("project");
		rootElement.appendChild(project);
		
		attr=doc.createAttribute("id");
		attr.setValue(projectId);
		project.setAttributeNode(attr);
		
		//
		attr=doc.createAttribute("name");
		attr.setValue(buildName);
		project.setAttributeNode(attr);
		System.out.println("*** running 2");
		
		//
		
		attr=doc.createAttribute("href");
		attr.setValue(FetchProperty.readProperty("buildVcshref")+projectId);
		project.setAttributeNode(attr);
		
		//
		Element properties = doc.createElement("settings");
		rootElement.appendChild(properties);

		
		
		Element property1 = doc.createElement("property");
		properties.appendChild(property1);
		
		//
		try {
			
			System.out.println("*** running 3");
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("allowExternalStatus"));
		property1.setAttributeNode(attr);

		attr=doc.createAttribute("name");
		attr.setValue("allowExternalStatus");
		property1.setAttributeNode(attr);
		
		Element property2 = doc.createElement("property");
		properties.appendChild(property2);
		
		//
	

		attr=doc.createAttribute("name");
		attr.setValue("artifactRules");
		property2.setAttributeNode(attr);
		
		//
		Element property3 = doc.createElement("property");
		properties.appendChild(property3);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("buildNumberCounter"));
		property3.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("buildNumberCounter");
		property3.setAttributeNode(attr);
		
		
		
		Element property4 = doc.createElement("property");
		properties.appendChild(property4);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("buildNumberPattern"));
		property4.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("buildNumberPattern");
		property4.setAttributeNode(attr);
		
		Element property5 = doc.createElement("property");
		properties.appendChild(property5);
		
		//
		
		
		attr=doc.createAttribute("name");
		attr.setValue("checkoutDirectory");
		property5.setAttributeNode(attr);
		
		
		System.out.println("*** running 4");
		Element property6 = doc.createElement("property");
		properties.appendChild(property6);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("checkoutMode"));
		property6.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("checkoutMode");
		property6.setAttributeNode(attr);
		
		
		
		Element property7 = doc.createElement("property");
		properties.appendChild(property7);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("cleanBuild"));
		property7.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("cleanBuild");
		property7.setAttributeNode(attr);
		
		//
		Element property8 = doc.createElement("property");
		properties.appendChild(property8);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("enableHangingBuildsDetection"));
		property8.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("enableHangingBuildsDetection");
		property8.setAttributeNode(attr);
		
		//
		
		Element property9 = doc.createElement("property");
		properties.appendChild(property9);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("executionTimeoutMin"));
		property9.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("executionTimeoutMin");
		property9.setAttributeNode(attr);
		//
		
		Element property10 = doc.createElement("property");
		properties.appendChild(property10);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("maximumNumberOfBuilds"));
		property10.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("maximumNumberOfBuilds");
		property10.setAttributeNode(attr);
		//
		
		Element property11 = doc.createElement("property");
		properties.appendChild(property11);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("shouldFailBuildIfTestsFailed"));
		property11.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("shouldFailBuildIfTestsFailed");
		property11.setAttributeNode(attr);
		
		//
		
		Element property12 = doc.createElement("property");
		properties.appendChild(property12);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("shouldFailBuildOnAnyErrorMessage"));
		property12.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("shouldFailBuildOnAnyErrorMessage");
		property12.setAttributeNode(attr);
		
		//
		
		Element property13 = doc.createElement("property");
		properties.appendChild(property13);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("shouldFailBuildOnBadExitCode"));
		property13.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("shouldFailBuildOnBadExitCode");
		property13.setAttributeNode(attr);
		
		//
		
		Element property14 = doc.createElement("property");
		properties.appendChild(property14);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("shouldFailBuildOnOOMEOrCrash"));
		property14.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("shouldFailBuildOnOOMEOrCrash");
		property14.setAttributeNode(attr);
		
		//
		
		Element property15 = doc.createElement("property");
		properties.appendChild(property15);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("showDependenciesChanges"));
		property15.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("showDependenciesChanges");
		property15.setAttributeNode(attr);
		
		//
		
		Element property16 = doc.createElement("property");
		properties.appendChild(property6);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("vcsLabelingBranchFilter"));
		property16.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("vcsLabelingBranchFilter");
		property16.setAttributeNode(attr);
		
		
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		 StringWriter writer = new StringWriter();
		
		StreamResult result = new StreamResult(writer);
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);
		dataXmlBuild=writer.toString();
		System.out.println("File saved!");
		return dataXmlBuild;
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
		 } catch (Exception e) {
				// TODO: handle exception
			}
		 
		 return dataXmlBuild;
	}
	
	public static String xmlBuildStepsSonar(String projectId,String buildName,String vcsId,String buildStepId,String path,String option)
	{
		 try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("step");
		doc.appendChild(rootElement);
		
		
		Attr attr=doc.createAttribute("name");
		attr.setValue(vcsId);
		rootElement.setAttributeNode(attr);
		
		//
		attr=doc.createAttribute("id");
		attr.setValue(buildStepId+1);
		rootElement.setAttributeNode(attr);
		

		
		
		//
		attr=doc.createAttribute("type");
		attr.setValue(FetchProperty.readProperty("typesonar"));
		rootElement.setAttributeNode(attr);
		
		
		//
		
		
		
	

		//
		Element properties = doc.createElement("properties");
		rootElement.appendChild(properties);

		
		
		Element property1 = doc.createElement("property");
		properties.appendChild(property1);
		
		//
		try {
			
			
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("sonarqubeserver"));
		property1.setAttributeNode(attr);

		attr=doc.createAttribute("name");
		attr.setValue("sonarServer");
		property1.setAttributeNode(attr);
		
		
		
		//
		
		
		Element property2 = doc.createElement("property");
		properties.appendChild(property2);
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("sourceslocation"));
		property2.setAttributeNode(attr);

		attr=doc.createAttribute("name");
		attr.setValue("sonarProjectSources");
		property2.setAttributeNode(attr);
		
		//
		Element property3 = doc.createElement("property");
		properties.appendChild(property3);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("testlocation"));
		property3.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("sonarProjectTests");
		property3.setAttributeNode(attr);
		
		
		
		Element property4 = doc.createElement("property");
		properties.appendChild(property4);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("binarieslocation"));
		property4.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("sonarProjectBinaries");
		property4.setAttributeNode(attr);
		
		
		//
		Element property6 = doc.createElement("property");
		properties.appendChild(property6);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("sonar.projectKey"));
		property6.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("sonarProjectName");
		property6.setAttributeNode(attr);
		
		//
		Element property7 = doc.createElement("property");
		properties.appendChild(property7);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("sonar.projectName"));
		property7.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("sonarProjectKey");
		property7.setAttributeNode(attr);
		
		//
		
		//
		Element property8 = doc.createElement("property");
		properties.appendChild(property8);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("sonar.projectVersion"));
		property8.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("sonarProjectVersion");
		property8.setAttributeNode(attr);
		
		//
		
		Element property5 = doc.createElement("property");
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("sonarqubeserver"));
		property5.setAttributeNode(attr);

		attr=doc.createAttribute("name");
		attr.setValue("sqsChooser");
		property5.setAttributeNode(attr);
		
		
		
		Element property9 = doc.createElement("property");
		properties.appendChild(property9);
		
		//
		attr=doc.createAttribute("value");
		if(option.equals("0"))
		{
		attr.setValue(FetchProperty.readProperty("option0"));
		} else 
			if(option.equals("1"))
			{
			attr.setValue(FetchProperty.readProperty("option1"));
			} else 
				if(option.equals("2"))
				{
				attr.setValue(FetchProperty.readProperty("option3"));
				} 
		property9.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("teamcity.step.mode");
		property9.setAttributeNode(attr);
		
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		
		   StringWriter writer = new StringWriter();
		
		StreamResult result = new StreamResult(writer);
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);
		dataXmlStep=writer.toString();
		return dataXmlStep;
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
		 } catch (Exception e) {
				// TODO: handle exception
			}
		 
		 return dataXmlStep;
	}

	public static String xmlBuildStepsDeploy(String projectId,String buildName,String vcsId,String buildStepId,String path,String option)
	{
		 try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("step");
		doc.appendChild(rootElement);
		
		
		Attr attr=doc.createAttribute("name");
		attr.setValue(vcsId);
		rootElement.setAttributeNode(attr);
		
		//
		attr=doc.createAttribute("id");
		attr.setValue(buildStepId+2);
		rootElement.setAttributeNode(attr);
		System.out.println("*** running 2");
		

		
		
		//
		attr=doc.createAttribute("type");
		attr.setValue(FetchProperty.readProperty("typeDeploy"));
		rootElement.setAttributeNode(attr);
		
		
		//
		
		
		
	

		//
		Element properties = doc.createElement("properties");
		rootElement.appendChild(properties);

		
		
		Element property1 = doc.createElement("property");
		properties.appendChild(property1);
		
		//
		try {
			
		attr=doc.createAttribute("value");
		
		if(option.equals("0"))
		{
		attr.setValue(FetchProperty.readProperty("option0"));
		} else 
			if(option.equals("1"))
			{
			attr.setValue(FetchProperty.readProperty("option1"));
			} else 
				if(option.equals("2"))
				{
				attr.setValue(FetchProperty.readProperty("option2"));
				} 
		property1.setAttributeNode(attr);

		attr=doc.createAttribute("name");
		attr.setValue("teamcity.step.mode");
		property1.setAttributeNode(attr);
		
		Element property2 = doc.createElement("property");
		properties.appendChild(property2);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("jetbrains.buildServer.deployer.targetUrl"));
		property2.setAttributeNode(attr);

		attr=doc.createAttribute("name");
		attr.setValue("jetbrains.buildServer.deployer.targetUrl");
		property2.setAttributeNode(attr);
		
		//
		Element property3 = doc.createElement("property");
		properties.appendChild(property3);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("jetbrains.buildServer.deployer.container.type"));
		property3.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("jetbrains.buildServer.deployer.container.type");
		property3.setAttributeNode(attr);
		
		
		
		Element property4 = doc.createElement("property");
		properties.appendChild(property4);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("jetbrains.buildServer.deployer.username"));
		property4.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("jetbrains.buildServer.deployer.username");
		property4.setAttributeNode(attr);
		
		
		//
		
		Element property5 = doc.createElement("property");
		properties.appendChild(property5);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("secure_jetbrains.buildServer.deployer.password"));
		property5.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("secure:jetbrains.buildServer.deployer.password");
		property5.setAttributeNode(attr);
		
		
		//
		
		Element property6 = doc.createElement("property");
		properties.appendChild(property6);
		
		//
		attr=doc.createAttribute("value");
		attr.setValue(FetchProperty.readProperty("jetbrains.buildServer.deployer.sourcePath"));
		property6.setAttributeNode(attr);
		
		attr=doc.createAttribute("name");
		attr.setValue("jetbrains.buildServer.deployer.sourcePath");
		property6.setAttributeNode(attr);
		
		
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		System.out.println("***** document element "+doc.getElementsByTagName("project"));
		
		   StringWriter writer = new StringWriter();
		
		StreamResult result = new StreamResult(writer);
		
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);
		dataXmlStep=writer.toString();
		System.out.println("File saved!");
		return dataXmlStep;
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
		 } catch (Exception e) {
				// TODO: handle exception
			}
		 
		 return dataXmlStep;
	}
	public static String xmlTrigger()
	{

		 try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("trigger");
		doc.appendChild(rootElement);
		
	
		//
		Attr attr=doc.createAttribute("type");
		attr.setValue(FetchProperty.readProperty("typeTrigger"));
		rootElement.setAttributeNode(attr);
		
		
		
		//
		Element properties = doc.createElement("properties");
		rootElement.appendChild(properties);

		
		
		Element property1 = doc.createElement("property");
		properties.appendChild(property1);
		
		//
		try {
			
		attr=doc.createAttribute("value");
		attr.setValue("true");
		property1.setAttributeNode(attr);

		attr=doc.createAttribute("name");
		attr.setValue("perCheckinTriggering");
		property1.setAttributeNode(attr);
		
		
		
		
		
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		
		   StringWriter writer = new StringWriter();
		
		StreamResult result = new StreamResult(writer);
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);
		dataXmlStep=writer.toString();
		System.out.println("File saved!");
		return dataXmlStep;
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
		 } catch (Exception e) {
				// TODO: handle exception
			}
		 
		 return dataXmlStep;
	
	}
	public static String xmlParameter()
	{

		 try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();
		
		

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("property");
		doc.appendChild(rootElement);
		
		
		//
		Attr attr=doc.createAttribute("type");
		attr.setValue("env");
		rootElement.setAttributeNode(attr);
		
		
		attr=doc.createAttribute("name");
		attr.setValue("maven");
		rootElement.setAttributeNode(attr);
		
		
		attr=doc.createAttribute("value");
		attr.setValue("C:\\apache-maven-3.3.3");
		rootElement.setAttributeNode(attr);
		//
		
		
	
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		
		
		   StringWriter writer = new StringWriter();
		
		StreamResult result = new StreamResult(writer);
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);
		dataXmlStep=writer.toString();
		return dataXmlStep;
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return dataXmlStep;
	
	}

	}

