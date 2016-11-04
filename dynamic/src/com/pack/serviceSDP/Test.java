package com.pack.serviceSDP;

import java.io.IOException;

import com.pack.serviceSDP.ServiceSDP;

public class Test {

	public static void main(String[] args) {
          try {
			ServiceSDP.sendGET("http://localhost:8080//api/json?tree=jobs[name,url,builds[number,url]]");
			ServiceSDP.sendGET("http://localhost:81/httpAuth/app/rest/projects");
			ServiceSDP.ServiceCall("http://localhost:8080/createItem?name=sarthak", "<project>  <description></description>  <keepDependencies>false</keepDependencies>  <properties/> <scm class='hudson.scm.NullSCM'/>  <canRoam>true</canRoam>  <disabled>false</disabled>  <blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding>  <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>  <triggers/>  <concurrentBuild>false</concurrentBuild>  <builders>    <hudson.tasks.Maven>      <targets>package</targets>      <usePrivateRepository>false</usePrivateRepository>      <settings class='jenkins.mvn.DefaultSettingsProvider'/>      <globalSettings class='jenkins.mvn.DefaultGlobalSettingsProvider'/>    </hudson.tasks.Maven>  </builders>  <publishers/>  <buildWrappers/></project>");
			ServiceSDP.deleteJob("sarthak2","http://localhost:8080");
			System.out.println("rohit kumar");
			System.out.println("rohit");
			System.out.println("kj");
          } catch (IOException e) {
			e.printStackTrace();
          }
	}

}
