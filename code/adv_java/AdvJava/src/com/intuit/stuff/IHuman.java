package com.intuit.stuff;

public interface IHuman {

	public default String do3() {
		return "hello from other do3";
	}
}
