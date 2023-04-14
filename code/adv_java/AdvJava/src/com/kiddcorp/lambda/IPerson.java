package com.kiddcorp.lambda;

public interface IPerson {
	
	public String do1();
	
	public default String do2()
	{
		return "Hello from do2";
	}

}
