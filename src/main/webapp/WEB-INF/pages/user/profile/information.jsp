<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div
        class="modal fade"
        id="editPersonalInfo"
        tabindex="-1"
        aria-labelledby="editPersonalInfoLabel"
        aria-hidden="true"
>
    <div class="modal-dialog">
        <div class="modal-content text-dark">
            <div class="modal-header">
                <h5 class="modal-title" id="editPersonalInfoLabel">
                    Edit Personal Info
                </h5>
                <button
                        type="button"
                        class="btn-close"
                        data-bs-dismiss="modal"
                        aria-label="Close"
                ></button>
            </div>
            <div class="modal-body">
                <form id="personalInfoForm" action="http://localhost:8080/demo_jsp_war_exploded/user/profile/infomation"
                      method="post">
                    <div class="mb-3">
                        <label for="nameInput" class="form-label">Name</label>
                        <input
                                type="text"
                                class="form-control"
                                id="nameInput"
                                name="name"
                                value="<%= user.getName() %>"
                        />
                    </div>

                    <div class="mb-3">
                        <label for="phoneInput" class="form-label">Phone</label>
                        <input
                                type="text"
                                class="form-control"
                                id="phoneInput"
                                name="phoneNumber"
                                value="<%= user.getPhoneNumber() %>"
                        />
                    </div>

                    <div class="mb-3">
                        <label for="cityInput" class="form-label">City</label>
                        <input
                                type="text"
                                class="form-control"
                                id="cityInput"
                                name="city"
                                value="<%= user.getCity() %>"
                        />
                    </div>

                    <div class="mb-3">
                        <label for="dateInput" class="form-label">Birthday</label>
                        <input
                                type="date"
                                class="form-control"
                                id="dateInput"
                                name="birthday"
                                value="<%= user.getBirthday() %>"
                        />
                    </div>

                    <div class="modal-footer">
                        <button
                                type="button"
                                class="btn btn-secondary"
                                data-bs-dismiss="modal"
                        >
                            Cancel
                        </button>
                        <button type="submit" class="btn btn-primary">
                            Save Changes
                        </button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>


<div class="avatar">
    <img
            class="rounded-circle mx-auto"
            src="<%= user.getAvatar() == null ? "https://ibiettuot.com/wp-content/uploads/2021/10/avatar-mac-dinh.png" : user.getAvatar() %>"
            alt="U"
            style="height: 300px; width: 300px;"
    />
</div>
<div class="d-flex flex-column justify-content-center">
    <h4 class="m-2 text-center my-3 font-700 text-[28px]"><%= user.getName() == null ? "Hãy thêm ten của bạn!" : user.getName() %>
    </h4>
</div>
<div class="col col-8 mx-auto bg-light text-dark p-4 rounded-2xl mb-6">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h1>Thông tin cơ bản</h1>
        <button
                class="btn btn-outline-dark"
                data-bs-toggle="modal"
                data-bs-target="#editPersonalInfo"
        >
            <i class="bi bi-pencil-square"></i>
        </button>
    </div>
    <div class="d-flex justify-content-between">
        <div class="d-flex align-items-center gap-2">
            <i class="bi bi-envelope"></i>
            <span><%= user.getEmail() %></span>
        </div>
        <div class="d-flex align-items-center gap-2">
            <i class="bi bi-phone"></i>
            <span><%= user.getPhoneNumber() == null ? "hãy thêm số điện thoại của bạn!" : user.getPhoneNumber() %></span>
        </div>
        <div class="d-flex align-items-center gap-2">
            <i class="bi bi-globe-americas"></i>
            <span><%= user.getCity() == null ? "Hãy thêm thành phố của bạn" : user.getCity() %></span>
        </div>
        <div class="d-flex align-items-center gap-2">
            <i class="bi bi-cake2"></i>
            <span><%= user.getBirthday() == null ? "hãy thêm ngày sinh của bạn!" : user.getBirthday() %></span>
        </div>
    </div>
</div>
