/**
 * 
 */
package com.adinnet.aplus.web.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.adinnet.aplus.annotation.Logined;
import com.adinnet.aplus.exception.AplusException;
import com.adinnet.aplus.model.Course;
import com.adinnet.aplus.model.Exam;
import com.adinnet.aplus.model.Favorite;
import com.adinnet.aplus.model.Feedback;
import com.adinnet.aplus.model.Item;
import com.adinnet.aplus.model.Lesson;
import com.adinnet.aplus.model.Material;
import com.adinnet.aplus.model.Model;
import com.adinnet.aplus.model.Teacher;
import com.adinnet.aplus.model.Unit;
import com.adinnet.aplus.model.User;
import com.adinnet.aplus.service.UserService;
import com.adinnet.aplus.service.UserTokenService;
import com.adinnet.aplus.web.api.param.Input;
import com.adinnet.aplus.web.api.param.Output;
import com.adinnet.framework.util.RandomUtils;
import com.adinnet.framework.web.WebxController;
import com.alibaba.fastjson.JSONObject;

/**
 * 基础Controller
 * 
 * @author zhurui
 *
 */
public abstract class AbstractController implements WebxController {

	protected transient Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("#{properties['web.upload.path']}")
	protected String uploadPath = "attachment/images/";
	
	@Value("#{properties['web.context.path']}")
	protected String contextPath = "http://localhost:8080/aplus/";
	
	@Autowired
	protected ServletContext context;
	
	@Autowired
	protected UserService userService;
	
	@Autowired
	protected UserTokenService userTokenService;
	
	/**
	 * Dispatch
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody Output dispatch(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
	        //response.setContentType("text/html;charset=UTF-8"); // 设置Content-Type字段值
			response.setContentType("application/json;charset=UTF-8"); // 设置Content-Type字段值
			
	        // 读取请求参数
			Output result = doService(getInput(request));
			logger.info("执行乐师傅接口, 返回数据: " + JSONObject.toJSONString(result));
			return result;
		} catch (AplusException ae) {
			return new Output(ae.getStatus(), ae.getMessage());
		} catch (Exception ex) {
			ex.printStackTrace();
			return new Output(ERROR_UNKNOWN, ex.getMessage());
		}
	}
	
	/**
	 * 处理业务逻辑，使用反射执行<code>method</code>定义的方法，可重载
	 * @param input
	 * @return
	 */
	protected Output doService(Input input) {
		String method = input.getMethod();
		try {
			Method md = this.getClass().getDeclaredMethod(method, Input.class);
			// 如果有@Logined注解的需要做登录判断
			Annotation annotation = md.getAnnotation(Logined.class);
			if (annotation != null) {
				if (StringUtils.isEmpty(input.getToken())) {
					return new Output(ERROR_UNKNOWN, "当前用户未登录");
				} else {
					User currentUser = getCurrentUser(input.getToken());
					if (currentUser == null) {
						return new Output(ERROR_UNKNOWN, "当前用户未登录");
					}
					input.setCurrentUser(currentUser);	// 设置当前用户，便于复用
				}
			}
			return (Output) md.invoke(this, input);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return new Output(ERROR_NO_RECORD, "找不到对应的方法");
	}
	
	/**
	 * 获得输入参数
	 * @param request
	 * @return
	 * @throws IOException
	 */
	protected Input getInput(HttpServletRequest request) throws IOException {
		//request.setCharacterEncoding("UTF-8"); // 设置处理请求参数的编码格式
        // 读取JSON字符串
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		String jsonStr = sb.toString();
		if (StringUtils.isEmpty(jsonStr)) {
			jsonStr = request.getParameter("data");
		}
		logger.info("接口请求数据: " + jsonStr);
		if (StringUtils.isEmpty(jsonStr)) {
			throw new AplusException(ERROR_NO_RECORD, "请求参数为空");
		}
		return JSONObject.parseObject(jsonStr, Input.class);
	}
	
	/**
	 * 获得当前用户信息
	 * @param token
	 * @return
	 */
	protected User getCurrentUser(String token) {
		//TODO 获得当前用户
		return User.Anonymous;
	}
	
	/**
	 * 获得当前用户信息
	 * @param request
	 * @return
	 */
	protected User getCurrentUser(HttpServletRequest request) {
		try {
			Input input = getInput(request);
			String token = input.getToken();
			if (StringUtils.isNotEmpty(token)) {
				return getCurrentUser(token);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 用户
	 * @param course
	 * @return
	 */
	protected Map<String, Object> toMap(User user) {
		if (user == null) {
			return null;
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("id", user.getId());
		result.put("username", user.getUsername());
		result.put("mobile", user.getMobile());
		result.put("nickname", user.getNickname());
		result.put("sex", user.getNickname());
		result.put("avatarUrl", getImageUrlPath(user.getAvatarUrl()));
		result.put("regTime", user.getRegTime());
		result.put("subject", user.getSubject());
		result.put("schoolType", user.getSchoolType());
		result.put("schoolSystem", user.getSchoolSystem());
		result.put("grade", user.getGrade());
		result.put("mobileView", user.getMobileView());
		result.put("mobileDown", user.getMobileDown());
		result.put("status", user.getStatus());
		return result;
	}
	
	/**
	 * 教师
	 * @param course
	 * @return
	 */
	protected Map<String, Object> toMap(Teacher teacher) {
		if (teacher == null) {
			return null;
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("id", teacher.getId());
		if (teacher.getCourse() != null) {
			result.put("course", toMap(teacher.getCourse()));	
		}
		result.put("name", teacher.getName());
		result.put("avatarUrl", getImageUrlPath(teacher.getAvatarUrl()));
		result.put("status", teacher.getStatus());
		return result;
	}
	
	/**
	 * 收藏
	 * @param favorite
	 * @return
	 */
	protected Map<String, Object> toMap(Favorite favorite) {
		if (favorite == null) {
			return null;
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("id", favorite.getId());
		result.put("type", favorite.getType());
		result.put("status", favorite.getStatus());
		if (favorite.getUser() != null) {
			result.put("user", favorite.getUser());
		}
		if (favorite.getTarget() != null) {
			if (favorite.getType() == Favorite.ITEM) {
				result.put("target", toMap((Item) favorite.getTarget()));
			} else if (favorite.getType() == Favorite.EXAM) {
				result.put("target", toMap((Exam) favorite.getTarget()));
			}
		}
		return result;
	}
	
	/**
	 * 用户反馈
	 * @param feedback
	 * @return
	 */
	protected Map<String, Object> toMap(Feedback feedback) {
		if (feedback == null) {
			return null;
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("id", feedback.getId());
		result.put("content", feedback.getContent() );
		result.put("status", feedback.getStatus());
		if (feedback.getUser() != null) {
			result.put("user", feedback.getUser());
		}
		return result;
	}
	
	/**
	 * 学科
	 * @param course
	 * @return
	 */
	protected Map<String, Object> toMap(Course course) {
		if (course == null) {
			return null;
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("id", course.getId());
		result.put("name", course.getName());
		result.put("seq", course.getSeq());
		result.put("thumbUrl", getImageUrlPath(course.getThumbUrl()));
		result.put("subject", course.getSubject());
		result.put("status", course.getStatus());
		return result;
	}
	
	/**
	 * 学科，以及学科下的教材列表
	 * @param course
	 * @param materials
	 * @return
	 */
	protected Map<String, Object> toMap(Course course, Collection<Material> materials) {
		if (course == null) {
			return null;
		}
		
		Map<String, Object> result = toMap(course);
		
		if (materials != null && !materials.isEmpty()) {
			List<Map<String, Object>> list = new ArrayList<>();
			for (Material material : materials) {
				list.add(toMap(material));
			}
			result.put("materials", list);
		}
		return result;
	}
	
	/**
	 * 教材
	 * @param material
	 * @return
	 */
	protected Map<String, Object> toMap(Material material) {
		if (material == null) {
			return null;
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("id", material.getId());
		result.put("schoolType", material.getSchoolType());
		result.put("schoolSystem", material.getSchoolSystem());
		result.put("grade", material.getGrade());
		if (material.getCourse() != null) {
			result.put("course", toMap(material.getCourse()));	
		}
		result.put("semester", material.getSemester());
		result.put("name", material.getName());
		result.put("seq", material.getSeq());
		result.put("supportAR", material.getSupportAR());
		result.put("description", material.getDescription());
		result.put("status", material.getStatus());
		
		return result;
	}
	
	/**
	 * 教材，以及教材下的单元
	 * @param material
	 * @param units
	 * @return
	 */
	protected Map<String, Object> toMap(Material material, Collection<Unit> units) {
		if (material == null) {
			return null;
		}
		
		Map<String, Object> result = toMap(material);
		if (units != null && !units.isEmpty()) {
			List<Map<String, Object>> list = new ArrayList<>();
			for (Unit unit : units) {
				list.add(toMap(unit));
			}
			result.put("units", list);
		}
		return result;
	}
	
	/**
	 * 单元
	 * @param unit
	 * @return
	 */
	protected Map<String, Object> toMap(Unit unit) {
		if (unit == null) {
			return null;
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("id", unit.getId());
		if (unit.getMaterial() != null) {
			result.put("material", toMap(unit.getMaterial()));	
		}
		result.put("name", unit.getName());
		result.put("seq", unit.getSeq());
		result.put("description", unit.getDescription());
		result.put("status", unit.getStatus());
		//---- 用于显示 ----//
		if (unit.getCourse() != null) {
			result.put("course", toMap(unit.getCourse()));
		}
		
		return result;
	}
	
	/**
	 * 单元，以及单元下的课程
	 * @param unit
	 * @param lessons
	 * @return
	 */
	protected Map<String, Object> toMap(Unit unit, Collection<Lesson> lessons) {
		if (unit == null) {
			return null;
		}
		
		Map<String, Object> result = toMap(unit);
		
		if (lessons != null && !lessons.isEmpty()) {
			List<Map<String, Object>> list = new ArrayList<>();
			for (Lesson lesson : lessons) {
				list.add(toMap(lesson));
			}
			result.put("lessons", list);
		}
		return result;
	}
	
	/**
	 * 课程
	 * @param lesson
	 * @return
	 */
	protected Map<String, Object> toMap(Lesson lesson) {
		if (lesson == null) {
			return null;
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("id", lesson.getId());
		if (lesson.getUnit() != null) {
			result.put("unit", toMap(lesson.getUnit()));
		}
		result.put("name", lesson.getName());
		result.put("seq", lesson.getSeq());
		result.put("description", lesson.getDescription());
		result.put("status", lesson.getStatus());
		//---- 用于显示 ----//
		if (lesson.getCourse() != null) {
			result.put("course", toMap(lesson.getCourse()));
		}
		if (lesson.getMaterial() != null) {
			result.put("material", toMap(lesson.getMaterial()));
		}
		
		return result;
	}
	
	/**
	 * 课程，以及课程下的视频
	 * @param lesson
	 * @param items
	 * @return
	 */
	protected Map<String, Object> toMap(Lesson lesson, Collection<Item> items) {
		if (lesson == null) {
			return null;
		}
		
		Map<String, Object> result = toMap(lesson);
		
		if (items != null && !items.isEmpty()) {
			List<Map<String, Object>> list = new ArrayList<>();
			for (Item item : items) {
				list.add(toMap(item));
			}
			result.put("items", list);
		}
		
		return result;
	}
	
	/**
	 * 视频
	 * @param item
	 * @return
	 */
	protected Map<String, Object> toMap(Item item) {
		if (item == null) {
			return null;
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("id", item.getId());
		if (item.getLesson() != null) {
			result.put("lesson", toMap(item.getLesson()));
		}
		result.put("name", item.getName());
		if (item.getTeacher() != null) {
			result.put("teacher", toMap(item.getTeacher()));
		}
		result.put("videoUrl", item.getVideoUrl());
		result.put("pageNum", item.getPageNum());
		result.put("tag", item.getTag());
		if (item.getModel() != null) {
			result.put("model", toMap(item.getModel()));
		}
		result.put("knowledge", item.getKnowledge());
		result.put("description", item.getDescription());
		result.put("status", item.getStatus());
		//---- 用于显示 ----//
		if (item.getCourse() != null) {
			result.put("course", toMap(item.getCourse()));
		}
		if (item.getMaterial() != null) {
			result.put("material", toMap(item.getMaterial()));
		}
		if (item.getUnit() != null) {
			result.put("unit", toMap(item.getUnit()));
		}
		
		return result;
	}
	
	/**
	 * 3D模型
	 * @param model
	 * @return
	 */
	protected Map<String, Object> toMap(Model model) {
		if (model == null) {
			return null;
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("id", model.getId());
		if (model.getLesson() != null) {
			result.put("lesson", toMap(model.getLesson()));
		}
		result.put("name", model.getName());
		result.put("fbxUrl", model.getFbxUrl());
		result.put("status", model.getStatus());
		return result;
	}
	
	/**
	 * 考点
	 * @param exam
	 * @return
	 */
	protected Map<String, Object> toMap(Exam exam) {
		if (exam == null) {
			return null;
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("id", exam.getId());
		if (exam.getLesson() != null) {
			result.put("lesson", toMap(exam.getLesson()));
		}
		result.put("description", exam.getDescription());
		result.put("status", exam.getStatus());
		//---- 用于显示 ----//
		if (exam.getCourse() != null) {
			result.put("course", toMap(exam.getCourse()));
		}
		if (exam.getMaterial() != null) {
			result.put("material", toMap(exam.getMaterial()));
		}
		if (exam.getUnit() != null) {
			result.put("unit", toMap(exam.getUnit()));
		}
		
		return result;
	}
	
	/**
	 * 泛型列表
	 * @param courses
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T> List<Map<String, Object>> toArray(Collection<T> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}

		List<Map<String, Object>> result = new ArrayList<>();
		try {
			// 反射执行 toMap 方法，获得数据
			Class<T> typeClass = (Class<T>) list.iterator().next().getClass();
			Method method = null;
			try {
				method = this.getClass().getDeclaredMethod("toMap", typeClass);
			} catch (NoSuchMethodException ex) {
				method = this.getClass().getSuperclass().getDeclaredMethod("toMap", typeClass);
			}
			if (method != null) {
				method.setAccessible(true);	// 不让Java对方法进行检查, 可执行私有方法
				for (T entity : list) {
					result.add((Map<String, Object>) method.invoke(this, entity));
				}
			}
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 获得图片完整的URL地址
	 * 
	 * @param imagePath
	 * @return
	 */
	protected String getImageUrlPath(String imagePath) {
		if (StringUtils.isEmpty(imagePath)) {
			return "";
		}
		if(imagePath.startsWith("http://") || imagePath.startsWith("https://")) {
			return imagePath;
		} else {
			return contextPath.concat(imagePath);
		}
	}
	
	/**
	 * 上传文件
	 * 
	 * @param file	上传文件
	 */
	protected String uploadImage(MultipartFile file) {
		String savePath = context.getRealPath("/") + "/" + uploadPath;
		if (file != null && StringUtils.isNotEmpty(file.getOriginalFilename())) {
			try {
				String uploadFileName = file.getOriginalFilename();
				if (uploadFileName.lastIndexOf('.') < 0) {
					return null;
				}
				String suffix = uploadFileName.substring(uploadFileName.lastIndexOf('.'));
				String imgId = String.valueOf(System.currentTimeMillis());
				String random = RandomUtils.getString(6);
				String fileName = imgId + "_" + random + suffix;
				FileUtils.writeByteArrayToFile(new File(savePath + fileName), file.getBytes());
				return (uploadPath + fileName);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 上传文件
	 * 
	 * @param uploadFileName	上传文件名
	 * @param file	文件二进制字符流
	 */
	protected String uploadImage(String uploadFileName, byte[] file) {
		String savePath = context.getRealPath("/") + "/" + uploadPath;
		if (file != null) {
			try {
				String suffix = uploadFileName.substring(uploadFileName.lastIndexOf('.'));
				String imgId = String.valueOf(System.currentTimeMillis());
				String random = RandomUtils.getString(6);
				String fileName = imgId + "_" + random + suffix;
				FileUtils.writeByteArrayToFile(new File(savePath + fileName), file);
				return (uploadPath + fileName);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 上传文件
	 * 
	 * @param file	BASE64编码
	 * @param fileType	图片格式
	 * @return
	 */
	protected String uploadImage(String file, String fileType) {
		if (StringUtils.isEmpty(file)) {
			throw new AplusException(ERROR_NO_RECORD, "没有上传文件");
		}
		
		if (StringUtils.isEmpty(fileType)) {
			throw new AplusException(ERROR_NO_RECORD, "没有注明文件类型");
		}
		
		// 去掉前端Canvas的头
		if (file.startsWith("data:image/png;base64,")) {	// PNG
			file = file.substring("data:image/png;base64,".length());
		} else if (file.startsWith("data:image/gif;base64,")) {	// GIF
			file = file.substring("data:image/gif;base64,".length());
		} else if (file.startsWith("data:image/jpeg;base64,")) {	// JPEG
			file = file.substring("data:image/jpeg;base64,".length());
		} else if (file.startsWith("data:image/jpg;base64,")) {	// JPG
			file = file.substring("data:image/jpg;base64,".length());
		}
		// BASE64解析上传
		byte[] photoBytes = Base64.decodeBase64(file);
		return uploadImage(System.currentTimeMillis() + (fileType.startsWith(".")?fileType:"." + fileType), photoBytes);
	}
}
