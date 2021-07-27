<%@ page import="com.example.TaskManagement.model.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.TaskManagement.model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<link href="css/tooplate-chilling-cafe.css" rel="stylesheet" type="text/css" />

<html>
<head>
    <title>Us</title>
</head>
<body>
<% String mesege = (String) session.getAttribute("msg");%>
<% if (mesege != null && !"".equals(mesege)) { %>
<span><%=mesege%></span>
<%
        session.removeAttribute("mesege");
    }%>

<% List<User> users = (List<User>) request.getAttribute("user");%>


<div style="text-align: center "><h1><a href="${pageContext.request.contextPath}/addUser">Add User</a></h1><br></div>
<h1>
    <div style="text-align: center ">

        <table border="1">

            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Action</th>
            </tr>
            <% if (users != null && !users.isEmpty()) {
                for (User user : users) {
            %>
            <tr>
                <td><%=user.getName()%>
                </td>
                <td><%=user.getSurname()%>
                </td>
                <td> <a href="${pageContext.request.contextPath}/updateUser?id=<%=user.getId()%>">Update</a> | <a
                        href="${pageContext.request.contextPath}/deleteuser?id=<%=user.getId()%>">Delete</a></td>
            </tr>
            <% }
            }%>
        </table>

    </div>
</h1>
</body>
</html>