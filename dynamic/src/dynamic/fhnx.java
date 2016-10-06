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
	public void rohit1()
	{
		try {
			Service.sendGET("http://localhost:8080//api/json?tree=jobs[name,url,builds[number,url]]");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		str1=str1+jobName;
		Service.ServiceCall(str1, "<project><builders/><publishers/><buildWrappers/></project>");
	}
	

}
