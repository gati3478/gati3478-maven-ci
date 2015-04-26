package com.gati3478.test.gati3478_maven_ci;

import java.util.Iterator;

import com.gati3478.test.gati3478_maven_ci.FibonacciIterable;
import com.gati3478.test.gati3478_maven_ci.LimitIterable;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Iterable<Integer> fibonacci = new FibonacciIterable();
		Iterable<Integer> limit = new LimitIterable<Integer>(fibonacci, 33);

		Iterator<Integer> it = limit.iterator();

		while (it.hasNext())
			System.out.println(it.next());
	}
}
