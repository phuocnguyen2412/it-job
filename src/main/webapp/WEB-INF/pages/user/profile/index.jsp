<%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 8/12/24
  Time: 00:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Document</title>
    <%@include file="/WEB-INF/layouts/header.jsp" %>
</head>
<body>


<!-- Main Content -->
<div class="container my-5">
    <div class="flex-col gap-6">
        <!-- Thông tin cá nhân -->
        <%@include file="information.jsp" %>
        <%--        Giois thieju--%>
        <%@include file="introduce.jsp" %>

        <!-- Học vấn -->
        <%@include file="education.jsp" %>

        <!-- Project -->
        <%@include file="project.jsp" %>

        <!-- Giấy chứng nhận -->
        <%@include file="certificate.jsp" %>
        <!-- Giải thưởng -->
        <%@include file="award.jsp" %>
    </div>
</div>
</body>

</html>

