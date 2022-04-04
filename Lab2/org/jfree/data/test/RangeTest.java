package org.jfree.data.test;

import junit.framework.TestCase;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTest extends TestCase {

	private Range rangeObjectUnderTest;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(1, 5);
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	//Contains Method Tests
	@Test
	public void testContains_ValueBelowRange() {
		assertFalse("-4 should be outside the range", rangeObjectUnderTest.contains(-4));
	}
	@Test
	public void testContains_ValueEqualToLower() {
		assertTrue("As 1 is on the lower border of the range, we would expect it to return true", rangeObjectUnderTest.contains(1));
	}
	@Test
	public void testContains_ValueWithinRange() {
		assertTrue("3.4 is within the range, thus it should return true", rangeObjectUnderTest.contains(3.4));
	}
	@Test
	public void testContains_ValueEqualToUpper() {
		assertTrue("As 5 is on the upper border of the range, we would expect it to return true", rangeObjectUnderTest.contains(5));
	}
	@Test
	public void testContains_ValueAboveRange() {
		assertFalse("8.7 should be outside the range", rangeObjectUnderTest.contains(8.7));
	}
	
	//Constrain Method Tests
	@Test
	public void testConstrain_ValueBelowRange() {
		assertEquals("-4 is less than the lower bound so should return 1", rangeObjectUnderTest.constrain(-4), 1.0);
	}
	@Test
	public void testConstrain_ValueEqualToLower() {
		assertEquals("1 is on the lower bound so should return 1", rangeObjectUnderTest.constrain(1), 1.0);
	}
	@Test
	public void testConstrain_ValueWithinRange() {
		assertEquals("3.4 is within the range so should return 3.4", rangeObjectUnderTest.constrain(3.4), 3.4);
	}
	@Test
	public void testConstrain_ValueEqualToUpper() {
		assertEquals("5 is on the upper bound so should return 5", rangeObjectUnderTest.constrain(5), 5.0);
	}
	@Test
	public void testConstrain_ValueAboveRange() {
		assertEquals("8.7 is above the upper bound so should return 5", rangeObjectUnderTest.constrain(8.7), 5.0);
	}
	
	//Equals Method Tests
	@Test
	public void testEquals_NonRangeObject() {
		assertFalse("Not a range object, should return false", rangeObjectUnderTest.equals(new Object()));
	}
	@Test
	public void testEquals_EqualRangeObject() {
		assertTrue("Equivalent range object, should return true", rangeObjectUnderTest.equals(new Range(1, 5)));
	}
	@Test
	public void testEquals_upperLessThanThisLower() {
		assertFalse("Range object with different upper and lower bounds, should return false", rangeObjectUnderTest.equals(new Range(-5, -1.4)));
	}
	@Test
	public void testEquals_lowerGreaterThanThisUpper() {
		assertFalse("Range object with different upper and lower bounds, should return false", rangeObjectUnderTest.equals(new Range(6.3, 13)));
	}
	@Test
	public void testEquals_IntersectsLower() {
		assertFalse("Range object with different upper and lower bounds, should return false", rangeObjectUnderTest.equals(new Range(-3, 3)));
	}
	@Test
	public void testEquals_IntersectsUpper() {
		assertFalse("Range object with different upper and lower bounds, should return false", rangeObjectUnderTest.equals(new Range(3, 7)));
	}
	@Test
	public void testEquals_RangeContainsThisRange() {
		assertFalse("Range object with different upper and lower bounds, should return false", rangeObjectUnderTest.equals(new Range(-1, 7)));
	}
	@Test
	public void testEquals_RangeWithinThisRange() {
		assertFalse("Range object with different upper and lower bounds, should return false", rangeObjectUnderTest.equals(new Range(2.4, 4.2)));
	}
	@Test
	public void testEquals_UpperEqualsThisLower() {
		assertFalse("Range object with different upper and lower bounds, should return false", rangeObjectUnderTest.equals(new Range(-3, 1)));
	}
	@Test
	public void testEquals_LowerEqualsThisUpper() {
		assertFalse("Range object with different upper and lower bounds, should return false", rangeObjectUnderTest.equals(new Range(5, 93.2)));
	}
	@Test
	public void testEquals_EqualLowerBoundLargerUpper() {
		assertFalse("Range object with different upper and lower bounds, should return false", rangeObjectUnderTest.equals(new Range(1, 9.34)));
	}
	@Test
	public void testEquals_EqualLowerBoundSmallerUpper() {
		assertFalse("Range object with different upper and lower bounds, should return false", rangeObjectUnderTest.equals(new Range(1, 4)));
	}
	@Test
	public void testEquals_EqualUpperBoundLargerLower() {
		assertFalse("Range object with different upper and lower bounds, should return false", rangeObjectUnderTest.equals(new Range(0.2, 5)));
	}
	@Test
	public void testEquals_EqualUpperBoundSmallerLower() {
		assertFalse("Range object with different upper and lower bounds, should return false", rangeObjectUnderTest.equals(new Range(-19, 5)));
	}
}