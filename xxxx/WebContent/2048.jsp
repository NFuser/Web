<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/2048.css">
	<link rel="stylesheet" type="text/css" href="css/2048game.css">
	
	<title>2048</title>
	
</head>
<body>
	<div class="div_all">
		<table id="table_top">
			<tr><td colspan="2"><p class="p_2048">2048</p></td>
				<!-- 左上角2048 -->
				<form action="/xxxx/GameStarServlet" method="post">
				<td><div style="margin: 0px;padding: 0px;">
					<div name="div_top">score</div>
					<div name="div_low">
						
							<input type="text" name="score" id="score" class="input_sql" readonly="readonly" value=0>
						
					</div>
				</div></td>
				<!-- 左半边score -->
				<td><div style="margin: 0px;padding: 0px;">
					<div name="div_top">best</div>
					<div name="div_low">
						
							<input type="text" name="best" id="best" class="input_sql" readonly="readonly" value=${user.getScore()}>
														
							<input type="text" name="id" style="display: none;" value="${user.getUserId()}"/>
							<!-- id暂存隐藏域 -->
							<input id="submit_btn" type="submit" value="submit" style="display: none;"/>
							<!-- 隐藏提交按钮 -->
							
						<!-- post传Servlet,GameStartServlet toPost方法接收 -->
					</div>
				</div></td>
				</form>
				<!-- 右半边best -->
			</tr>
			<tr>
				<td colspan="2"><p class="div_2p"><b>Play 2048 Game Online</b><br>Join the number and get to the <b>2048 tile!</b></p></td>
				<!-- 中间文字部分 -->
				<td colspan="2">
					<input type="button" value="New Game" class="div_newgame" onclick="new_game()">
					<input type="button" value="Exit Game" class="div_newgame" onclick="quit_game()">
				</td>
				<!-- 右边新游戏/退出游戏按钮 -->
			</tr>
		</table>
		<!-- 上部分介绍部分 -->
		
		<div class="g2048">
			<div class="cell"></div>
			<div class="cell"></div>
			<div class="cell"></div>
			<div class="cell"></div>
			<div class="cell"></div>
			<div class="cell"></div>
			<div class="cell"></div>
			<div class="cell"></div>
			<div class="cell"></div>
			<div class="cell"></div>
			<div class="cell"></div>
			<div class="cell"></div>
			<div class="cell"></div>
			<div class="cell"></div>
			<div class="cell"></div>
			<div class="cell"></div>
		</div>
	<!-- 2048板块，div用border-box盒子模型构造，按外条件构造16*16游戏格子 -->
	</div>

	<script src="http://apps.bdimg.com/libs/jquery/1.8.1/jquery.min.js"></script>
	<script src="js/2048game.js"></script>
</body>
</html>