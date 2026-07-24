<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Poppins', sans-serif;
    }

    body {
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);
    }

    .card {
        width: 350px;
        padding: 40px;
        border-radius: 20px;
        background: rgba(255, 255, 255, 0.08);
        backdrop-filter: blur(15px);
        box-shadow: 0 8px 32px rgba(0,0,0,0.4);
        color: white;
    }

    .card h2 {
        text-align: center;
        margin-bottom: 30px;
        font-weight: 600;
    }

    .input-box {
        position: relative;
        margin-bottom: 25px;
    }

    .input-box input {
        width: 100%;
        padding: 12px 10px;
        background: transparent;
        border: none;
        border-bottom: 2px solid rgba(255,255,255,0.5);
        outline: none;
        color: white;
        font-size: 16px;
    }

    .input-box label {
        position: absolute;
        top: 50%;
        left: 10px;
        transform: translateY(-50%);
        color: rgba(255,255,255,0.7);
        font-size: 14px;
        pointer-events: none;
        transition: 0.3s;
    }

    .input-box input:focus + label,
    .input-box input:valid + label {
        top: -8px;
        font-size: 12px;
        color: #00c6ff;
    }

    .btn {
        width: 100%;
        padding: 12px;
        border: none;
        border-radius: 10px;
        background: linear-gradient(45deg, #00c6ff, #0072ff);
        color: white;
        font-size: 16px;
        cursor: pointer;
        transition: 0.3s;
    }

    .btn:hover {
        transform: scale(1.05);
        box-shadow: 0 5px 20px rgba(0,198,255,0.5);
    }

    .error {
        text-align: center;
        margin-bottom: 15px;
        color: #ff6b6b;
        font-size: 14px;
    }

</style>

</head>
<body>

<div class="card">
    <h2>Welcome Back</h2>

    <!-- Error Message -->
    <%
        String error = (String) request.getAttribute("errorMsg");
        if (error != null) {
    %>
        <div class="error"><%= error %></div>
    <%
        }
    %>

    <form action="loginForm" method="post">
        
        <div class="input-box">
            <input type="text" name="email1" required>
            <label>Email</label>
        </div>

        <div class="input-box">
            <input type="password" name="pass1" required>
            <label>Password</label>
        </div>

        <button class="btn" type="submit">Login</button>

    </form>
</div>

</body>
</html>