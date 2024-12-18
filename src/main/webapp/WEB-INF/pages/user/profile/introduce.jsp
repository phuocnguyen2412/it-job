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
                        ><%= user.getIntroduce()%></textarea>
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
                <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="16"
                        height="16"
                        fill="currentColor"
                        class="bi bi-pencil"
                        viewBox="0 0 16 16"
                >
                    <path
                            d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325"
                    />
                </svg>
            </button>
        </div>
        <div class="card-body bg-light">
            <h3>
                <%= user.getIntroduce()%>
            </h3>
        </div>
    </div>
</div>