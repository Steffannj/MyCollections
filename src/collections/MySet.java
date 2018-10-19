package collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MySet<E> implements Set<E> {

	E[] array;

	@SuppressWarnings("unchecked")
	public MySet() {
		array = (E[]) new Object[0];
	}

	@Override
	public boolean add(E arg0) {
		if (!contains(arg0)) {
			array = Arrays.copyOf(array, array.length + 1);
			array[array.length - 1] = arg0;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		for (E e : arg0) {
			add(e);
		}
		return true;
	}

	@Override
	public void clear() {
		array = Arrays.copyOf(array, 0);
	}

	@Override
	public boolean contains(Object arg0) {
		boolean contains = false;

		for (E e : array) {
			if (e.equals(arg0)) {
				contains = true;
				break;
			}
		}

		return contains;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		boolean contains = true;
		for (Object object : arg0) {
			if (!contains(object)) {
				contains = false;
				break;
			}
		}
		return contains;
	}

	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Iterator<E> iterator() {
		Iterator<E> iterator = new Iterator<E>() {
			int index = 0;

			@Override
			public boolean hasNext() {
				return index < array.length;
			}

			@Override
			public E next() {
				return array[index++];
			}

		};
		return iterator;
	}

	@Override
	public boolean remove(Object arg0) {

		boolean removed = false;

		if (contains(arg0)) {
			for (int i = 0; i < array.length; i++) {
				if (array[i] == arg0) {

					for (int j = i; j < array.length - 1; j++) {
						array[j] = array[j + 1];
					}

					array = Arrays.copyOf(array, size() - 1);
					removed = true;
				}
			}
		}
		return removed;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		boolean removed = false;

		for (Object object : arg0) {
			if (contains(object)) {
				remove(object);
				removed = true;
			}
		}

		return removed;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		boolean retained = false;

		for (Object object : array) {
			if (!arg0.contains(object)) {
				remove(object);
				retained = true;
			}
		}

		return retained;
	}

	@Override
	public int size() {
		return array.length;
	}

	@Override
	public Object[] toArray() {
		return (Object[]) array;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return (T[]) arg0;
	}

}
