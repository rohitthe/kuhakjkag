package org.dstadler.jgit.porcelain;


import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
public class CloneRemoteRepository {
	private static final String REMOTE_URL = "https://github.com/github/testrepo.git";

   
    
    
    public void cloneRep() {
        String login = "rohitthe";
        String password = "enter5*";
        String rep = "yuygbhj";
        String localDir = "C:/Users/rohit.kumar63/git81";
        try {
            System.out.println("Connecting...." + login + " : " + password);
            GitHub gitHub = GitHub.connectUsingOAuth(login, password);
            boolean isValid = gitHub.isCredentialValid();
            System.out.println("is Valid ? " + isValid);
            if (isValid) {
                GHRepository repository = gitHub.getRepository(rep);
            }
        } catch (Exception e) {
            System.out.println("EXCEPTION....");
            e.printStackTrace();
        }
    }
    
}

