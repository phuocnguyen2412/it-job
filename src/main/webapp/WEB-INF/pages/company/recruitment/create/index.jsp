<%@ page import="models.bean.CompanyAddress" %>
<%@ page import="java.util.List" %>
<h2 class="text-center mb-4">Recruitment Form</h2>
<form action="http://localhost:8080/demo_jsp_war_exploded/company/create-recruitment" method="post">
    <div class="flex flex-col gap-3">
        <!-- Position -->
        <div class="form-floating">
            <input type="text" class="form-control" id="position" name="position" placeholder="Position" required>
            <label for="position">Position</label>
        </div>

        <!-- Salary Range From and Salary Range To on the same row -->
        <div class="row">
            <div class="col-md-6">
                <div class="form-floating">
                    <input type="number" class="form-control" id="rangeOfSalaryFrom" name="rangeOfSalaryFrom"
                           placeholder="Range of Salary From" required>
                    <label for="rangeOfSalaryFrom">Range of Salary From (USD)</label>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-floating">
                    <input type="number" class="form-control" id="rangeOfSalaryTo" name="rangeOfSalaryTo"
                           placeholder="Range of Salary To" required>
                    <label for="rangeOfSalaryTo">Range of Salary To (USD)</label>
                </div>
            </div>
        </div>

        <div class="form-floating">
            <input type="text" class="form-control" id="skills" name="skills" placeholder="Position" required>
            <label for="skills">Skills</label>
        </div>

        <!-- Requirement -->
        <div class="form-floating">
        <textarea class="form-control" id="requirement" name="requirement" placeholder="Requirement" rows="4"
                  required></textarea>
            <label for="requirement">Requirement</label>
        </div>

        <!-- Benefit -->
        <div class="form-floating">
        <textarea class="form-control textarea-large h-[150px]" id="benefit" name="benefit" placeholder="Benefit"
                  required style="height: 150px"></textarea>
            <label for="benefit">Benefit</label>
        </div>

        <!-- Job Description -->
        <div class="form-floating">
        <textarea class="form-control textarea-large h-[150px]" id="jobDescription" name="jobDescription"
                  placeholder="Job Description" required style="height: 150px"></textarea>
            <label for="jobDescription">Job Description</label>
        </div>

        <div class="form-group">
            <label for="addresses" class="form-label">Select Addresses</label>

            <div>
                <%
                    for (CompanyAddress addr : (List<CompanyAddress>) request.getAttribute("addresses")) {
                %>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="selectedAddresses" value="<%= addr.getId() %>"
                           id="address_<%= addr.getId() %>">
                    <label class="form-check-label" for="address_<%= addr.getId() %>">
                        <%= addr.getAddress() + " - " + addr.getDetail() %>
                    </label>
                </div>
                <% } %>
            </div>
        </div>
        <!-- Submit Button -->
        <div class="d-grid gap-2">
            <button type="submit" class="btn btn-primary btn-lg">Submit</button>
        </div>
    </div>

</form>