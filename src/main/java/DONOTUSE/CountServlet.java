package DONOTUSE;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "countservlet", value = "/count-servlet")
public class CountServlet extends HttpServlet {
    private int count = 0;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        synchronized(this) {
            Integer count = (Integer) getServletContext().getAttribute("count");
            if (count == null) {
                count = 0;
            }
            getServletContext().setAttribute("count", count + 1);
        }

        out.println("<html><body>");
        out.println("<h1>This page has been visited " + count + " times.</h1>");
        out.println("</body></html>");
    }
}
