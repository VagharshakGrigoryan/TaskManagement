<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<link href="css/addus.css" rel="stylesheet" type="text/css" />
<html>
<head>
    <title>aduser</title>
</head>
<body>
<% String mesege = (String) session.getAttribute("mesege");%>
<% if (mesege != null && !"".equals(mesege)) { %>
<span><%=mesege%></span>
<%
        session.removeAttribute("mesege");
    }%>
<div  style="text-align: center ">
    <h1>AddUser</h1></div>

<div style="text-align: left ">
    <form action="${pageContext.request.contextPath}/addUser" method="post" >
        <div style="text-align: left "><h1> name:<label>
            <input type="text" name="name">
        </label></h1><br></div>
        <div style="text-align: left
 "><h1> surname: <label>
            <input type="text" name="surname">
        </label></h1><br></div>
        <div style="text-align: left
 "><h1> email: <label>
            <input type="text" name="email">
        </label></h1><br></div>
        <div style="text-align: left "><h1> password: <label>
            <input type="password" name="password">
        </label></h1><br></div>
        <div style="text-align: center"><h1><input type="submit" value="Register"></h1><br></div>
    </form>
</div >
</body>
</html>