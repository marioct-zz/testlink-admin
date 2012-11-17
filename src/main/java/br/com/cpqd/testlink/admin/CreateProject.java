package br.com.cpqd.testlink.admin;

import java.net.MalformedURLException;
import java.net.URL;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.model.TestProject;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;

public class CreateProject {

	public static void main(String[] args) { 
		
		String url = args[0];
	    String devKey = args[1];
	    String projectName = args[2];
		String projectPrefix = args[3];
		String projectNotes = args[4];
		
		URL testlinkURL = null;
		try {
			testlinkURL = new URL(url);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		
		TestLinkAPI api = null;
		try {
			api = new TestLinkAPI(testlinkURL, devKey);
		} catch (TestLinkAPIException e1) {
			e1.printStackTrace();
		}
		
		TestProject project = null;       
        try {
                project = api.createTestProject(
                		        projectName, //testProjectName //$NON-NLS-1$
                		        projectPrefix, //testProjectPrefix //$NON-NLS-1$
                		        projectNotes, //notes //$NON-NLS-1$
                                true, //enableRequirements
                                true, //enableTestPriority
                                true, //enableAutomation
                                true, //enableInventory
                                true, //isActive
                                true); //isPublic
        } catch (TestLinkAPIException e) {
                e.printStackTrace( System.err );
                System.exit(-1);
        }
        
        System.out.println( "Test project created! " ); //$NON-NLS-1$        
        System.out.println( "Test Project ID: [ " + project.getId() + " ]." );
	}

}
