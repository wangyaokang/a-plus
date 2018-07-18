/**
 * 
 */
package com.adinnet.aplus.service.impl;

import org.springframework.stereotype.Service;

import com.adinnet.aplus.model.User;
import com.adinnet.aplus.service.UserService;
import com.adinnet.framework.service.impl.BaseServcieImpl;

/**
 * @author zhurui
 *
 */
@Service
public class UserServiceImpl extends BaseServcieImpl<User> implements UserService {

	/* (non-Javadoc)
	 * @see com.adinnet.aplus.service.UserService#getAnonymous()
	 */
	@Override
	public User getAnonymous() {
		return User.Anonymous;
	}

}
