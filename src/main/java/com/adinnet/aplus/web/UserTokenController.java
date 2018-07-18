/**
 * 
 */
package com.adinnet.aplus.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adinnet.aplus.model.UserToken;
import com.adinnet.framework.web.BaseController;

/**
 * @author zhurui
 *
 */
@Controller
@RequestMapping("/userToken")
public class UserTokenController extends BaseController<UserToken> {

}
