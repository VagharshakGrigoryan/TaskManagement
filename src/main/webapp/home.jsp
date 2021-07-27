<%@ page import="com.example.TaskManagement.model.Task" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<link href="css/tooplate-chilling-cafe.css" rel="stylesheet" type="text/css" />

<html>
<head>
    <title>home</title>
</head>
<body>
<% String msg = (String) session.getAttribute("msg");%>
<% if (msg != null && !"".equals(msg)) { %>
<span><%=msg%></span>
<%
        session.removeAttribute("msg");
    }%>

<% List<Task> tasks = (List<Task>) request.getAttribute("tasks");%>


<div style="text-align: center "><h1><a href="${pageContext.request.contextPath}/addTask">Add TASK</a></h1><br></div>
<h1>
<div style="text-align: center ">

    <table border="1">

        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Action</th>
        </tr>
        <% if (tasks != null && !tasks.isEmpty()) {
            for (Task task : tasks) {
        %>
        <tr>
            <td><%=task.getName()%>
            </td>
            <td><%=task.getDescription()%>
            </td>
            <td> <a href="${pageContext.request.contextPath}/updatetask?id=<%=task.getId()%>">Update</a> | <a
                    href="${pageContext.request.contextPath}/deletetask?id=<%=task.getId()%>">Delete</a></td>
        </tr>
        <% }
        }%>
    </table>

</div>
</h1>
</body>
</html>