<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="assets/css/style3.css">
        <link rel="stylesheet" href="assets/css/unite.css" type="text/css">
        <title>修改课程信息</title>
        <a href="teachercenter.jsp" title="返回教师首页">
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
            <h2>您好，${realname}</h2>
            <ul>
                <li> <a href="teachercenter.jsp">首页</a></li>
                <li><a href="teacherinformation.jsp">教师信息</a></li>
                <li><a href="updatepassword?Type=2&&url=<%= " teachercenter.jsp " %>">修改密码</a></li>
                <li><a href="exit?choose=3">注销</a></li>
            </ul>
        </nav>

        <form action="updatelessoninformation.do" method="post" class="mmm">
            课程编号：${lesson.getCno()}<br> 教师编号：${lesson.getTno()}
            <br> 课程名称：
            <input class="nnn" type="text" name="Cname" value=${lesson.getCname()}><br> 学期：
            <input class="nnn" type="text" name="Cterm" value=${lesson.getCterm()}><br> 考试考查：
            <input class="nnn" type="text" name="Cexam" value=${lesson.getCexam()}><br> 学时：
            <input class="nnn" type="text" name="Ctime" value=${lesson.getCtime()}><br> 学分：
            <input class="nnn" type="text" name="Ccredit" value=${lesson.getCcredit()}><br> 班级：
            <input class="nnn" type="text" name="Cclass" value=${lesson.getCclass()}><br>
            <button class="bttn-unite bttn-md bttn-primary" type="submit">保存修改</button>
        </form>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/skel.min.js"></script>
        <script src="assets/js/util.js"></script>
        <script src="assets/js/main.js"></script>
    </body>

    </html>
