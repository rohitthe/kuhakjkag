package com.pack.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;






@ManagedBean
@RequestScoped
public class Rohit {
	
	
	private String REMOTE_URL;
	private String projectname;


	public String getProjectname() {
		return projectname;
	}



	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}



	public String getREMOTE_URL() {
		return REMOTE_URL;
	}



	public void setREMOTE_URL(String rEMOTE_URL) {
		REMOTE_URL = rEMOTE_URL;
	}



	public void call()
	{
		
			//String[] arg = new String[]{"-u root", "-h localhost"};
			
		    try {
		        String[] cmdArray = new String[3];
		    	cmdArray[0] ="C:\\Program Files\\Git\\git-bash.exe";
		    	cmdArray[1]="git clone "+REMOTE_URL+"/"+projectname+".git";
		    	cmdArray[2]="git init";
		        String ss = null;
		        //Runtime obj = null;
		        Runtime rt = Runtime.getRuntime();
		        Process p = rt.exec(cmdArray[0]);
		        p = rt.exec(cmdArray[1]);
		        OutputStream out=p.getOutputStream();
		        out.write(cmdArray[1].getBytes());
		
		       // Process p1 = rt.exec(cmdArray[0]);
		        //p1=rt.exec(cmdArray[1]);
		        //OutputStream out1=p1.getOutputStream();
		        //out1.write(cmdArray[1].getBytes());
		        
		        // --cd-to-home
		        BufferedWriter writeer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
		        writeer.write("dir");
		        writeer.flush();
		        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
		        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		        System.out.println("Here is the standard output of the command:\n" );
		        out.write(cmdArray[1].getBytes());
		        while ((ss = stdInput.readLine()) != null) {
		            System.out.println(ss);
		        }
		        while ((ss = stdError.readLine()) != null) {
		            System.out.println(ss);
		        }

		    } catch (IOException e) {
		        System.out.println("FROM CATCH" + e.toString());
		    }

		}
		}


