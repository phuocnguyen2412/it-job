<%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 30/11/24
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>
        Quản lý nhân viên
    </title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body class="container">
<%@ include file="/WEB-INF/layouts/header.jsp" %>
<div class="row">
    <div class="col-3">
        <%@ include file="side_bar.jsp" %>
    </div>
    <div class="col-9">
        <jsp:include page="${contentPage}"/>
    </div>

</div>
<%@ include file="/WEB-INF/layouts/footer.jsp" %>
</body>
</html>