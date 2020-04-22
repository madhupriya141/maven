<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.error{
 color:#EF1313;
 
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<form:form action="register" commmandName="modelAttribute" method="post">
<tr><td>
UserName: <form:input path="user"/>
<form:errors path="user"> </form:errors></tr></td>
<tr><td>
Email: <form:input path="email"/>
<form:errors path="email"></form:errors></tr></td>
<tr><td>
Phone Number: <form:input path="phoneNo"/>
<form:errors path="phoneNo"></form:errors></tr></td>
<tr><td>
Password: <form:input path="password"/>
<form:errors path="password"></form:errors></tr></td>
</table>
<input type="submit" value="register">
</form:form>
</body>
</html>