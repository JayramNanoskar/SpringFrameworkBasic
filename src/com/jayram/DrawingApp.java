package com.jayram;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		//Using ClassPathXmlApplicationContext because going to use xml file and xml file will contain blueprint for beans to instantiate
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle = (Triangle)context.getBean("triangle-name"); //Getting required bean from Spring containers ApplicationContext
		triangle.draw(); 
		Triangle triangle1 = (Triangle)context.getBean("triangle-alias");
		triangle1.draw();
	}

}
