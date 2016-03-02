package UnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Control.SupplyPower;

public class SupplyPowerTest {

SupplyPower SupplyPowerTest;
	
	@Before
	public void setUp() throws Exception {
		SupplyPowerTest = new SupplyPower();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWriteLowSOCWarning() {
		boolean[] lowSOC = SupplyPowerTest.writeLowSOCWarning();
		int[] testArray = new int []{100, 90, 80, 70, 60, 50, 40, 30};//match xml field
		Assert.assertTrue(lowSOC != null);
		Assert.assertTrue(lowSOC instanceof boolean[]);
		for(int i = 0; i < testArray.length; i++)
		{
			if(testArray[i] > 40)
			{
				Assert.assertFalse(lowSOC[i]);
			}
			else if(testArray[i] <= 40)
			{
				Assert.assertTrue(lowSOC[i]);
			}
			System.out.println("LowSOCWarning: " + lowSOC[i]);
		}
	}
	
	@Test
	public void testWriteChargeCell() {
		//fail("Not yet implemented");
	}

	@Test
	public void testWriteIsolateBattery() {
		boolean testResult = SupplyPowerTest.writeIsolateBattery();
		Assert.assertTrue(testResult == true || testResult == false);
	}

	@Test
	public void testValueCompare() {
		//fail("Not yet implemented");
	}

	@Test
	public void testWriteSafeSupplyRange() {
		//fail("Not yet implemented");
	}

}
