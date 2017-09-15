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
            <title>学生成绩录入</title>
            <a href="exit?choose=4" title="返回教师首页">
                <img class="rrr" src="images/logo.svg" alt="" />
            </a>
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
            <%
   				String xueqi = (String)request.getSession().getAttribute("xueqi");
   				if(xueqi==null){
	    			xueqi="2016/2017(1)";
   				}
   				String kecheng = request.getParameter("kecheng");
   				if(kecheng==null){
					kecheng="0";
   				}   
			%>
                        <script language="JavaScript" type="text/javascript">
                            function Check() {
                                var kecheng = document.getElementById("kecheng");
                                if (kecheng.value == "0") {
                                    alert("请选择课程！");
                                    document.getElementById("kecheng").focus();
                                    return false;
                                }
                            }

                        </script>
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
                    <li><a href="exit?choose=4">首页</a></li>
                    <li><a href="teacherinformation.jsp">教师信息</a></li>
                    <li><a href="updatepassword?Type=2&&url=<%= " teachercenter.jsp " %>">修改密码</a></li>
                    <li><a href="exit?choose=3">注销</a></li>
                </ul>
            </nav>
            <div align="center">
                <form onsubmit="return Check()" action="selectlesson" method="post">
                    <strong><h2 class="ttt">请选择需要录入成绩的学期课程：</h2></strong>

                    <select name="xueqi" id="xueqi" onchange="window.location=this.value;">
    <option value="selectlesson?xueqi=<%="2015/2016(1)"  %>" <%=(xueqi.equals("2015/2016(1)")?"selected":"")%>>2015/2016(1)</option>
    <option value="selectlesson?xueqi=<%="2015/2016(2)"  %>" <%=(xueqi.equals("2015/2016(2)")?"selected":"")%>>2015/2016(2)</option>
    <option value="selectlesson?xueqi=<%="2016/2017(1)"  %>" <%=(xueqi.equals("2016/2017(1)")?"selected":"")%>>2016/2017(1)</option>
    <option value="selectlesson?xueqi=<%="2016/2017(2)"  %>" <%=(xueqi.equals("2016/2017(2)")?"selected":"")%>>2016/2017(2)</option>
</select>
                    <select name="kecheng" id="kecheng">
    <option value="0" <%=(kecheng.equals("0")?"selected":"")%>>请选择课程</option>
    <c:forEach var="lesson" items="${sessionScope.lessonlist}" varStatus="status">
    <option value="${lesson.getCname()}" <c:if test="${lesson.getCname()== kecheng}">selected="selected"</c:if>>${lesson.getCname()}</option>
    </c:forEach>
</select>
                    <button class="bttn-unite bttn-md bttn-primary" type="submit">查询</button>
                </form>
            </div>
            <form action="inputstudentgrades" method="post">
                <div id="container">
                    <table class="zebra">
                        <thead>
                            <tr>
                                <th align="center">学号</th>
                                <th align="center">学生姓名</th>
                                <th align="center">成绩</th>
                            </tr>
                        </thead>
                        <c:forEach var="grade" items="${gradelist}" varStatus="status">
                            <tr>
                                <td align="center"><input type="hidden" value=${grade.getSno()} name="Sno">${grade.getSno()}</td>
                                <td align="center"><input type="hidden" value=${grade.getCno()} name="Cno">${grade.getSname()}</td>
                                <td align="center"><input type="text" name="Sgrade" value=${grade.getSgrade()}></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div align="center">
                    <button class="bttn-unite bttn-md bttn-primary" type="submit">提交保存</button>
                </div>
            </form>
            <script src="assets/js/jquery.min.js"></script>
            <script src="assets/js/skel.min.js"></script>
            <script src="assets/js/util.js"></script>
            <script src="assets/js/main.js"></script>
        </body>

        </html>
