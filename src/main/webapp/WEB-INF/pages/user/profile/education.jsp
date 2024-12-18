<%@ page import="models.bean.Education" %><%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 8/12/24
  Time: 01:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Modal Thêm Học Vấn --%>
<div
        class="modal fade"
        id="addEducationModal"
        tabindex="-1"
        aria-labelledby="addEducationModalLabel"
        aria-hidden="true"
>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addEducationModalLabel">Thêm Học Vấn</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="addEducationForm" action="http://localhost:8080/demo_jsp_war_exploded/user/profile"
                      method="post">
                    <div class="mb-3">
                        <label for="degreeInput" class="form-label">Bằng cấp</label>
                        <input type="text" class="form-control" id="degreeInput" name="specialize" required>
                    </div>
                    <div class="mb-3">
                        <label for="descriptionInput" class="form-label">Truờng</label>
                        <textarea class="form-control" id="descriptionInput" name="school" rows="3"
                                  required></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="startDateInput" class="form-label">Ngày bắt đầu</label>
                        <input type="date" class="form-control" id="startDateInput" name="startDate" required>
                    </div>
                    <div class="mb-3">
                        <label for="endDateInput" class="form-label">Ngày kết thúc</label>
                        <input type="date" class="form-control" id="endDateInput" name="endDate" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Lưu</button>
                </form>
            </div>
        </div>
    </div>
</div>

<div
        class="col col-8 mx-auto bg-light  p-4 rounded-2xl mb-6"
>
    <div class="card border-none">
        <div class="card-header bg-light flex justify-between items-center ">
            <h3>Học vấn</h3>
            <button
                    class="btn"
                    data-bs-toggle="modal"
                    data-bs-target="#addEducationModal"
            >
                <i class="bi bi-plus-circle"></i> Thêm mới
            </button>
        </div>
        <div class="card-body bg-light">
            <% for (Education education : user.getEducations()) { %>
            <div class="border-b-2 border-dashed my-2 py-2">
                <div class="flex justify-between j items-center mb-2">
                    <h4><%=education.getSpecialize()%>
                    </h4>
                    <div class="flex gap-x-4">
                        <button
                                class="btn btn-sm btn-danger delete-education-btn"
                                data-id="<%= education.getId() %>"
                        >
                            <i class="bi bi-trash"></i>
                        </button>
                    </div>
                </div>

                <p class="mb-2">
                    <%=education.getSchool()%>
                </p>
                <span> <%= education.getDateStart()%> - <%= education.getDateEnd()%> </span>
            </div>
            <% } %>
        </div>
    </div>
</div>
