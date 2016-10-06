package com.pack.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
 
import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.InitCommand;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.UnmergedPathsException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.errors.UnmergedPathException;
import org.eclipse.jgit.revwalk.RevCommit;
 
public class JGitSample
{
  public static void main(String[] args) throws Exception
  {
    File gitWorkDir = new File("C:/temp/gittest/");
    Git git = null;
 
    InitCommand initCommand = Git.init();
    initCommand.setDirectory(gitWorkDir);
    git = initCommand.call();
 
    //git = Git.open(gitWorkDir); // not necessary, but show how to open an existing repo
     
    changeContentAndCommit(git, "DoubleCloud.org rocks!", "first commit");
    changeContentAndCommit(git, "DoubleCloud.org really rocks!", "second commit");
    changeContentAndCommit(git, "DoubleCloud.org really really rocks!", "third commit");
     
    Iterator<RevCommit> iterator = git.log().call().iterator();
 
    RevCommit rc2 = iterator.next();
    System.out.println("msg2:" + rc2.getFullMessage());
    System.out.println("con2:" + new String(rc2.getRawBuffer()));
    System.out.println("msg1:" + iterator.next().getFullMessage());
     
   // ReflogCommand reflogCmd = git.reflog();
    //Collection<ReflogEntry> reflogs = reflogCmd.call();
   // System.out.println("size of reflogs:" + reflogs.size());
  }
 
  private static void changeContentAndCommit(Git git, String content, String message) throws NoHeadException, NoMessageException, UnmergedPathsException, ConcurrentRefUpdateException, WrongRepositoryStateException, GitAPIException 
  {
    File workDir = git.getRepository().getWorkTree();
    File myfile = new File(workDir, "file1.txt");
    writeToFile(myfile, content);
 
    AddCommand add = git.add();
    add.addFilepattern(".").call();
 
    CommitCommand commit = git.commit();
    try {
		commit.setMessage(message).call();
	} catch (UnmergedPathException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JGitInternalException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
 
 
  public static void writeToFile(File file, String text)
  {
    FileWriter writer;
    try
    {
        writer = new FileWriter(file);
        writer.write(text);
        writer.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}