<%@ page import="java.util.List" %>
<%@ page import="models.bean.Application" %><%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 19/12/24
  Time: 01:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Application> applications = (List<Application>) request.getAttribute("applications"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Profile</title>
    <%@include file="/WEB-INF/layouts/header.jsp" %>
</head>
<body>

<%@include file="/WEB-INF/layouts/nav.jsp" %>
<!-- Main Content -->
<div class="container my-5">
    <div class="flex-col gap-6">
        <h1 class="text-center my-4">Danh sách đơn xin việc</h1>
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
            <tr>
                <th>#</th>
                <th>Vị trí</th>
                <th>Công ty</th>
                <th>Mức lương</th>
                <th>Tình trạng</th>
            </tr>
            </thead>
            <tbody>
            <%
                if (applications != null && !applications.isEmpty()) {
                    for (int i = 0; i < applications.size(); i++) {
                        Application application_ = applications.get(i);
                        if (application_ != null && application_.getUser() != null) {
            %>
            <tr>
                <td><%= i + 1 %>
                </td>
                <td><%= application_.getRecruitment().getPosition() %>
                </td>
                <td><%= application_.getRecruitment().getCompany().getName() %>
                </td>
                <td><%= application_.getRecruitment().getSalarayRange() %>
                </td>
                <td>
                    <%
                        if (application_.getStatus() != null) {
                            if (application_.getStatus().equals("PENDING")) {
                    %>
                    <span class="badge bg-info">Đang chờ</span>
                    <%
                    } else if (application_.getStatus().equals("ACCEPTED")) {
                    %>
                    <span class="badge bg-success">Đã chấp nhận</span>
                    <%
                    } else {
                    %>
                    <span class="badge bg-danger">Đã từ chối</span>
                    <%
                        }
                    } else {
                    %>
                    <span class="badge bg-secondary">Không xác định</span>
                    <%
                        }
                    %>
                </td>
            </tr>
            <%
                    }
                }
            } else {
            %>
            <tr>
                <td colspan="6" class="text-center">Không có việc làm nào</td>
            </tr>
            <% } %>

            </tbody>
        </table>

    </div>
</div>
<%@include file="/WEB-INF/layouts/footer.jsp" %>
</body>

</html>