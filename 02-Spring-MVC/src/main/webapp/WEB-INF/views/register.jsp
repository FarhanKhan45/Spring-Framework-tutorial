
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>

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

        .container {
            width: 400px;
            background: white;
            padding: 35px;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
        }

        .container h1 {
            text-align: center;
            color: #333;
            margin-bottom: 10px;
        }

        .subtitle {
            text-align: center;
            color: #777;
            font-size: 14px;
            margin-bottom: 25px;
        }

        .form-group {
            margin-bottom: 18px;
        }

        .form-group label {
            display: block;
            color: #444;
            font-size: 14px;
            font-weight: bold;
            margin-bottom: 7px;
        }

        .form-group input {
            width: 100%;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 8px;
            font-size: 14px;
            outline: none;
            transition: 0.3s;
        }

        .form-group input:focus {
            border-color: #667eea;
            box-shadow: 0 0 5px rgba(102, 126, 234, 0.3);
        }

        .register-btn {
            width: 100%;
            padding: 13px;
            border: none;
            border-radius: 8px;
            background: linear-gradient(135deg, #667eea, #764ba2);
            color: white;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: 0.3s;
        }

        .register-btn:hover {
            opacity: 0.9;
            transform: translateY(-1px);
        }

        .login-link {
            text-align: center;
            margin-top: 20px;
            font-size: 14px;
        }

        .login-link a {
            color: #667eea;
            text-decoration: none;
            font-weight: bold;
        }

        .login-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>

    <div class="container">

        <h1>Create Account</h1>

        <p class="subtitle">
            Register to get started
        </p>

        <form action="${pageContext.request.contextPath}/register"
              method="post">

            <div class="form-group">
                <label for="name">Full Name</label>

                <input type="text"
                       id="name"
                       name="name"
                       placeholder="Enter your full name"
                       required>
            </div>

            <div class="form-group">
                <label for="email">Email Address</label>

                <input type="email"
                       id="email"
                       name="email"
                       placeholder="Enter your email"
                       required>
            </div>

            <div class="form-group">
                <label for="age">Age</label>

                <input type="number"
                       id="age"
                       name="age"
                       placeholder="Enter your age"
                       min="1"
                       required>
            </div>

            <div class="form-group">
                <label for="password">Password</label>

                <input type="password"
                       id="password"
                       name="password"
                       placeholder="Create a password"
                       required>
            </div>

            <button type="submit" class="register-btn">
                Register
            </button>

        </form>

        <div class="login-link">
            Already have an account?

            <a href="${pageContext.request.contextPath}/login">
                Login here
            </a>
        </div>

    </div>

</body>
</html>