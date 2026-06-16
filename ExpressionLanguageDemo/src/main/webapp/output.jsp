<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Dashboard | Welcome</title>

<style>
    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;800&display=swap');

    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Poppins', sans-serif;
    }

    :root {
        --snake-color: #ff0044; 
        --snake-glow: rgba(255, 0, 68, 0.6);
        --accent-blue: #00c6ff;
        --accent-dark: #0072ff;
    }

    /* Unified, deep background to make elements pop */
    body {
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        background: radial-gradient(circle at center, #1a1a2e, #050505);
        overflow: hidden;
        color: white;
    }

    /* --- THE SNAKE (ORB) --- */
    #snake {
        position: fixed;
        width: 60px;
        height: 60px;
        background: radial-gradient(circle at 30% 30%, #ff6688, var(--snake-color));
        border-radius: 50%;
        pointer-events: none;
        z-index: 9999;
        box-shadow: 
            0 0 15px var(--snake-glow),
            0 0 30px var(--snake-glow),
            0 0 60px var(--snake-glow);
        transform: translate(-50%, -50%); /* Centers the element perfectly */
        animation: snake-pulse 1.5s infinite alternate ease-in-out;
        
        display: flex;
        justify-content: center;
        align-items: center;
        gap: 8px; 
    }

    /* The Eyes */
    .eye {
        width: 10px;
        height: 10px;
        background: white;
        border-radius: 50%;
        position: relative;
        box-shadow: inset 0 0 3px rgba(0,0,0,0.8);
    }
    .eye::after {
        content: '';
        position: absolute;
        width: 4px;
        height: 4px;
        background: black;
        border-radius: 50%;
        top: 3px;
        right: 2px; 
    }

    /* --- THE ENVIRONMENT --- */
    .circle {
        position: absolute;
        border-radius: 50%;
        background: rgba(255, 0, 68, 0.03); 
        border: 1px solid rgba(255, 0, 68, 0.1);
        animation: float 6s infinite ease-in-out;
        z-index: 0; 
    }
    .circle:nth-child(1) { width: 250px; height: 250px; top: 5%; left: 10%; }
    .circle:nth-child(2) { width: 350px; height: 350px; bottom: -5%; right: 5%; animation-delay: 2s; }

    @keyframes float {
        0%, 100% { transform: translateY(0); }
        50% { transform: translateY(-30px); }
    }
    @keyframes snake-pulse {
        0% { transform: translate(-50%, -50%) scale(0.95); filter: brightness(1); }
        100% { transform: translate(-50%, -50%) scale(1.05); filter: brightness(1.3); }
    }
    @keyframes card-entrance {
        0% { opacity: 0; transform: translateY(30px); }
        100% { opacity: 1; transform: translateY(0); }
    }

    /* --- THE CARD --- */
    .card {
        background: rgba(25, 25, 35, 0.4);
        padding: 50px 40px;
        border-radius: 20px;
        backdrop-filter: blur(20px);
        -webkit-backdrop-filter: blur(20px);
        border: 1px solid rgba(255, 255, 255, 0.08); /* True glassmorphism */
        box-shadow: 0 25px 50px rgba(0,0,0,0.5);
        text-align: center;
        width: 380px;
        transition: transform 0.4s ease;
        z-index: 10;
        animation: card-entrance 0.8s cubic-bezier(0.2, 0.8, 0.2, 1) forwards;
    }
    .card:hover {
        transform: translateY(-10px);
    }

    .avatar {
        width: 80px;
        height: 80px;
        border-radius: 50%;
        background: linear-gradient(135deg, var(--accent-blue), var(--accent-dark));
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 28px;
        color: white;
        margin: 0 auto 20px;
        font-weight: 800;
        box-shadow: 0 10px 20px rgba(0, 198, 255, 0.3);
    }

    h2 { font-weight: 600; font-size: 20px; color: #aaa; }

    .name {
        font-size: 32px;
        font-weight: 800;
        margin-top: 5px;
        background: linear-gradient(to right, #fff, #aaa);
        -webkit-background-clip: text;
        color: transparent;
        letter-spacing: 1px;
    }

    .type {
        color: var(--accent-blue);
        font-size: 15px;
        margin-top: 15px;
        height: 22px;
        font-weight: 600;
    }

    .copy {
        margin-top: 15px;
        font-size: 13px;
        color: #777;
        cursor: pointer;
        transition: color 0.3s;
    }
    .copy:hover { color: #fff; }

    .btn {
        margin-top: 30px;
        display: inline-block;
        padding: 12px 30px;
        border-radius: 8px;
        background: linear-gradient(135deg, var(--accent-blue), var(--accent-dark));
        color: white;
        text-decoration: none;
        font-weight: 600;
        transition: all 0.3s ease;
        border: none;
    }
    .btn:hover {
        transform: scale(1.05);
        box-shadow: 0 10px 25px rgba(0, 198, 255, 0.4);
    }
</style>
</head>
<body>

<div class="circle"></div>
<div class="circle"></div>

<div id="snake">
    <div class="eye"></div>
    <div class="eye"></div>
</div>

<div class="card">
    <div class="avatar">
        ${param.name1 != null && param.name1.length() > 0 ? param.name1.substring(0,1).toUpperCase() : "U"}
    </div>

    <h2 id="greet">Welcome</h2>

    <div class="name" id="username">
        ${param.name1 != null ? param.name1 : "Guest"}
    </div>

    <div class="type" id="type"></div>

    <div class="copy" onclick="copyName()">Click to copy name 📋</div>

    <a href="index.jsp" class="btn">Execute Next</a>
</div>

<script>
    // --- Logic & Data ---
    function getGreeting() {
        const h = new Date().getHours();
        if (h < 12) return "Good Morning ☀️";
        if (h < 18) return "Good Afternoon 🌤️";
        return "Good Evening 🌙";
    }

    function typeText() {
        const text = "System access granted...";
        let i = 0;
        const target = document.getElementById("type");
        
        function type() {
            if (i < text.length) {
                target.innerHTML += text.charAt(i);
                i++;
                setTimeout(type, 50);
            }
        }
        type();
    }

    function copyName() {
        const name = document.getElementById("username").innerText.trim();
        navigator.clipboard.writeText(name);
        
        const copyBtn = document.querySelector('.copy');
        const originalText = copyBtn.innerText;
        copyBtn.innerText = "Copied! ✔";
        copyBtn.style.color = "#00c6ff";
        
        setTimeout(() => {
            copyBtn.innerText = originalText;
            copyBtn.style.color = "#777";
        }, 2000);
    }

    // --- High Performance Orb Tracking ---
    const snake = document.getElementById("snake");
    let mouseX = window.innerWidth / 2;
    let mouseY = window.innerHeight / 2;
    let snakeX = mouseX;
    let snakeY = mouseY;

    document.addEventListener("mousemove", (e) => {
        mouseX = e.clientX;
        mouseY = e.clientY;
    });

    function animateSnake() {
        // Lerping for smooth follow effect
        snakeX += (mouseX - snakeX) * 0.12; 
        snakeY += (mouseY - snakeY) * 0.12;

        // CSS transform handles the centering, so we just pass exact coordinates
        snake.style.left = snakeX + "px";
        snake.style.top = snakeY + "px";

        requestAnimationFrame(animateSnake);
    }

    // Initialize
    window.onload = function() {
        document.getElementById("greet").innerText = getGreeting();
        typeText();
        
        snake.style.left = snakeX + "px";
        snake.style.top = snakeY + "px";
        
        animateSnake();
    };
</script>

</body>
</html>