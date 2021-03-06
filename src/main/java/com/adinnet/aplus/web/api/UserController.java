/**
 * 
 */
package com.adinnet.aplus.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adinnet.aplus.annotation.Logined;
import com.adinnet.aplus.model.User;
import com.adinnet.aplus.service.UserService;
import com.adinnet.aplus.web.api.param.Input;
import com.adinnet.aplus.web.api.param.Output;

/**
 * 个人相关接口
 * 
 * @author zhurui
 *
 */
@Controller("apiUser")
@RequestMapping("/api/user")
public class UserController extends AbstractController {

	@Autowired
	UserService userService;
	
	/**
	 * 获得当前用户的个人信息
	 * <p>传入参数：</p>
	 * <pre>
	 * method:info
	 * token:当前TOKEN信息
	 * </pre>
	 * @param input
	 * @return
	 */
	@Logined
	public Output info(Input input) {
		Output result = new Output();
		
		result.setStatus(SUCCESS);
		result.setMsg("获得个人信息");
		result.setData(input.getCurrentUser());
		return result;
	}
	
	/**
	 * 修改个人信息
	 * <p>传入参数：</p>
	 * <pre>
	 * method:modify
	 * token:当前TOKEN信息
	 * params:{当前所有信息JSON格式}
	 * </pre>
	 * @param input
	 * @return
	 */
	@Logined
	public Output modify(Input input) {
		Output result = new Output();
		
		result.setStatus(SUCCESS);
		result.setMsg("个人信息修改成功");
		result.setData(User.Anonymous);
		return result;
	}
	
	/**
	 * 用户反馈
	 * <p>传入参数：</p>
	 * <pre>
	 * method:feedback
	 * token:当前TOKEN信息
	 * params:{"content":"反馈内容"}
	 * </pre>
	 * @param input
	 * @return
	 */
	@Logined
	public Output feedback(Input input) {
		Output result = new Output();
		
		result.setStatus(SUCCESS);
		result.setMsg("用户反馈提交成功");
		return result;
}
}
