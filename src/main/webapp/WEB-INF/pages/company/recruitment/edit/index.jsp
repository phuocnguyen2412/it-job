<%@ page import="models.bean.Recruitment" %>
<%@ page import="models.bean.CompanyAddress" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Recruitment recruitment = (Recruitment) request.getAttribute("recruitment"); %>
<% List<CompanyAddress> companyAddresses = (List<CompanyAddress>) request.getAttribute("companyAddresses"); %>
<div class="container">
    <form action="http://localhost:8080/demo_jsp_war_exploded/company/edit-recruitment" method="post">
        <input type="hidden" name="id" value="<%= recruitment.getId()%>"/>
        <!-- Position -->
        <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3 shadow-[0px_6px_32px_0px_#00000014]">
            <div class="border-b-2 border-dashed border-gray-500 pb-4">
                <label for="positionInput" class="font-bold">Position:</label>
                <input
                        type="text"
                        class="form-control w-full"
                        id="positionInput"
                        name="position"
                        value="<%= recruitment.getPosition()%>"
                        required
                />
            </div>

            <!-- Company Name -->
            <h2 class="mb-3 text-[24px] font-bold mt-3"><%= recruitment.getCompany().getName()%>
            </h2>
            <div class="row">
                <div class="col-6">
                    <!-- Salary Range -->
                    <label for="salaryRangeFromInput" class="font-bold mt-3">Salary Range from:</label>
                    <input
                            type="text"
                            class="form-control w-full"
                            id="salaryRangeFromInput"
                            name="salaryRangeTo"
                            value="<%= recruitment.getSalarayRange()%>"
                            required
                    />
                </div>
                <div class="col-6">
                    <!-- Salary Range -->
                    <label for="salaryRangeToInput" class="font-bold mt-3">Salary Range to:</label>
                    <input
                            type="text"
                            class="form-control w-full"
                            id="salaryRangeToInput"
                            name="salaryRangeTo"
                            value="<%= recruitment.getSalarayRange()%>"
                            required
                    />
                </div>

            </div>

        </div>


        <!-- Company Addresses -->
        <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3 shadow-[0px_6px_32px_0px_#00000014]">
            <label class="font-bold">Company Addresses:</label>
            <% for (CompanyAddress address : companyAddresses) { %>
            <div class="form-check mb-2">
                <input
                        type="checkbox"
                        class="form-check-input"
                        id="address_<%= address.getId() %>"
                        name="addresses"
                        value="<%= address.getAddress() %>"
                />
                <label class="form-check-label" for="address_<%= address.getId() %>">
                    <%= address.getAddress() %>
                </label>
            </div>
            <% } %>
        </div>

        <!-- Skills -->
        <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3 shadow-[0px_6px_32px_0px_#00000014]">
            <label for="skillsInput" class="font-bold">Skills:</label>
            <input
                    id="skillsInput"
                    type="text"
                    class="form-control w-full mb-2"
                    name="skills"
                    value="<%=String.join(",", recruitment.getSkills()) %>"
                    required
            />

        </div>

        <!-- Job Description -->
        <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3 shadow-[0px_6px_32px_0px_#00000014]">
            <label for="jobDescriptionInput" class="font-bold">Job Description:</label>
            <textarea
                    class="form-control w-full"
                    id="jobDescriptionInput"
                    name="jobDescription"
                    rows="4"
                    required
            ><%= recruitment.getJobDescription()%></textarea>
        </div>

        <!-- Benefits -->
        <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3 shadow-[0px_6px_32px_0px_#00000014]">
            <label for="benefitsInput" class="font-bold">Benefits:</label>

            <input
                    id="benefitsInput"
                    type="text"
                    class="form-control w-full mb-2"
                    name="benefits"
                    value="<%=String.join(",", recruitment.getBenefit())%>"
                    required
            />

        </div>

        <!-- Requirements -->
        <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3 shadow-[0px_6px_32px_0px_#00000014]">
            <label for="requirementsInput" class="font-bold">Requirements:</label>

            <input
                    id="requirementsInput"
                    type="text"
                    class="form-control w-full mb-2"
                    name="requirements"
                    value="<%=String.join(",", recruitment.getRequirement())%>"
                    required
            />

        </div>

        <!-- Submit Button -->
        <div class="text-right">
            <button type="submit" class="btn btn-primary">Save Changes</button>
        </div>
    </form>
</div>
