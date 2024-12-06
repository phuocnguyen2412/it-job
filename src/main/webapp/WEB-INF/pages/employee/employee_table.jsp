<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="models.bean.NhanVien" %>


<%

    boolean loggedIn = session.getAttribute("loggedin") != null ? (Boolean) session.getAttribute("loggedin") : false;


    List<NhanVien> employees = (List<NhanVien>) request.getAttribute("employees");
%>


<form id="employeeForm" action="${pageContext.request.contextPath}/employee?action=deleteMulti" method="POST">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th><input type="checkbox" id="selectAll" onclick="toggleSelectAll()"></th>
            <th>IDNV</th>
            <th>Họ Tên</th>
            <th>Địa Chỉ</th>
            <th>Phòng Ban</th>
            <% if (loggedIn) { %>
            <th>Hành động</th>
            <% } %>
        </tr>
        </thead>
        <tbody>
        <%
            if (employees != null && !employees.isEmpty()) {
                for (NhanVien emp : employees) {
        %>
        <tr>
            <td><input type="checkbox" name="selectedEmployees[]" value="<%= emp.getIDNV() %>"></td>
            <td><%= emp.getIDNV() %>
            </td>
            <td><%= emp.getHoTen() %>
            </td>
            <td><%= emp.getDiaChi() %>
            </td>
            <td><%= emp.getIDPB() %>
            </td>
            <% if (loggedIn) { %>
            <td>
                <a class="btn btn-warning btn-sm"
                   href="${pageContext.request.contextPath}/employee?action=edit&IDNV=<%= emp.getIDNV() %>">Chỉnh
                    sửa</a>
                <button class="btn btn-danger btn-sm" onclick="deleteEmployee(event, '<%= emp.getIDNV() %>')">Xóa
                </button>
            </td>
            <% } %>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="6">Không có dữ liệu</td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <% if (loggedIn) { %>
    <button type="submit" class="btn btn-danger">Xóa Nhân Viên Đã Chọn</button>
    <% } %>
</form>

<script>
    function toggleSelectAll() {
        const selectAllCheckbox = document.getElementById("selectAll");
        const checkboxes = document.querySelectorAll("input[name='selectedEmployees[]']");
        checkboxes.forEach(checkbox => {
            checkbox.checked = selectAllCheckbox.checked;
        });
    }

    function deleteEmployee(event, id) {
        console.log(id)
        event.preventDefault();
        console.log('${pageContext.request.contextPath}/employee?action=delete&IDNV' + id)
        if (confirm('Bạn có chắc muốn xóa nhân viên này?')) {
            window.location.href = '${pageContext.request.contextPath}/employee?action=delete&IDNV=' + id;
        }
    }
</script>
