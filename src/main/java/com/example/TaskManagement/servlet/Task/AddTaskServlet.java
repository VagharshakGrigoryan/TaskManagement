package com.example.TaskManagement.servlet.Task;
import com.example.TaskManagement.manager.TaskManager;
import com.example.TaskManagement.model.Task;
import com.example.TaskManagement.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/addTask")

public class AddTaskServlet extends HttpServlet {

    private final TaskManager taskManager = new TaskManager();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addTask.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User users = (User) req.getSession().getAttribute("task");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String status = req.getParameter("status");


        Task task = Task.builder()
                .name(name)
                .description(description)
                .user(String.valueOf(users))
                .status(status)
                .deadline(new Date())
                .build();

        taskManager.addtask(task);
        req.getSession().setAttribute("msg", "task was added");
        resp.sendRedirect("home.jsp");
    }
}