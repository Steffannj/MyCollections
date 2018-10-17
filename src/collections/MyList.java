package collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList<E> implements List<E> {

	E[] array;

	@SuppressWarnings("unchecked")
	public MyList() {
		array = (E[]) new Object[0];
	}

	@Override
	public boolean add(E e) {

		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = e;

		return true;
	}

	@Override
	public void add(int index, E element) {

		if (index < array.length) {
			array[index] = element;
		} else if (index == array.length) {
			array = Arrays.copyOf(array, array.length + 1);
			array[array.length - 1] = element;
		}

	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		int index = array.length;
		array = Arrays.copyOf(array, array.length + c.size());
		for (E e : c) {
			array[index] = e;
			index++;
		}
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		@SuppressWarnings("unchecked")
		E[] newArray = (E[]) new Object[array.length - index];

		for (int i = index, j = 0; i < array.length; i++, j++) {
			newArray[j] = array[i];
		}

		array = Arrays.copyOf(array, array.length + c.size());

		for (int i = newArray.length - 1, j = array.length - 1; i >= 0; i--, j--) {
			array[j] = newArray[i];
		}

		for (E e : c) {
			array[index] = e;
			index++;
		}

		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		array = (E[]) new Object[0];

	}

	@Override
	public boolean contains(Object o) {
		boolean contains = false;

		for (E e : array) {
			if (e == o) {
				contains = true;
				break;
			}
		}

		return contains;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean containsAll(Collection<?> c) {
		E[] cArray = (E[]) c.toArray();

		for (int i = 0; i < cArray.length; i++) {
			if (!contains(cArray[i])) {
				return false;
			}
		}

		return true;
	}

	@Override
	public E get(int index) {
		return array[index];
	}

	@Override
	public int indexOf(Object o) {
		int index = 0;
		if (contains(o)) {
			for (int i = 0; i < array.length; i++) {
				if (array[i] == o) {
					index = i;
					break;
				}
			}
		} else {
			throw new IllegalArgumentException();
		}
		return index;
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
	public int lastIndexOf(Object o) {
		int index = 0;

		if (contains(o)) {
			for (int i = array.length - 1; i >= 0; i--) {
				if (array[i] == o) {
					index = i;
					break;
				}
			}
		} else {
			throw new IllegalArgumentException();
		}
		return index;
	}

	@Override
	public ListIterator<E> listIterator() {
		ListIterator<E> li = new ListIterator<E>() {
			int index = 0;
			
			@Override
			public void add(E e) {
		
			}

			@Override	
			public boolean hasNext() {
				return index < array.length;
			}

			@Override
			public boolean hasPrevious() {
				return index > 0;
			}

			@Override
			public E next() {
				return array[index++];
				
			}

			@Override
			public int nextIndex() {
				int next = 0;
				if(!hasNext()) {
					next = array.length;
				}
				else if(hasNext()) {
					next = index + 1;
				}
				return next;
			}

			@Override
			public E previous() {
				return array[index--];
			}

			@Override
			public int previousIndex() {
				int previous = 0;
				if(!hasPrevious()) {
					previous = -1;
				}
				else if(hasPrevious()) {
					previous = index - 1;
				}
				return previous;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void set(E e) {
				
			}
		};
		return li;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean remove(Object o) {
		
		if (contains(o)) {
			int index = indexOf(o);

			for (int i = index; i < array.length - 1; i++) {
				array[i] = array[i + 1];
			}
			array = Arrays.copyOf(array, array.length - 1);

			return true;
		} else {
			return false;
		}

	}

	@Override
	public E remove(int index) {

		E e = null;

		if (index == array.length - 1) {

			e = array[index];
			array[index] = null;
			array = Arrays.copyOf(array, array.length - 1);

		} else if (index < array.length && index >= 0) {

			for (int i = index; i < array.length - 1; i++) {
				e = array[index];
				array[i] = array[i + 1];
			}

			array = Arrays.copyOf(array, array.length - 1);
		}

		return e;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean modified = false;

		for (E e : array) {
			if(c.contains(e)) {
				remove(e);
				modified = true;
			}
		}

		return modified;
	}


	@Override
	public boolean retainAll(Collection<?> c) {
		boolean modified = false;
		
		for (E e : array) {
			if(!c.contains(e)) {
				remove(e);
				modified = true;
			}
		}
		
		return modified;
	}

	@Override
	public E set(int index, E element) {
		if(index >= 0 && index < array.length) {
			array[index] = element;
		}
		return array[index];
	}

	@Override
	public int size() {
		return array.length;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		List<E> sub = new MyList<E>();
		
		if(fromIndex >= 0 && fromIndex <= array.length-1 && toIndex <= array.length && toIndex >= 0) {
			for(int i = fromIndex; i < toIndex; i++) {
				sub.add(get(i));
			}
		}
		
		return sub;
	}

	@Override
	public Object[] toArray() {
		return (Object[]) array;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return (T[]) a;
	}

}
