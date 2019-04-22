<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
		<a href="list">显示所有user</a><br>
		根据ID查询用户
		<form action="select" method="get">
			id:<input type="text" name=id> <input type="submit" value="查询">
		</form>
		根据ID删除用户
		<form action="delete" method="get">
			id:<input type="text" name=id> <input type="submit" value="删除">
		</form>
		插入新用户
		<form action="insert" method="post">
		id:<input type="text" name="id"><br>
        name:<input type="text" name="name"><br>
        age:<input type="text" name="age"><br>
        gender:<input type="text" name="gender"><br>
        date:<input type="text" name="date"><br>
        address:<input type="text" name="address"><br>
          <input type="submit" value="插入">
		</form>
		更新用户信息
		<form action="update" method="post">
		id:<input type="text" name="id"><br>
        name:<input type="text" name="name"><br>
        age:<input type="text" name="age"><br>
        gender:<input type="text" name="gender"><br>
        date:<input type="text" name="date"><br>
        address:<input type="text" name="address"><br>
          <input type="submit" value="插入">
		</form>
	</body>
</html>