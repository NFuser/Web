package com.twly.server;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.twly.dao.UserDao;
import com.twly.entity.GameUser;

	public class UserServer {
	UserDao dao=new UserDao();
	
	//×¢²á²Ù×÷ÑéÖ¤
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
	//µÇÂ¼½×¶ÎÓÃ»§ÃûÑéÖ¤
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
	//µÇÂ¼½×¶ÎÃÜÂëÑéÖ¤
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
	//µÇÂ¼½×¶Î¼¤»î×´Ì¬¼ì²â
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
	//¼¤»î²Ù×÷¼ì²â
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
	//userid²éÑ¯²Ù×÷ÑéÖ¤
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
	
	//»ñÈ¡userid²Ù×÷¼ì²â
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
	//´æ´¢ÐÂ·ÖÊý¼ì²â
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
	
	//É¾³ý¼ì²â
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
