package com.gati3478.test.gati3478_maven_ci;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ChainIterable<T> implements Iterable<T> {
	private Iterable<T> a;
	private Iterable<T> b;

	public ChainIterable(Iterable<T> a, Iterable<T> b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public Iterator<T> iterator() {
		return new ChainIterator<T>(a, b);
	}

	private class ChainIterator<E> implements Iterator<E> {
		private Queue<Iterator<E>> currIters;

		public ChainIterator(Iterable<E> a, Iterable<E> b) {
			this.currIters = new LinkedList<Iterator<E>>();
			this.currIters.add(a.iterator());
			this.currIters.add(b.iterator());
		}

		@Override
		public boolean hasNext() {
			if (currIters.isEmpty())
				return false;

			return this.currIters.peek().hasNext();
		}

		@Override
		public E next() {
			if (this.currIters.isEmpty())
				throw new NoSuchElementException();

			if (this.currIters.peek().hasNext()) {
				E retValue = (E) this.currIters.peek().next();

				if (!this.currIters.peek().hasNext())
					this.currIters.poll();

				return retValue;
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
