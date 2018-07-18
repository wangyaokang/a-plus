/**
 * 
 */
package com.adinnet.aplus.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adinnet.aplus.model.User;
import com.adinnet.framework.web.BaseController;

/**
 * @author zhurui
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User> {

}
