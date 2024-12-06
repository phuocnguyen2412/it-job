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
<body>
<%@ include file="/layouts/header.jsp" %>
<div class="row">
    <div class="col-3">
        <%@ include file="/side_bar.jsp" %>
    </div>
    <div class="col-9">
        <jsp:include page="${contentPage}"/>
    </div>

</div>
<%@ include file="/layouts/footer.jsp" %>
</body>
</html>