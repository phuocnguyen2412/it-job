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
                                name="city"
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
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWdu-qOixArQruGnl8wz6iK-ygXGGGOSQytg&s"
            alt="User Avatar"
            style="height: 300px; width: 300px;"
    />
</div>
<div class="d-flex flex-column justify-content-center">
    <h4 class="m-2 text-center my-3 font-700 text-[28px]"><%= user.getName() %>
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
    <div class="d-flex justify-content-between">
        <div class="d-flex align-items-center gap-2">
            <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="16"
                    height="16"
                    fill="currentColor"
                    class="bi bi-envelope"
                    viewBox="0 0 16 16"
            >
                <path
                        d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1zm13 2.383-4.708 2.825L15 11.105zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741M1 11.105l4.708-2.897L1 5.383z"
                />
            </svg>
            <span><%= user.getEmail() %></span>
        </div>
        <div class="d-flex align-items-center gap-2">
            <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="16"
                    height="16"
                    fill="currentColor"
                    class="bi bi-phone"
                    viewBox="0 0 16 16"
            >
                <path
                        d="M11 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1zM5 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2z"
                />
                <path d="M8 14a1 1 0 1 0 0-2 1 1 0 0 0 0 2"/>
            </svg>
            <span><%= user.getPhoneNumber() %></span>
        </div>
        <div class="d-flex align-items-center gap-2">
            <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="16"
                    height="16"
                    fill="currentColor"
                    class="bi bi-envelope"
                    viewBox="0 0 16 16"
            >
                <path
                        d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1zm13 2.383-4.708 2.825L15 11.105zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741M1 11.105l4.708-2.897L1 5.383z"
                />
            </svg>
            <span><%= user.getCity() %></span>
        </div>
        <div class="d-flex align-items-center gap-2">
            <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="16"
                    height="16"
                    fill="currentColor"
                    class="bi bi-phone"
                    viewBox="0 0 16 16"
            >
                <path
                        d="M11 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1zM5 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2z"
                />
                <path d="M8 14a1 1 0 1 0 0-2 1 1 0 0 0 0 2"/>
            </svg>
            <span><%= user.getBirthday() %></span>
        </div>
    </div>
</div>
