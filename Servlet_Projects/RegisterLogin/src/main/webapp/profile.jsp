<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>

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
        width: 380px;
        padding: 40px;
        border-radius: 20px;
        background: rgba(255, 255, 255, 0.08);
        backdrop-filter: blur(15px);
        box-shadow: 0 8px 32px rgba(0,0,0,0.4);
        color: white;
        text-align: center;
    }

    .avatar {
        width: 80px;
        height: 80px;
        border-radius: 50%;
        background: linear-gradient(45deg, #00c6ff, #0072ff);
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 30px;
        font-weight: bold;
        margin: 0 auto 20px;
    }

    h2 {
        margin-bottom: 10px;
    }

    p {
        color: rgba(255,255,255,0.7);
        margin-bottom: 25px;
        font-size: 14px;
    }

    .btn {
        display: inline-block;
        padding: 10px 20px;
        border-radius: 10px;
        background: linear-gradient(45deg, #00c6ff, #0072ff);
        color: white;
        text-decoration: none;
        transition: 0.3s;
    }

    .btn:hover {
        transform: scale(1.05);
        box-shadow: 0 5px 20px rgba(0,198,255,0.5);
    }
</style>

</head>
<body>

<div class="card">

    <div class="avatar">
        ${session_name != null ? session_name.charAt(0) : "U"}
    </div>

    <h2>Welcome, ${session_name}</h2>
    <p>You are successfully logged in 🎉</p>

    <a href="login.jsp" class="btn">Logout</a>

</div>

</body>
</html>