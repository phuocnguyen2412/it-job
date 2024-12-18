<%@ page import="models.bean.Recruitment" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1 class="text-center mb-4">Danh sách việc làm</h1>
<table class="table table-bordered table-striped">
    <thead class="table-dark">
    <tr>
        <th>#</th>
        <th>Vị trí</th>
        <th>Mức lương</th>
        <th>Ngày tạo</th>
        <th>Chỉnh sửa</th>
        <th>Xem chi tiết</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Ví dụ danh sách việc làm
        List<Recruitment> recruitments = (List<Recruitment>) request.getAttribute("recruitments");
        if (recruitments != null && !recruitments.isEmpty()) {
            for (int i = 0; i < recruitments.size(); i++) {
                Recruitment recruitment = recruitments.get(i);
    %>
    <tr>
        <td><%=recruitment.getId() %>
        </td>
        <td><%= recruitment.getPosition() %>
        </td>
        <td><%= recruitment.getSalarayRange() %>
        </td>
        <td><%= recruitment.getCreatedAt() %>
        </td>
        <td>
            <a href="${pageContext.request.contextPath}/company/edit-recruitment?id=<%= recruitment.getId() %>"
               class="btn btn-warning btn-sm">
                <i class="bi bi-pencil"></i> Chỉnh sửa
            </a>
        </td>
        <td>
            <a href="${pageContext.request.contextPath}/recruitment/detail?id=<%= recruitment.getId() %>"
               class="btn btn-info btn-sm">
                <i class="bi bi-eye"></i> Xem chi tiết
            </a>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="6" class="text-center">Không có việc làm nào</td>
    </tr>
    <% } %>
    </tbody>
</table>