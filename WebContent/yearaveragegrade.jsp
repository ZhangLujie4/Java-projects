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
            <title>学年成绩统计</title>
            <a href="studentcenter.jsp" title="返回学生首页">
                <img class="rrr" src="images/logo.svg" alt="" />
            </a>
            <%
                 String xuenian = (String)request.getAttribute("xuenian");
                 if(xuenian==null){
	                     xuenian = "2016/2017";
                 }
            %>
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
            <form action="yearaveragegrade" method="post">
                <div align="center">
                    <select name="xuenian" id="xuenian">
    <option value="2015/2016" <%=(xuenian.equals("2015/2016")?"selected":"")%>>2015/2016</option>
    <option value="2016/2017" <%=(xuenian.equals("2016/2017")?"selected":"")%>>2016/2017</option>
</select>
                    <button class="bttn-unite bttn-md bttn-primary" type="submit">查询</button>
                </div>
            </form>
            <div id="container">
                <table class="zebra">
                    <thead>
                        <tr>
                            <th align="center">课程编号</th>
                            <th align="center">课程名称</th>
                            <th align="center">学时</th>
                            <th align="center">成绩</th>
                        </tr>
                    </thead>
                    <c:forEach var="grade" items="${gradelist}" varStatus="status">
                        <tr>
                            <td align="center">${grade.getCno()}</td>
                            <td align="center">${grade.getCname()}</td>
                            <td align="center">${grade.getCterm()}</td>
                            <td align="center">${grade.getSgrade()}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td class="aaa" colspan=4>${xuenian}学年成绩平均分：${averagexuenian}</td>
                    </tr>
                </table>
            </div>
            <script src="assets/js/jquery.min.js"></script>
            <script src="assets/js/skel.min.js"></script>
            <script src="assets/js/util.js"></script>
            <script src="assets/js/main.js"></script>
        </body>

        </html>
