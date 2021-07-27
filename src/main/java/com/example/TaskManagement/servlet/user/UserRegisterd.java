package com.example.TaskManagement.servlet.user;
import com.example.TaskManagement.manager.UserManager;
import com.example.TaskManagement.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/userreg")
public class UserRegisterd extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

        UserManager userManager = new UserManager();
        userManager.addUser(user);

        req.setAttribute("Mesagge", " Yo have registered user successfully !!! ");
        req.getRequestDispatcher("addUser.jsp").forward(req,resp);
    }


}



