/**
 * 
 */
package com.adinnet.aplus.service;

import com.adinnet.aplus.model.User;
import com.adinnet.framework.service.BaseService;

/**
 * @author zhurui
 *
 */
public interface UserService extends BaseService<User> {

	public User getAnonymous();
}
