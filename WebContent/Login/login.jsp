<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body>



<script language="javascript">
  function mycheck(){
	//  alert("用户名不能为空");
	  
  var username = document.getElementById("username");
  var password1 = document.getElementById("password");
 
  if(username.value==''||password1.value==''){
  alert("用户名或者密码不能为空");
  return false;
  }

    var form = document.forms[0];
	form.action="<%=request.getContextPath()%>/login";
	form.method="post";
	form.submit();
  
  
  }
  
  
  </script>


 <form action="" method="post">
            用户：<input type="text" name="username"  id="username"><br/>
            密码：<input type="password" name="password" id="password"><br/>
           
            <input type="submit" value="登录" onClick="return mycheck()">
         </form>
</body>



</body>
</html>