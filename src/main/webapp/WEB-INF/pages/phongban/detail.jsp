<%@ page import="models.bean.NhanVien" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Thông tin phòng ban <%= request.getParameter("id") %>
</h1> <!-- Hiển thị ID phòng ban -->

<table class="table table-bordered">
    <thead>
    <tr>
        <th>IDNV</th>
        <th>HoTen</th>
        <th>DiaChi</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<NhanVien> employees = (List<NhanVien>) request.getAttribute("employees");
        if (employees != null && !employees.isEmpty()) {
            for (NhanVien employee : employees) {
    %>
    <tr>
        <td><%= employee.getIDNV() %>
        </td>
        <td><%= employee.getHoTen() %>
        </td>
        <td><%= employee.getDiaChi() %>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="3">Không có dữ liệu</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
