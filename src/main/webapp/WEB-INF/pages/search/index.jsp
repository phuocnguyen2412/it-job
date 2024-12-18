<%@ page import="models.bean.Recruitment" %>
<%@ page import="java.util.List" %>
<%@ page import="models.bean.CompanyAddress" %><%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 18/12/24
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<% Recruitment recruitment_detail = (Recruitment) request.getAttribute("recruitment");%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>IT Jobs Search</title>
    <%@ include file="/WEB-INF/layouts/header.jsp" %>

</head>
<body>
<!-- Navbar -->
<%@ include file="/WEB-INF/layouts/nav.jsp" %>

<!-- Main Content -->
<div class="container my-5">
    <h1 class="mb-4">822 IT Jobs For "Chất" Developers</h1>
    <form>
        <div class="row">
            <div class="col-md-2">
                <select name="city" class="form-select search-bar">
                    <option value="0" selected>All Cities</option>
                    <option value="An Giang">An Giang</option>
                    <option value="Bà Rịa - Vũng Tàu">
                        Bà Rịa - Vũng Tàu
                    </option>
                    <option value="Bắc Giang">Bắc Giang</option>
                    <option value="Bắc Kạn">Bắc Kạn</option>
                    <option value="Bạc Liêu">Bạc Liêu</option>
                    <option value="Bắc Ninh">Bắc Ninh</option>
                    <option value="Bến Tre">Bến Tre</option>
                    <option value="Bình Định">Bình Định</option>
                    <option value="Bình Dương">Bình Dương</option>
                    <option value="Bình Phước">Bình Phước</option>
                    <option value="Bình Thuận">Bình Thuận</option>
                    <option value="Cà Mau">Cà Mau</option>
                    <option value="Cần Thơ">Cần Thơ</option>
                    <option value="Cao Bằng">Cao Bằng</option>
                    <option value="Đà Nẵng">Đà Nẵng</option>
                    <option value="Đắk Lắk">Đắk Lắk</option>
                    <option value="Đắk Nông">Đắk Nông</option>
                    <option value="Điện Biên">Điện Biên</option>
                    <option value="Đồng Nai">Đồng Nai</option>
                    <option value="Đồng Tháp">Đồng Tháp</option>
                    <option value="Gia Lai">Gia Lai</option>
                    <option value="Hà Giang">Hà Giang</option>
                    <option value="Hà Nam">Hà Nam</option>
                    <option value="Hà Nội">Hà Nội</option>
                    <option value="Hà Tĩnh">Hà Tĩnh</option>
                    <option value="Hải Dương">Hải Dương</option>
                    <option value="Hải Phòng">Hải Phòng</option>
                    <option value="Hậu Giang">Hậu Giang</option>
                    <option value="Hòa Bình">Hòa Bình</option>
                    <option value="Hồ Chí Minh">Hồ Chí Minh</option>
                    <option value="Hưng Yên">Hưng Yên</option>
                    <option value="Khánh Hòa">Khánh Hòa</option>
                    <option value="Kiên Giang">Kiên Giang</option>
                    <option value="Kon Tum">Kon Tum</option>
                    <option value="Lai Châu">Lai Châu</option>
                    <option value="Lâm Đồng">Lâm Đồng</option>
                    <option value="Lạng Sơn">Lạng Sơn</option>
                    <option value="Lào Cai">Lào Cai</option>
                    <option value="Long An">Long An</option>
                    <option value="Nam Định">Nam Định</option>
                    <option value="Nghệ An">Nghệ An</option>
                    <option value="Ninh Bình">Ninh Bình</option>
                    <option value="Ninh Thuận">Ninh Thuận</option>
                    <option value="Phú Thọ">Phú Thọ</option>
                    <option value="Phú Yên">Phú Yên</option>
                    <option value="Quảng Bình">Quảng Bình</option>
                    <option value="Quảng Nam">Quảng Nam</option>
                    <option value="Quảng Ngãi">Quảng Ngãi</option>
                    <option value="Quảng Ninh">Quảng Ninh</option>
                    <option value="Quảng Trị">Quảng Trị</option>
                    <option value="Sóc Trăng">Sóc Trăng</option>
                    <option value="Sơn La">Sơn La</option>
                    <option value="Tây Ninh">Tây Ninh</option>
                    <option value="Thái Bình">Thái Bình</option>
                    <option value="Thái Nguyên">Thái Nguyên</option>
                    <option value="Thanh Hóa">Thanh Hóa</option>
                    <option value="Thừa Thiên Huế">Thừa Thiên Huế</option>
                    <option value="Tiền Giang">Tiền Giang</option>
                    <option value="Trà Vinh">Trà Vinh</option>
                    <option value="Tuyên Quang">Tuyên Quang</option>
                    <option value="Vĩnh Long">Vĩnh Long</option>
                    <option value="Vĩnh Phúc">Vĩnh Phúc</option>
                    <option value="Yên Bái">Yên Bái</option>
                </select>
            </div>
            <div class="col-md-2">
                <select name="key" class="form-select search-bar">
                    <option value="company">Công ty</option>
                    <option value="position">Vị trí</option>
                </select>
            </div>
            <div class="col-md-6">
                <input
                        name="value"
                        type="text"
                        class="form-control search-bar"
                        placeholder="Enter keyword skill (Java, iOS...), job title, company..."
                />
            </div>
            <div class="col-md-2">
                <button class="btn btn-danger w-100">Search</button>
            </div>
        </div>
    </form>


    <!-- Suggestions -->
    <div class="flex mt-4 gap-x-3">
        <span>Suggestions for you: </span>
        <div class="suggestions">
            <span>Java</span>
            <span>ReactJS</span>
            <span>.NET</span>
            <span>Tester</span>
            <span>PHP</span>
            <span>Business Analyst</span>
            <span>NodeJS</span>
            <span>Manager</span>
        </div>
    </div>
</div>

<div class="container mx-auto py-10">
    <div class="row">
        <div class="col-4 flex-col gap-5">
            <% List<Recruitment> recruitments = (List<Recruitment>) request.getAttribute("recruitments");
                if (recruitments.isEmpty()) {%>
            <div class="bg-[#fff4e9] border border-[#dedede] rounded-[8px] shadow-[0px_4px_24px_0px_#0000001f] gap-x-3 text-[#121212] leading-[24px] pt-[16px] p-3 mb-4">
                <h2 class="text-[18px] font-[700] text-[#121212] my-3">Không tìm thấy công việc nào</h2>
            </div>
            <% } %>

            <%for (Recruitment recruitment : recruitments) {%>
            <a href="http://localhost:8080/demo_jsp_war_exploded/search?city=<%=(String) request.getAttribute("city")%>&key=<%=(String) request.getAttribute("key")%>&value=<%=(String) request.getAttribute("value")%>&recruitmentId=
                    <%=recruitment.getId()%>">
                <div class=" gap-y-3 flex flex-col bg-[#fff4e9] border border-[#dedede] rounded-[8px] shadow-[0px_4px_24px_0px_#0000001f] gap-x-3 text-[#121212] leading-[24px] pt-[16px] p-3 mb-4">
                    <div class="border-b-2 border-dashed border-gray-500 pb-3">
                        <div class="text-[#a6a6a6] text-[14px]">Đăng 40 ngày trước</div>

                        <h2 class="text-[18px] font-[700] text-[#121212] my-3"><%=recruitment.getPosition()%>
                        </h2>
                        <h2 class=""><i
                                class="bi bi-currency-dollar text-green-500"></i> <%=recruitment.getSalarayRange()%>
                        </h2>
                    </div>
                    <div class="flex gap-3 border-b-2 border-dashed border-gray-500 pb-3">
                        <% for (String skill : recruitment.getSkills()) { %>
                        <div class="rounded-[20px] border border-solid border-[#dedede] px-3 py-1"><%=skill%>
                        </div>
                        <% } %>
                    </div>
                    <% for (String benefit : recruitment.getAllBenefits()) {%>
                    <div class=" text-[18px]">
                        <i class="bi bi-check2-all text-red-500"></i>
                        <%=benefit%>
                    </div>
                    <% } %>
                </div>
            </a>
            <% } %>
        </div>
        <div class="col-8">
            <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3 shadow-[0px_6px_32px_0px_#00000014]">
                <div class="border-b-2 border-dashed border-gray-500 pb-4">
                    <h1 class="text-[28px] font-bold"><%=recruitment_detail.getPosition()%>
                    </h1>
                </div>
                <a href="http://localhost:8080/demo_jsp_war_exploded/search/company?id=<%=recruitment_detail.getCompany().getId()%>">
                    <h2 class="mb-3 text-[24px] font-bold mt-3 text-blue-500"><%=recruitment_detail.getCompany().getName()%>
                    </h2>
                </a>


                <div class="mb-3 text-[#414042] text-[18px]"><%=recruitment_detail.getSalarayRange()%>
                </div>
                <form action="http://localhost:8080/demo_jsp_war_exploded/user/create-application" method="post">
                    <input type="hidden" name="recruitmentId" value="<%=recruitment_detail.getId()%>">
                    <button class="mb-3 btn w-full text-center rounded-[8px] py-[11px] px-[24px] bg-red-500">Apply now
                    </button>
                </form>

                <div class="mb-3">
                    <% for (CompanyAddress address : recruitment_detail.getAddresses()) { %>
                    <div class="text-[#414042] mb-2"><i class="bi bi-geo-alt"></i> <%=address.getAddress()%>
                    </div>
                    <% } %>
                </div>

                <div class="flex gap-3 mb-3">
                    <% for (String skill : recruitment_detail.getSkills()) { %>
                    <div class="rounded-[20px] border border-solid border-[#dedede] px-3 py-1"><%=skill%>
                    </div>
                    <% } %>
                </div>
                <span><i class="bi bi-clock"></i> <%=recruitment_detail.getCreatedAt()%></span>
            </div>
            <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3 shadow-[0px_6px_32px_0px_#00000014]">
                <div class="border-b-2 border-dashed border-gray-500 pb-4 mb-3">
                    <h1 class="text-[22px] font-bold">Job description
                    </h1>
                </div>
                <p>
                    <%=recruitment_detail.getJobDescription()%>
                </p>

            </div>
            <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3 shadow-[0px_6px_32px_0px_#00000014]">
                <div class="border-b-2 border-dashed border-gray-500 pb-4 mb-3">
                    <h1 class="text-[22px] font-bold">Benefits
                    </h1>
                </div>
                <% for (String benefit : recruitment_detail.getAllBenefits()) { %>
                <div>- <%=benefit%>
                </div>
                <% } %>
            </div>
            <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3 shadow-[0px_6px_32px_0px_#00000014]">
                <div class="border-b-2 border-dashed border-gray-500 pb-4 mb-3">
                    <h1 class="text-[22px] font-bold">Requirements
                    </h1>
                </div>
                <% for (String requirement : recruitment_detail.getRequirementList()) { %>
                <div>- <%=requirement%>
                </div>
                <% } %>
            </div>

        </div>
    </div>
</div>


<%@ include file="/WEB-INF/layouts/footer.jsp" %>
</body>
</html>
