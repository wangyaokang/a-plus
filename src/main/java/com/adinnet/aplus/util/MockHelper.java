/**
 * 
 */
package com.adinnet.aplus.util;

import java.util.Date;

import com.adinnet.aplus.model.Course;
import com.adinnet.aplus.model.Item;
import com.adinnet.aplus.model.Lesson;
import com.adinnet.aplus.model.Material;
import com.adinnet.aplus.model.Model;
import com.adinnet.aplus.model.Teacher;
import com.adinnet.aplus.model.Unit;
import com.adinnet.aplus.model.User;

/**
 * 用于Mock的工具类
 * 
 * @author zhurui
 *
 */
public class MockHelper {

	/**
	 * 获得用户信息
	 * 
	 * @return
	 */
	public static User getUser() {
		User user = new User();
		user.setUsername("用户名");
		user.setMobile("18901780827");
		user.setNickname("昵称");
		user.setSex(1);
		user.setRegTime(new Date());
		user.setSubject(1);
		user.setSchoolType(1);
		user.setSchoolSystem(1);
		user.setGrade(1);
		return user;
	}
	
	public static Teacher getTeacher() {
		Teacher teacher = new Teacher();
		teacher.setCourse(getCourseChinese());
		teacher.setName("语文老师");
		return teacher;
	}
	
	/**
	 * 学科: 语文
	 * @return
	 */
	public static Course getCourseChinese() {
		Course course = new Course();
		course.setName("语文");
		course.setSeq(1);
		course.setSubject(0);
		return course;
	}
	
	/**
	 * 学科: 物理
	 * @return
	 */
	public static Course getCoursePhysics() {
		Course course = new Course();
		course.setName("物理");
		course.setSeq(1);
		course.setSubject(2);
		return course;
	}
	
	/**
	 * 教材：人教版初一语文
	 * @return
	 */
	public static Material getRenJiaoChuYiYuWen() {
		Material material = new Material();
		material.setCourse(getCourseChinese());
		material.setName("人教版初一语文");
		material.setSchoolType(1);
		material.setSchoolSystem(1);
		material.setGrade(1);
		material.setSemester(1);
		material.setSeq(1);
		return material;
	}
	
	/**
	 * 教材：人教版初一物理
	 * @return
	 */
	public static Material getRenJiaoChuYiWuLi() {
		Material material = new Material();
		material.setCourse(getCoursePhysics());
		material.setName("人教版初一物理");
		material.setSchoolType(1);
		material.setSchoolSystem(1);
		material.setGrade(1);
		material.setSemester(1);
		material.setSeq(1);
		return material;
	}
	
	/**
	 * 第一单元
	 * @return
	 */
	public static Unit getUnitOne() {
		Unit unit = new Unit();
		unit.setMaterial(getRenJiaoChuYiYuWen());
		unit.setName("第一单元：语文的基础知识");
		unit.setSeq(1);
		return unit;
	}
	
	/**
	 * 第一课
	 * 
	 * @return
	 */
	public static Lesson getLessonOne() {
		Lesson lesson = new Lesson();
		lesson.setUnit(getUnitOne());
		lesson.setName("第一课：题目");
		return lesson;
	}
	
	/**
	 * 视频一
	 * 
	 * @return
	 */
	public static Item getItemOne() {
		Item item = new Item();
		item.setLesson(getLessonOne());
		item.setName("视频一：");
		item.setKnowledge("知识点");
		item.setDescription("描述");
		item.setModel(getModel());
		item.setTeacher(getTeacher());
		item.setVideoUrl("视频地址");
		
		return item;
	}
	
	/**
	 * 3D模型
	 * 
	 * @return
	 */
	public static Model getModel() {
		Model model = new Model();
		model.setLesson(getLessonOne());
		model.setName("3D模型");
		return model;
	}
	
	
}
