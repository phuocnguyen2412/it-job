<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Login Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e9f7e9;
        }

        .login-container {
            width: 300px;
            margin: 100px auto;
            background-color: #ccffcc;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
        }

        label {
            display: block;
            margin: 10px 0 5px;
        }

        input[type="text"],
        input[type="password"] {
            width: 80%;
            padding: 8px;
            margin: 5px 0 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .buttons {
            text-align: center;
        }

        button {
            padding: 10px 15px;
            margin: 5px;
            border: none;
            background-color: #4caf50;
            color: white;
            border-radius: 5px;
            cursor: pointer;
        }

        button[type="reset"] {
            background-color: #f44336;
        }

        button:hover {
            opacity: 0.8;
        }

        #error-message {
            color: red;
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>

<body>
<div class="login-container">
    <form id="loginForm" onsubmit="return validateForm()" action="login" method="post">
        <h2>Login</h2>
        <label for="username">Username</label>
        <input type="text" id="username" name="username" placeholder="Enter your username" required/>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Enter your password" required/>
        <div class="buttons">
            <button type="submit">OK</button>
            <button type="reset">Reset</button>
        </div>
        <p id="error-message">${errorMessage}</p>
    </form>
</div>
<script>
    const username = document.getElementById("username");
    const password = document.getElementById("password");


    function validateForm() {
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;
        const errorMessage = document.getElementById("error-message");

        if (!username || !password) {
            errorMessage.textContent = "Both fields are required!";
            return false;
        }

        if (username.length < 3) {
            errorMessage.textContent =
                "Username must be at least 3 characters long.";
            return false;
        }

        if (password.length < 6) {
            errorMessage.textContent =
                "Password must be at least 6 characters long.";
            return false;
        }
        errorMessage.textContent = "";

        return true;
    }

    window.onload = () => {
        username.focus();
    };
</script>
</body>

</html>