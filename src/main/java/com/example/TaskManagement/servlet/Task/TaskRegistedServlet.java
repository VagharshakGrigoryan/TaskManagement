package com.example.TaskManagement.servlet.Task;

import com.example.TaskManagement.manager.TaskManager;
import com.example.TaskManagement.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/registertask")

public class TaskRegistedServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String user = req.getParameter("user");
        String status = req.getParameter("status");

        Task task = new Task();
        task.setName(name);
        task.setDescription(description);
        task.setUser(user);;
        task.setStatus(status);

        TaskManager taskManager = new TaskManager();
        taskManager.addtask(task);
        req.setAttribute("Mesagge", " Yo added !!! you can add task");
        req.getRequestDispatcher("addTask.jsp").forward(req,resp);
    }
}