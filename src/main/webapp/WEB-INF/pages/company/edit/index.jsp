<%@ page import="models.bean.Company" %>
<%@ page import="models.bean.CompanyAddress" %>
<%@ page import="java.util.stream.Collectors" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 17/12/24
  Time: 23:12
--%>
<% Company company = (Company) request.getAttribute("company"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="http://localhost:8080/demo_jsp_war_exploded/company/edit" method="post">
    <body class="bg-[#f7f7f7]">
    <div class="container py-[30px]">
        <div class="px-[24px] bg-[#121212] py-5">
            <div class="container flex justify-between items-center ">
                <div class="flex gap-5 items-center">
                    <img src="<%= company.getLogo() %>" alt="<%= company.getName() %>"
                         class="object-cover w-[160px] h-[160px] rounded-[4px]">
                    <div>
                        <!-- Editable Name -->
                        <input name="name"
                               class="text-[#fff] text-[28px] font-[700] mb-2 bg-transparent border-b-2 border-white outline-none"
                               value="<%= company.getName() %>"/>

                        <div class="flex gap-3 mt-3">
                            <a class="flex items-center justify-center bg-[#ed1b2f] rounded-[4px] text-white font-[Lexend] font-semibold gap-[8px] leading-[24px] py-[11px] px-[24px]">
                                View reviews
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-12">
                <!-- General Information -->
                <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3">
                    <div class="border-b-2 border-dashed border-gray-500 pb-4">
                        <h1 class="text-[22px] font-bold">General Information</h1>
                    </div>
                    <div class="grid grid-cols-2 gap-3 mt-3">
                        <div>
                            <label class="text-[#a6a6a6] text-[14px]" for="industry">Company Industry</label>
                            <input name="industry" id="industry" class="w-full border border-gray-300 p-2 rounded"
                                   value="<%= company.getIndustry() %>"/>
                        </div>
                        <div>
                            <label class="text-[#a6a6a6] text-[14px]" for="size">Company Size</label>
                            <input name="size" id="size" class="w-full border border-gray-300 p-2 rounded"
                                   value="<%= company.getSize() %>"/>
                        </div>
                        <div>
                            <label class="text-[#a6a6a6] text-[14px]" for="country">Country</label>
                            <input name="country" id="country" class="w-full border border-gray-300 p-2 rounded"
                                   value="<%= company.getCountry() != null ? company.getCountry() : "" %>"/>
                        </div>
                        <div>
                            <label class="text-[#a6a6a6] text-[14px]" for="workingDays">Working Days</label>
                            <input name="workingDays" id="workingDays" class="w-full border border-gray-300 p-2 rounded"
                                   value="<%= company.getWorkingDays() %>"/>
                        </div>
                    </div>
                </div>

                <!-- Company Overview -->
                <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3">
                    <div class="border-b-2 border-dashed border-gray-500 pb-4 mb-3">
                        <h1 class="text-[22px] font-bold">Company Overview</h1>
                    </div>
                    <textarea name="introduce" class="w-full border border-gray-300 p-2 rounded"
                              rows="4"><%= company.getIntroduce() %></textarea>
                </div>

                <!-- Skills -->
                <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3">
                    <div class="border-b-2 border-dashed border-gray-500 pb-4 mb-3">
                        <h1 class="text-[22px] font-bold">Our Key Skills</h1>
                    </div>
                    <textarea name="skills" class="w-full border border-gray-300 p-2 rounded"
                              rows="2"><%= String.join(", ", company.getSkills()) %></textarea>
                </div>

                <!-- Locations -->
                <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3">
                    <div class="border-b-2 border-dashed border-gray-500 pb-4 mb-3">
                        <h1 class="text-[22px] font-bold">Our Locations</h1>
                    </div>
                    <textarea name="locations" class="w-full border border-gray-300 p-2 rounded" rows="3">
                        <%= String.join("\n",
                                company.getAddresses()
                                        .stream()
                                        .map(CompanyAddress::getAddress)
                                        .collect(Collectors.toList())
                        ) %>
                    </textarea>
                </div>
            </div>
        </div>

        <div class="text-center mt-5">
            <button type="submit" class="bg-[#ed1b2f] text-white px-6 py-2 rounded font-semibold">Save Changes</button>
        </div>
    </div>
    </body>
</form>
