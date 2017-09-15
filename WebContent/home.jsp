<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>学生成绩管理系统</title>
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <body>
            <%
                 String result = (String)request.getAttribute("result");
                 System.out.println(result);
                 if(result!=null){
			%>
                <script type="text/javascript" language="javascript">
                    var result = '<%= result %>'
                    alert(result);

                </script>
            <%
   				}
			%>
                    <script language="JavaScript" type="text/javascript">
                        function Check() {
                            var yonghu = document.getElementById("yonghu");
                            var username = document.getElementById("username");
                            var password = document.getElementById("password");
                            if (yonghu.value == "0") {
                                alert("请选择用户！");
                                document.getElementById("yonghu").focus();
                                return false;
                            } else if (username.value == "") {
                                alert("用户名不能为空!");
                                document.getElementById("username").focus();
                                return false;
                            } else if (password.value == "") {
                                alert("密码不能为空！");
                                document.getElementById("password").focus();
                                return false;
                            }
                        }

                    </script>
    </head>

    <body>
        <div class="page-container">
            <h1>登录</h1>
            <form onsubmit="return Check()" action="login.do" method="post">
                <div class="styled-select">
                    <select name="yonghu" id="yonghu">
                        <option value="0">用户选择</option>
                        <option value="1">学生</option>
                        <option value="2">教师</option>
                    </select>
                </div>
                <input type="text" name="username" id="username" class="username" placeholder="用户名">
                <input type="password" name="password" id="password" class="password" placeholder="密码">
                <button type="submit">登陆</button>
                <div class="error"><span>+</span></div>
            </form>
        </div>
        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/scripts.js"></script>
    </body>

    </html>
