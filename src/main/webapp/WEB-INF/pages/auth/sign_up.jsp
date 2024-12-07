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
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
    />
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
            rel="stylesheet"
    />
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        body {
            background-color: #121212;
            color: #fff;
        }

        .navbar {
            background-color: #1a1a1a;
        }

        .search-bar {
            padding: 12px;
            background-color: #1a1a1a;
            border: 1px solid #444;
            color: #fff;
        }

        .search-bar::placeholder {
            color: #fff;
        }

        .suggestions span {
            background-color: #333;
            color: #fff;
            padding: 0.3rem 0.6rem;
            border-radius: 4px;
            margin-right: 0.5rem;
        }

        .suggestions span:hover {
            background-color: #555;
        }

        .merry-christmas {
            position: absolute;
            bottom: 0;
            right: 20px;
        }
    </style>
</head>
<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">itviec</a>
        <div class="d-flex">
            <a href="#" class="me-3 text-light">For Employers</a>
            <a href="#" class="me-3 text-light">Sign in/Sign up</a>
        </div>
    </div>
</nav>

<!-- Main Content -->
<div class="container my-5">
    <div class="flex justify-center">
        <div class="col col-7">
            <h1>Chào mừng bạn đến với IT Jobs</h1>
            <p>
                Bằng việc đăng nhập, bạn đồng ý với các Điều khoản dịch
                vụ và Chính sách quyền riêng tư của ITviec liên quan đến
                thông tin riêng tư của bạn.
            </p>
            <form action="" method="post">
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
                    <label for="password" class="form-label"
                    >Password</label
                    >
                    <input
                            type="password"
                            class="form-control"
                            id="password"
                            name="password"
                            placeholder="Nhập mật khẩu của bạn"
                            required
                    />
                </div>
                <div>
                    <input type="submit" title="Đăng nhập"/>
                </div>

                <span>
                  Bạn đã có tài khoản? <a href="#">Đăng nhập ngay</a>
                </span>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
