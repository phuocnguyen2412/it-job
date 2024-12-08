<%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 7/12/24
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Sign Up!</title>
    <%@ include file="/WEB-INF/layouts/header.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/layouts/nav.jsp" %>

<!-- Main Content -->
<div class="container my-5">
    <div class="row justify-content-center">
        <div class="col-12 col-md-7">
            <h1>Chào mừng bạn đến với IT Jobs</h1>
            <p>
                Bằng việc đăng ký, bạn đồng ý với các Điều khoản dịch vụ
                và Chính sách quyền riêng tư của ITviec liên quan đến
                thông tin riêng tư của bạn.
            </p>
            <form action="<%= request.getContextPath() %>/auth/register" method="post">
                <div class="mb-3">
                    <label for="name" class="form-label">Tên</label>
                    <input
                            type="text"
                            class="form-control"
                            id="name"
                            name="name"
                            placeholder="Nhập tên của bạn"
                            required
                    />
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input
                            type="email"
                            class="form-control"
                            id="email"
                            name="email"
                            placeholder="Nhập email của bạn"
                            required
                    />
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input
                            type="password"
                            class="form-control"
                            id="password"
                            name="password"
                            placeholder="Nhập mật khẩu của bạn"
                            required
                    />
                </div>
                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Đăng ký</button>
                </div>
                <p class="mt-3">
                    Bạn đã có tài khoản?
                    <a href="<%= request.getContextPath() %>/auth/login" class="text-primary">Đăng nhập ngay</a>
                </p>
            </form>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/layouts/footer.jsp" %>
</body>
</html>
