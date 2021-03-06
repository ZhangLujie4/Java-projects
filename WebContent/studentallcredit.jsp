<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <meta name="viewport" content="width=device-width, initial-scale=1" />
            <link rel="stylesheet" href="assets/css/style2.css" type="text/css">
            <link rel="stylesheet" href="assets/css/unite.css" type="text/css">
            <title>已修学分统计</title>
            <a href="studentcenter.jsp" title="返回学生首页">
                <img class="rrr" src="images/logo.svg" alt="" />
            </a>
        </head>

        <body>
            <div>
                <img style="position:absolute;left:0;top:0;z-Index:-1;width:100%;max-width:none; " src="images/2.jpg">
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
            <div id="container">
                <table class="zebra">
                    <thead>
                        <tr>
                            <th align="center">课程编号</th>
                            <th align="center">课程名称</th>
                            <th align="center">学期</th>
                            <th align="center">学时</th>
                            <th align="center">学分</th>
                        </tr>
                    </thead>
                    <c:forEach var="lesson" items="${lessonlist}" varStatus="status">
                        <tr>
                            <td align="center">${lesson.getCno()}</td>
                            <td align="center">${lesson.getCname()}</td>
                            <td align="center">${lesson.getCterm()}</td>
                            <td align="center">${lesson.getCtime()}</td>
                            <td align="center">${lesson.getCcredit()}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td class="bbb" colspan=4 align="center" style="color:red">已修学分共计：</td>
                        <td style="color:blue">${Scredit}</td>
                    </tr>
                </table>
            </div>
            <script src="assets/js/jquery.min.js"></script>
            <script src="assets/js/skel.min.js"></script>
            <script src="assets/js/util.js"></script>
            <script src="assets/js/main.js"></script>
        </body>

        </html>
