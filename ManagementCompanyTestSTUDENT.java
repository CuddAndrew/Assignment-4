
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	ManagementCompany m;
	@Before
	public void setUp() throws Exception {
		//student create a management company
		m = new ManagementCompany("Cudd Firm", "21145", 12.0);
		//student add three properties, with plots, to mgmt co
		m.addProperty("house", "Silver Spring", 2700.00, "Andrew Cudd", 2, 3, 3, 3);
		m.addProperty("appartment", "Germentown", 1200, "Zach", 1, 1, 2, 2);
		m.addProperty("Townhouse", "Frederick", 1580, "maddie", 5, 5, 3, 4);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		m = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		Property p4 = new Property("mexico", "chicago", 700.00, "Isabella");
		//student should add property with 8 args
		Property p5 = new Property("buildings", "nantucket", 1925.00, "Geoff", 3, 1, 1, 1);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
		Property p6 = new Property("Hospital", "hanover", 700.00, "Jeff", 10, 4, 2, 3);
		assertEquals(m.addProperty(p4),3,0);
		assertEquals(m.addProperty(p5),4,0);
		assertEquals(m.addProperty(p6),-1,0);
	}
 
	@Test
	public void testMaxRentProp() {
		assertEquals(m.maxRentProp(),2700, 0);
		//student should test if maxRentProp contains the maximum rent of properties
		
	}

	@Test
	public void testTotalRent() {
		assertEquals(m.totalRent(),5480.0, 0);
		//student should test if totalRent returns the total rent of properties
	}

 }
