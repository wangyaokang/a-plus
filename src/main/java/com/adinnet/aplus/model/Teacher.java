/**
 * 
 */
package com.adinnet.aplus.model;

/**
 * @author zhurui
 *
 */
public class Teacher extends BaseModel {
	
	private static final long serialVersionUID = -790364572709515907L;

	/** 学科 */
	private Course course;

	/** 姓名 */
	private String name;
	
	/** 头像 */
	private String avatarUrl;
	
	/**
	 * 
	 * @return
	 */
	public Long getCourseId() {
		if (course == null) {
			return null;
		}
		return course.getId();
	}
	
	/**
	 * 
	 * @param courseId
	 */
	public void setCourseId(Long courseId) {
		if (courseId == null) {
			return;
		}
		if (course == null) {
			course = new Course();
		}
		course.setId(courseId);
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the avatarUrl
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	/**
	 * @param avatarUrl the avatarUrl to set
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	
}
