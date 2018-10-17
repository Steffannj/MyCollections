package collections;

import java.util.ListIterator;

public class MyListRunner {

	public static void main(String[] args) {
		MyList<String> list = new MyList<>();
		list.add("String");
		list.add( "asd");
		list.add("String");
		list.add("Sasdfa");
		
	
		ListIterator<String> li = list.listIterator();
		
		System.out.println(li.next());
		System.out.println(li.next());
		System.out.println(li.next());
		System.out.println(li.next());
		
		
	}

}
