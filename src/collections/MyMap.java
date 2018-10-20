package collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyMap<K, V> implements Map<K, V> {

	K[] keys;
	V[] values;

	@SuppressWarnings("unchecked")
	public MyMap() {
		keys = (K[]) new Object[0];
		values = (V[]) new Object[0];
	}

	@Override
	public void clear() {
		keys = Arrays.copyOf(keys, 0);
		values = Arrays.copyOf(values, 0);
	}

	@Override
	public boolean containsKey(Object key) {
		boolean contains = false;

		for (K k : this.keys) {
			if (k.equals(key)) {
				contains = true;
			}
		}

		return contains;
	}

	@Override
	public boolean containsValue(Object value) {
		boolean contains = false;

		for (V v : values) {
			if (v.equals(value)) {
				contains = true;
			}
		}

		return contains;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		MySet<Entry<K, V>> set = new MySet<>();
		
		Entry<K, V> entry = new Entry<K, V>() {

			@Override
			public K getKey() {
				return keys[0];
			}

			@Override
			public V getValue() {
				return values[0];
			}

			@Override
			public V setValue(V value) {
				return values[0] = value;
			}
		};

		set.add(entry);
		return set;
	}

	@Override
	public V get(Object key) {
		V returnValue = null;
		if (containsKey(key)) {
			for (int i = 0; i < this.keys.length; i++) {
				if (keys[i] == key) {
					returnValue = values[i];
				}
			}
		}
		return returnValue;
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
	public Set<K> keySet() {
		MySet<K> set = new MySet<>();
			
		for (K k : keys) {
			set.add(k);
		}
		
		return set;
	}

	@Override
	public V put(K key, V value) {

		V v = null;
		if (!containsKey(key)) {
			keys = Arrays.copyOf(keys, keys.length + 1);
			keys[keys.length - 1] = key;

			values = Arrays.copyOf(values, values.length + 1);
			values[values.length - 1] = value;
			v = value;

		} else if (containsKey(key)) {
			for (int i = 0; i < keys.length; i++) {
				if (keys[i] == key) {
					values[i] = value;
					v = value;
					return v;
				}
			}
		}
		return v;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		MySet<K> keySet = (MySet<K>) m.keySet();
		MySet<V> valueSet = (MySet<V>) m.values();
		
		Iterator<K> ki = keySet.iterator();
		Iterator<V> vi = valueSet.iterator();
		
		while(ki.hasNext() && vi.hasNext()) {
			put(ki.next(), vi.next());
		}

	}

	@Override
	public V remove(Object key) {
		V v = null;
		
		if (containsKey(key)) {
			for(int i = 0, j = 0; i < keys.length; i++, j++) {
				if(keys[i] == key) {
					while(i < keys.length-1) {
						keys[i] = keys[i+1];
						i++;
					}
					while(j < values.length-1) {
						v = values[j];
						values[j] = values[j+1];
						j++;
					}

					keys = Arrays.copyOf(keys, keys.length - 1);
					values = Arrays.copyOf(values, values.length - 1);
					return v;
				}
			}
			}
		return v;
	}

	@Override
	public int size() {
		return values.length;
	}

	@Override
	public Collection<V> values() {

		MyList<V> valuesList = new MyList<>();

		for (V v : values) {
			valuesList.add(v);
		}

		return valuesList;
	}

	@Override
	public String toString() {
		String printOut = "";
		for (int i = 0; i < keys.length; i++) {
			System.out.println("{" + keys[i] + "=" + values[i] + "}");
		}
		return printOut;
	}

}
