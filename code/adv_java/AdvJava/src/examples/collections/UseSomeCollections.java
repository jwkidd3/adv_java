package examples.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class UseSomeCollections {
	public static void main(String[] args) {
		Collection arrayList = new ArrayList();
		Collection hashSet = new HashSet();
		Collection treeSet = new TreeSet();
		Collection linkList = new LinkedList();
		arrayList = Fill.init(arrayList, 5);
		hashSet = Fill.init(hashSet, 5);
		treeSet = Fill.init(treeSet, 5);
		linkList = Fill.init(linkList, 5);
		System.out.println("ArrayList");
		System.out.println(arrayList);
		System.out.println("HashSet");
		System.out.println(hashSet);
		System.out.println("TreeSet");
		System.out.println(treeSet);
		System.out.println("LinkedList");
		System.out.println(linkList);

		Fill.deleteSecond(arrayList);
		System.out.println(arrayList);
		System.out.println("HashSet");
		Fill.deleteSecond(hashSet);
		System.out.println(hashSet);
		System.out.println("TreeSet");
		Fill.deleteSecond(treeSet);
		System.out.println(treeSet);
		System.out.println("LinkedList");
		Fill.deleteSecond(linkList);
		System.out.println(linkList);
	}
}