<%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 8/12/24
  Time: 00:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div
        class="modal fade"
        id="editPersonalInfo"
        tabindex="-1"
        aria-labelledby="editPersonalInfoLabel"
        aria-hidden="true"
>
    <div class="modal-dialog">
        <div class="modal-content bg-dark text-white">
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
                <form id="personalInfoForm">
                    <div class="mb-3">
                        <label for="nameInput" class="form-label"
                        >Name</label
                        >
                        <input
                                type="text"
                                class="form-control"
                                id="nameInput"
                                value="Phước Nguyên"
                        />
                    </div>
                    <div class="mb-3">
                        <label for="emailInput" class="form-label"
                        >Email</label
                        >
                        <input
                                type="email"
                                class="form-control"
                                id="emailInput"
                                value="huynhphuocnguyen@gmail.com"
                        />
                    </div>
                    <div class="mb-3">
                        <label for="phoneInput" class="form-label"
                        >Phone</label
                        >
                        <input
                                type="text"
                                class="form-control"
                                id="phoneInput"
                                value="0931950231"
                        />
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button
                        type="button"
                        class="btn btn-secondary"
                        data-bs-dismiss="modal"
                >
                    Cancel
                </button>
                <button type="button" class="btn btn-primary">
                    Save Changes
                </button>
            </div>
        </div>
    </div>
</div>
<div
        class="col col-8 mx-auto bg-[#1a1a1a] p-4 rounded-2xl mb-6"
>
    <div class="flex justify-between">
        <div class="flex gap-x-6">
            <div class="avatar">
                <img
                        class="rounded-full h-20 w-20"
                        src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWdu-qOixArQruGnl8wz6iK-ygXGGGOSQytg&s"
                        alt=""
                />
            </div>
            <div
                    class="flex-col items-center justify-center gap-4"
            >
                <div class="text-[32px]">Phước Nguyên</div>
            </div>
        </div>

        <button
                class="btn btn-outline-light"
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
    <div class="flex justify-between">
        <div class="flex items-center gap-x-3 my-2">
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
            <div>huynhphuocnguyen@gmail.com</div>
        </div>

        <div class="flex items-center gap-x-3 my-2">
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
            <div>0931950231</div>
        </div>
    </div>
    <div class="flex justify-between">
        <div class="flex items-center gap-x-3">
            <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="16"
                    height="16"
                    fill="currentColor"
                    class="bi bi-geo-alt"
                    viewBox="0 0 16 16"
            >
                <path
                        d="M12.166 8.94c-.524 1.062-1.234 2.12-1.96 3.07A32 32 0 0 1 8 14.58a32 32 0 0 1-2.206-2.57c-.726-.95-1.436-2.008-1.96-3.07C3.304 7.867 3 6.862 3 6a5 5 0 0 1 10 0c0 .862-.305 1.867-.834 2.94M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10"
                />
                <path
                        d="M8 8a2 2 0 1 1 0-4 2 2 0 0 1 0 4m0 1a3 3 0 1 0 0-6 3 3 0 0 0 0 6"
                />
            </svg>
            <div>Đà nẵng</div>
        </div>
        <div class="flex items-center gap-x-3">
            <div class="flex items-center gap-x-3">
                <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="16"
                        height="16"
                        fill="currentColor"
                        class="bi bi-gift"
                        viewBox="0 0 16 16"
                >
                    <path
                            d="M3 2.5a2.5 2.5 0 0 1 5 0 2.5 2.5 0 0 1 5 0v.006c0 .07 0 .27-.038.494H15a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1v7.5a1.5 1.5 0 0 1-1.5 1.5h-11A1.5 1.5 0 0 1 1 14.5V7a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h2.038A3 3 0 0 1 3 2.506zm1.068.5H7v-.5a1.5 1.5 0 1 0-3 0c0 .085.002.274.045.43zM9 3h2.932l.023-.07c.043-.156.045-.345.045-.43a1.5 1.5 0 0 0-3 0zM1 4v2h6V4zm8 0v2h6V4zm5 3H9v8h4.5a.5.5 0 0 0 .5-.5zm-7 8V7H2v7.5a.5.5 0 0 0 .5.5z"
                    />
                </svg>
                <div>12/12/2004</div>
            </div>
        </div>
    </div>
</div>