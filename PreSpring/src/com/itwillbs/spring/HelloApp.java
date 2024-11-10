package com.itwillbs.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloApp {
	
	public static void sayHello(String name) {
		System.out.println(name + "님 안녕하세요");
	}

	public static void main(String[] args) {
		
		// 1. 변수, 코드 직접 사용 "ㅇㅇㅇ님 안녕하세요" 출력
		System.out.println("아이티윌님 안녕하세요");
		
		String name = "부산";
		System.out.println(name + "님 안녕하세요");
		
		// 2. 동작을 모듈화 => 메서드로 생성
		sayHello("메서드 호출");
		
		// 3. 객체를 생성
		
		// HelloApp(나)는 HelloMessageBean 객체를 생성해서 사용
		// => sayHelloMsg("333333");가 실행될려면 객체 없으면 안됨/있어야만 한다
		// => HelloApp은 HelloMessageBean 객체가 없으면 안됨
		// => HelloApp은 HelloMessageBean 객체를 의존하고 있다(의존관계)
		// => 객체간의 "강한" 결합 사용
		
		HelloMessageBean hmb = new HelloMessageBean();
		hmb.sayHelloMsg("333333");
		
		// 4. 인터페이스를 상속한 객체를 구현
		
		// "강한" 결함
		HelloMasBeanImpl msgBeanImpl = new HelloMasBeanImpl();
		msgBeanImpl.sayHelloMsgI("4444");
		
		// 업캐스팅 => "약한" 결합
		HelloMsgBean msgBean = new HelloMasBeanImpl();
		msgBean.sayHelloMsgI("4-1");
		
		// 5. 스프링을 사용한 객체 사용
		
		// 스프링/마트 의 정보가 필요
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans.xml"));
		
		// HelloMsgBeanImpl 객체를 생성해서 정보 사용
		HelloMsgBean msgBean1 = (HelloMsgBean)factory.getBean("msgBean1");
		msgBean.sayHelloMsgI("555555");
		
		// xml 파일에 bean 객체 생성후
		// @inject
		// private HelloMsgBean msgBean2;
		// msgBean2.sayHelloMsgI("5-1");
	}
}


















