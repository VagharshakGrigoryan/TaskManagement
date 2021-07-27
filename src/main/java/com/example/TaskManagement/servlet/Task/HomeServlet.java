package com.example.TaskManagement.servlet.Task;
import com.example.TaskManagement.manager.TaskManager;
import com.example.TaskManagement.model.Task;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    private final TaskManager taskManager = new TaskManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Task> tasks = taskManager.gettalltasks();
        req.setAttribute("tasks", tasks);
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }
}
