<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0"/>
    <title>感谢您宝贵意见</title>
    <style>
        *{
            margin: 0;
            padding:0;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
        }
        body {
            font-size: 62.5%;
        }
        .evaluate{
           width:100%;
           height:auto;
        }
        .container {
            text-align: center;
            margin: 0 auto;
            width:100%;
            position: absolute;
            top:50%;
            text-align: center;
            
        }
        .wrap {
            display: inline-block;
            position: relative;
            padding-left: 3rem;
            line-height: 2rem;

        }
        .icon {
            position: absolute;
            left: 0;
            top: 0;
            height: 2rem;
        }
        p {
            font-family: 'Microsoft Yahei';
            font-size: 1rem;
        }
    </style>
</head>
<body>
<div class ='evaluate'>
    <div class="container">
    <span class="wrap">
        <img src="${pageContext.request.contextPath}/view/img/1_03.png" class="icon" alt=""/>
    <p>感谢您的宝贵意见和建议！</p>
    </span>
    </div>
    </div>
</body>
</html>