package examples.collections;

import java.util.HashSet;
import java.util.Set;

class Test {
} // something to put in the Set

public class TestASet {
	public static void main(String[] args) {
		Set<Object> s = new HashSet<>(); // create the set
		Test t = new Test();
		s.add(t);
		s.add(t);
		s.add("One");
		s.add("Two");
		s.add("One");
		s.add("One");
		s.add("Three");
		s.add("Four");
		s.add("Four");
		s.add("Four");
		s.add(new Test()); /// not a duplicate
		System.out.println(s);
	}
}