<%@ page import="models.bean.Company" %>
<%@ page import="java.util.List" %>
<%@ page import="models.bean.Recruitment" %><%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 13/12/24
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Company company = (Company) request.getAttribute("company"); %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title><%=company.getName()%>
    </title>
    <%@ include file="/WEB-INF/layouts/header.jsp" %>
    <style>
        .star-rating {
            display: flex;

            font-size: 2rem;
            justify-content: center;
        }

        .star-rating input {
            display: none;
        }

        .star {
            cursor: pointer;
            color: #ccc;
            transition: color 0.2s;
        }

        .star:hover,
        .star:hover ~ .star {
            color: #f5b301;
        }

        .star-rating input:checked ~ .star {
            color: #f5b301;
        }
    </style>
</head>
<body>
<%@ include file="/WEB-INF/layouts/nav.jsp" %>
<body class="bg-[#f7f7f7]">
<div class="bg-[#121212] py-5">
    <div class="container flex justify-between items-center ">
        <div class="flex gap-5 items-center">
            <img src="<%= company.getLogo() %>" alt="<%= company.getName() %>"
                 class=" object-cover w-[160px] h-[160px] rounded-[4px]">
            <div>
                <h1 class="text-[#fff] text-[28px] font-[700] mb-2"><%= company.getName() %>
                </h1>
             
                <div class="flex gap-3">
                    <a class="flex items-center justify-center bg-[#ed1b2f]  rounded-[4px] text-white font-[Lexend] font-semibold gap-[8px] leading-[24px] py-[11px] px-[24px]">
                        View reviews
                    </a>
                    <a class="flex items-center justify-center bg-[#fff]  rounded-[4px] text-[#ed1b2f] font-[Lexend] font-semibold gap-[8px] leading-[24px] py-[11px] px-[24px]">
                        Follow
                    </a>
                </div>

            </div>

        </div>

    </div>
</div>

<div class="container py-[30px]">
    <div class="row">

        <div class="col-8">
            <%--    Introduction--%>
            <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3">
                <div class="border-b-2 border-dashed border-gray-500 pb-4">
                    <h1 class="text-[22px] font-bold">General information
                    </h1>
                </div>

                <div class="grid grid-cols-2 gap-3 mt-3">
                    <div>
                        <div class="text-[#a6a6a6] text-[14px]">
                            Company industry
                        </div>
                        <div>
                            <%= company.getIndustry() %>
                        </div>
                    </div>
                    <div>
                        <div class="text-[#a6a6a6] text-[14px]">
                            Company size
                        </div>
                        <div>
                            <%= company.getSize() %>
                        </div>
                    </div>
                    <div>
                        <div class="text-[#a6a6a6] text-[14px]">
                            Country
                        </div>
                        <div>
                            <%= company.getCountry() %>
                        </div>
                    </div>
                    <div>
                        <div class="text-[#a6a6a6] text-[14px]">
                            Working days
                        </div>
                        <div>
                            <%= company.getWorkingDays() %>
                        </div>
                    </div>
                </div>
            </div>
            <%--    Overview--%>
            <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3">
                <div class="border-b-2 border-dashed border-gray-500 pb-4 mb-3">
                    <h1 class="text-[22px] font-bold">Company overview
                    </h1>
                </div>
                <p>
                    <%= company.getIntroduce()%>
                </p>

            </div>
            <%--        SKILLS--%>
            <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3">
                <div class="border-b-2 border-dashed border-gray-500 pb-4 mb-3">
                    <h1 class="text-[22px] font-bold">Our key skills
                    </h1>
                </div>
                <div class="flex gap-3">
                    <% for (String skill : company.getSkills()) { %>
                    <div class="rounded-[20px] border border-solid border-[#dedede] px-3 py-1"><%=skill%>
                    </div>
                    <% } %>
                </div>

            </div>
            <%--    Location--%>
            <div class="bg-[#fff] px-[24px] py-[32px] rounded-[8px] text-[#121212] mb-3">
                <div class="border-b-2 border-dashed border-gray-500 pb-4 mb-3">
                    <h1 class="text-[22px] font-bold">Our locations
                    </h1>
                </div>
                <div class="flex">
                    <!-- Sidebar -->
                    <div class="w-1/4 p-4 bg-white rounded-md shadow-md mr-4">

                        <div class="mt-3">
                            <div class="flex items-center space-x-2">
                                <div class="w-3 h-3 bg-red-500 rounded-full"></div>
                                <span class="text-lg font-bold text-[#121212]">Ho Chi Minh</span>
                            </div>
                            <p class="text-sm text-gray-600 mt-1">Dong Nhan Building, Nguyen Dinh Chieu, Da Kao,
                                District 1,
                                Ho
                                Chi Minh</p>
                        </div>
                        <div class="mt-3">
                            <div class="flex items-center space-x-2">
                                <div class="w-3 h-3 bg-green-500 rounded-full"></div>
                                <span class="text-lg font-bold text-[#121212]">Ha Noi</span>
                            </div>
                            <p class="text-sm text-gray-600 mt-1">Center Point, Trung Kinh, Yen Hoa, Hanoi</p>
                        </div>
                        <div class="mt-3">
                            <div class="flex items-center space-x-2">
                                <div class="w-3 h-3 bg-blue-500 rounded-full"></div>
                                <span class="text-lg font-bold text-[#121212]">Da Nang</span>
                            </div>
                            <p class="text-sm text-gray-600 mt-1">Vinh Trung Plaza, 255 - 257, Hưng Vương, Thanh Khe, Da
                                Nang</p>
                        </div>
                    </div>

                    <!-- Map -->
                    <div class="w-3/4 bg-gray-200 p-2 rounded-md shadow-md">

                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d9443.042745712964!2d108.16884419879474!3d16.069523149325427!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3142191e2023af1f%3A0xcc9f24852645b6f6!2zU-G7kSAyNjAgTMO9IFRow6FpIFTDtG5n!5e0!3m2!1svi!2s!4v1734445958418!5m2!1svi!2s"
                                class="w-full h-full" style="border:0;" allowfullscreen="" loading="lazy"
                                referrerpolicy="no-referrer-when-downgrade"></iframe>

                    </div>
                </div>


            </div>
        </div>
        <div class="col-4 flex-col gap-5">
            <h1 class="font-[700] text-[22px] py-3">3 việc làm đang tuyển dụng</h1>
            <% List<Recruitment> recruitments = (List<Recruitment>) request.getAttribute("recruitments");
                for (Recruitment recruitment : recruitments) {%>
            <div class=" gap-y-3 flex flex-col bg-[#fff4e9] border border-[#dedede] rounded-[8px] shadow-[0px_4px_24px_0px_#0000001f] gap-x-3 text-[#121212] leading-[24px] pt-[16px] p-3 mb-4">
                <div class="border-b-2 border-dashed border-gray-500 pb-3">
                    <div class="text-[#a6a6a6] text-[14px]">Đăng 40 ngày trước</div>

                    <h2 class="text-[18px] font-[700] text-[#121212] my-3"><%= recruitment.getPosition()%>
                    </h2>
                    <h2 class=""><i
                            class="bi bi-currency-dollar text-green-500"></i> <%= recruitment.getSalarayRange()%>
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
            <% } %>
        </div>
    </div>


</div>
<script>
    const stars = document.querySelectorAll('.star-rating input');
    const ratingValue = document.getElementById('ratingValue');

    stars.forEach(star => {
        star.addEventListener('change', () => {
            const rating = star.value;
            ratingValue.textContent = `You rated: ${rating} star${rating > 1 ? 's' : ''}`;
        });
    });
</script>
</body>
<%@ include file="/WEB-INF/layouts/footer.jsp" %>
</body>
</html>
