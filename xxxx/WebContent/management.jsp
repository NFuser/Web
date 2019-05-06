<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/management.css">
<title>User Management</title>
</head>
<body>
	<div class="div_management">
		<hr>
		<hr>
		<div class="div_chaxun">
			<span class="p_center">查询选项</span> <span class="p_right"><a
				href="/xxxx/login.html">Return</a></span>
		</div>
		<hr>
		<hr>
		<form action="">
			<div class="div_top">
				<table class="table_top">
					<tr>
						<td>用户名</td>
						<td><input type="text" id="username" name="username"
							value="${username}"></td>
						<td>是否删除</td>
						<td><select name="is_del" id="is_del">
								<%
									String is_del = request.getAttribute("is_del").toString();
									if (is_del.equals("0")) {
								%>
								<option value="1">是</option>
								<option value="0" selected>否</option>
								<option value="">全部</option>
								<%
									} else if (is_del.equals("1")) {
								%>
								<option value="1">是</option>
								<option value="0" selected>否</option>
								<option value="">全部</option>
								<%
									} else {
								%>
								<option value="1">是</option>
								<option value="0" selected>否</option>
								<option value="">全部</option>
								<%
									}
								%>
						</select></td>
						<td><input type="submit"></td>
					</tr>
					<tr>
						<td>是否激活</td>
						<td><select name="is_activate">
								<%
									String is_activate = request.getAttribute("is_activate").toString();
									if (is_activate.equals("0")) {
								%>
								<option value="1">是</option>
								<option value="0" selected>否</option>
								<option value="">全部</option>
								<%
									} else if (is_activate.equals("1")) {
								%>
								<option value="1">是</option>
								<option value="0" selected>否</option>
								<option value="">全部</option>
								<%
									} else {
								%>
								<option value="1">是</option>
								<option value="0" selected>否</option>
								<option value="">全部</option>
								<%
									}
								%>
						</select></td>
						<td>是否为管理员</td>
						<td><select name="is_admin">
								<%
									String is_admin = request.getAttribute("is_admin").toString();
									if (is_admin.equals("0")) {
								%>
								<option value="1">是</option>
								<option value="0" selected>否</option>
								<option value="">全部</option>
								<%
									} else if (is_admin.equals("1")) {
								%>
								<option value="1">是</option>
								<option value="0" selected>否</option>
								<option value="">全部</option>
								<%
									} else {
								%>
								<option value="1">是</option>
								<option value="0" selected>否</option>
								<option value="">全部</option>
								<%
									}
								%>
						</select></td>
						<td><input type="reset"></td>
					</tr>
				</table>
			</div>
		</form>
		<!-- 负责上半部分选择查询操作 -->
		<hr>
		<hr>
		<div class="div_chaxun">查询结果</div>
		<hr>
		<hr>
		<div class="div_bottom">
			<table class="list_table">
				<tr>
					<th class="list_th" style="width: 12.5%;">序号</th>
					<th class="list_th" style="width: 12.5%;">用户名</th>
					<th class="list_th" style="width: 12.5%;">邮件</th>
					<th class="list_th" style="width: 12.5%;">最高分数</th>
					<th class="list_th" style="width: 12.5%;">是否删除</th>
					<th class="list_th" style="width: 12.5%;">是否激活</th>
					<th class="list_th" style="width: 12.5%;">是否为管理员</th>
					<th class="list_th" style="width: 12.5%;">操作</th>
				</tr>
				<%@ page import="java.util.*"%>
				<%@ page import="com.twly.entity.GameUser"%>
				<%
					List<GameUser> list = new ArrayList();
					list = (List) request.getAttribute("list");
					for (int i = 0; i < list.size(); i++) {
				%>
				<tr>
					<%
						GameUser user = list.get(i);
					%>
					<td class="list_td" style="width: 12.5%;"><%=i + 1%> <input
						type="text" name="userid" id="userid"
						value="<%=user.getUserId()%>" style="display: none;"></td>
					<td class="list_td" style="width: 12.5%;"><input type="text"
						name="<%=i + 1%>_username>" id="<%=i + 1%>_username"
						value="<%=user.getUsername()%>" style="display: none;"> <%=user.getUsername()%>

					</td>
					<td class="list_td" style="width: 12.5%;"><%=user.getMail()%>

					</td>
					<td class="list_td" style="width: 12.5%;"><%=user.getScore()%>

					</td>
					<%
						if (user.getIs_del() == 0) {
					%>
					<td class="list_td" style="width: 12.5%;">活跃</td>
					<%
						} else {
					%>
					<td class="list_td" style="width: 12.5%;">已冻结</td>
					<%
						}
							if (user.getIs_Activate() == 0) {
					%>
					<td class="list_td" style="width: 12.5%;">未激活</td>
					<%
						} else {
					%>
					<td class="list_td" style="width: 12.5%;">已激活</td>
					<%
						}
							if (user.getIs_admin() == 0) {
					%>
					<td class="list_td" style="width: 12.5%;">用户</td>
					<%
						} else {
					%>
					<td class="list_td" style="width: 12.5%;">管理员</td>
					<%
						}
					%>
					<td class="list_td" style="width: 12.5%;"><a
						href="/xxxx/AdminServlet?userid=<%=user.getUserId()%>">删除</a> <a
						href="/xxxx/EditServlet?userid=<%=user.getUserId()%>">修改</a></td>
					<%
						
					%>
				</tr>
				<%
					}
				%>

				</div>
				<!-- 负责下半部分查询显示操作 -->
				</div>
</body>
</html>