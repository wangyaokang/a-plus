/**
 * 
 */
package com.adinnet.aplus.model;

import java.util.Date;

/**
 * @author zhurui
 *
 */
public class User extends BaseModel {

	private static final long serialVersionUID = 3474323268481100686L;
	
	/** 匿名用户 */
	public static final User Anonymous;
	/** 不分科 */
	public static final int DEFAULT = 0;
	/** 文科 */
	public static final int ARTS = 1;
	/** 理科 */
	public static final int SCIENCE = 2;

	/** 用户名 */
	private String username;
	
	/** 密码 */
	private String password;
	
	/** 手机号 */
	private String mobile;
	
	/** 昵称 */
	private String nickname;
	
	/** 性别 */
	private Integer sex;
	
	/** 头像 */
	private String avatarUrl;
	
	/** 注册时间 */
	private Date regTime;
	
	/**
	 * 学科
	 * <pre>
	 * 0: 不分科
	 * 1: 文科
	 * 2: 理科
	 * </pre>
	 */
	private int subject = 0;
	
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
	
	/** 移动网络观看 */
	private Integer mobileView;
	
	/** 移动网络下载 */
	private Integer mobileDown;
	
	/**
	 * 匿名用户初始化
	 */
	static {
		Anonymous = new User();
		Anonymous.setId(0L);
		Anonymous.setUsername("anonymous");
		Anonymous.setNickname("匿名用户");
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the sex
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * @return the avatarUrl
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	/**
	 * @param avatarUrl the avatarUrl to set
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	/**
	 * @return the regTime
	 */
	public Date getRegTime() {
		return regTime;
	}

	/**
	 * @param regTime the regTime to set
	 */
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
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
	 * @return the mobileView
	 */
	public Integer getMobileView() {
		return mobileView;
	}

	/**
	 * @param mobileView the mobileView to set
	 */
	public void setMobileView(Integer mobileView) {
		this.mobileView = mobileView;
	}

	/**
	 * @return the mobileDown
	 */
	public Integer getMobileDown() {
		return mobileDown;
	}

	/**
	 * @param mobileDown the mobileDown to set
	 */
	public void setMobileDown(Integer mobileDown) {
		this.mobileDown = mobileDown;
	}
	
}
