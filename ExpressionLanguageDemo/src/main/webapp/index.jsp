<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>System Authentication</title>

<style>
    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;800&display=swap');

    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Poppins', sans-serif;
    }

    :root {
        --accent-blue: #00c6ff;
        --accent-dark: #0072ff;
        --text-light: #ffffff;
        --text-muted: #aaa;
    }

    /* Cohesive deep background matching your output page */
    body {
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        background: radial-gradient(circle at center, #1a1a2e, #050505);
        overflow: hidden;
        color: var(--text-light);
    }

    /* --- THE ENVIRONMENT --- */
    .circle {
        position: absolute;
        border-radius: 50%;
        background: rgba(0, 198, 255, 0.03); /* Cyan tint instead of red for the entry */
        border: 1px solid rgba(0, 198, 255, 0.1);
        animation: float 6s infinite ease-in-out;
        z-index: 0; 
    }
    .circle:nth-child(1) { width: 300px; height: 300px; top: -5%; left: -5%; }
    .circle:nth-child(2) { width: 400px; height: 400px; bottom: -10%; right: -5%; animation-delay: 2s; }

    @keyframes float {
        0%, 100% { transform: translateY(0); }
        50% { transform: translateY(-30px); }
    }
    
    @keyframes card-entrance {
        0% { opacity: 0; transform: scale(0.9); }
        100% { opacity: 1; transform: scale(1); }
    }

    /* --- THE LOGIN CARD --- */
    .card {
        background: rgba(25, 25, 35, 0.4);
        padding: 50px 40px;
        border-radius: 20px;
        backdrop-filter: blur(20px);
        -webkit-backdrop-filter: blur(20px);
        border: 1px solid rgba(255, 255, 255, 0.08);
        box-shadow: 0 25px 50px rgba(0,0,0,0.5);
        text-align: center;
        width: 360px;
        z-index: 10;
        animation: card-entrance 0.6s cubic-bezier(0.2, 0.8, 0.2, 1) forwards;
    }

    .icon-container {
        width: 70px;
        height: 70px;
        border-radius: 50%;
        background: rgba(0, 198, 255, 0.1);
        display: flex;
        align-items: center;
        justify-content: center;
        margin: 0 auto 20px;
        border: 2px solid var(--accent-blue);
        box-shadow: 0 0 20px rgba(0, 198, 255, 0.2);
    }

    /* A simple CSS-drawn lock icon */
    .lock {
        width: 20px;
        height: 16px;
        border: 2px solid var(--accent-blue);
        border-radius: 4px;
        position: relative;
        margin-top: 10px;
    }
    .lock::before {
        content: "";
        position: absolute;
        width: 10px;
        height: 12px;
        border: 2px solid var(--accent-blue);
        border-bottom: none;
        border-radius: 6px 6px 0 0;
        top: -12px;
        left: 3px;
    }

    h2 {
        font-weight: 800;
        font-size: 24px;
        letter-spacing: 1px;
        margin-bottom: 5px;
    }

    p {
        color: var(--text-muted);
        font-size: 14px;
        margin-bottom: 30px;
    }

    /* --- THE FORM --- */
    form {
        display: flex;
        flex-direction: column;
        gap: 20px;
    }

    .input-group {
        position: relative;
    }

    input[type="text"] {
        width: 100%;
        padding: 15px 20px;
        background: rgba(0, 0, 0, 0.2);
        border: 1px solid rgba(255, 255, 255, 0.1);
        border-radius: 10px;
        color: white;
        font-size: 16px;
        outline: none;
        transition: all 0.3s ease;
    }

    input[type="text"]::placeholder {
        color: rgba(255, 255, 255, 0.3);
    }

    input[type="text"]:focus {
        border-color: var(--accent-blue);
        box-shadow: 0 0 15px rgba(0, 198, 255, 0.3);
        background: rgba(0, 0, 0, 0.4);
    }

    input[type="submit"] {
        padding: 15px;
        border-radius: 10px;
        background: linear-gradient(135deg, var(--accent-blue), var(--accent-dark));
        color: white;
        font-size: 16px;
        font-weight: 600;
        border: none;
        cursor: pointer;
        transition: all 0.3s ease;
        text-transform: uppercase;
        letter-spacing: 1px;
    }

    input[type="submit"]:hover {
        transform: translateY(-3px);
        box-shadow: 0 10px 25px rgba(0, 198, 255, 0.4);
    }
    
    input[type="submit"]:active {
        transform: translateY(1px);
    }
</style>
</head>
<body>

<div class="circle"></div>
<div class="circle"></div>

<div class="card">
    <div class="icon-container">
        <div class="lock"></div>
    </div>
    
    <h2>Identify Yourself</h2>
    <p>Initialize protocol to access dashboard.</p>

    <form action="output.jsp" method="get">
        <div class="input-group">
            <input type="text" name="name1" placeholder="Enter Designation / Name" required autocomplete="off" />
        </div>
        <input type="submit" value="Initialize Protocol" />
    </form>
</div>

</body>
</html>