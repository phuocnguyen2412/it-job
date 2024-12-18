<%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 8/12/24
  Time: 01:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Modal chỉnh sửa thông tin giới thiệu
--%>
<div
        class="modal fade"
        id="editIntroduce"
        tabindex="-1"
        aria-labelledby="editIntroduceLabel"
        aria-hidden="true"
>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editIntroduceLabel">
                    Chỉnh sửa giới thiệu
                </h5>
                <button
                        type="button"
                        class="btn-close"
                        data-bs-dismiss="modal"
                        aria-label="Close"
                ></button>
            </div>
            <div class="modal-body">
                <form action="http://localhost:8080/demo_jsp_war_exploded/user/profile" method="post">
                    <div class="mb-3">
                        <label for="introduceInput" class="form-label"
                        >Giới thiệu</label>
                        <textarea
                                class="form-control"
                                id="introduceInput"
                                rows="4"
                        ><%= user.getIntroduce() == null ? "Hãy thêm phần giơí thiệu của bạn!" : user.getIntroduce()%></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button
                        type="button"
                        class="btn btn-secondary"
                        data-bs-dismiss="modal"
                >
                    Hủy
                </button>
                <button
                        type="button"
                        class="btn btn-primary"
                        id="saveIntroduceButton"
                >
                    Lưu thay đổi
                </button>
            </div>
        </div>
    </div>
</div>

<div
        class="col col-8 mx-auto bg-light p-4 rounded-2xl mb-6"
>
    <div class="card border-none">
        <div class="card-header bg-light flex justify-between items-center">
            <h3>Giới thiệu</h3>
            <button
                    class="btn btn-outline-dark"
                    data-bs-toggle="modal"
                    data-bs-target="#editIntroduce"
            >
                <i class="bi bi-pencil-square"></i>
            </button>
        </div>
        <div class="card-body bg-light">
            <h3>
                <%= user.getIntroduce() == null ? "Hãy thêm phần giơí thiệu của bạn!" : user.getIntroduce()%>
            </h3>
        </div>
    </div>
</div>