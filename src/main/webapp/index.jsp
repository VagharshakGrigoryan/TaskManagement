<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="css/addus.css" rel="stylesheet" type="text/css" />
        <title>index</title>

<body>
<% String msg = (String) session.getAttribute("msg");%>
<% if (msg != null && !"".equals(msg)) { %>
<span><%=msg%></span>
<%
        session.removeAttribute("msg");
    }%>
<h1>
<div style="text-align: center "><h1> Welcome You  can </h1> </div>

<div style="text-align: center ">   <h1>  </h1> <br>
    <a href="${pageContext.request.contextPath}/login"> <h1> login</h1> </a> <h1> <br>or
    </h1>  <a href="register.jsp"><h1>  register</h1></a><br></div></h1>
</body>
</html>


