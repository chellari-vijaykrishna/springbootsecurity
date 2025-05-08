<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Vijay Bank - Home</title>
    <link rel="icon" type="image/x-icon" href="https://clipartcraft.com/images/v-logo-blue-3.png">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f1f1f1;
        }

        header {
            background-color: #003366;
            color: white;
            padding: 20px 0;
            text-align: center;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
        }

        header img {
            height: 50px;
            vertical-align: middle;
        }

        header h1 {
            display: inline;
            margin-left: 10px;
            font-size: 28px;
            vertical-align: middle;
        }

        .content {
            text-align: center;
            padding: 40px 20px;
        }

        .content h2 {
            color: #003366;
            margin-bottom: 30px;
        }

        .link-container {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            gap: 20px;
        }

        .link-container a {
            background-color: #007bff;
            color: white;
            padding: 15px 30px;
            text-decoration: none;
            border-radius: 6px;
            font-weight: bold;
            transition: background-color 0.3s;
        }

        .link-container a:hover {
            background-color: #0056b3;
        }

        footer {
            background-color: #003366;
            color: white;
            text-align: center;
            padding: 15px 0;
            position: fixed;
            width: 100%;
            bottom: 0;
            font-size: 14px;
        }
    </style>
</head>
<body>

    <header>
        <img src="https://clipartcraft.com/images/v-logo-blue-3.png">
        <h1>Vijay Bank of India</h1>
    </header>

    <div class="content">
        <h2>Welcome to Your Vijay Bank Online Banking</h2>
        <div class="link-container">
            <a href="balance">Check Balance</a>
            <a href="loanApprove">Approve Loan</a>
            <a href="offers">View Offers</a>
        </div>
    </div>

    <footer>
        @ 2025 Vijay Bank of India. All Rights Reserved.
    </footer>

</body>
</html>
