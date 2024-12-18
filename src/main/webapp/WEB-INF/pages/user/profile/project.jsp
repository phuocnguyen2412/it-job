<%@ page import="models.bean.PersonalProject" %><%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 8/12/24
  Time: 01:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div
        class="col col-8 mx-auto bg-light p-4 rounded-2xl mb-6"
>
    <div class="card border-none">
        <div class="card-header bg-light flex justify-between items-center ">
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
                <span class="mb-2"><%= project.getDateStart()%> - <%= project.getDateEnd()%> </span>
                <div>
                    <a href="<%= project.getLink()%>"
                    >View project</a
                    >
                </div>
            </div>
            <% } %>
        </div>
    </div>
</div>