package name.luoyong.spring.basic;

import name.luoyong.spring.basic.component.UserService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		UserService us = (UserService) ctx.getBean("userService");

		us.save();
		us.delete();
	}

}
