package com.gati3478.test.gati3478_maven_ci;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LimitIterable<T> implements Iterable<T> {
	private Iterable<T> iterable;
	private int n;

	public LimitIterable(Iterable<T> iterable, int n) {
		this.iterable = iterable;
		this.n = n;
	}

	@Override
	public Iterator<T> iterator() {
		return new LimitIterator<T>(iterable, n);
	}

	private class LimitIterator<E> implements Iterator<E> {
		private Iterator<E> iter;
		private int takeNum;

		public LimitIterator(Iterable<E> iterable, int takeNum) {
			this.iter = iterable.iterator();
			this.takeNum = takeNum;
		}

		@Override
		public boolean hasNext() {
			return (takeNum > 0 && iter.hasNext());
		}

		@Override
		public E next() {
			if (hasNext()) {
				--takeNum;
				return (E) iter.next();
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