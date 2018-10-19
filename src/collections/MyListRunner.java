package collections;

import java.util.ListIterator;

public class MyListRunner {

	public static void main(String[] args) {
		MyList<String> list = new MyList<>();
		list.add("1");
		list.add( "2");
		
		ListIterator<String> li = list.listIterator();

		System.out.println(li.next());
		System.out.println(li.next());
	
		li.add("dodaj");
		System.out.println(li.next());
		li.previous();
		System.out.println(li.next());
	}

}
