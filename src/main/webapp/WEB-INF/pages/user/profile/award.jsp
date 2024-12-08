<%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 8/12/24
  Time: 01:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div
        class="modal fade"
        id="editAward"
        tabindex="-1"
        aria-labelledby="editAwardLabel"
        aria-hidden="true"
>
    <div class="modal-dialog">
        <div class="modal-content bg-dark text-white">
            <div class="modal-header">
                <h5 class="modal-title" id="editAwardLabel">
                    Edit Award
                </h5>
                <button
                        type="button"
                        class="btn-close"
                        data-bs-dismiss="modal"
                        aria-label="Close"
                ></button>
            </div>
            <div class="modal-body">
                <form id="awardForm">
                    <div class="mb-3">
                        <label
                                for="awardName"
                                class="form-label"
                        >Award Name</label
                        >
                        <input
                                type="text"
                                class="form-control"
                                id="awardName"
                                value="Dut Hackathon"
                        />
                    </div>
                    <div class="mb-3">
                        <label
                                for="awardDescription"
                                class="form-label"
                        >Description</label
                        >
                        <textarea
                                class="form-control"
                                id="awardDescription"
                        >
Chi tiết giải thưởng...</textarea
                        >
                    </div>
                    <div class="mb-3">
                        <label
                                for="awardDate"
                                class="form-label"
                        >Date</label
                        >
                        <input
                                type="date"
                                class="form-control"
                                id="awardDate"
                                value="2012-02-02"
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
    <div class="card border-none">
        <div
                class="card-header bg-[#1a1a1a] flex justify-between"
        >
            <h3>Giải thưởng</h3>
            <i class="bi bi-clipboard2-plus"></i>
        </div>
        <div class="card-body bg-[#1a1a1a]">
            <div>
                <div
                        class="flex justify-between items-center mb-2"
                >
                    <h4>Dut hackaton</h4>
                    <div class="flex gap-x-4">
                        <i class="bi bi-pencil"></i>
                        <i class="bi bi-trash"></i>
                    </div>
                </div>
                <span class="mb-2">Tổ chức từ thiện</span>
                <p class="mb-2">
                    CHi tiết giải thương Lorem ipsum dolor, sit
                    amet consectetur adipisicing elit.
                    Reprehenderit, debitis sequi modi quo
                    cupiditate necessitatibus corrupti molestiae
                    aperiam magni dolorum? Maxime doloribus
                    molestiae vel nesciunt! Omnis ex est laborum
                    optio!
                </p>
                <span class="mb-2"> 02/2012 </span>
            </div>
        </div>
    </div>
</div>
