package examples.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TestAList {
	public static void main(String[] args) {
		List<Object> L = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			L.add("" + i);
		}
		System.out.println("List created");
		System.out.println(L);
		L.add(4, "10");
		System.out.println(L);
		L.set(5, "11");
		System.out.println(L);
		ListIterator itl = L.listIterator(4);
		System.out.println("L[4]=" + L.get(4));
		itl.previous();
		itl.remove();
		System.out.println(L);
	}
}