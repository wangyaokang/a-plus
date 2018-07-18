/**
 * 
 */
package com.adinnet.aplus.model;

/**
 * 收藏列表
 * 
 * @author zhurui
 *
 */
public class Favorite extends BaseModel {

	private static final long serialVersionUID = 1784755678275844427L;
	
	/** 课程 */
	public static final int ITEM = 1;
	/** 考点 */
	public static final int EXAM = 2;

	/** 用户 */
	private User user;
	
	/** 
	 * 目标
	 * <pre>
	 * 当收藏类型为1时目标为课程
	 * 当收藏类型为2时目标为考点
	 * </pre> 
	 */
	private BaseModel target;

	/**
	 * 收藏类型
	 * <pre>1：课程，2：考点</pre>
	 */
	private Integer type;
	
	/**
	 * @return the targetId
	 */
	public Long getTargetId() {
		if (target == null) {
			return null;
		}
		return target.getId();
	}

	/**
	 * @param targetId the targetId to set
	 */
	public void setTargetId(Long targetId) {
		if (targetId == null) {
			return;
		}
		if (target == null) {
			if (type == ITEM) {
				target = new Item();
			} else if (type == EXAM) {
				target = new Exam();
			}
		}
		if (target != null) {
			target.setId(targetId);
		}
	}

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
	 * @return the target
	 */
	public BaseModel getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(BaseModel target) {
		this.target = target;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	
}
