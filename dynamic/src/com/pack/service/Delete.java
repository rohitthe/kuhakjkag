package com.pack.service;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Delete {
		private String jobNamedeleted;
		private String joburl;
		public String getJobNamedeleted() {
			return jobNamedeleted;
		}
		public void setJobNamedeleted(String jobNamedeleted) {
			this.jobNamedeleted = jobNamedeleted;
		}
		public String getJoburl() {
			return joburl;
		}
		public void setJoburl(String joburl) {
			this.joburl = joburl;
		}
		public void delete()
		{
			Service.deleteJob(jobNamedeleted, joburl);
		}
		
	}
