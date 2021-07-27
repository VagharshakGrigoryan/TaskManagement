<%@ page import="com.example.TaskManagement.model.User" %>
<%@ page import="com.example.TaskManagement.model.Task" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<link href="css/addus.css" rel="stylesheet" type="text/css" />

<html>
<head>
    <title>updateuser</title>
</head>
<body>
<% String msg = (String) session.getAttribute("msg");%>
<% Task task = (Task) request.getAttribute("task");%>
<% if (msg != null && !"".equals(msg)) { %>
<span><%=msg%></span>
<%
        session.removeAttribute("msg");
    }%>
<div  style="text-align: center ">
    <h1>Addtask</h1></div>

<form action="${pageContext.request.contextPath}/updatetask" method="post" >
    <input type="hidden" name="id" value="<%=task.getId()%>" >
    <div style="text-align: center "><h1> name: <label>
        <input type="text" name="name" value="<%=task.getName()%>"/>
    </label></h1><br></div>
    <div style="text-align: center "><h1> description: <label>
        <input type="text" name="description" value="<%=task.getDescription()%>"/>
    </label></h1><br></div>
    <div style="text-align: center "><h1> user: <label>
        <input type="text" name="user" value="<%=task.getUser()%>"/>
    </label></h1><br></div>
    <div style="text-align: center "><h1> status: <label>
        <input type="text" name="status" value="<%=task.getStatus()%>"/>
    </label></h1><br></div>

    <div style="text-align: center "><h1><input type="submit" value="update task"></h1><br></div>
</form>
</body>
</html>