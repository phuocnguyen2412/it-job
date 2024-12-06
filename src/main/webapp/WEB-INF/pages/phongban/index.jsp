<%@ page import="models.bean.PhongBan" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Thông tin phòng ban</h1>

<table class="table">
    <thead>
    <tr>
        <th>IDPB</th>
        <th>TenPB</th>
        <th>MoTa</th>
        <th>Thông tin NVPB</th>
        <%
            // Kiểm tra xem người dùng đã đăng nhập hay chưa
            if (session.getAttribute("loggedin") != null && (Boolean) session.getAttribute("loggedin")) {
        %>
        <th>Cập nhật</th>
        <%
            }
        %>
    </tr>
    </thead>
    <tbody>
    <%
        // Lấy danh sách phòng ban từ request
        List<PhongBan> phongBanList = (List<PhongBan>) request.getAttribute("phongBanList");

        // Kiểm tra nếu có dữ liệu
        if (phongBanList != null && !phongBanList.isEmpty()) {
            for (PhongBan phongBan : phongBanList) {
    %>
    <tr>
        <td><%= phongBan.getIDPB() %>
        </td>
        <td><%= phongBan.getTenPB() %>
        </td>
        <td><%= phongBan.getMoTa() %>
        </td>
        <td><a href="http://localhost:8080/demo_jsp_war_exploded/phongban?action=detail&id=<%= phongBan.getIDPB() %>">xxx</a>
        </td>

        <%
            // Hiển thị nút "Cập nhật" nếu người dùng đã đăng nhập
            if (session.getAttribute("loggedin") != null && (Boolean) session.getAttribute("loggedin")) {
        %>
        <td><a href="http://localhost:8080/demo_jsp_war_exploded/phongban?action=edit&id=<%= phongBan.getIDPB() %>"
               class="edit-btn">Edit</a></td>
        <%
            }
        %>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="5">Không có dữ liệu</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
