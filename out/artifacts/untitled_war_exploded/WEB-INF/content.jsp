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
                <form action="index.jsp">
                    <label for="weight">Weight:</label><br>
                    <input type="number" id="weight" name="weight"><br>
                    <label for="height">Height:</label><br>
                    <input type="number" id="height" name="height">
                    <input type="submit" value="Submit">
                </form>
                <%
                    String weightString = request.getParameter("weight");
                    String heightString = request.getParameter("height");
                    if (weightString != null && heightString != null) {
                        double weight = Double.parseDouble(weightString);
                        double height = Double.parseDouble(heightString);
                        height = height * 0.01;
                        int bmi = (int) (weight / Math.pow(height, 2.0));
                        if (weight > 0 && height > 0) {
                            out.println("<p> Your weight: " + weight + "</p>");
                            out.println("<p> Your height: " + height + "</p>");
                            out.println("<p> Your BMI: " + bmi + "</p>");
                        } else {
                            out.println("<p> Wrong height or weight </p>");
                        }
                    }
                %>
            </blockquote>
        </div>
    </div>
</div>
</body>
</html>
