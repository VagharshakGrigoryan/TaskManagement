package com.example.TaskManagement.servlet.user;
import com.example.TaskManagement.manager.UserManager;
import com.example.TaskManagement.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateUser")
public class UserUbdeitServlet extends HttpServlet {

    private final UserManager userManager = new UserManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("id"));
        User user = userManager.getUserById(userId);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/updateUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("id"));
        User userById = userManager.getUserById(userId);
        if(userById != null) {

            User user= (User) req.getSession().getAttribute("user");
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String surname = req.getParameter("surname ");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            User users = User.builder()
                    .id(id)
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .password(password)
                    .build();

            userManager.updateUser(users);
            req.getSession().setAttribute("msg", "users was added");
            resp.sendRedirect("/UsHome");
        }

    }
}
