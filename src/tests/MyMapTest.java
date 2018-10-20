package tests;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import collections.MyList;
import collections.MyMap;
import collections.MySet;

public class MyMapTest {
	MyMap<Integer, String> map;

	@Before
	public void setUp() {
		map = new MyMap<>();
		map.put(1, "jedan");
		map.put(2, "dva");
		map.put(3, "tri");
		map.put(4, "cetiri");
	}

	@Test
	public void shouldClearMap() {
		map.clear();
		assertEquals(0, map.size());
	}

	@Test
	public void shouldReturnTrueIfMapContainsKey() {
		assertTrue(map.containsKey(1));
		assertFalse(map.containsKey(5));
	}

	@Test
	public void shouldReturnTrueIfMapContainsValue() {
		assertTrue(map.containsValue("dva"));
		assertFalse(map.containsValue("pet"));
	}

	@Test
	public void shouldReturnExpectedValue() {
		assertEquals("dva", map.get(2));
		assertEquals(null, map.get(0));
	}

	@Test
	public void shouldReturnTrueIfMapIsEmpty() {
		assertFalse(map.isEmpty());
		map.clear();
		assertTrue(map.isEmpty());
	}

	@Test
	public void shouldReturnSetOfKeys() {
		MySet<Integer> keySet = new MySet<>();
		keySet.add(1);
		keySet.add(2);
		keySet.add(3);
		keySet.add(4);
		MySet<Integer> ks = (MySet<Integer>) map.keySet();
		assertTrue(ks.containsAll(keySet));
	}

	@Test
	public void shouldPutValueToTheMap() {
		map.put(1, "nova vrijednost");
		assertTrue(map.containsValue("nova vrijednost"));
	}
	
	@Test 
	public void checkIfElementIsRemoved() {
		map.remove(1);
		assertFalse(map.containsKey(1));
	}
	
	@Test
	public void shouldReturnCollectionOfValues() {
		MyList<String> values = (MyList<String>) map.values();
		MyList<String> expected = new MyList<>();
		expected.add("jedan");
		expected.add("dva");
		expected.add("tri");
		expected.add("cetiri");
		assertTrue(values.containsAll(expected));
	}
	

}
