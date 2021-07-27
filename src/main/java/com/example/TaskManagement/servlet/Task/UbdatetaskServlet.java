package com.example.TaskManagement.servlet.Task;
import com.example.TaskManagement.manager.TaskManager;
import com.example.TaskManagement.model.Task;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updatetask")
public class UbdatetaskServlet extends HttpServlet {

    private final TaskManager taskManager = new TaskManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int taskId = Integer.parseInt(req.getParameter("id"));
        Task task = taskManager.gettaskById(taskId);
        req.setAttribute("task", task);
        req.getRequestDispatcher("/updatetask.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int taskId = Integer.parseInt(req.getParameter("id"));
        Task taskById = taskManager.gettaskById(taskId);
        if(taskById != null) {

        Task task = (Task) req.getSession().getAttribute("task");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description ");
        String user = req.getParameter("user");
        String status = req.getParameter("status");

        Task tasks = Task.builder()
                .id(id)
                .name(name)
                .description(description)
                .user(user)
                .status(status)
                .build();

        taskManager.updatetask(tasks);
        req.getSession().setAttribute("msg", "task was added");
        resp.sendRedirect("/home");
        }

    }
}