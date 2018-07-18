/**
 * 
 */
package com.adinnet.aplus.model;

/**
 * 教材
 * 
 * @author zhurui
 *
 */
public class Material extends BaseModel {

	private static final long serialVersionUID = 8120729239039013878L;

	/** 
	 * 类型
	 * <pre>1：初中，2：高中</pre> 
	 */
	private Integer schoolType;
	
	/** 
	 * 学制
	 * <pre>1：五四制，2：六三制</pre>
	 */
	private Integer schoolSystem;
	
	/**
	 * 年级
	 * <pre>
	 * 初中：（1：初一，2：初二，3：初三，4：初四）
	 * 高中：（1：高一，2：高二，3：高三）
	 * </pre>
	 */
	private Integer grade;
	
	/** 学科 */
	private Course course;
	
	/**
	 * 学期
	 * <pre>1：上半学期，2：下半学期</pre>
	 */
	private Integer semester;
	
	/** 教材名称 */
	private String name;
	
	/** 排序 */
	private Integer seq;
	
	/** 是否支持 */
	private Integer supportAR;
	
	/** 描述 */
	private String description;
	
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
	 * @return the schoolType
	 */
	public Integer getSchoolType() {
		return schoolType;
	}

	/**
	 * @param schoolType the schoolType to set
	 */
	public void setSchoolType(Integer schoolType) {
		this.schoolType = schoolType;
	}

	/**
	 * @return the schoolSystem
	 */
	public Integer getSchoolSystem() {
		return schoolSystem;
	}

	/**
	 * @param schoolSystem the schoolSystem to set
	 */
	public void setSchoolSystem(Integer schoolSystem) {
		this.schoolSystem = schoolSystem;
	}

	/**
	 * @return the grade
	 */
	public Integer getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
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
	 * @return the semester
	 */
	public Integer getSemester() {
		return semester;
	}

	/**
	 * @param semester the semester to set
	 */
	public void setSemester(Integer semester) {
		this.semester = semester;
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
	 * @return the seq
	 */
	public Integer getSeq() {
		return seq;
	}

	/**
	 * @param seq the seq to set
	 */
	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	/**
	 * @return the supportAR
	 */
	public Integer getSupportAR() {
		return supportAR;
	}

	/**
	 * @param supportAR the supportAR to set
	 */
	public void setSupportAR(Integer supportAR) {
		this.supportAR = supportAR;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
