<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>

 <script language="javascript">
  function mycheck(){
	//  alert("用户名不能为空");
	  
  var username = document.getElementById("username");
  var password1 = document.getElementById("password");
  var password2= document.getElementById("password2")
  if(username.value==''){
  alert("用户名不能为空");
  return false;
  }


  if(password1.value != password2.value){
  //alert("密码和重复密码不相等"+password1.+ " "+password2);
  return false;
  }
  
    var form = document.forms[0];
	form.action="<%=request.getContextPath()%>/register";
	form.method="post";
	form.submit();
  
  
  }
  
  
  </script>


 <form action="" method="post">
            用户：<input type="text" name="username"  id="username"><br/>
            密码：<input type="password" name="password" id="password"><br/>
            重复密码：<input type="password" name="password2" id="password2"><br/>
            邮箱:<input type="text" name=email><br/>
            <input type="submit" value="确定" onClick="return mycheck()">
         </form>
</body>
</html>