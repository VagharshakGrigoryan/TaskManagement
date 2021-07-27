package com.example.TaskManagement.servlet.user;

import com.example.TaskManagement.manager.TaskManager;
import com.example.TaskManagement.manager.UserManager;
import com.example.TaskManagement.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/deleteuser")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("id"));
        UserManager userManager = new UserManager();
        userManager.deleteUser(userId);
        req.getSession().setAttribute("mesege", "user was removed");
        resp.sendRedirect("/UsHome");
    }

}



