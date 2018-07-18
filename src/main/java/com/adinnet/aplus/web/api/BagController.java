/**
 * 
 */
package com.adinnet.aplus.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adinnet.aplus.annotation.Logined;
import com.adinnet.aplus.service.FavoriteService;
import com.adinnet.aplus.web.api.param.Input;
import com.adinnet.aplus.web.api.param.Output;

/**
 * 书包相关接口
 * 
 * @author zhurui
 *
 */
@Controller("apiBag")
@RequestMapping("/api/bag")
public class BagController extends AbstractController {

	@Autowired
	FavoriteService favoriteService;
	
	/**
	 * 获得我的书包内课程或考点的列表
	 * <p>传入参数：</p>
	 * <pre>
	 * method:getBags
	 * token:当前TOKEN信息
	 * params:{"type":"1","group":"time"}
	 * - type: 1表示课程，2表示考点
	 * - group: 标示“按时间”、“按学科”、“按提纲”
	 * </pre>
	 * @param input
	 * @return
	 */
	@Logined
	public Output getBags(Input input) {
		Output result = new Output();
		
		result.setStatus(SUCCESS);
		result.setMsg("获得我的书包内容");
		return result;
	}
}
