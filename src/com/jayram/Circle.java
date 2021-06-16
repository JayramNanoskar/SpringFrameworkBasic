package com.jayram;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape{
	private Point center;
	
	@Autowired
	@Qualifier("messageSource1") //There are 2 beans of MessageSource type present in configuration and name specified here also not matching with any of beans in configuration. Hence, Qualifier needed to get wired with desired bean.
	private MessageSource ms;
	
	public MessageSource getMs() {
		return ms;
	}

	public void setMs(MessageSource ms) {
		this.ms = ms;
	}

	public Point getCenter() {
		return center;
	}

	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}

	@PostConstruct
	public void initializeCircle(){
		System.out.println("Init of Circle");
	}

	@PreDestroy
	public void destroyCircle(){
		System.out.println("Destroy of Circle");
	}

	@Override
	public void draw() {
		System.out.println(this.ms.getMessage("drawing.circle", null, "Default Drawing from Circle!!", null));
		System.out.println(this.ms.getMessage("drawing.point", new Object[]{center.getX(), center.getY()}, "Default Point message!!", null));
		System.out.println(this.ms.getMessage("greeting", null, "Default Greeting from Circle!!", null));
	}

}
