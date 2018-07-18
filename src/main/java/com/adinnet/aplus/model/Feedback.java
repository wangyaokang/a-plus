/**
 * 
 */
package com.adinnet.aplus.model;

/**
 * 用户反馈
 * 
 * @author zhurui
 *
 */
public class Feedback extends BaseModel {

	private static final long serialVersionUID = -4304067079635712672L;

	/** 用户 */
	private User user;

	/** 内容 */
	private String content;
	
	/**
	 * 
	 * @return
	 */
	public Long getUserId() {
		if (user == null) {
			return null;
		}
		return user.getId();
	}
	
	/**
	 * 
	 * @param userId
	 */
	public void setUserId(Long userId) {
		if (userId == null) {
			return;
		}
		if (user == null) {
			user = new User();
		}
		user.setId(userId);
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
}
