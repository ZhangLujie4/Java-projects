<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="assets/css/style3.css">
        <link rel="stylesheet" href="assets/css/unite.css" type="text/css">
        <title>学生信息</title>
        <a href="studentcenter.jsp" title="返回学生首页">
            <img class="rrr" src="images/logo.svg" alt="" />
        </a>
        <%
   String update = (String)request.getAttribute("updateresult");
   System.out.println(update);
   if(update!=null){
%>
            <script type="text/javascript" language="javascript">
                alert("修改成功");

            </script>
            <%
   }
%>
    </head>

    <body>
        <div>
            <img style="position:absolute;left:0;top:0;z-Index:-1;width:100%;max-width:none; " src="images/1.jpg">
        </div>
        <!-- Header -->
        <header id="header">
            <div class="inner">

                <!-- Nav -->
                <nav>
                    <ul>
                        <li><a href="#menu">Menu</a></li>
                    </ul>
                </nav>

            </div>
        </header>

        <!-- Menu -->
        <nav id="menu">
            <h2>你好，${realname}</h2>
            <ul>
                <li><a href="studentcenter.jsp">首页</a></li>
                <li><a href="updateScredit">学生信息</a></li>
                <li><a href="updatepassword?Type=1&&url=<%= " studentcenter.jsp " %>">修改密码</a></li>
                <li><a href="exit?choose=2">注销</a></li>
            </ul>
        </nav>
        <form action="updatestudentinformation.do" method="post" class="mmm">
            学号：${student.getSno()}<br> 已修总学分：${student.getScredit()}
            <br> 姓名：
            <input class="nnn" type="text" name="Sname" value=${student.getSname()}><br> 性别：
            <input class="nnn" type="text" name="Ssex" value=${student.getSsex()}><br> 专业：
            <input class="nnn" type="text" name="Smajor" value=${student.getSmajor()}><br> 班级：
            <input class="nnn" type="text" name="Sclass" value=${student.getSclass()}><br> 生源所在地：
            <input class="nnn" type="text" name="Sarea" value=${student.getSarea()}><br> 地区：
            <input class="nnn" type="text" name="Splace" value=${student.getSplace()}><br>

            <button class="bttn-unite bttn-md bttn-primary" type="submit">保存修改</button>
        </form>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/skel.min.js"></script>
        <script src="assets/js/util.js"></script>
        <script src="assets/js/main.js"></script>
    </body>

    </html>
