<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<link href="css/addus.css" rel="stylesheet" type="text/css" />
<head>
    <title>Register</title>
</head>
<body>
<br>
<form action="${pageContext.request.contextPath}/userreg" method="post">
    <div style="text-align: center "><h1> name:<label>
        <input type="text" name="name">
    </label></h1><br></div>
    <div style="text-align: center "><h1> description: <label>
        <input type="text" name="description">
    </label></h1><br></div>
    <div style="text-align: center "><h1> user: <label>
        <input type="text" name="user">
    </label></h1><br></div>
    <div style="text-align: center "><h1> status: <label>
        <input type="text" name="status">
    </label></h1><br></div>
    <div style="text-align: center "><h1> deadline: <label>
        <input type="datetime-local" name="deadline">
    </label></h1><br></div>
    <div style="text-align: center "><h1><input type="submit" value="add task"></h1><br></div>
</form>
</body>
</html>
