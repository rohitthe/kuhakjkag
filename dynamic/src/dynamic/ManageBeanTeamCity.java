package dynamic;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.pack.constants.Constants;
import com.pack.parser.ConfigParser;
import com.pack.service.Service;
import com.pack.serviceSDP.ServiceSDP;
import com.pack.utilitySDP.FetchData;
import com.pack.utilitySDP.ReadXMLFile;


	@ManagedBean
	@RequestScoped
	public class ManageBeanTeamCity {
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

		public void callService()
		{
			try {
				//Service.sendPOST("", jobName, "newprojectid", "newprojectid", "newprojectid", "newprojectid", "newprojectid", "2");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Service.sendPOST("", jobName, "newprojectid", "newprojectid", "newprojectid", "newprojectid", "newprojectid", "2");
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
}
