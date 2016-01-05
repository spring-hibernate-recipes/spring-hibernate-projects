package org.aryalinux;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("model.xml");
		
		classPathXmlApplicationContext.close();
	}
}
