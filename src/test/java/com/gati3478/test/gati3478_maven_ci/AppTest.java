package com.gati3478.test.gati3478_maven_ci;

import java.util.Iterator;
import static org.mockito.Mockito.*;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	public void testFibonacciIterable() {
		Iterable<Integer> fib = new FibonacciIterable();
		Iterator<Integer> it = fib.iterator();

		// testing for fibonacci sequence
		for (int i = 0; i < 100000; ++i) {
			assertEquals(true, it.hasNext());
			int first = it.next();
			int second = it.next();
			assertEquals(first + second, it.next().intValue());
		}

		// testing if it returns new sequence every time
		it = fib.iterator();
		for (int i = 0; i < 100000; ++i) {
			assertEquals(true, it.hasNext());
			int first = it.next();
			int second = it.next();
			assertEquals(first + second, it.next().intValue());
		}
	}

	public void testLimitIterable() {
		// assuming FibonacciIterable works as expected
		Iterable<Integer> fib = new FibonacciIterable();
		Iterable<Integer> limit = new LimitIterable<Integer>(fib, 30000);
		Iterator<Integer> it = limit.iterator();

		// testing for fibonacci sequence
		for (int i = 0; i < 10000; ++i) {
			assertEquals(true, it.hasNext());
			int first = it.next();
			int second = it.next();
			assertEquals(first + second, it.next().intValue());
		}

		// testing if it returns new sequence every time
		it = limit.iterator();
		for (int i = 0; i < 10000; ++i) {
			assertEquals(true, it.hasNext());
			int first = it.next();
			int second = it.next();
			assertEquals(first + second, it.next().intValue());
		}

		assertEquals(false, it.hasNext());

		// testing for empty
		limit = new LimitIterable<Integer>(fib, 0);
		assertEquals(false, it.hasNext());
	}

	public void testLimitIterableMock() {
		// TODO Auto-generated method stub
		Iterator<Integer> itMock = mock(Iterator.class);
		when(itMock.hasNext()).thenReturn(true);
		when(itMock.next()).thenReturn(1);

		Iterable<Integer> iterableMock = mock(Iterable.class);
		when(iterableMock.iterator()).thenReturn(itMock);

		Iterable<Integer> limit = new LimitIterable<Integer>(iterableMock,
				10000);
		Iterator<Integer> it = limit.iterator();

		for (int i = 0; i < 10000; ++i) {
			assertEquals(true, it.hasNext());
			assertEquals(1, it.next().intValue());
		}
		assertEquals(false, it.hasNext());
	}

}
