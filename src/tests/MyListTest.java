package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import collections.MyList;

public class MyListTest {
	MyList<String> list;

	@Before
	public void setUp() {
		list = new MyList<>();
	}

	@Test
	public void shouldReturnTrueIfElementIsAddedToList() {
		String str = "Stirng";
		list.add(str);
		
		assertTrue(list.contains(str));
	}

	@Test
	public void shouldReturnTrueIfElementIsAddedOnEnteredIndexPosition() {
		list.add("1st");
		list.add("1st");
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
}
