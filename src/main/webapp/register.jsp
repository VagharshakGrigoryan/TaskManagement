<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link href="css/addus.css" rel="stylesheet" type="text/css" />

    <title>Register</title>
</head>
<body>
<br>
<form action="${pageContext.request.contextPath}/register" method="post">
    <div style="text-align: center "><h1> name:<label>
        <input type="text" name="name">
    </label></h1><br></div>
    <div style="text-align: center "><h1> surname: <label>
        <input type="text" name="surname">
    </label></h1><br></div>
    <div style="text-align: center "><h1> email: <label>
        <input type="text" name="email">
    </label></h1><br></div>
    <div style="text-align: center "><h1> password: <label>
        <input type="password" name="password">
    </label></h1><br></div>
    <div style="text-align: center "><h1><input type="submit" value="Register"></h1><br></div>
</form>
</body>
</html>
