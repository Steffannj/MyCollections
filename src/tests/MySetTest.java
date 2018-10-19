package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import collections.MySet;

public class MySetTest {

	MySet<String> set;
	
	@Before
	public void setUp() {
		set = new MySet<>();
		set.add("1st");
	}
	
	@Test
	public void shouldReturnTrueIfElementIsAdded() {
		set.add("1st");
		set.add("2nd");
		assertTrue(set.contains("2nd"));
	}
	
	@Test 
	public void shouldReturnTrueIfCollectionIsAdded() {
		ArrayList<String> al = new ArrayList<>();
		al.add("2nd");
		al.add("3rd");
		set.addAll(al);
		assertTrue(set.contains("3rd"));	
	}
	
	@Test
	public void shouldReturnTrueIfSetContainsAllElementsFromCollection() {
		ArrayList<String> al = new ArrayList<>();
		al.add("2nd");
		al.add("1st");
		assertFalse(set.containsAll(al));
		set.add("2nd");
		assertTrue(set.containsAll(al));
	}

	@Test 
	public void shouldReturnTrueIfSetIsEmpty() {
		assertFalse(set.isEmpty());
		set.clear();
		assertTrue(set.isEmpty());
	}
	
	@Test
	public void shouldAddAllElementsToStringThroughForEachLoopUsingIterator() {
		set.add("2nd");
		set.add("3rd");
		
		@SuppressWarnings("unused")
		String s = "";
		for (String string : set) {
			s += string;
		}
	}
	
	@Test
	public void shouldReturnTrueIfElementIsSuccessfullyRemoved() {
		set.add("2nd");
		set.add("3rd");
		set.add("4th");
	
		assertTrue(set.remove("2nd"));
		assertFalse(set.remove("2nd"));
		
	}
	
	@Test
	public void shouldReturnTrueIfAllElementsFromSetWhichAreContainedInCollectionAreRemoved() {
		ArrayList<String> al = new ArrayList<>();
		al.add("1st");
		al.add("2nd");
		al.add("4th");
		
		set.add("2nd");
		set.add("3rd");
		
		assertTrue(set.removeAll(al));
	
	}
	
	@Test
	public void shouldReturnTrueIfAllElementsFromSetWhichAreNotContainedInCollectionAreRemoved() {
		ArrayList<String> al = new ArrayList<>();
		al.add("2nd");
		al.add("1st");
		
		set.add("2nd");
		set.add("3rd");
		
		assertTrue(set.retainAll(al));
	}
	
	@Test
	public void shouldReturnSetToArray(){
		Object[] array = set.toArray();
		assertArrayEquals(array, set.toArray());
	}
	
	@Test
	public void shouldReturnStringArrayOfSet() {
		String[] array = new String[2];
		array[0] = "1st";
		array[1] = "2nd";
		String[] newArray = set.toArray(array);
		assertArrayEquals(array, newArray);
	}
}
