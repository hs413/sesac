package com.example.sbb;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {
	private final String hello;
	private final int lombok;

	public HelloLombok(String hello, int lombok) {
		this.hello = hello;
		this.lombok = lombok;
	}

	public static void main(String[] args) {
		HelloLombok helloLombok = new HelloLombok("헬로", 5);
		helloLombok.getHello();
		helloLombok.getLombok();
	}
}
