package UnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Control.ChargeBattery;
import junit.framework.Assert;

public class ChargeBatteryTest {

	ChargeBattery testChargeObject;
	
	@Before
	public void setUp() throws Exception {
		testChargeObject = new ChargeBattery();
	}

	@After
	public void tearDown() throws Exception {
		testChargeObject = null;
	}

	@Test
	public void testWriteChargeCell() {
		boolean testData[] = {true,true,true,true,true,true,true,false};
		testChargeObject.writeChargeCell(testData, "cellCharging");
	}

	@Test
	public void testValueCompare() {
		int bigVal = 50;
		int smallVal = 10;
		Assert.assertFalse(testChargeObject.valueCompare("voltage",20.0f));
		bigVal = -50;
		smallVal = -60;
		Assert.assertTrue(testChargeObject.valueCompare("current", 30.0f));
		float bigValFloat = 50.0f;
		float smallValFloat = 10.0f;
		Assert.assertTrue(testChargeObject.valueCompare("temperature", 50.0f));
	}

	@Test
	public void testShuntCharge() {
		//fail("Not yet implemented");
	}

	@Test
	public void testTrickleCharging() {
		//fail("Not yet implemented");
	}

}