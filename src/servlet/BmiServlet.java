package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

public class BmiServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String weightString = request.getParameter("weight");
        String heightString = request.getParameter("height");
        if (weightString != null && heightString != null) {
            double weight = Double.parseDouble(weightString);
            double height = Double.parseDouble(heightString);
            height = height * 0.01;
            if (weight > 0 && height > 0) {
                int bmi = (int) (weight / Math.pow(height, 2.0));
                request.setAttribute("weight", weight);
                request.setAttribute("height", height);
                request.setAttribute("bmi", bmi);
                HttpSession session = request.getSession();
                session.setAttribute("hello","Hello from session attribute");
                Cookie bmiCookie = new Cookie("bmi", String.valueOf(bmi));
                bmiCookie.setMaxAge(-1);
                response.addCookie(bmiCookie);
                request.setAttribute("cookieBmiInfo", "BMI saved in cookie file:" + " " + bmiCookie.getValue() + ".");
            } else {
                request.setAttribute("error", "Wrong height or weight");
            }
        }
        RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
        rs.forward(request, response);
    }
}
