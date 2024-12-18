<%@ page import="models.bean.PersonalProject" %><%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 8/12/24
  Time: 01:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col col-8 mx-auto bg-light p-4 rounded-2xl mb-6">
    <div class="card border-none">
        <div class="card-header bg-light flex justify-between items-center">
            <h3>Project</h3>
            <button
                    class="btn"
                    data-bs-toggle="modal"
                    data-bs-target="#addProjectModal"
            >
                <i class="bi bi-plus-circle"></i> Thêm mới
            </button>
        </div>
        <div class="card-body bg-light">
            <% if (user.getProjects().isEmpty()) { %>
            <div>
                <p>Chưa có dự án nào</p>
            </div>
            <% } else { %>
            <% for (PersonalProject project : user.getProjects()) { %>
            <div>
                <div class="flex justify-between items-center mb-2">
                    <h4><%= project.getName()%>
                    </h4>
                    <div class="flex gap-x-4">
                        <i class="bi bi-trash"></i>
                    </div>
                </div>
                <p class="mb-2">
                    <%= project.getDetail()%>
                </p>
                <span class="mb-2"><%= project.getDateStart()%> - <%= project.getDateEnd()%></span>
                <div>
                    <a href="<%= project.getLink()%>">View project</a>
                </div>
            </div>
            <% }
            } %>
        </div>
    </div>
</div>

<!-- Modal thêm mới dự án -->
<div class="modal fade" id="addProjectModal" tabindex="-1" aria-labelledby="addProjectModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="addProject" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="addProjectModalLabel">Thêm dự án mới</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="projectName" class="form-label">Tên dự án</label>
                        <input type="text" class="form-control" id="projectName" name="projectName" required>
                    </div>
                    <div class="mb-3">
                        <label for="projectDetail" class="form-label">Chi tiết dự án</label>
                        <textarea class="form-control" id="projectDetail" name="projectDetail" rows="3"
                                  required></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="dateStart" class="form-label">Ngày bắt đầu</label>
                        <input type="date" class="form-control" id="dateStart" name="dateStart" required>
                    </div>
                    <div class="mb-3">
                        <label for="dateEnd" class="form-label">Ngày kết thúc</label>
                        <input type="date" class="form-control" id="dateEnd" name="dateEnd">
                    </div>
                    <div class="mb-3">
                        <label for="projectLink" class="form-label">Liên kết dự án</label>
                        <input type="url" class="form-control" id="projectLink" name="projectLink">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                    <button type="submit" class="btn btn-primary">Thêm dự án</button>
                </div>
            </form>
        </div>
    </div>
</div>
