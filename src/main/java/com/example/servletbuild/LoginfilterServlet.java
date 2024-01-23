import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/hello-servlet")
public class LoginfilterServlet implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("user") != null);

        if (isLoggedIn) {
            chain.doFilter(request, response);

        } else {
            ((HttpServletResponse) response).sendRedirect("login.jsp");
        }
    }


    public void destroy() {

    }
}