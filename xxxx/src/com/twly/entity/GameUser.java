package com.twly.entity;

public class GameUser {
//	id����
	private String userid;
//�û���
	private String username;
//	����
	private String password;
//����
	private String mail;
//����
	private int score;
//ɾ��״̬     	Ĭ��Ϊ0     	1����ɾ��     	0��δɾ��
	private int is_del;
//	������
	private String activation;
//����״̬     	Ĭ��Ϊ0     	1���Ѽ���     	0��δ����
	private int is_activate;
//	����Ա״̬   Ĭ��Ϊ0    	1������Ա	 		0���ǹ���Ա
	private int is_admin;
	

	public String getUserId() {
		return userid;
	}
//��ֵ
	public void setUserId(String userid) {
		this.userid = userid;
	}
//ȡֵ
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
