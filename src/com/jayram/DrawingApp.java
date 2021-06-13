package com.jayram;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		//Using XmlBeanFactory because going to use xml file and xml file will contain blueprint for beans to instantiate
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		Triangle triangle = (Triangle)factory.getBean("triangle"); //Getting required bean from Spring containers Bean factory
		triangle.draw(); 
	}

}
