<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/revise.css">
	<title>Document</title>
	
</head>
<body>
	<div class="div_management">
		<hr><hr>
		<div class="div_ttop">
			<span class="p_center">Edit page</span>
			<span class="p_right"><a href="/xxxx/ListServlet">Return</a></span>
		</div>
		<hr><hr>
		
		<form action="/xxxx/EditServlet" id="revise" method="post">
			<table class="modify_table">
				<tr>
					<th>
						Password
					</th><th>
						E-mail
					</th><th>
						Is_del
					</th><th>
						Is_activate
					</th><th>
						Is_admin
					</th>
					<th colspan="2">
						Operational
					</th>
				</tr>
				<tr>
					<td>
						<input type="text" name="password" id="password" value=${user.getPassword()}>
						<input type="text" name="userid" id="userid" value=${user.getUserId()} style="display: none;">
					</td><td>
						<input type="text" name="mail" id="mail" value=${user.getMail()}>
					</td><td>
						<input type="text" name="is_del" id="is_del" value=${user.getIs_del()}>
					</td><td>
						<input type="text" name="is_activate" id="is_activate" value=${user.getIs_Activate()}>
					</td><td>
						<input type="text" name="is_admin" id="is_admin" value=${user.getIs_admin()}>
					</td><td>
						<input type="submit" id="submit" >
					</td><td>
						<input type="reset" id="reset" >
					</td>
				</tr>
			</table>
			</form>
	</div>
</body>
</html>