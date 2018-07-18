/**
 * 
 */
package com.adinnet.aplus.model;

/**
 * 考点
 * 
 * @author zhurui
 *
 */
public class Exam extends BaseModel {

	private static final long serialVersionUID = -3906462804448466695L;

	/** 课程 */
	private Lesson lesson;
	
	/** 描述 */
	private String description;
	
	/**
	 * 
	 * @return
	 */
	public Long getLessonId() {
		if (lesson == null) {
			return null;
		}
		return lesson.getId();
	}
	
	/**
	 * 
	 * @param lessonId
	 */
	public void setLessonId(Long lessonId) {
		if (lessonId == null) {
			return;
		}
		if (lesson == null) {
			lesson = new Lesson();
		}
		lesson.setId(lessonId);
	}

	/**
	 * @return the lesson
	 */
	public Lesson getLesson() {
		return lesson;
	}

	/**
	 * @param lesson the lesson to set
	 */
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
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

	//---- 以下仅用于字段显示，不用于数据库存储 ----//
	
	/** 学科 */
	private Course course;
	
	/** 教材 */
	private Material material;
	
	/** 单元 */
	private Unit unit;

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
	 * @return the material
	 */
	public Material getMaterial() {
		return material;
	}

	/**
	 * @param material the material to set
	 */
	public void setMaterial(Material material) {
		this.material = material;
	}

	/**
	 * @return the unit
	 */
	public Unit getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	//---- End ----//
}
