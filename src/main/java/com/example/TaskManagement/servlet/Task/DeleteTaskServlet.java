package com.example.TaskManagement.servlet.Task;
import com.example.TaskManagement.manager.TaskManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deletetask")
public class DeleteTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int taskId = Integer.parseInt(req.getParameter("id"));
        TaskManager taskManager = new TaskManager();
        taskManager.deletetask(taskId);
        req.getSession().setAttribute("msg", "task was removed");
        resp.sendRedirect("/home");
    }

}
