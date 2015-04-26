package com.gati3478.test.gati3478_maven_ci;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangeIterable implements Iterable<Integer> {
	private int from;
	private int to;

	public RangeIterable(int from, int to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new RangeIterator(this.from, this.to);
	}

	private class RangeIterator implements Iterator<Integer> {
		private int from;
		private int to;
		private boolean isReversed;

		public RangeIterator(int from, int to) {
			this.from = from;
			this.to = to;

			if (this.from <= this.to)
				this.isReversed = false;
			else
				this.isReversed = true;
		}

		@Override
		public boolean hasNext() {
			if (this.isReversed) {
				if (this.from >= this.to)
					return true;
				else
					return false;
			} else {
				if (this.from <= this.to)
					return true;
				else
					return false;
			}
		}

		@Override
		public Integer next() {
			if (hasNext()) {
				if (this.isReversed) {
					int retValue = this.from;
					this.from--;
					return retValue;
				} else {
					int retValue = this.from;
					this.from++;
					return retValue;
				}
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}

}
