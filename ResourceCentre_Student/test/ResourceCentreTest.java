import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;
	
	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;
	
	public ResourceCentreTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}

	
	@Test
	public void addCamcorderTest() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
		
		//Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}
	@Test
	public void addChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
		// Item list is not null, so that can add a new item
				assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
				
				//Given an empty list, after adding 1 item, the size of the list is 1
				ResourceCentre.addChromebook(chromebookList, cb1);		
				assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());
				
				//The item just added is as same as the first item of the list
				assertSame("Test that Chromebook is added same as 1st item of the list?", cb1, chromebookList.get(0));
				
				//Add another item. test The size of the list is 2?
				ResourceCentre.addChromebook(chromebookList, cb2);
				assertEquals("Test that Camcorder arraylist size is 2?", 2, chromebookList.size());
	}
	
	@Test
	public void retrieveAllCamcorderTest() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//test if the list of Camcoder retrieved from the SourceCentre is empty
				String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
				String testOutput = "";
				assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		//test if the expected output string same as the list of Camcoder retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	@Test
	public void retrieveAllChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
		// Test if Item list is not null but empty, so that can add a new item
				assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
				
				//test if the list of Chromebook retrieved from the SourceCentre is empty
						String allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
						String testOutput = "";
						assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);
						
				//Given an empty list, after adding 2 items, test if the size of the list is 2
				ResourceCentre.addChromebook(chromebookList, cb1);
				ResourceCentre.addChromebook(chromebookList, cb2);
				assertEquals("Test if that Chromebook arraylist size is 2?", 2, chromebookList.size());
				
				//test if the expected output string same as the list of Chromebook retrieved from the SourceCentre
				allChromebook= ResourceCentre.retrieveAllCamcorder(camcorderList);

				testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
				testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
			
				assertEquals("Check that ViewAllChromebooklist", testOutput, allChromebook);
	}

	@Test
	public void doLoanCamcorderTest() {
		//fail("Not yet implemented");
		// write your code here	
			//test if the list of Camcoder retrieved from the SourceCentre is not empty
			String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
			assertNotNull("Test if there is valid Camcorder arraylist to add to", allCamcorder);
			
			//test if the availability of the Camcorder is false when camcorder is loaned
			String tag = Helper.readString("Enter asset tag > ");
			String dueDate = Helper.readString("Enter due date > ");
			for (int i = 0; i < camcorderList.size(); i++) {
				if (tag.equalsIgnoreCase(camcorderList.get(i).getAssetTag())
						&& camcorderList.get(i).getIsAvailable() == true) {
					
					camcorderList.get(i).setIsAvailable(false);
					camcorderList.get(i).setDueDate(dueDate);				
				}
			}
			assertSame("Test that Camcorder is unavailable after loan?", false, camcorderList.get(0).getIsAvailable());
	}
	
	@Test
	public void doLoanChromebookTest() {
		//fail("Not yet implemented");
		// write your code here	
			//test if the list of Chromebook retrieved from the SourceCentre is not empty
			String allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
			assertNotNull("Test if there is valid Camcorder arraylist to add to", allChromebook);
			
			//test if the availability of the Chromebook is false when Chromebook is loaned
			String tag = Helper.readString("Enter asset tag > ");
			String dueDate = Helper.readString("Enter due date > ");
			for (int i = 0; i < chromebookList.size(); i++) {
				if (tag.equalsIgnoreCase(chromebookList.get(i).getAssetTag())
						&& chromebookList.get(i).getIsAvailable() == true) {
					
					chromebookList.get(i).setIsAvailable(false);
					chromebookList.get(i).setDueDate(dueDate);				
				}
			}
			assertSame("Test that Chromebook is unavailable after loan?", false, chromebookList.get(0).getIsAvailable());
	}
	
	@Test
	public void doReturnCamcorderTest() {
		//fail("Not yet implemented");
		// write your code here
		//test if the list of Camcoder retrieved from the SourceCentre is not empty
		String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
		assertNotNull("Test if there is valid Camcorder arraylist to add to", allCamcorder);
		
		// Test if the availability of camcorder is true when camcorder is returned
		String tag = Helper.readString("Enter asset tag > ");
		
		for (int i = 0; i < camcorderList.size(); i++) {
			if (tag.equalsIgnoreCase(camcorderList.get(i).getAssetTag())
					&& camcorderList.get(i).getIsAvailable() == false) {
				camcorderList.get(i).setIsAvailable(true);
				camcorderList.get(i).setDueDate("");
			}
		}
		assertSame("Test that Camcorder is available after camcorder is returned?", true, camcorderList.get(0).getIsAvailable());
		
		// Test if the due date is empty after camcorder is returned
		String empty = "";
		assertSame("Test that due date is empty after returned?", empty, camcorderList.get(0).getDueDate());
	}
	@Test
	public void doReturnChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
		//test if the list of Chromebook retrieved from the SourceCentre is not empty
		String allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
		assertNotNull("Test if there is valid Chromebook arraylist to add to", allChromebook);
		
		// Test if the availability of chromebook is true when chromebook is returned
		String tag = Helper.readString("Enter asset tag > ");
		
		for (int i = 0; i < chromebookList.size(); i++) {
			if (tag.equalsIgnoreCase(chromebookList.get(i).getAssetTag())
					&& chromebookList.get(i).getIsAvailable() == false) {
				chromebookList.get(i).setIsAvailable(true);
				chromebookList.get(i).setDueDate("");
			}
		}
		assertSame("Test that Chromebook is available after chromebook is returned?", true, chromebookList.get(0).getIsAvailable());
		
		// Test if the due date is empty after chromebook is returned
		String empty = "";
		assertSame("Test that due date is empty after returned?", empty, chromebookList.get(0).getDueDate());
	}
	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
