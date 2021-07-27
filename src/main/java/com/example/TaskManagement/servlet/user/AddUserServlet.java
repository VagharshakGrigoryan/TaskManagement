package com.example.TaskManagement.servlet.user;

import com.example.TaskManagement.manager.UserManager;
import com.example.TaskManagement.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addUser")

public class AddUserServlet extends HttpServlet {

    private final UserManager userManager= new UserManager();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User users = (User) req.getSession().getAttribute("user");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        User user = User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .build();

        userManager.addUser(user);
        req.getSession().setAttribute("mesege", "user was added");
        resp.sendRedirect("UsHome.jsp");
    }
}