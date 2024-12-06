<%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 30/11/24
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="margin:auto">
    <form action="${pageContext.request.contextPath}/employee?action=find" method="GET">
        <input type="hidden" name="action" value="find">

        <label for="searchType">Tìm kiếm theo:</label>
        <input type="radio" name="key" id="hoTen" value="HoTen">
        <label for="hoTen">Họ Tên</label>
        <input type="radio" name="key" id="idnv" value="IDNV">
        <label for="idnv">ID Nhân Viên</label>
        <input type="radio" name="key" id="diaChi" value="DiaChi">
        <label for="diaChi">Địa Chỉ</label>

        <br>

        <label for="searchValue">Giá trị tìm kiếm:</label>
        <input type="text" name="value" id="searchValue">

        <button type="submit">Tìm kiếm</button>
        <button type="reset">reset</button>
    </form>
</div>

<%@ include file="employee_table.jsp" %>