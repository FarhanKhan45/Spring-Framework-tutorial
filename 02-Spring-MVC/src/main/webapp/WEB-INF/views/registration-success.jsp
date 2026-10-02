
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Registration Successful</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #667eea, #764ba2);
            min-height: 100vh;

            display: flex;
            justify-content: center;
            align-items: center;

            padding: 20px;
        }

        .success-container {
            background: #ffffff;
            width: 100%;
            max-width: 450px;

            padding: 40px;
            border-radius: 16px;

            text-align: center;

            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
        }

        .success-icon {
            width: 75px;
            height: 75px;

            margin: 0 auto 20px;

            display: flex;
            justify-content: center;
            align-items: center;

            background: #e8f8ee;
            color: #28a745;

            border-radius: 50%;

            font-size: 40px;
            font-weight: bold;
        }

        h1 {
            color: #222222;
            margin-bottom: 12px;
            font-size: 28px;
        }

        .success-message {
            color: #666666;
            margin-bottom: 30px;
            font-size: 15px;
        }

        .user-details {
            text-align: left;

            background: #f8f9fa;

            padding: 20px;
            border-radius: 10px;

            margin-bottom: 25px;
        }

        .detail-row {
            display: flex;
            justify-content: space-between;
            gap: 15px;

            padding: 12px 0;

            border-bottom: 1px solid #e5e5e5;
        }

        .detail-row:last-child {
            border-bottom: none;
        }

        .detail-label {
            color: #555555;
            font-weight: bold;
        }

        .detail-value {
            color: #222222;
            text-align: right;
            overflow-wrap: anywhere;
        }

        .login-button {
            display: block;

            width: 100%;

            padding: 13px;

            background: #667eea;
            color: #ffffff;

            text-decoration: none;

            border-radius: 8px;

            font-size: 16px;
            font-weight: bold;

            transition: background 0.3s ease;
        }

        .login-button:hover {
            background: #5268d8;
        }

        .footer-text {
            margin-top: 20px;

            font-size: 13px;
            color: #888888;
        }
    </style>
</head>

<body>

    <div class="success-container">

        <!-- Success Icon -->
        <div class="success-icon">
            ✓
        </div>

        <!-- Heading -->
        <h1>Registration Successful!</h1>

        <p class="success-message">
            Your account has been created successfully.
        </p>

        <!-- User Details -->
        <div class="user-details">

            <div class="detail-row">
                <span class="detail-label">Name</span>
                <span class="detail-value">${user.name}</span>
            </div>

            <div class="detail-row">
                <span class="detail-label">Email</span>
                <span class="detail-value">${user.email}</span>
            </div>

            <div class="detail-row">
                <span class="detail-label">Age</span>
                <span class="detail-value">${user.age}</span>
            </div>

        </div>

        <!-- Login Button -->
        <a class="login-button"
           href="${pageContext.request.contextPath}/login">
            Go to Login
        </a>

        <p class="footer-text">
            Thank you for registering with us.
        </p>

    </div>

</body>

</html>