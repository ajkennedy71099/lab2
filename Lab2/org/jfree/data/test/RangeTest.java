package org.jfree.data.test;

import junit.framework.TestCase;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTest extends TestCase {

	private Range rangeObjectUnderTest;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0",
		0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	
	@Test
	public void testGetLength() {
		Range r1 = new Range(2, 2);
		assertEquals("getLength: Did not return the expected output", 0.0, r1.getLength());
		
		Range r2 = new Range(4, 9);
		assertEquals("getLength: Did not return the expected output", 5.0, r2.getLength());
		
		Range r3 = new Range(-99, -99);
		assertEquals("getLength: Did not return the expected output", 0.0, r3.getLength());
		
		Range r4 = new Range(-11, -4);
		assertEquals("getLength: Did not return the expected output", 7.0, r4.getLength());
		
		Range r5 = new Range(-5, 3);
		assertEquals("getLength: Did not return the expected output", 8.0, r5.getLength());
	}
	
	@Test
	public void testContains() {
		Range r1 = new Range(1,5);
		assertTrue(r1.contains(3));

		assertTrue(r1.contains(1));

		assertTrue(r1.contains(5));

		assertFalse(r1.contains(0));
		
		assertFalse(r1.contains(6));

		assertFalse(r1.contains(-99));

		assertFalse(r1.contains(99));
	}
	
	public void testEquals() {
		Range r1 = new Range(2, 8);
		
		assertTrue(r1.equals(new Range(2,8)));
		
		assertFalse(r1.equals(new Range(2,7)));
		
		assertFalse(r1.equals(new Range(2,9)));
		
		assertFalse(r1.equals(new Range(3,8)));

		assertFalse(r1.equals(new Range(1,8)));

		assertFalse(r1.equals(new Range(1,7)));

		assertFalse(r1.equals(new Range(1,9)));

		assertFalse(r1.equals(new Range(3,7)));

		assertFalse(r1.equals(new Range(3,9)));

		assertFalse(r1.equals(new Range(9, 18)));

		assertFalse(r1.equals(new Range(0,1)));
	}
}