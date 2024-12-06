<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    boolean loggedIn = session.getAttribute("loggedin") != null ? (Boolean) session.getAttribute("loggedin") : false;
%>
<nav class="nav flex-column bordered">
    <a class='nav-link' href="${pageContext.request.contextPath}/home">Trang chủ</a>
    <a class='nav-link' href="${pageContext.request.contextPath}/employee?action=index">Xem thông tin sinh viên</a>
    <a class='nav-link' href="${pageContext.request.contextPath}/employee?action=create">Tạo nhân viên</a>

    <a class='nav-link' href="${pageContext.request.contextPath}/employee?action=find">Tìm kiếm nhân viên</a>
    <% if (loggedIn) { %>
    <a class='nav-link' href="<%= request.getContextPath() %>/login">Đăng xuất</a>
    <% } else { %>
    <a class='nav-link' href="<%= request.getContextPath() %>/login">Đăng nhập</a>
    <% } %>

    <a class='nav-link' href="${pageContext.request.contextPath}/phongban?action=index">Xem thông tin phòng ban</a>
</nav>