<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <%
                    if(request.getAttribute("bmi")!=null) {
                        out.print("<p> Your weight in kg: " + request.getAttribute("weight") + "</p>");
                        out.print("<p> Your height in m: " + request.getAttribute("height") + "</p>");
                        out.print("<p> Your BMI: " + request.getAttribute("bmi") + "</p>");
                    }
                %>
            </blockquote>
        </div>
    </div>
</div>
</body>
</html>
