
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Successful</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: linear-gradient(135deg, #667eea, #764ba2);
        }

        .success-container {
            width: 420px;
            background: white;
            padding: 40px 35px;
            border-radius: 15px;
            text-align: center;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
        }

        .success-icon {
            width: 70px;
            height: 70px;
            margin: 0 auto 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            border-radius: 50%;
            background-color: #e6f8ed;
            color: #20a05a;
            font-size: 38px;
            font-weight: bold;
        }

        .success-container h1 {
            color: #20a05a;
            font-size: 26px;
            margin-bottom: 12px;
        }

        .welcome-message {
            color: #333;
            font-size: 20px;
            margin-bottom: 15px;
        }

        .user-info {
            color: #666;
            font-size: 15px;
            margin-bottom: 25px;
            line-height: 1.8;
        }

        .user-info strong {
            color: #333;
        }

        .dashboard-btn {
            display: inline-block;
            width: 100%;
            padding: 13px;
            background: linear-gradient(135deg, #667eea, #764ba2);
            color: white;
            text-decoration: none;
            border-radius: 8px;
            font-size: 15px;
            font-weight: bold;
            transition: 0.3s;
        }

        .dashboard-btn:hover {
            opacity: 0.9;
            transform: translateY(-1px);
        }

        .logout-link {
            display: inline-block;
            margin-top: 18px;
            color: #667eea;
            text-decoration: none;
            font-size: 14px;
        }

        .logout-link:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>

    <div class="success-container">

        <div class="success-icon">
            ✓
        </div>

        <h1>Login Successful!</h1>

        <h2 class="welcome-message">
            Welcome, ${user.name}!
        </h2>

        <div class="user-info">
            <p>
                You have successfully logged in.
            </p>

            <p>
                <strong>Email:</strong>
                ${user.email}
            </p>
        </div>

        <a class="dashboard-btn"
           href="${pageContext.request.contextPath}/login">
            Back to Login
        </a>

        <a class="logout-link"
           href="${pageContext.request.contextPath}/login">
            Logout
        </a>

    </div>

</body>
</html>