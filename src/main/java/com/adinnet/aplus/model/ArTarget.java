/**
 * 
 */
package com.adinnet.aplus.model;

import java.util.Date;

import com.adinnet.framework.entity.AutoIdEntity;

/**
 * AR Target
 * 
 * @author zhurui
 *
 */
public class ArTarget extends AutoIdEntity {

	private static final long serialVersionUID = -403434402577868654L;

	/** 视频 */
	private Item item;
	
	/** AR编码 */
	private String arCode;
	
	/** 新增时间 */
	protected Date createTime;

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
	 * @return the arCode
	 */
	public String getArCode() {
		return arCode;
	}

	/**
	 * @param arCode the arCode to set
	 */
	public void setArCode(String arCode) {
		this.arCode = arCode;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
