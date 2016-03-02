package UnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Control.Writer;

public class WriterTest {

	Writer testWriter;
	
	@Before
	public void setUp() throws Exception {
		testWriter = new Writer("src/testDB.xml");
	}

	@After
	public void tearDown() throws Exception {
		testWriter = null;
	}

	@Test
	public void testWriteBooleanArray() {
		assertNotNull(testWriter.getClass());
		assertNotNull(testWriter.getNodesToEdit("cellCharging"));
		
		boolean testData[] = {true, false, true, false, true, false, true, false};
		assertTrue(testWriter.writeBooleanArray("cellCharging", testData));
		boolean shortTestData[] = {true, false};
		assertFalse(testWriter.writeBooleanArray("cellCharging", shortTestData));
	}
	
}
