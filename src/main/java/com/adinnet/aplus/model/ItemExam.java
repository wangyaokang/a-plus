/**
 * 
 */
package com.adinnet.aplus.model;

/**
 * 考点与视频关系
 * 
 * @author zhurui
 *
 */
public class ItemExam extends BaseModel {

	private static final long serialVersionUID = -3699800039786037483L;

	/** 视频 */
	private Item item;
	
	/** 考点 */
	private Exam exam;
	
	/** 考点标题 */
	private String examTitle;

	/**
	 * 
	 * @return
	 */
	public Long getItemId() {
		if (item == null) {
			return null;
		}
		return item.getId();
	}
	
	/**
	 * 
	 * @param lessonId
	 */
	public void setItemId(Long itemId) {
		if (itemId == null) {
			return;
		}
		if (item == null) {
			item = new Item();
		}
		item.setId(itemId);
	}
	
	/**
	 * 
	 * @return
	 */
	public Long getExamId() {
		if (exam == null) {
			return null;
		}
		return exam.getId();
	}
	
	/**
	 * 
	 * @param examId
	 */
	public void setExamId(Long examId) {
		if (examId == null) {
			return;
		}
		if (exam == null) {
			exam = new Exam();
		}
		exam.setId(examId);
	}
	
	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * @return the exam
	 */
	public Exam getExam() {
		return exam;
	}

	/**
	 * @param exam the exam to set
	 */
	public void setExam(Exam exam) {
		this.exam = exam;
	}

	/**
	 * @return the examTitle
	 */
	public String getExamTitle() {
		return examTitle;
	}

	/**
	 * @param examTitle the examTitle to set
	 */
	public void setExamTitle(String examTitle) {
		this.examTitle = examTitle;
	}
	
}
