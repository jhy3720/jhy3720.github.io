<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<% request.setCharacterEncoding("utf-8"); %> 
<!doctype html> <!-- /beanMem.jsp --> 
<html><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> 
<meta name="viewport" content="width=device-width, initial-scale=1"/> 
<style> 
* {padding:0; margin:0; } 
body {font-family: Verdana, sans-serif; font-size:0.8em} 
header,nav,section, article, aside,footer {border:1px solid gray; margin:5px; padding:8px} 
nav ul{margin:0; padding:0;} 
nav ul li{display:inline; margin:5px} 
a:link { color:blue; text-decoration:none; } a:visited{color:purple;text-decoration:none;} 
a:hover { text-decoration:underline; } a:active { color:red; text-decoration:none; } 
section{height:450px;} .id form{width:50px;} 
.label_form{display: inline-block; width:55px; height: 14px; color:red;padding:5px;} 
.button_form { width:60px; margin-left:5px; } 
.fset {padding: 15px; } 
#dupBtn { height:25px;} 
ul.level_1 > li {list-style:none; display:inline-block;vertical-align:bottom;} 
ul.level_1 > li > ul {list-style:none; } 
.level_2 li { padding-top:5px; } .level_2 span { display:inline-block; width:70px; } .level_2 input { width:100px; } 
#loginBtn button { margin-left:5px; height:42px;} 
</style>
<title>회원관리</title>
<jsp:useBean id="dto" class="studpkg.StudDTO" scope="session"/> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> 
</head> 
<body> 
<% 
boolean flag = dto.isVerified(); 
if (!flag)
{
response.sendRedirect("./beanHome.html"); 
} else { 
%> 
<header><h2>회원관리</h2></header> 
<nav><ul><li><a href="./beanLogout.jsp"> 로그아웃</a></li> 
<li><a href="./beanFind.jsp"> 검색</a></li></ul></nav> 
<section> <% } %> 
</section> 
<footer><p>&copy;20XX Made by Korea. All rights reserved.</p></footer></body></html>