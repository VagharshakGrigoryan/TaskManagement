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
<% String mesege = (String) session.getAttribute("mesege");%>
<% User user = (User) request.getAttribute("user");%>
<% if (mesege != null && !"".equals(mesege)) { %>
<span><%=mesege%></span>
<%
        session.removeAttribute("mesege");
    }%>
<div  style="text-align: center ">
    <h1>AddUser</h1></div>

<form action="${pageContext.request.contextPath}/updateUser" method="post" >
    <input type="hidden" name="id" value="<%=user.getId()%>" >
    <div style="text-align: center "><h1> name: <label>
        <input type="text" name="name" value="<%=user.getName()%>"/>
    </label></h1><br></div>
    <div style="text-align: center "><h1> surname: <label>
        <input type="text" name="surname" value="<%=user.getSurname()%>"/>
    </label></h1><br></div>
    <div style="text-align: center "><h1> email: <label>
        <input type="text" name="user" value="<%=user.getEmail()%>"/>
    </label></h1><br></div>
    <div style="text-align: center "><h1> password: <label>
        <input type="password" name="password" value="<%=user.getPassword()%>"/>
    </label></h1><br></div>

    <div style="text-align: center "><h1><input type="submit" value="update user"></h1><br></div>
</form>
</body>
</html>