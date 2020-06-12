<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>
        .content {
            flex: 1 0 auto;
            padding: 50px 0;
        }
    </style>
</head>
<body>
<div class="content container-fluid">
    <div class="card">
        <div class="card-header">
            BMI Calculator
        </div>
        <div class="card-body">
            <blockquote class="blockquote mb-0">
                <form action="bmi" method="post">
                    <label for="weight">Weight in kg:</label><br>
                    <input type="number" id="weight" name="weight"><br>
                    <label for="height">Height in cm:</label><br>
                    <input type="number" id="height" name="height">
                    <input type="submit" value="Submit">
                </form>
                <c:out value="User weight: ${weight}"/><br>
                <c:out value="User height: ${height}"/><br>
                <c:out value="BMI: ${bmi}"/><br>
                <c:out value="BMI from cookies: ${requestScope.bmi}"/><br>
                <c:out value="Message from session: ${sessionScope.hello}"/>
            </blockquote>
        </div>
    </div>
</div>
</body>
</html>
