package com.twly.server;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.twly.dao.UserDao;
import com.twly.entity.GameUser;

	public class UserServer {
	UserDao dao=new UserDao();
	
	//ע�������֤
	public boolean registe(GameUser user){
		int result=0;
		try {
			result=dao.registe(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result>0;
	}
	//��¼�׶��û�����֤
	public boolean checkusername(String username) {
		int result=0;
		try {
			result=dao.checkUsername(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result>0;
	}
	//��¼�׶�������֤
	public String login(String username){
		GameUser user=new GameUser();
		try {
			user=dao.login(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return user.getPassword();	
	}
	//��¼�׶μ���״̬���
	public boolean is_Activate_yn(String username) {
		int result=0;
		try {
			result=dao.is_Activate_yn(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result==1;
	}
	//����������
	public boolean is_Activate(String activation){
		int result=0;
		try {
			result=dao.is_Activate(activation);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result>0;
	}
	//userid��ѯ������֤
	public String userid(String username){
		GameUser user=new GameUser();
		try {
			user=dao.userid(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return user.getUserId();	
	}
	
	//��ȡuserid�������
	public GameUser userById(String userid){
		GameUser user=new GameUser();
		try {
			user=dao.userById(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return user;	
	}
	//�洢�·������
	public boolean saveScoreById(String id,int score){
		int result=0;
		try {
			result=dao.saveScoreById(id,score);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result>0;
	}
	
	//ɾ�����
		public boolean delById(String id){
			int result=0;
			try {
				result=dao.delById(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result>0;
		}
	
		public boolean updateByUser(GameUser user){
			int result=0;
			try {
				result=dao.updateByUser(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result>0;
		}
	
	
//	public int score(String username){
//		GameUser user=new GameUser();
//		try {
//			user=dao.score(username);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return user.getScore();
//	}
	
	
	public List<GameUser> getList(Map<String,Object> map){
		List<GameUser> list=new ArrayList<GameUser>();
		
		try {
			list=dao.getList(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}
}
