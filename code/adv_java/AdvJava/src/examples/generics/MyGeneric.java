package examples.generics;

import java.util.Collection;

public class MyGeneric<T extends Collection<? extends Object>,Q extends Number> {
	private T myVar;
	private Q num;
	
	
	public T getMyVar() {
		return myVar;
	}
	public void setMyVar(T myVar) {
		this.myVar = myVar;
	}
	public Q getNum() {
		return num;
	}
	public void setNum(Q num) {
		this.num = num;
	}
	
	

}
