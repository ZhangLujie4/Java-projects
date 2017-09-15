<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>教师中心</title>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="assets/css/main.css" />
        <a href="teachercenter.jsp" title="返回教师首页">
            <img class="rrr" src="images/logo.svg" alt="" />
        </a>
    </head>

    <body>
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
            <h2>欢迎${realname}</h2>
            <ul>
                <li><a href="teacherinformation.jsp">教师信息</a></li>
                <li><a href="updatepassword?Type=2&&url=<%= " teachercenter.jsp " %>">修改密码</a></li>
                <li><a href="exit?choose=3">注销</a></li>
            </ul>
        </nav>
        <div id="main">
            <div class="inner">
                <section class="tiles">
                    <article class="style5">
                        <span class="image">
					<img src="images/pic10.jpg" alt="" />
				</span>
                        <a href="teacherlessonsServlet.do">
                            <h2>教师任课查询</h2>
                            <div class="content">
                                <p>教师每学期任课查询</p>
                            </div>
                        </a>
                    </article>
                    <article class="style6">
                        <span class="image">
					<img src="images/pic11.jpg" alt="" />
				</span>
                        <a href="selectlesson">
                            <h2>学生成绩录入</h2>
                            <div class="content">
                                <p>输入学生成绩</p>
                            </div>
                        </a>
                    </article>
                    <article class="style4">
                        <span class="image">
					<img src="images/pic12.jpg" alt="" />
				</span>
                        <a href="selectindexgrade">
                            <h2>学生成绩排名及平均成绩</h2>
                            <div class="content">
                                <p>查看各科目学生成绩排名及科目平均分</p>
                            </div>
                        </a>
                    </article>
                </section>
            </div>
        </div>
        <!-- Scripts -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/skel.min.js"></script>
        <script src="assets/js/util.js"></script>
        <script src="assets/js/main.js"></script>
    </body>

    </html>
