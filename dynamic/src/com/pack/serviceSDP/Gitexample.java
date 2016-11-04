package com.pack.serviceSDP;

import java.io.File;
import java.io.IOException;

import edu.nyu.cs.javagit.api.DotGit;
import edu.nyu.cs.javagit.api.JavaGitConfiguration;
import edu.nyu.cs.javagit.api.JavaGitException;

public class Gitexample{
	public static void main(String[] args) {
		try {
			JavaGitConfiguration.setGitPath("C:/Program Files/Git/bin/git.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JavaGitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Print the git version:  1.5.1
		try {
			System.out.println(JavaGitConfiguration.getGitVersion());
		} catch (JavaGitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Print the git version:  1.5.1
	// Create a new directory to be used as a git repository or point to an exisiting directory.
	  File repositoryDirectory = new File("C:/Users/rohit.kumar63/Downloads");

	//get the instance of the dotGit Object
      DotGit dotGit=DotGit.getInstance(repositoryDirectory);
	//Initialize the repository ,similar to git init
	  dotGit.init();
	}
}
