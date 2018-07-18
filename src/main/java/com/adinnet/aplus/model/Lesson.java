/**
 * 
 */
package com.adinnet.aplus.model;

/**
 * 课程
 * 
 * @author zhurui
 *
 */
public class Lesson extends BaseModel {

	private static final long serialVersionUID = 1500054659911689263L;
	
	/** 单元 */
	private Unit unit;

	/** 课程名称 */
	private String name;
	
	/** 排序 */
	private Integer seq;
	
	/** 描述 */
	private String description;

	/**
	 * 
	 * @return
	 */
	public Long getUnitId() {
		if (unit == null) {
			return null;
		}
		return unit.getId();
	}

	/**
	 * 
	 * @param unitId
	 */
	public void setUnitId(Long unitId) {
		if (unitId == null) {
			return;
		}
		if (unit == null) {
			unit = new Unit();
		}
		unit.setId(unitId);
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

	//---- End ----//
}
