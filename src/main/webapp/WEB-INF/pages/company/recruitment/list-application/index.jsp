<%@ page import="models.bean.Application" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 18/12/24
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Application> applications = (List<Application>) request.getAttribute("applications"); %>
<h1 class="text-center my-4">Danh sách đơn xin việc</h1>
<table class="table table-bordered table-striped">
    <thead class="table-dark">
    <tr>
        <th>#</th>
        <th>Họ tên</th>
        <th>Email</th>
        <th>SDT</th>
        <th>CV</th>
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
        <td><%= application_.getUser().getName() != null ? application_.getUser().getName() : "N/A" %>
        </td>
        <td><%= application_.getUser().getEmail() != null ? application_.getUser().getEmail() : "N/A" %>
        </td>
        <td><%= application_.getUser().getPhoneNumber() != null ? application_.getUser().getPhoneNumber() : "N/A" %>
        </td>
        <td>
            <a href="<%= application_.getCv() != null ? application_.getCv() : "#" %>" target="_blank">Link CV</a>
        </td>
        <td>
            <%
                if (application_.getStatus() != null) {
                    if (application_.getStatus().equals("PENDING")) {
            %>
            <div class="flex gap-3">
                <form method="post" action="http://localhost:8080/demo_jsp_war_exploded/application/update">
                    <input type="hidden" name="id" value="<%= application_.getId() %>">
                    <input type="hidden" name="status" value="ACCEPTED">
                    <button class="btn btn-success" type="submit"><i class="bi bi-check2"></i></button>
                </form>
                <form method="post" action="http://localhost:8080/demo_jsp_war_exploded/application/update">
                    <input type="hidden" name="id" value="<%= application_.getId() %>">
                    <input type="hidden" name="status" value="DECLINED">
                    <button class="btn btn-danger" type="submit"><i class="bi bi-x-lg"></i></button>
                </form>

            </div>
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
