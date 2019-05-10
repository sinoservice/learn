<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<style>
    .clearfix:before,
    .clearfix:after {
        content: "";
        display: block;
        height: 0;
        line-height: 0;
        visibility: hidden;
        clear: both;
    }

    .clearfix {
        *zoom: 1; /*IE/7/6*/
    }

    a{
        text-decoration: none;
        color: red;
    }
    ul li {
        list-style: none;
    }
    p:nth-child(1) {
        margin-top:200px
    }
    p:nth-child(2) {
        margin-top:40px
    }
    /*底部*/
    .footer {
        width:100%;
        margin-top: 100px;
        padding-bottom: 30px;

    }
    .footer .about {
        width: 100%;
    }

    .footer ul {
        width: 480px;
        margin: 0 auto;
        padding-top: 40px;

    }
    .footer ul li {
        float: left;
        cursor: pointer;
        font-family: "Microsoft YaHei", sans-serif;
        font-size: 14px;
        padding-left:80PX ;
        color: #5A280A;
    }
    .footer span {
        display: block;
        text-align: center;
        font-family: "Microsoft YaHei", sans-serif;
        font-size: 14px;
        color: #5A280A;
        padding-top: 10px;
    }
</style>
<body>
<p align='center' class=""> <img src="${pageContext.request.contextPath}/view/img/appraise.png" alt=""></p>
<div class='footer '>
    <div class='about clearfix'>
        <ul style='text-align: center'>
            <li><a href="#"></a>关于我们</li>
            <li><a href="#"></a>合作</li>
            <li><a href="#"></a>联系我们</li>
        </ul>
    </div>
    <span>Copyright(C) 北京居然之家智慧物联科技有限公司 2003-2018,All Rights Reserved.</span>
</div>
</body>
</html>