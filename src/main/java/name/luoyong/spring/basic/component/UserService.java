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
