<%@ page isELIgnored="false" import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Balance</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f0f8ff;
            margin-top: 50px;
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

    <h1>Show Balance Page</h1>
    <div class="info">
        Balance: Rs. <%= new Random().nextInt(100000) %>
    </div>

     <a href="./">Back to Home</a>

</body>
</html>
