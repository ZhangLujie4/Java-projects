<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="assets/css/style3.css">
        <link rel="stylesheet" href="assets/css/unite.css" type="text/css">
        <title>教师个人信息</title>
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
                <li><a href="teachercenter.jsp">首页</a></li>
                <li><a href="teacherinformation.jsp">教师信息</a></li>
                <li><a href="updatepassword?Type=2&&url=<%= " teachercenter.jsp " %>">修改密码</a></li>
                <li><a href="exit?choose=3">注销</a></li>
            </ul>
        </nav>
        <form action="updateteacherinformation.do" method="post" class="mmm">
            教师编号：${teacher.getTno()}<br> 姓名：
            <input class="nnn" type="text" name="Tname" value=${teacher.getTname()}><br> 性别：
            <input class="nnn" type="text" name="Tsex" value=${teacher.getTsex()}><br> 年龄：
            <input class="nnn" type="text" name="Tage" value=${teacher.getTage()}><br> 职称：
            <input class="nnn" type="text" name="Ttitle" value=${teacher.getTtitle()}><br> 联系电话：
            <input class="nnn" type="text" name="Tphone" value=${teacher.getTphone()}><br>
            <button class="bttn-unite bttn-md bttn-primary" type="submit">保存修改</button>
        </form>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/skel.min.js"></script>
        <script src="assets/js/util.js"></script>
        <script src="assets/js/main.js"></script>
    </body>

    </html>
