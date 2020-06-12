package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class BmiServletMVC extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String weightString = request.getParameter("weight");
        String heightString = request.getParameter("height");
        if (weightString != null && heightString != null) {
            UserData userData = new UserData();
            userData.setWeight(Double.parseDouble(weightString));
            userData.setHeight(Double.parseDouble(heightString));
            userData.setHeight(userData.getHeight() * 0.01);
            if (userData.getHeight() > 0 && userData.getWeight() > 0) {
                userData.setBmi ((int) (userData.getWeight() / Math.pow(userData.getHeight(), 2.0)));
                request.setAttribute("weight", userData.getWeight());
                request.setAttribute("height", userData.getHeight());
                request.setAttribute("bmi", userData.getBmi());
                HttpSession session = request.getSession();
                session.setAttribute("hello","Hello from session attribute");
                Cookie bmiCookie = new Cookie("bmi", String.valueOf(userData.getBmi()));
                bmiCookie.setMaxAge(-1);
                response.addCookie(bmiCookie);
                response.addHeader("headerKey", "headerValue");
                request.setAttribute("cookieBmiInfo", "BMI saved in cookie file:" + " " + bmiCookie.getValue() + ".");
            } else {
                request.setAttribute("error", "Wrong height or weight");
            }
        }
        RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
        rs.forward(request, response);
    }
}
