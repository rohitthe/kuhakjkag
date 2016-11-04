package com.pack.jobscreation;

import java.io.IOException;

import com.pack.service.Service;

public class JobBuild {

	public String build(String url,String buildName,String jobId,String vcsId,String buildId,String buildStepsId,String path,String option)
	{
		try {
			Service.sendPOST(url,buildName,jobId,vcsId,buildId,buildStepsId,path,option);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Success";
	}
}
