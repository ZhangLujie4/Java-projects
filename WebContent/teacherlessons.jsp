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
            <title>教师任课查询</title>
            <a href="teachercenter.jsp" title="返回教师首页">
                <img class="rrr" src="images/logo.svg" alt="" />
            </a>
            <%
                 String xueqi = (String)request.getAttribute("xueqi");
                 if(xueqi==null){
	                  xueqi = "2016/2017(1)";
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
                <h2>您好，${realname}</h2>
                <ul>
                    <li> <a href="teachercenter.jsp">首页</a></li>
                    <li><a href="teacherinformation.jsp">教师信息</a></li>
                    <li><a href="updatepassword?Type=2&&url=<%= " teachercenter.jsp " %>">修改密码</a></li>
                    <li><a href="exit?choose=3">注销</a></li>
                </ul>
            </nav>
            <form action="teacherlessonsServlet.do" method="post">
                <div align="center">
                    <select name="xueqi" id="xueqi">
    <option value="2015/2016(1)" <%=(xueqi.equals("2015/2016(1)")?"selected":"")%>>2015/2016(1)</option>
    <option value="2015/2016(2)" <%=(xueqi.equals("2015/2016(2)")?"selected":"")%>>2015/2016(2)</option>
    <option value="2016/2017(1)" <%=(xueqi.equals("2016/2017(1)")?"selected":"")%>>2016/2017(1)</option>
    <option value="2016/2017(2)" <%=(xueqi.equals("2016/2017(2)")?"selected":"")%>>2016/2017(2)</option>
</select>
                    <button class="bttn-unite bttn-md bttn-primary" type="submit">查询</button>
                </div>
            </form>
            <div id="container">
                <table class="zebra">
                    <thead>
                        <tr>
                            <th>课程编号</th>
                            <th>课程名称</th>
                            <th>学期</th>
                            <th>考试考查次数</th>
                            <th>学时</th>
                            <th>学分</th>
                            <th>班级</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <c:forEach var="lesson" items="${lessonlist}" varStatus="status">
                        <tr>
                            <td align="center">${lesson.getCno()}</td>
                            <td align="center">${lesson.getCname()}</td>
                            <td align="center">${lesson.getCterm()}</td>
                            <td align="center">${lesson.getCexam()}</td>
                            <td align="center">${lesson.getCtime()}</td>
                            <td align="center">${lesson.getCcredit()}</td>
                            <td align="center">${lesson.getCclass()}</td>
                            <td align="center">
                                <a class="ppp" href="lessondetail?Cno=${lesson.getCno()}">修改</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <script src="assets/js/jquery.min.js"></script>
            <script src="assets/js/skel.min.js"></script>
            <script src="assets/js/util.js"></script>
            <script src="assets/js/main.js"></script>
        </body>

        </html>
