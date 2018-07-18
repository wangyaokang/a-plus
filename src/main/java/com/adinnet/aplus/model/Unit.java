/**
 * 
 */
package com.adinnet.aplus.model;

/**
 * 单元
 * 
 * @author zhurui
 *
 */
public class Unit extends BaseModel {

	private static final long serialVersionUID = -830115623716856339L;
	
	/** 教材 */
	private Material material;

	/** 单元名称 */
	private String name;
	
	/** 排序 */
	private Integer seq;
	
	/** 描述 */
	private String description;
	
	/**
	 * 
	 * @return
	 */
	public Long getMaterialId() {
		if (material == null) {
			return null;
		}
		return material.getId();
	}
	
	/**
	 * 
	 * @param materialId
	 */
	public void setMaterialId(Long materialId) {
		if (materialId == null) {
			return;
		}
		if (material == null) {
			material = new Material();
		}
		material.setId(materialId);
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

	//---- End ----//
}
