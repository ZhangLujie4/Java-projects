<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>学生中心</title>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="assets/css/main.css" />
        <a href="studentcenter.jsp" title="返回学生首页">
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
                <li><a href="updateScredit">学生信息</a></li>
                <li><a href="updatepassword?Type=1&&url=<%= " studentcenter.jsp " %>">修改密码</a></li>
                <li><a href="exit?choose=2">注销</a></li>
            </ul>
        </nav>
        <div id="main">
            <div class="inner">
                <section class="tiles">
                    <article class="style1">
                        <span class="image">
					<img src="images/pic01.jpg" alt="" />
				</span>
                        <a href="studentgradeServlet.do">
                            <h2>学生学期成绩查询</h2>
                            <div class="content">
                                <p>根据学期查询所得成绩</p>
                            </div>
                        </a>
                    </article>
                    <article class="style2">
                        <span class="image">
					<img src="images/pic02.jpg" alt="" />
				</span>
                        <a href="yearaveragegrade">
                            <h2>学生学年成绩统计</h2>
                            <div class="content">
                                <p>按每学年成绩取平均得到统计结果</p>
                            </div>
                        </a>
                    </article>
                    <article class="style3">
                        <span class="image">
					<img src="images/pic03.jpg" alt="" />
				</span>
                        <a href="studentallcredit">
                            <h2>学生学分统计</h2>
                            <div class="content">
                                <p>已修课程及已修学分总和</p>
                            </div>
                        </a>
                    </article>
                    <article class="style4">
                        <span class="image">
					<img src="images/pic04.jpg" alt="" />
				</span>
                        <a href="studentlessonsServlet.do">
                            <h2>学生学期课表</h2>
                            <div class="content">
                                <p>每学期已选课程</p>
                            </div>
                        </a>
                    </article>
                    <article class="style5">
                        <span class="image">
					<img src="images/pic05.jpg" alt="" />
				</span>
                        <a href="classlessonsServlet.do">
                            <h2>班级开课查询<br></h2>
                            <h2>(含增删课)</h2>
                            <div class="content">
                                <p>每学期按班级开设课程及增删选课</p>
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
