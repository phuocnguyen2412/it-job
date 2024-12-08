<%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 1/12/24
  Time: 01:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
        }

        h1 {
            font-size: 48px;
            color: #ff6b6b;
        }

        p {
            font-size: 18px;
        }
    </style>
</head>
<body>
<h1>Error</h1>
<p>${errorMessage}</p>
<a href="/">Return to Home</a>
</body>
</html>
