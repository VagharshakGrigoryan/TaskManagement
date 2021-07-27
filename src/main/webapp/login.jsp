<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>


<head>
    <link href="css/addus.css" rel="stylesheet" type="text/css" />

    <title>Login</title>
</head>
<body>
<br>
<div  style="text-align: center "><h1>
    <strong> <%if (request.getAttribute("Mesagge")!=null){ %>
    </strong></h1>
    </div>
<br>
<div  style="text-align: center "><h1>
    <strong> <%=request.getAttribute("Mesagge")%>

    </strong></h1>
    </div>
<% } %>
<div style="text-align: center ">
<form action="${pageContext.request.contextPath}/login" method="post">
    <div style="text-align: center "><h3> email:<label>
        <input type="text" name="email">
    </label></h3><br></div>
    <div style="text-align: center "><h3> password: <label>
        <input type="text" name="password">
    </label></h3><br></div>
    <div style="text-align: center "><h1><input type="submit" value="Login"></h1><br></div>
</form>
</div>
</body>
</html>