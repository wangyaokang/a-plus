/**
 * 
 */
package com.adinnet.aplus.model;

/**
 * 3D模型
 * 
 * @author zhurui
 *
 */
public class Model extends BaseModel {

	private static final long serialVersionUID = -2513125295148461814L;

	/** 课程 */
	private Lesson lesson;
	
	/** 3D模块名称 */
	private String name;
	
	/** 3D模型 */
	private String fbxUrl;

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
	 * @return the fbxUrl
	 */
	public String getFbxUrl() {
		return fbxUrl;
	}

	/**
	 * @param fbxUrl the fbxUrl to set
	 */
	public void setFbxUrl(String fbxUrl) {
		this.fbxUrl = fbxUrl;
	}
	
	//---- 以下仅用于字段显示，不用于数据库存储 ----//
	
	/** 学科名称 */
	private String courseName;
	
	/** 学科缩略图 */
	private String thumbUrl;
	
	/**
	 * 学科
	 * <pre>
	 * 0: 主科
	 * 1: 文科
	 * 2: 理科
	 * </pre>
	 */
	private int subject = Course.MAJOR;
	
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
	
	/**
	 * 学期
	 * <pre>1：上半学期，2：下半学期</pre>
	 */
	private Integer semester;
	
	/** 教材名称 */
	private String materialName;
	
	/** 单元名称 */
	private String unitName;
	
	/** 课程名称 */
	private String lessonName;

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the thumbUrl
	 */
	public String getThumbUrl() {
		return thumbUrl;
	}

	/**
	 * @param thumbUrl the thumbUrl to set
	 */
	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

	/**
	 * @return the subject
	 */
	public int getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(int subject) {
		this.subject = subject;
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
	 * @return the materialName
	 */
	public String getMaterialName() {
		return materialName;
	}

	/**
	 * @param materialName the materialName to set
	 */
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	/**
	 * @return the unitName
	 */
	public String getUnitName() {
		return unitName;
	}

	/**
	 * @param unitName the unitName to set
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	/**
	 * @return the lessonName
	 */
	public String getLessonName() {
		return lessonName;
	}

	/**
	 * @param lessonName the lessonName to set
	 */
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	
	//---- End ----//
	
}
