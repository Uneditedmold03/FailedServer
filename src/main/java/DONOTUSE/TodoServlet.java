package DONOTUSE;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

@WebServlet(name = "todoservlet", value = "/todo-servlet")
public class TodoServlet extends HttpServlet {

    private List<String> todos = new ArrayList<>();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String title = request.getParameter("title");
        String text = request.getParameter("text");
        String deadline = request.getParameter("deadline");

        todos.add("Title: " + title + ", Text: " + text + ", Deadline: " + deadline);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Todo List:</h1>");
        out.println("<h1>New Todo Created! </h1>");


        for(String todo : todos) {
            out.println("<p>" + todo + "</p>");
        }

        out.println("</body></html>");
    }


}