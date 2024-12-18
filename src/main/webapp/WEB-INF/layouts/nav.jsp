<%@ page import="models.bean.Account" %><%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 7/12/24
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String role = request.getSession().getAttribute("role") == null ? "" : (String) request.getSession().getAttribute("role"); %>
<nav class="navbar navbar-expand-lg bg-dark " data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="http://localhost:8080/demo_jsp_war_exploded/home">IT JOB</a>
        <div class="d-flex">
            <% if (role.equals("Admin")) {%>
            <a style="color: #fff" href="http://localhost:8080/demo_jsp_war_exploded/admin/create-account" class="me-3"
               class="text-[#fff]">Admin Dashboard</a>
            <% } %>

            <% if (role.equals("Employee")) {%>
            <a style="color: #fff" href="http://localhost:8080/demo_jsp_war_exploded/user/application" class="me-3"
               class="text-[#fff]">My application</a>
            <a style="color: #fff" href="http://localhost:8080/demo_jsp_war_exploded/user/profile" class="me-3"
               class="text-[#fff]">My profile</a>
            <% } %>

            <% if (role.equals("Company")) {%>
            <a style="color: #fff" href="http://localhost:8080/demo_jsp_war_exploded/company/edit" class="me-3"
               class="text-[#fff]">Company Dashboard</a>
            <% } %>

            <a style="color: #fff" href="http://localhost:8080/demo_jsp_war_exploded/auth/login" class="me-3"
               class="text-[#fff]">Sign
                in/Sign up</a>
        </div>
    </div>
</nav>
