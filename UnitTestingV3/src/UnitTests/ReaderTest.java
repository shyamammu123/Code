package UnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Control.Reader;

public class ReaderTest {

	Reader testReaderObject;
	
	@Before
	public void setUp() throws Exception {
		testReaderObject = new Reader();
	}

	@After
	public void tearDown() throws Exception {
		testReaderObject = null;
	}

	@Test
	public void testReadVoltage() {
		float[] testArray = testReaderObject.readVoltage();
		Assert.assertTrue(testArray instanceof float[]);
		Assert.assertTrue(testArray != null);
	}

	@Test
	public void testReadCurrent() {
		float[] testArray = testReaderObject.readCurrent();
		Assert.assertTrue(testArray instanceof float[]);
		Assert.assertTrue(testArray != null);
	}

	@Test
	public void testReadTemperature() {
		float[] testArray = testReaderObject.readTemperature();
		Assert.assertTrue(testArray instanceof float[]);
		Assert.assertTrue(testArray != null);
	}

	@Test
	public void testReadLoad() {
		float[] testArray = testReaderObject.readLoad();
		Assert.assertTrue(testArray instanceof float[]);
		Assert.assertTrue(testArray != null);
	}

	@Test
	public void testReadSOCLevel() {
		int[] testArray = testReaderObject.readSOCLevel();
		Assert.assertTrue(testArray instanceof int[]);
		Assert.assertTrue(testArray != null);
	}

	@Test
	public void testReadSOHLevel() {
		float[] testArray = testReaderObject.readSOHLevel();
		Assert.assertTrue(testArray instanceof float[]);
		Assert.assertTrue(testArray != null);
	}
	
	@Test
	public void testReadIsolateBattery() {
		boolean testResult = testReaderObject.readIsolateBattery();
		Assert.assertTrue(testResult == true || testResult == false);
	}
	
	@Test
	public void testParse() {
		String testArray[] = testReaderObject.parse("vcell");
		Assert.assertTrue(testArray instanceof String[]);
		Assert.assertTrue(testArray.length == 8);
		Assert.assertTrue(testArray != null);
	}
}
