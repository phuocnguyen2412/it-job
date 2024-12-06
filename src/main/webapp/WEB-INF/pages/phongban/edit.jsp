<%@ page import="models.bean.PhongBan" %><%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 30/11/24
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% %><h2 class="text-center mb-4">Chỉnh sửa thông tin phòng
    ban <%= request.getAttribute("phongBan") != null ? ((PhongBan) request.getAttribute("phongBan")).getTenPB() : "" %>
</h2>
<form action="${pageContext.request.contextPath}/phongban?action=edit" method="POST"
      class="p-4 border rounded bg-light">

    <input hidden="hidden" name="IDPB" type="text"
           value="<%= request.getAttribute("phongBan") != null ? ((PhongBan) request.getAttribute("phongBan")).getIDPB() : "" %>">

    <!-- Tên phòng ban -->
    <div class="mb-3">
        <label for="tenPB" class="form-label">Tên phòng ban</label>
        <input type="text" class="form-control" id="tenPB" name="TenPB"
               value="<%= request.getAttribute("phongBan") != null ? ((PhongBan) request.getAttribute("phongBan")).getTenPB() : "" %>"
               required>
    </div>

    <!-- Mô tả -->
    <div class="mb-3">
        <label for="moTa" class="form-label">Mô tả</label>
        <textarea class="form-control" id="moTa" name="MoTa" rows="3" required><%=
        request.getAttribute("phongBan") != null ? ((PhongBan) request.getAttribute("phongBan")).getMoTa() : "" %>
            </textarea>
    </div>

    <!-- Nút hành động -->
    <div class="text-center">
        <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
        <a href="${pageContext.request.contextPath}/PhongBanServlet?action=index" class="btn btn-secondary">Hủy</a>
    </div>
</form>