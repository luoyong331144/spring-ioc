package name.luoyong.spring.basic.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	@Autowired
	// @Qualifier("userDao")  // 如果有多个可装配的 bean ， 则必须指定 @Qualifier
	private UserDao userDao;
	
	public void save() {
		userDao.persist();
	}
	
	public void delete() {
		userDao.remove();
	}

}
