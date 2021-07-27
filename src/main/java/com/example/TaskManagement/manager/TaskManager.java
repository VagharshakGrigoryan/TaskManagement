package com.example.TaskManagement.manager;

import com.example.TaskManagement.db.DBConnectionProvider;
import com.example.TaskManagement.model.Task;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final Connection connection = DBConnectionProvider.getProvider().getConnection();
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public void addtask(Task task) {
        try {

            String query = "INSERT INTO `task` (`name`,`description`,`user`,`status`,`deadline`) " +
                    "VALUES(?,?,?,?,?);";
            PreparedStatement pStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pStatement.setString(1, task.getName());
            pStatement.setString(2, task.getDescription());
            pStatement.setString(3, task.getUser());
            pStatement.setString(4, task.getStatus());
            pStatement.setString(5, sdf.format(task.getDeadline()));
            System.out.println(query);
            pStatement.executeUpdate();
            ResultSet generatedKeys = pStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                task.setId(id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updatetask(Task task) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("UPDATE task SET name = " +
                            "'%s', description = '%s', " + "status ='%s' WHERE id=" + task.getId(),task.getName(),
                    task.getDescription(), task.getUser(), task.getStatus());
            System.out.println(query);
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Task> gettalltasks() {

        String sql = "SELECT * from task";
        List<Task> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Task task = Task.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .user(resultSet.getString(4))
                        .status(resultSet.getString(5))
                        .deadline(resultSet.getDate(6))
                        .build();
                result.add(task);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public Task gettaskById(int id) {
        String sql = "SELECT * FROM task WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return Task.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .user(resultSet.getString(4))
                        .status(resultSet.getString(5))
                        .deadline(resultSet.getDate(6))
                        .build();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void deletetask(int id) {
        String sql = "DELETE from task where id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
