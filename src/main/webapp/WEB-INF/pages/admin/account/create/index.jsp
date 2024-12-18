<%--
  Created by IntelliJ IDEA.
  User: nguyenhuynh
  Date: 19/12/24
  Time: 02:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2 class="text-center my-4 font-700 text-[30px]">Company Registration Form</h2>
<form action="http://localhost:8080/demo_jsp_war_exploded/admin/create-account" method="post">
    <!-- Email Field -->
    <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" class="form-control" name="email" id="email" placeholder="Enter your email" required>
    </div>

    <!-- Password Field -->
    <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" name="password" id="password" placeholder="Enter your password" required>
    </div>

    <!-- Company Name Field -->
    <div class="mb-3">
        <label for="companyName" class="form-label">Company Name</label>
        <input type="text" class="form-control" name="companyName" id="companyName" placeholder="Enter your company name" required>
    </div>

    <!-- Company Logo Field -->
    <div class="mb-3">
        <label for="companyLogo" class="form-label">Company Logo</label>
        <input type="file" class="form-control" name="companyLogo" id="companyLogo" accept="image/*" required>
    </div>

    <!-- Submit Button -->
    <button type="submit" class="btn btn-primary">Submit</button>
</form>