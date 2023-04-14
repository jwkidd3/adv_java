package com.kiddcorp.lambda;

public interface IHuman {

	public default String doHuman() {

		return "I am human!!";
	}
	
	public default String do2(String g)
	{
		return "Hello from do2";
	}
}
