package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

import collections.MyList;

public class MyListTest {
	MyList<String> list;

	@Before
	public void setUp() {
		list = new MyList<>();
		list.add("1st");
		list.add("2nd");
	}

	@Test
	public void shouldReturnTrueIfElementIsAddedToList() {
		String str = "Stirng";
		list.add(str);
		
		assertTrue(list.contains(str));
	}

	@Test
	public void shouldReturnTrueIfElementIsAddedOnEnteredIndexPosition() {
		
		list.add(1, "2nd");
		list.add(2, "3rd");
		
		assertTrue(list.get(1).equals("2nd"));
		assertTrue(list.get(2).equals("3rd"));
	}
	
	@Test 
	public void shouldReturnTrueIfCollectionIsAddedToList() {
		ArrayList<String> al = new ArrayList<>();
		al.add("str1");
		al.add("str2");
		list.addAll(al);
		
		assertTrue(al.get(0).equals("str1") && al.get(1).equals("str2"));
	}
	
	@Test
	public void shouldReturnEqualsIfCollectionIsAddedToIndexPositionInList() {
		ArrayList<String> al = new ArrayList<>();
	
		
		al.add("str1");
		al.add("str2");
		list.addAll(0, al);
		String result = list.get(0)+" "+list.get(1)+" "+list.get(2)+" "+list.get(3);
		assertEquals("str1 str2 1st 2nd", result);
	}
	
	@Test
	public void shouldReturn0IfListIsCleared() {
	
		list.clear();
		assertEquals(0, list.size());
	}
	
	@Test
	public void shouldReturnTrueIfListContainsAllElementsFromCollection() {
		ArrayList<String> al = new ArrayList<>();
		list.add("3rd");
		
		al.add("2nd");
		al.add("3rd");
		
		assertTrue(list.containsAll(al));
		al.add("4th");
		assertFalse(list.containsAll(al));
		
	}
	
	@Test
	public void shouldReturnIndexOfElementInList() {
		assertEquals(0, list.indexOf("1st"));
	}
	
	@Test
	public void shouldReturnTrueIfListIsEmpty() {
		assertFalse(list.isEmpty());
		list.clear();
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void shouldReturnTrueIfIteratorHasNext() {
		Iterator<String> it = list.iterator();
		assertTrue(it.hasNext());
		assertEquals("1st", it.next());
		it.next();

		assertFalse(it.hasNext());
	}
	
	@Test
	public void shouldReturnLastIndexOfElement() {
		list.add("1st");
		assertEquals(2, list.lastIndexOf("1st"));
	}
	
	@Test
	public void shouldListIteratorWorksPropertly() {
		ListIterator<String> li = list.listIterator();
		
		assertFalse(li.hasPrevious());
		assertTrue(li.hasNext());
		assertEquals("1st", li.next());
		assertTrue(li.hasPrevious());
		assertEquals(2, li.nextIndex());
		li.remove();
		assertEquals(0, li.previousIndex());
		assertEquals("1st", li.previous());
		assertEquals(-1, li.previousIndex());
		li.set("2nd");
		li.add("3rd");
		assertTrue(list.contains("3rd"));
		li.next();
		li.next();
		assertEquals(2, li.nextIndex());
	}
	@Test
	public void shouldListIteratorFromIndexWorksPropertly() {
		ListIterator<String> li = list.listIterator(0);
		
		assertFalse(li.hasPrevious());
		assertTrue(li.hasNext());
		assertEquals("1st", li.next());
		assertTrue(li.hasPrevious());
		assertEquals(2, li.nextIndex());
		li.remove();
		assertEquals(0, li.previousIndex());
		assertEquals("1st", li.previous());
		assertEquals(-1, li.previousIndex());
		li.set("2nd");
		li.add("3rd");
		assertTrue(list.contains("3rd"));
		li.next();
		li.next();
		assertEquals(2, li.nextIndex());
	}
	
	@Test
	public void shouldReturnTrueIfElementIsRemoved() {
		assertFalse(list.remove("3rd"));
		assertTrue(list.remove("1st"));
	}
	
	@Test
	public void shouldReturnTrueIfElementIsRemovedFromEnteredIndex() {
		assertEquals(null, list.remove(3));
		assertEquals("1st", list.remove(0));
		assertEquals("2nd", list.remove(0));
	
	}
	
	@Test
	public void shouldReturnTrueIfAllElementsAreRemoved() {
		list.add("3rd");
		ArrayList<String> al = new ArrayList<>();
		al.add("1st");
		al.add("3rd");
		assertTrue(list.removeAll(al));
		assertFalse(list.contains("1st"));
	}
	
	@Test
	public void shouldReturnTrueIfAllElementsAreRetained() {
		ArrayList<String> al = new ArrayList<>();
		al.add("1st");
		assertTrue(list.retainAll(al));
		assertFalse(list.contains("2nd"));
	}
	
	@Test
	public void shouldReturnSublist() {
		list.add("3rd");
		List<String> sublist = list.subList(0, 2);
		assertEquals("1st 2nd", sublist.get(0)+" "+sublist.get(1));
	}
	
	@Test
	public void shouldReturnListToArray() {
		Object[] array = list.toArray();
		assertArrayEquals(array, list.toArray());
	}
	
	@Test
	public void shouldReturnStringArrayOfList() {
		String[] array = new String[2];
		array[0] = "1st";
		array[1] = "2nd";
		String[] newArray = list.toArray(array);
		assertArrayEquals(array, newArray);
	}
}
