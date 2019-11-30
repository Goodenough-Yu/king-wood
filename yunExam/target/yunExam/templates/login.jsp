<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/11/30
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 引入 bootstrap 样式文件 --%>
<link rel="stylesheet" href="/static/bootstrap-4.3.1-dist/css/bootstrap.css">
<%-- 引入 bootstrap 脚本文件--%>
<script src="/static/bootstrap-4.3.1-dist/js/bootstrap.js"></script>
<html>
<head>
    <title>在线考试系统--用户登录</title>
</head>
<style>
    body {
        background-color: #f7f7f7;
    }

    img {
        width: 300px;
        height: 200px;
    }
</style>
<body>
    <div class="container">
        <div class="row mt-5">
            <img src="/static/images/logo.jpg" alt="在线考试" class="rounded mx-auto d-block">
        </div>
        <div class="row mt-3"><h4 class="mx-auto" style="font-weight: 700;">考试系统登录</h4></div>
        <div class="row mt-3">
            <form action="" method="post" class="mx-auto" style="width: 30%;" >
                <div class="form-group row">
                    <input type="text" class="form-control" name="username" placeholder="学/工号" aria-label="username input with dropdown button" >
                </div>
                <div class="form-group row">
                    <input type="password" class="form-control" name="password" placeholder="密码" aria-label="password input">
                </div>
                <div class="form-group row">
                    <select name="identify" class="form-control">
                        <option  value="student" selected>学生</option>
                        <option value="teacher">教师</option>
                        <option value="manager">管理员</option>
                    </select>
                </div>
                <div class="form-group row">
                    <button type="submit" class="btn btn-lg btn-primary" style="width: 100%;">登录</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
