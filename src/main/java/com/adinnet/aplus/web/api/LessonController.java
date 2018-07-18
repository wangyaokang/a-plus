/**
 * 
 */
package com.adinnet.aplus.web.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adinnet.aplus.annotation.Logined;
import com.adinnet.aplus.model.Course;
import com.adinnet.aplus.model.Item;
import com.adinnet.aplus.model.Lesson;
import com.adinnet.aplus.model.Material;
import com.adinnet.aplus.model.Unit;
import com.adinnet.aplus.model.User;
import com.adinnet.aplus.service.CourseService;
import com.adinnet.aplus.service.ItemService;
import com.adinnet.aplus.service.LessonService;
import com.adinnet.aplus.service.MaterialService;
import com.adinnet.aplus.service.UnitService;
import com.adinnet.aplus.util.Constants;
import com.adinnet.aplus.web.api.param.Input;
import com.adinnet.aplus.web.api.param.Output;

/**
 * 视频课程相关接口
 * 
 * @author zhurui
 *
 */
@Controller("apiLesson")
@RequestMapping("/api/lesson")
public class LessonController extends AbstractController {

	@Autowired
	CourseService courseService;
	
	@Autowired
	MaterialService materialService;
	
	@Autowired
	UnitService unitService;
	
	@Autowired
	LessonService lessonService;
	
	@Autowired
	ItemService itemService;
	
	/**
	 * 首页课程列表（1A_视频课程_理科.png）
	 * <p>传入参数：</p>
	 * <pre>
	 * method:getSubjectList
	 * token:当前TOKEN信息
	 * params:{"schoolType":"1","schoolSystem":"1","grade":"1"} 非必填
	 * </pre>
	 * @param input
	 * @return
	 */
	@Logined
	public Output getSubjectList(Input input) {
		Output result = new Output();

		User user = input.getCurrentUser();
		
		Map<String, Object> data = new HashMap<>();
		// 分科判断
		Map<String, Object> params = new HashMap<>();
		// 主科
		params.put("subject", Course.MAJOR);
		data.put(Constants.Subject.MAJOR, toArray(courseService.query(params)));
		if (user.getSubject() == User.DEFAULT || user.getSubject() == User.ARTS) {
			// 文科
			params.put("subject", Course.ARTS);
			data.put(Constants.Subject.ARTS, toArray(courseService.query(params)));
		}
		if (user.getSubject() == User.DEFAULT || user.getSubject() == User.SCIENCE) {
			// 理科
			params.put("subject", Course.SCIENCE);
			data.put(Constants.Subject.SCIENCE, toArray(courseService.query(params)));
		}
		
		result.setStatus(SUCCESS);
		result.setMsg("获得学科列表");
		result.setData(data);
		return result;
	}
	
	/**
	 * 课程列表（7A_视频课程_首页_更多.png）
	 * <p>传入参数：</p>
	 * <pre>
	 * method:getCourseList
	 * token:当前TOKEN信息
	 * params:{"schoolType":"1","schoolSystem":"1","grade":"1","subject":"1"} 非必填
	 * </pre>
	 * @param input
	 * @return
	 */
	@Logined
	public Output getCourseList(Input input) {
		Output result = new Output();
		
		Map<String, Object> params = input.getParams();
		List<Course> data = courseService.query(params);
		
//		List<Course> data = new ArrayList<>();
//		data.add(MockHelper.getCourseChinese());
//		data.add(MockHelper.getCoursePhysics());
		
		result.setStatus(SUCCESS);
		result.setMsg("获得学科列表");
		result.setData(toArray(data));
		return result;
	}
	
	/**
	 * 学科详情
	 * <p>传入参数：</p>
	 * <pre>
	 * method:getCourse
	 * token:当前TOKEN信息
	 * params:{"courseId":"1"}
	 * </pre>
	 * @param input
	 * @return
	 */
	@Logined
	public Output getCourse(Input input) {
		Output result = new Output();
		// 学科
		Long courseId = input.getLong("courseId");
		Course course = courseService.get(courseId);
		if (course == null) {
			return new Output(ERROR_NO_RECORD, "找不到相应的学科");
		}
		// 教材列表
		Map<String, Object> params = input.getParams();
		List<Material> materials = materialService.query(params);
		
		result.setStatus(SUCCESS);
		result.setMsg("获得学科详情");
		result.setData(toMap(course, materials));
		return result;
	}
	
	/**
	 * 选择教材列表
	 * <p>传入参数：</p>
	 * <pre>
	 * method:getMaterialList
	 * token:当前TOKEN信息
	 * params:{"courseId":"1",...}
	 * </pre>
	 * @param input
	 * @return
	 */
	public Output getMaterialList(Input input) {
		Output result = new Output();
		
		Map<String, Object> params = input.getParams();
		List<Material> list = materialService.query(params);
		
		result.setStatus(SUCCESS);
		result.setMsg("获得教材列表");
		result.setData(toArray(list));
		return result;
	}
	
	/**
	 * 获得教材详情
	 * <p>传入参数：</p>
	 * <pre>
	 * method:getMaterial
	 * token:当前TOKEN信息
	 * params:{"materialId":"1"}
	 * </pre>
	 * @param input
	 * @return
	 */
	@Logined
	public Output getMaterial(Input input) {
		Output result = new Output();
		// 教材
		Long materialId = input.getLong("materialId");
		Material material = materialService.get(materialId);
		if (material == null) {
			return new Output(ERROR_NO_RECORD, "找不到相应的教材");
		}
		// 单元列表
		Map<String, Object> params = input.getParams();
		List<Unit> units = unitService.query(params);
		
		result.setStatus(SUCCESS);
		result.setMsg("获得教材信息");
		result.setData(toMap(material, units));
		return result;
	}
	
	/**
	 * 获得单元列表
	 * <p>传入参数：</p>
	 * <pre>
	 * method:getUnitList
	 * token:当前TOKEN信息
	 * params:{"materialId":"1",...}
	 * </pre>
	 * @param input
	 * @return
	 */
	public Output getUnitList(Input input) {
		Output result = new Output();
		
		Map<String, Object> params = input.getParams();
		List<Unit> list = unitService.query(params);
		
		result.setStatus(SUCCESS);
		result.setMsg("获得单元列表");
		result.setData(toArray(list));
		return result;
	}
	
	/**
	 * 获得单元详情
	 * <p>传入参数：</p>
	 * <pre>
	 * method:getUnit
	 * token:当前TOKEN信息
	 * params:{"materialId":"1"}
	 * </pre>
	 * @param input
	 * @return
	 */
	@Logined
	public Output getUnit(Input input) {
		Output result = new Output();
		// 单元
		Long unitId = input.getLong("unitId");
		Unit unit = unitService.get(unitId);
		if (unit == null) {
			return new Output(ERROR_NO_RECORD, "找不到对应的单元");
		}
		// 课程列表
		Map<String, Object> params = input.getParams();
		List<Lesson> lessons = lessonService.query(params);
		
		result.setStatus(SUCCESS);
		result.setMsg("获得单元详情");
		result.setData(toMap(unit, lessons));
		return result;
	}
	
	/**
	 * 获得课程列表
	 * <p>传入参数：</p>
	 * <pre>
	 * method:getLessonList
	 * token:当前TOKEN信息
	 * params:{"materialId":"1","unitId":"1",...}
	 * </pre>
	 * @param input
	 * @return
	 */
	public Output getLessonList(Input input) {
		Output result = new Output();
		
		Map<String, Object> params = input.getParams();
		List<Lesson> lessons = lessonService.query(params);
		
		result.setStatus(SUCCESS);
		result.setMsg("获得课程列表");
		result.setData(toArray(lessons));
		return result;
	}
	
	/**
	 * 获得课程详情
	 * <p>传入参数：</p>
	 * <pre>
	 * method:getLesson
	 * token:当前TOKEN信息
	 * params:{"lessonId":"1"}
	 * </pre>
	 * @param input
	 * @return
	 */
	@Logined
	public Output getLesson(Input input) {
		Output result = new Output();
		// 课程
		Long lessonId = input.getLong("lessonId");
		Lesson lesson = lessonService.get(lessonId);
		if (lesson == null) {
			return new Output(ERROR_NO_RECORD, "找不到对应的课程");
		}
		// 视频课件列表
		Map<String, Object> params = input.getParams();
		List<Item> items = itemService.query(params);
		
		result.setStatus(SUCCESS);
		result.setMsg("获得课程详情");
		result.setData(toMap(lesson, items));
		return result;
	}
	
	/**
	 * 获得课程视频列表
	 * <p>传入参数：</p>
	 * <pre>
	 * method:getItemList
	 * token:当前TOKEN信息
	 * params:{"lessonId":"1",...}
	 * </pre>
	 * @param input
	 * @return
	 */
	public Output getItemList(Input input) {
		Output result = new Output();
		
		Map<String, Object> params = input.getParams();
		List<Item> items = itemService.query(params);
		
		result.setStatus(SUCCESS);
		result.setMsg("获得课程视频列表");
		result.setData(toArray(items));
		return result;
	}
	
	/**
	 * 获得课程视频详情
	 * <p>传入参数：</p>
	 * <pre>
	 * method:getItem
	 * token:当前TOKEN信息
	 * params:{"itemId":"1"}
	 * </pre>
	 * @param input
	 * @return
	 */
	@Logined
	public Output getItem(Input input) {
		Output result = new Output();
		
		Long itemId = input.getLong("itemId");
		Item item = itemService.get(itemId);
		if (item == null) {
			return new Output(ERROR_NO_RECORD, "找不到对应的课件视频");
		}
		
		result.setStatus(SUCCESS);
		result.setMsg("获得课程视频详情");
		result.setData(toMap(item));
		return result;
	}
	
	/**
	 * 收藏
	 * <p>传入参数：</p>
	 * <pre>
	 * method:getLessonInfo
	 * token:当前TOKEN信息
	 * params:{"type":"1","targetId":"1"}
	 * 其中：type: 1表示课程，2表示考点
	 * </pre>
	 * @param input
	 * @return
	 */
	@Logined
	public Output addFavorite(Input input) {
		Output result = new Output();
		
		result.setStatus(SUCCESS);
		result.setMsg("课程收藏成功");
		return result;
	}
	
	/**
	 * 用户反馈
	 * 
	 * @param input
	 * @return
	 */
	@Logined
	public Output feedback(Input input) {
		Output result = new Output();
		
		result.setStatus(SUCCESS);
		result.setMsg("获得课程详情");
		return result;
	}
	
}
