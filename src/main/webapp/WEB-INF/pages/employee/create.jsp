<%@ page import="models.bean.PhongBan" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 30/11/24
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Thêm Nhân Viên</h2>

<form action="http://localhost:8080/demo_jsp_war_exploded/employee?action=create" method="POST">

    <div class="mb-3">
        <label for="IDNV" class="form-label">ID Nhân Viên</label>
        <input type="text" class="form-control" id="IDNV" name="IDNV" required>
    </div>

    <!-- HoTen Field -->
    <div class="mb-3">
        <label for="HoTen" class="form-label">Họ Tên</label>
        <input type="text" class="form-control" id="HoTen" name="HoTen" required>
    </div>

    <!-- DiaChi Field -->
    <div class="mb-3">
        <label for="DiaChi" class="form-label">Địa Chỉ</label>
        <input type="text" class="form-control" id="DiaChi" name="DiaChi" required>
    </div>

    <!-- Phòng Ban Dropdown -->
    <div class="mb-3">
        <label for="IDPB" class="form-label">Phòng Ban</label>
        <select class="form-select" id="IDPB" name="IDPB" required>
            <option value="" disabled selected>Chọn Phòng Ban</option>
            <%-- Lấy các phòng ban từ dữ liệu và hiển thị --%>
            <%
                // Giả sử bạn đã có một danh sách phòng ban trong request hoặc session
                List<PhongBan> phongBanList = (List<PhongBan>) request.getAttribute("phongBanList");
                for (PhongBan phongBan : phongBanList) {
            %>
            <option value="<%= phongBan.getIDPB() %>"><%= phongBan.getTenPB() %>
            </option>
            <%
                }
            %>
        </select>
    </div>

    <!-- Submit Button -->
    <button type="submit" class="btn btn-primary">Thêm Nhân Viên</button>
</form>