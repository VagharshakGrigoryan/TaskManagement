<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<link href="css/addus.css" rel="stylesheet" type="text/css" />
<html>
<head>
  <title>adtask</title>
</head>
<body>
<% String msg = (String) session.getAttribute("msg");%>
<% if (msg != null && !"".equals(msg)) { %>
<span><%=msg%></span>
<%
    session.removeAttribute("msg");
  }%>
<div  style="text-align: center ">
  <h1>AddTask</h1></div>

  <form action="${pageContext.request.contextPath}/addTask" method="post" align="right">
    <div style="text-align: right "><h1> name:<label>
      <input type="text" name="name">
    </label></h1><br></div>
    <div style="text-align: right "><h1> description: <label>
      <input type="text" name="description">
    </label></h1><br></div>
    <div style="text-align: right "><h1> user: <label>
      <input type="text" name="user">
    </label></h1><br></div>
    <div style="text-align: right "><h1> status: <label>
      <input type="text" name="status">
    </label></h1><br></div>
    <div style="text-align:right "><h1> deadline: <label>
      <input type="datetime-local" name="deadline">
    </label></h1><br></div>
    <div style="text-align: -webkit-right "><h1><input type="submit" value="add task"></h1><br></div>
  </form>
<div style="text-align: left ">
</div >

</body>
</html>