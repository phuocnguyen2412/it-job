<%@ page import="models.bean.Company" %>
<%@ page import="java.util.List" %>
<%@ page import="models.bean.CompanyAddress" %><%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 7/12/24
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
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
    <h1 class="text-2xl font-bold text-center mb-8">Top Companies</h1>

    <div class="grid grid-cols-1 md:grid-cols-3 gap-6">
        <% List<Company> companies = (List<Company>) request.getAttribute("companies");
            for (Company company : companies) { %>
        <div class="bg-white rounded-lg shadow-lg p-6">
            <div class="flex justify-center">
                <img
                        src="<%= company.getLogo() %>"
                        alt="FPT Software Logo"
                        class="w-20 h-20 mb-4"
                />
            </div>
            <h2 class="text-center font-semibold text-lg">
                <%= company.getName() %>
            </h2>
            <div class="flex flex-wrap justify-center gap-2 mt-4">
                <% for (String skill : company.getSkills()) { %>
                <span class="bg-gray-200 text-sm px-3 py-1 rounded"><%= skill%></span>
                <% } %>
            </div>
            <p class="text-center text-gray-500 text-sm mt-4">
                <% for (CompanyAddress address : company.getAddresses()) { %>
                <%= address.getAddress() %>
                <% } %>
            </p>
            <div class="flex justify-between items-center mt-4">
                <span class="text-green-500 font-semibold">5 Jobs</span>
                <a href="http://localhost:8080/demo_jsp_war_exploded/company/detail?id=<%= company.getId()%>"
                   class="text-blue-500 hover:underline"
                >See more &gt;</a
                >
            </div>
        </div>

        <% } %>
    </div>
</div>


<%@ include file="/WEB-INF/layouts/footer.jsp" %>
</body>
</html>
