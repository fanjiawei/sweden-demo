<%@ page import="com.whereareyou.service.UserService" %>
<%@ page import="com.google.inject.Injector" %>
<%@ page import="com.whereareyou.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
  <head>
    <title></title>
    <link rel="stylesheet" href="/css/main.css" type="text/css"/>
    <link rel="stylesheet" href="http://cdnjscn.b0.upaiyun.com/libs/normalize/3.0.1/normalize.min.css" type="text/css"/>
    <link rel="stylesheet" href="http://cdnjscn.b0.upaiyun.com/libs/font-awesome/4.1.0/css/font-awesome.min.css" type="text/css">
    <script src="http://webapi.amap.com/maps?v=1.3&key=5885aebef9003604de85c0b1df288bd4" type="text/javascript"></script>
  </head>
  <body>
    <div id="map"></div>
    <ul class="buttons abs">
        <li><a href="javascript:expandCollapse('#friends');" title="好友"><span class="fa fa-users fa-2x"></span> </a></li>
        <li><a href="" title="设备"><span class="fa fa-cube fa-2x"></span> </a></li>
        <li><a href="" title="添加好友与设备"><span class="fa fa-plus fa-2x"></span> </a></li>
        <li><a href="/logout" title="注销"><span class="fa fa-power-off fa-2x"></span> </a></li>
    </ul>
    <ul id="friends" class="abs bg-black font-color-white hidden">
        <li>
            <div class="photo pull-left"><img src="/images/obama.png"></div>
            <span class="name">奥巴马</span>
        </li>
        <li>
            <div class="photo pull-left"> <img src="/images/dahuzi_48x48.png"></div>
            <span class="name">大胡子</span>
        </li>
    </ul>
    <div id="drives"></div>
    <div id="add"></div>
    <script>
        USERID="<%=((User)session.getAttribute("user")).getId()%>"
    </script>
    <script src="http://cdnjscn.b0.upaiyun.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="/js/main.js"></script>
    <script src="/js/sendLocation.js"></script>
  </body>
</html>
