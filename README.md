
#### pom.xml
``` xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>name.luoyong.spring</groupId>
	<artifactId>spring-ioc</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>spring-ioc</name>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<spring.version>4.0.3.RELEASE</spring.version>
		<junit.version>4.11</junit.version>
	</properties>

	<dependencies>
	
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>${junit.version}</version>
		</dependency>

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${spring.version}</version>
		</dependency>

	</dependencies>

</project>
```

#### applicationContext.xml
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans" 
	xmlns:aop="http://www.springframework.org/schema/aop" 
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:mvc="http://www.springframework.org/schema/mvc" 
	xmlns:tx="http://www.springframework.org/schema/tx" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/aop 
	http://www.springframework.org/schema/aop/spring-aop-3.0.xsd 
	http://www.springframework.org/schema/beans 
	http://www.springframework.org/schema/beans/spring-beans-3.0.xsd 
	http://www.springframework.org/schema/context 
	http://www.springframework.org/schema/context/spring-context-3.0.xsd 
	http://www.springframework.org/schema/mvc 
	http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd 
	http://www.springframework.org/schema/tx 
	http://www.springframework.org/schema/tx/spring-tx-3.0.xsd">
	
	<context:component-scan base-package="name.luoyong.*" />

</beans>
```

#### java test
``` java
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
```

``` java
package name.luoyong.spring.basic.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	@Autowired
	// @Qualifier("userDao")  // Optional
	private UserDao userDao;
	
	public void save() {
		userDao.persist();
	}
	
	public void delete() {
		userDao.remove();
	}

}

```

``` java
package name.luoyong.spring.basic.component;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	
	public void persist() {
		System.out.println("do persist User");
	}
	
	public void remove() {
		System.out.println("do remove User");
	}

}

```