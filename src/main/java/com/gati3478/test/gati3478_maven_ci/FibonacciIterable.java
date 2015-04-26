package com.gati3478.test.gati3478_maven_ci;

import java.util.Iterator;

public class FibonacciIterable implements Iterable<Integer> {

	@Override
	public Iterator<Integer> iterator() {
		return new FibonacciIterator();
	}

	private class FibonacciIterator implements Iterator<Integer> {
		private int first;
		private int second;

		public FibonacciIterator() {
			this.first = 0;
			this.second = 1;
		}

		@Override
		public boolean hasNext() {
			return true;
		}

		@Override
		public Integer next() {
			int retValue = this.second;
			this.second = this.first + this.second;
			this.first = retValue;
			return retValue;
		}

	}
}
