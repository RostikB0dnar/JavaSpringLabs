package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/*")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        String pathInfo = request.getPathInfo(); // /someUsername
        if (pathInfo != null && pathInfo.length() > 1) {
            username = pathInfo.substring(1);
            session.setAttribute("username", username);
        }

        if (username == null) {
            username = "DefaultUser";
            session.setAttribute("username", username);
        }
        else
            username = "Rostyslav";

        Cookie userCookie = new Cookie("username", username);
        userCookie.setMaxAge(60 * 60); // 1 година
        response.addCookie(userCookie);

        out.println("<h1>Welcome, " + username + "!</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        Cookie userCookie = new Cookie("username", username);
        userCookie.setMaxAge(60 * 60);
        response.addCookie(userCookie);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println("{\"message\": \"User saved in session\", \"username\": \"" + username + "\"}");
    }
}