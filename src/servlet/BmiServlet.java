package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BmiServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String weightString = request.getParameter("weight");
        String heightString = request.getParameter("height");
        if (weightString != null && heightString != null) {
            double weight = Double.parseDouble(weightString);
            double height = Double.parseDouble(heightString);
            height = height * 0.01;
            int bmi = (int) (weight / Math.pow(height, 2.0));
            if (weight > 0 && height > 0) {
                request.setAttribute("weight", weight);
                request.setAttribute("height", height);
                request.setAttribute("bmi", bmi);
            } else {
                request.setAttribute("error", "Wrong height or weight");
            }
        }
        RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
        rs.forward(request, response);
    }
}
