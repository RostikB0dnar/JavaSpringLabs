package Servlets;

import POJO.User;
import Services.UserService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.getAllUsers();
        response.setContentType("application/json");
        response.getWriter().write(new Gson().toJson(userList));
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