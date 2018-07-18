/**
 * 
 */
package com.adinnet.aplus.model;

/**
 * 学科
 * 
 * @author zhurui
 *
 */
public class Course extends BaseModel {

	private static final long serialVersionUID = -3009601052317477621L;
	
	/** 主科 */
	public static final int MAJOR = 0;
	/** 文科 */
	public static final int ARTS = 1;
	/** 理科 */
	public static final int SCIENCE = 2;

	/** 学科名称 */
	private String name;
	
	/** 排序 */
	private Integer seq;
	
	/** 缩略图 */
	private String thumbUrl;
	
	/**
	 * 学科
	 * <pre>
	 * 0: 主科
	 * 1: 文科
	 * 2: 理科
	 * </pre>
	 */
	private int subject = MAJOR;

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
	
}
