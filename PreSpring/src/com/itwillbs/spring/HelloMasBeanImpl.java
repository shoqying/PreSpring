package com.itwillbs.spring;

public class HelloMasBeanImpl implements HelloMsgBean {

	@Override
	public void sayHelloMsgI(String name) {
		System.out.println(name + "님 안녕하세요 (sayHelloMsgI)");
		
	}
 
}
