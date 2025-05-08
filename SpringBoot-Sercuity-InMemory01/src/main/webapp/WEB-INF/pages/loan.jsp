<%@ page isELIgnored="false" import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Loan Approval</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
            background-color: #f2f2f2;
        }

        h1 {
            color: blue;
        }

        .info {
            font-weight: bold;
            margin: 20px 0;
        }

        a {
            text-decoration: none;
            color: #007bff;
        }

        a:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>

    <h1>Loan Approval Page</h1>
    <div class="info">
        You are approved for a loan amount: 
        <%= new Random().nextInt(1000000) %>
    </div>

    <a href="./">Back to Home</a>

</body>
</html>
