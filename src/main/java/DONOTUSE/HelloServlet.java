package DONOTUSE;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;



@WebServlet(name = "helloservlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        String[] greetings = {"You look awesome today ", "What a fantastic day with you ", "Keep shining ", "You're doing great ", "Stay positive "};
        String greeting = greetings[new Random().nextInt(greetings.length)];

        out.println("<h1>" + greeting + name + "!</h1>");


        synchronized(this) {
            Integer count = (Integer) getServletContext().getAttribute("count");
            if (count == null) {
                count = 0;
            }
            getServletContext().setAttribute("count", count + 1);
        }

        out.println("<html><body>");
        out.println("<h1>This page has been visited " + getServletContext().getAttribute("count") + " times.</h1>");
        out.println("</body></html>");

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedDateTime = now.format(formatter);

        out.println("<html><body>");
        out.println("<h1>Current Date and Time: " + formattedDateTime + "</h1>");
        out.println("</body></html>");

        Integer count = (Integer) getServletContext().getAttribute("count");
        if (count == null) {
            count = 0;
        }
        out.println("<h1>This page has been visited " + count + " times.</h1>");
        out.println("<html><body>");

        out.println("<form action='./todo-servlet' method='POST'>");
        out.println("<label for='title'>Title:</label><br>");
        out.println("<input type='text' id='title' name='title'><br>");
        out.println("<label for='text'>Text:</label><br>");
        out.println("<textarea id='text' name='text'></textarea><br>");
        out.println("<label for='deadline'>Deadline:</label><br>");
        out.println("<input type='date' id='deadline' name='deadline'><br>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");

        out.println("</body></html>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

    }

}