package com.twly.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.twly.entity.GameUser;

public class UserDao {
	/*
	 * 连接数据库方法
	 * @return
	 * @throws SQLException
	 */
	public static Connection getconn() throws SQLException{
		//连接数据库
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mydb";
		String username="root";
		String password="password";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
	}
	
	//	注册
	public int  registe(GameUser user) throws SQLException{
		//获取数据库连接
		Connection conn=null;
		conn=getconn();
		//insert into 表名（属性）value（值）
		String sql="insert into user (userId,username,password,mail,score,is_del,activation,is_activate,is_admin) value(?,?,?,?,?,?,?,?,?)";
		//运行sql语句对象
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, user.getUserId());
		ps.setString(2,user.getUsername());
		ps.setString(3,user.getPassword());
		ps.setString(4, user.getMail());
		ps.setInt(5, 0);
		ps.setInt(6, 0);
		ps.setString(7, user.getActivation());
		ps.setInt(8, 0);
		ps.setInt(9, 0);
		//预处理，sql语句？填充
		//执行填充占位符之后的sql语句
		int result=ps.executeUpdate();
		return result;
	}
	
	//登录_检查用户名是否存在
	public int checkUsername(String username) throws SQLException{
		//获取数据库连接
		Connection conn=null;
		conn=getconn();
		//select 属性 from 表名 where 条件
		String sql="select count(*) num from user where username=?";
		//运行sql语句对象
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, username);
		//运行sql 获取返回值
		ResultSet rs=ps.executeQuery();
		int num=0;
		while(rs.next()){
			num=rs.getInt("num");
		}
		return num;
	}
				
	//登录_检查密码是否正确
	public GameUser login(String username) throws SQLException{
		//获取数据库连接
		Connection conn=null;
		conn=getconn();
		//select 属性 from 表名 where 条件
		String sql="select password from user where username=?";
		//运行sql语句对象
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, username);
		//运行sql 获取返回值
		ResultSet rs=ps.executeQuery();
		GameUser user=new GameUser();
		while(rs.next()){
			user.setPassword(rs.getString("password"));
		}
		return user;
	}
		
	//登录_检查是否激活
	public int is_Activate_yn(String username) throws SQLException{
		//获取数据库连接
		Connection conn=null;
		conn=getconn();
		//update 表名 set 新值 where 条件
		String sql="select is_activate from user where username=?";
		//运行sql语句对象
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, username);
		//运行sql 获取返回值
		ResultSet rs=ps.executeQuery();
		int num=0;
		while(rs.next()){
			num=rs.getInt("is_activate");
		}
		return num;
	}

	//账户激活操作
	public int is_Activate(String activation) throws SQLException{
		//获取数据库连接
		Connection conn=null;
		conn=getconn();
		//update 表名 set 新值 where 条件
		String sql="update user set is_activate=1 where activation=?";
		//运行sql语句对象
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, activation);
		//运行sql 获取返回值
		int result=ps.executeUpdate();
		return result;
	}
	
	//userid查询操作
	public GameUser userid(String username) throws SQLException{
		//获取数据库连接
		Connection conn=null;
		conn=getconn();
		//update 表名 set 新值 where 条件
		String sql="select userid from user where username=?";
		//运行sql语句对象
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, username);
		//运行sql 获取返回值
		ResultSet rs=ps.executeQuery();
		GameUser user=new GameUser();
		while(rs.next()){
			user.setUserId(rs.getString("userid"));
		}
		return user;
	}
				
	//通过id获取对象
	public GameUser userById(String userid) throws SQLException{
		//获取数据库连接
		Connection conn=null;
		conn=getconn();
		//update 表名 set 新值 where 条件
		String sql="select * from user where userid=?";
		//运行sql语句对象
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, userid);
		//运行sql 获取返回值
		ResultSet rs=ps.executeQuery();
		GameUser user=new GameUser();
		while(rs.next()){
			user.setUserId(rs.getString("userid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setMail(rs.getString("mail"));
			user.setScore(rs.getInt("score"));
			user.setIs_del(rs.getInt("is_del"));
			user.setActivation(rs.getString("activation"));
			user.setIs_Activate(rs.getInt("is_activate"));
			user.setIs_admin(rs.getInt("is_admin"));
		}
		return user;
	}
				
		//通过id存储新分数
		public int saveScoreById(String id,int score)throws SQLException{
			//获取数据库连接
			Connection conn=null;
			conn=getconn();
			//update 表名 set 新值 where 条件
			String sql="update user set score=? where userid=?";
			//运行sql语句对象
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, score);
			ps.setString(2, id);
			//运行sql 获取返回值
			int result=ps.executeUpdate();
			return result;
		}
		
//		//分数查询
//		public GameUser score(String username) throws SQLException{
//			//获取数据库连接
//			Connection conn=null;
//			conn=getconn();
//			//update 表名 set 新值 where 条件
//			String sql="select score from user where username=?";
//			//运行sql语句对象
//			PreparedStatement ps=conn.prepareStatement(sql);
//			ps.setString(1, username);
//			//运行sql 获取返回值
//			ResultSet rs=ps.executeQuery();
//			GameUser user=new GameUser();
//			while(rs.next()){
//				user.setScore(rs.getInt("score"));
//			}
//			return user;
//		}
		
		
		public List<GameUser> getList(Map<String,Object> map) throws SQLException{
			//获取数据库连接
			Connection conn=null;
			conn=getconn();
			//Select 属性  from  表名 where 条件
			String sql=" select  userId,username,mail,score,is_del,is_activate,is_admin "
					+ " from user where 1=1";
			//统计有几个占位符
			int i=0;
			if(map.get("username")!=null){
				sql+= " and username like ? ";
				i++;
			}
			if(map.get("is_del")!=null){
				sql+=" and is_del=? ";
				i++;
			}
			if(map.get("is_activate")!=null){
				sql+=" and is_activate=? ";
				i++;
			}
			if(map.get("is_admin")!=null){
				sql+=" and is_admin=? ";
				i++;
			}
			PreparedStatement ps=conn.prepareStatement(sql);
			if(map.get("is_admin")!=null){
				ps.setInt(i, Integer.parseInt(map.get("is_admin").toString()));
				i--;
			}
			if(map.get("is_activate")!=null){
				ps.setInt(i, Integer.parseInt(map.get("is_activate").toString()));
				i--;
			}
			if(map.get("is_del")!=null){
				ps.setInt(i, Integer.parseInt(map.get("is_del").toString()));
				i--;
			}
			if(map.get("username")!=null){
				ps.setString(i, "%"+map.get("username").toString()+"%");
				i--;
			}
			ResultSet rs=ps.executeQuery();
			List<GameUser> list=new ArrayList<GameUser>();
			while(rs.next()){
				GameUser user=new GameUser();
				//id,username,mail,score,is_del,is_activate,is_admin
				user.setUserId(rs.getString("userId"));
				user.setUsername(rs.getString("username"));
				user.setMail(rs.getString("mail"));
				user.setScore(rs.getInt("score"));
				user.setIs_del(rs.getInt("is_del"));
				user.setIs_Activate(rs.getInt("is_activate"));
				user.setIs_admin(rs.getInt("is_admin"));
				list.add(user);
			}
			return list;
		}
		
		//通过id修改账号状态
		public int delById(String id)throws SQLException{
			//获取数据库连接
			Connection conn=null;
			conn=getconn();
			//update 表名 set 新值 where 条件
			String sql="update user set is_del=1 where userid=?";
			//运行sql语句对象
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			//运行sql 获取返回值
			int result=ps.executeUpdate();
			return result;
		}
		public int updateByUser(GameUser user) throws SQLException{
			//获取数据库连接
			Connection conn=null;
			conn=getconn();
			//update 表名 set 新值 where 条件
			String sql="update user set password=? and mail=? and is_del=? and is_activate=? and is_admin=? where userId=?";
			//运行sql语句对象
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getMail());
			ps.setInt(3, user.getIs_del());
			ps.setInt(4, user.getIs_Activate());
			ps.setInt(5, user.getIs_admin());
			ps.setString(6, user.getUserId());
			int result=ps.executeUpdate();
			return result;
		}
		
	
}

