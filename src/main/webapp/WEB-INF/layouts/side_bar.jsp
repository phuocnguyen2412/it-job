<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    boolean loggedIn = session.getAttribute("loggedin") != null ? (Boolean) session.getAttribute("loggedin") : false;
%>
<nav class="nav  flex-column bordered">
    <a class='nav-link' href="${pageContext.request.contextPath}/home">Trang chủ</a>
    <a class='nav-link' href="${pageContext.request.contextPath}/company/edit">Chỉnh sửa thông tin công ty</a>
    <a class='nav-link' href="${pageContext.request.contextPath}/company/create-recruitment">Tạo việc làm</a>
    <a class='nav-link' href="${pageContext.request.contextPath}/company/list-recruitment">Danh sách việc làm</a>
    <% if (loggedIn) { %>
    <a class='nav-link' href="<%= request.getContextPath() %>/login">Đăng xuất</a>
    <% } else { %>
    <a class='nav-link' href="<%= request.getContextPath() %>/login">Đăng nhập</a>
    <% } %>


</nav>