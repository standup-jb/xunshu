<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <script language="javascript">
  function mycheck(){
	  alert("用户名不能为空");
	  
  var username = document.getElementById("username");
  var psd = document.getElementById("psd");
  if(usename.value==""){
  alert("用户名不能为空");
  return false;
  }
  if(psd.value==""){
  alert("密码不能为空");
  return false;
  }
  }
  </script>


 <form action="" method="post">
            用户：<input type="text" name="usename"  ><br/>
            密码：<input type="password" name="psd"><br/>
            <input type="submit" value="确定" onClick="return mycheck()">
         </form>
</html>