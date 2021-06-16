package com.jayram;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		//Using ClassPathXmlApplicationContext because going to use xml file and xml file will contain blueprint for beans to instantiate
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		Shape shape = (Shape)context.getBean("circle"); //Getting required bean from Spring containers ApplicationContext
		shape.draw(); 
		System.out.println(context.getMessage("greeting", null, "Default Greeting from Main!!", null)); //ApplicationContext also implements MessageSource interface, so getMessage gets available with default configuration but it can be override with custom configuration.
	}

}
