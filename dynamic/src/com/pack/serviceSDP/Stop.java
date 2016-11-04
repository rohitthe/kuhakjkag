package com.pack.serviceSDP;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Stop {
private String jobname;
private String joburl;
public String getJobname() {
	return jobname;
}
public void setJobname(String jobname) {
	this.jobname = jobname;
}
public String getJoburl() {
	return joburl;
}
public void setJoburl(String joburl) {
	this.joburl = joburl;
}
public void stop()
{
	String str1 ="http://localhost:8080/job/"+jobname;
	ServiceSDP.stop(str1);
}
}
