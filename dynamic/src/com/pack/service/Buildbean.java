package com.pack.service;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Buildbean {
private String buildjob;

public String getBuildjob() {
	return buildjob;
}

public void setBuildjob(String buildjob) {
	this.buildjob = buildjob;
}
String str1="http://localhost:8080/job/";
public void build()
{
	str1=str1+buildjob;
	str1=str1+"/build";
	System.out.println(str1);
	Service.buildJob(str1);
}
}
