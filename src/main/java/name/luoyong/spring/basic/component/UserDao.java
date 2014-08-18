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
