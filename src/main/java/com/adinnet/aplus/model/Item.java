/**
 * 
 */
package com.adinnet.aplus.model;

/**
 * 课程视频
 * 
 * @author zhurui
 *
 */
public class Item extends BaseModel {

	private static final long serialVersionUID = 8302939433367260752L;

	/** 课程 */
	private Lesson lesson;
	
	/** 视频名称 */
	private String name;
	
	/** 教师 */
	private Teacher teacher;
	
	/** 视频地址 */
	private String videoUrl;
	
	/** 课本页码 */
	private String pageNum;
	
	/** 分组标签*/
	private String tag;
	
	/** 3D模型 */
	private Model model;
	
	/** 知识点 */
	private String knowledge;
	
	/** 视频介绍 */
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
	 * 
	 * @return
	 */
	public Long getTeacherId() {
		if (teacher == null) {
			return null;
		}
		return teacher.getId();
	}
	
	/**
	 * 
	 * @param teacherId
	 */
	public void setTeacherId(Long teacherId) {
		if (teacherId == null) {
			return;
		}
		if (teacher == null) {
			teacher = new Teacher();
		}
		teacher.setId(teacherId);
	}
	
	/**
	 * 
	 * @return
	 */
	public Long getModelId() {
		if (model == null) {
			return null;
		}
		return model.getId();
	}
	
	/**
	 * 
	 * @param teacherId
	 */
	public void setModelId(Long modelId) {
		if (modelId == null) {
			return;
		}
		if (model == null) {
			model = new Model();
		}
		model.setId(modelId);
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
	 * @return the teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}

	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	/**
	 * @return the videoUrl
	 */
	public String getVideoUrl() {
		return videoUrl;
	}

	/**
	 * @param videoUrl the videoUrl to set
	 */
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	/**
	 * @return the pageNum
	 */
	public String getPageNum() {
		return pageNum;
	}

	/**
	 * @param pageNum the pageNum to set
	 */
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * @return the knowledge
	 */
	public String getKnowledge() {
		return knowledge;
	}

	/**
	 * @param knowledge the knowledge to set
	 */
	public void setKnowledge(String knowledge) {
		this.knowledge = knowledge;
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
