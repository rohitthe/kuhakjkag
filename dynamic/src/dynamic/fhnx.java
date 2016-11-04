package dynamic;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.pack.service.Service;

@ManagedBean
@RequestScoped
public class fhnx {
	private String jobName;
	private String joburl;
	private String repourl;
	private String technology;
	private String screpo;
	private String deploymentoption;
	public String getRepourl() {
		return repourl;
	}
	public void setRepourl(String repourl) {
		this.repourl = repourl;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getScrepo() {
		return screpo;
	}
	public void setScrepo(String screpo) {
		this.screpo = screpo;
	}
	public String getDeploymentoption() {
		return deploymentoption;
	}
	public void setDeploymentoption(String deploymentoption) {
		this.deploymentoption = deploymentoption;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJoburl() {
		return joburl;
	}
	public void setJoburl(String joburl) {
		this.joburl = joburl;
	}
	String str1="http://localhost:8080/createItem?name=";
	public String createService()
	{
		try {
			Service.sendGET("http://localhost:8080/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		str1=str1+jobName;
		String str="";
		for (int i = 0, n = repourl.length(); i < n; i++) {
		    char c = repourl.charAt(i);
		    if(c=='\\'){
		    	str=str+'\\'+c;
		    }
		    else  str=str+c;
		}
		System.out.println(str);
		String xml="";
		if(technology.equalsIgnoreCase("maven")){
				
		xml="<maven2-moduleset plugin=\"maven-plugin@2.13\"><actions/><description>Fetch from GIT Repo</description><keepDependencies>false</keepDependencies><properties><hudson.model.ParametersDefinitionProperty><parameterDefinitions><hudson.model.StringParameterDefinition><name>version</name><description></description><defaultValue>1.0.1</defaultValue></hudson.model.StringParameterDefinition></parameterDefinitions></hudson.model.ParametersDefinitionProperty></properties><scm class=\"hudson.plugins.git.GitSCM\" plugin=\"git@3.0.0\"><configVersion>2</configVersion><userRemoteConfigs><hudson.plugins.git.UserRemoteConfig><url>"+str+"</url></hudson.plugins.git.UserRemoteConfig></userRemoteConfigs><branches><hudson.plugins.git.BranchSpec><name>*/SecondBranch</name></hudson.plugins.git.BranchSpec></branches><doGenerateSubmoduleConfigurations>false</doGenerateSubmoduleConfigurations><submoduleCfg class=\"list\"/><extensions/></scm><canRoam>true</canRoam><disabled>false</disabled><blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding><blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding><triggers/><concurrentBuild>false</concurrentBuild><rootModule><groupId>com.mkyong</groupId><artifactId>NumberGenerator</artifactId></rootModule><settings class=\"jenkins.mvn.DefaultSettingsProvider\"/><globalSettings class=\"jenkins.mvn.DefaultGlobalSettingsProvider\"/><reporters/><publishers/><buildWrappers/></maven2-moduleset>";
		}
		else if(technology.equalsIgnoreCase("ant")){
		//Service.ServiceCall(str1, "<project><builders/><publishers/><buildWrappers/></project>");
		//Service.ServiceCall(str1, );
		xml="<project><description></description><keepDependencies>false</keepDependencies><properties/><scm class=\"hudson.plugins.git.GitSCM\" plugin=\"git@3.0.0\"><configVersion>2</configVersion><userRemoteConfigs><hudson.plugins.git.UserRemoteConfig><url>"+str+"</url></hudson.plugins.git.UserRemoteConfig></userRemoteConfigs><branches><hudson.plugins.git.BranchSpec><name>*/SecondBranch</name></hudson.plugins.git.BranchSpec></branches><doGenerateSubmoduleConfigurations>false</doGenerateSubmoduleConfigurations><submoduleCfg class=\"list\"/><extensions/></scm><canRoam>true</canRoam><disabled>false</disabled><blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding><blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding><triggers/><concurrentBuild>false</concurrentBuild><builders><hudson.tasks.Ant plugin=\"ant@1.4\"><targets></targets><antName>ant</antName><buildFile>C:\\Users\\sarthak.singhal\\Desktop\\build.xml</buildFile></hudson.tasks.Ant></builders><publishers/><buildWrappers/></project>";
		
		}
		Service.ServiceCall(str1,xml);
		return "JenkinsCreateSuccess.jsp";
	}
	
	
	

}
