package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        TodayDate date = new TodayDate();
        request.setAttribute("dayOfMonth", date.getDayOfMonth());
        request.setAttribute("dayOfWeek", date.getDayOfWeek());
        request.setAttribute("month", date.getMonth());
        request.setAttribute("year", date.getYear());
        RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
        rs.forward(request,response);
    }
}
