package examples.generics;

import java.util.List;

public class MyGenericTester {

	public static void main(String[] args) {
		MyGeneric<List<Integer>, Integer> x = new MyGeneric<List<Integer>, Integer>();
		x.setMyVar(null);
		x.setNum(99);

		System.out.println(x.getMyVar() + " - " + x.getNum());
	}

}
