<%@ page import="models.bean.Company" %><%--
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
    <title>Sign Up!</title>
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
                <p class="text-[#fff] text-[14px] mb-4"><i class="bi bi-geo-alt"></i> Ho chi minh</p>
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
        <div class="flex justify-center align-center">
            <div>
                4.1
            </div>
            <div class="">
                <div class="star-rating">
                    <input type="radio" id="star1" name="rating" value="1">
                    <label for="star1" class="star">&#9733;</label>
                    <input type="radio" id="star2" name="rating" value="2">
                    <label for="star2" class="star">&#9733;</label>
                    <input type="radio" id="star3" name="rating" value="3">
                    <label for="star3" class="star">&#9733;</label>
                    <input type="radio" id="star4" name="rating" value="4">
                    <label for="star4" class="star">&#9733;</label>
                    <input type="radio" id="star5" name="rating" value="5">
                    <label for="star5" class="star">&#9733;</label>
                </div>
                <p>131 reviews</p>
            </div>

        </div>
    </div>
</div>

<div class="container py-[30px]">
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
                    <p class="text-sm text-gray-600 mt-1">Dong Nhan Building, Nguyen Dinh Chieu, Da Kao, District 1, Ho
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
            <div class="w-3/4 bg-gray-200 p-4 rounded-md shadow-md">
                <div class="h-[400px] bg-cover bg-center rounded-md"
                     style="background-image: url('https://maps.googleapis.com/maps/api/staticmap?center=Ho+Chi+Minh&zoom=14&size=400x400&markers=color:red%7Clabel:S%7C10.762622,106.660172');"></div>

            </div>
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