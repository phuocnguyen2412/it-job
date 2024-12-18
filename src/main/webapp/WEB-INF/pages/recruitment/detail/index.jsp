<%@ page import="models.bean.Recruitment" %>
<%@ page import="models.bean.CompanyAddress" %><%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 18/12/24
  Time: 02:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Recruitment recruitment = (Recruitment) request.getAttribute("recruitment"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title><%=recruitment.getPosition() %>
    </title>
    <%@ include file="/WEB-INF/layouts/header.jsp" %>

</head>
<body>
<!-- Navbar -->
<%@ include file="/WEB-INF/layouts/nav.jsp" %>

<!-- Main Content -->
<div class="container my-5">
    <div class="row">
        <div class="col-8">
            <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3 shadow-[0px_6px_32px_0px_#00000014]">
                <div class="border-b-2 border-dashed border-gray-500 pb-4">
                    <h1 class="text-[28px] font-bold"><%= recruitment.getPosition()%>
                    </h1>
                </div>
                <h2 class="mb-3 text-[24px] font-bold mt-3"><%= recruitment.getCompany().getName()%>
                </h2>

                <div class="mb-3 text-[#414042] text-[18px]"><%= recruitment.getSalarayRange()%>
                </div>
                <button class="mb-3 btn w-full text-center rounded-[8px] py-[11px] px-[24px] bg-red-500">Apply now
                </button>
                <div class="mb-3">
                    <% for (CompanyAddress address : recruitment.getAddresses()) { %>
                    <div class="text-[#414042] mb-2"><i class="bi bi-geo-alt"></i> <%= address.getAddress()%>
                    </div>
                    <% } %>
                </div>

                <div class="flex gap-3 mb-3">
                    <% for (String skill : recruitment.getSkills()) { %>
                    <div class="rounded-[20px] border border-solid border-[#dedede] px-3 py-1"><%=skill%>
                    </div>
                    <% } %>
                </div>
                <span><i class="bi bi-clock"></i> <%= recruitment.getTimeAgo()%></span>
            </div>
            <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3 shadow-[0px_6px_32px_0px_#00000014]">
                <div class="border-b-2 border-dashed border-gray-500 pb-4 mb-3">
                    <h1 class="text-[22px] font-bold">Job description
                    </h1>
                </div>
                <p>
                    <%= recruitment.getJobDescription()%>
                </p>

            </div>
            <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3 shadow-[0px_6px_32px_0px_#00000014]">
                <div class="border-b-2 border-dashed border-gray-500 pb-4 mb-3">
                    <h1 class="text-[22px] font-bold">Benefits
                    </h1>
                </div>
                <% for (String benefit : recruitment.getAllBenefits()) { %>
                <div>- <%= benefit%>
                </div>
                <% } %>
            </div>
            <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3 shadow-[0px_6px_32px_0px_#00000014]">
                <div class="border-b-2 border-dashed border-gray-500 pb-4 mb-3">
                    <h1 class="text-[22px] font-bold">Requirements
                    </h1>
                </div>
                <% for (String requirement : recruitment.getRequirementList()) { %>
                <div>- <%= requirement%>
                </div>
                <% } %>
            </div>

        </div>
        <div class="col-4">
            <div class="bg-[#fff] rounded-[8px] p-6 shadow-[0px_6px_32px_0px_#00000014] ">
                <div class="flex gap-3">
                    <img src="<%= recruitment.getCompany().getLogo() %>" alt="<%= recruitment.getCompany().getName() %>"
                         class=" object-cover w-[160px] h-[160px] rounded-[4px]">
                    <div class="pt-4">
                        <h2 class="text-[24px] font-bold"><%= recruitment.getCompany().getName()%>
                        </h2>
                        <a href="http://localhost:8080/demo_jsp_war_exploded/company/detail?id=<%= recruitment.getCompany().getId()%>">View
                            detail</a>
                    </div>
                </div>
                <div class="border-b border-dashed border-gray-500 pb-2 mb-3 flex justify-between">
                    <div class="text-[#a6a6a6]">
                        Company industry
                    </div>
                    <div>
                        <%= recruitment.getCompany().getIndustry()%>
                    </div>
                </div>
                <div class="border-b border-dashed border-gray-500 pb-2 mb-3 flex justify-between">
                    <div class="text-[#a6a6a6]">
                        Size
                    </div>
                    <div>
                        <%= recruitment.getCompany().getSize()%>
                    </div>
                </div>
                <div class="border-b border-dashed border-gray-500 pb-2 mb-3 flex justify-between">
                    <div class="text-[#a6a6a6]">
                        Country
                    </div>
                    <div>
                        <%= recruitment.getCompany().getCountry()%>
                    </div>
                </div>
                <div class="border-b border-dashed border-gray-500 pb-2 mb-3 flex justify-between">
                    <div class="text-[#a6a6a6]">
                        Working days
                    </div>
                    <div>
                        <%= recruitment.getCompany().getWorkingDays()%>
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>


<%@ include file="/WEB-INF/layouts/footer.jsp" %>
</body>
</html>

