<%@ page import="models.bean.PhongBan" %>
<%@ page import="java.util.List" %>
<%@ page import="models.bean.NhanVien" %><%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 30/11/24
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% NhanVien nhanVien = (NhanVien) request.getAttribute("NhanVien"); %>
<h2>Chỉnh Sửa Nhân Viên</h2>

<form action="http://localhost:8080/demo_jsp_war_exploded/employee?action=edit" method="POST">
    <!-- IDNV Field (readonly) -->
    <div class="mb-3">
        <label for="IDNV" class="form-label">ID Nhân Viên</label>
        <input type="text" class="form-control" id="IDNV" name="IDNV" value="<%= nhanVien.getIDNV() %>" readonly>
    </div>

    <!-- HoTen Field -->
    <div class="mb-3">
        <label for="HoTen" class="form-label">Họ Tên</label>
        <input type="text" class="form-control" id="HoTen" name="HoTen" value="<%= nhanVien.getHoTen() %>" required>
    </div>

    <!-- DiaChi Field -->
    <div class="mb-3">
        <label for="DiaChi" class="form-label">Địa Chỉ</label>
        <input type="text" class="form-control" id="DiaChi" name="DiaChi" value="<%= nhanVien.getDiaChi() %>" required>
    </div>

    <!-- Phòng Ban Dropdown -->
    <div class="mb-3">
        <label for="IDPB" class="form-label">Phòng Ban</label>
        <select class="form-select" id="IDPB" name="IDPB" required>
            <option value="" disabled>Chọn Phòng Ban</option>
            <%
                // Lấy danh sách phòng ban từ request
                List<PhongBan> phongBanList = (List<PhongBan>) request.getAttribute("phongBanList");
                for (PhongBan phongBan : phongBanList) {
                    String selected = nhanVien.getIDPB().equals(phongBan.getIDPB()) ? "selected" : "";
            %>
            <option value="<%= phongBan.getIDPB() %>" <%= selected %>><%= phongBan.getTenPB() %>
            </option>
            <%
                }
            %>
        </select>
    </div>

    <!-- Submit Button -->
    <button type="submit" class="btn btn-primary">Cập Nhật</button>
</form>