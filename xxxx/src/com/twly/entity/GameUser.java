package com.twly.entity;

public class GameUser {
//	id主键
	private String userid;
//用户名
	private String username;
//	密码
	private String password;
//邮箱
	private String mail;
//分数
	private int score;
//删除状态     	默认为0     	1：已删除     	0：未删除
	private int is_del;
//	激活码
	private String activation;
//激活状态     	默认为0     	1：已激活     	0：未激活
	private int is_activate;
//	管理员状态   默认为0    	1：管理员	 		0：非管理员
	private int is_admin;
	

	public String getUserId() {
		return userid;
	}
//改值
	public void setUserId(String userid) {
		this.userid = userid;
	}
//取值
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getIs_del() {
		return is_del;
	}
	public void setIs_del(int is_del) {
		this.is_del = is_del;
	}
	public String getActivation() {
		return activation;
	}
	public void setActivation(String activation) {
		this.activation = activation;
	}
	public int getIs_Activate() {
		return is_activate;
	}
	public void setIs_Activate(int is_activate) {
		this.is_activate = is_activate;
	}
	public int getIs_admin() {
		return is_admin;
	}
	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}
}
