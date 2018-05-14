<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>New Dojo</title>
</head>
<body>
<h1>New Dojo</h1>
<form:form method="POST" action="/dojos/new" modelAttribute="dojo">
    <p><form:label path="name">Dojo Name
    <form:errors path="name"/>
    <form:input path="name"/></form:label></p>
        
    <p><input type="submit" value="Create Dojo"/></p>
</form:form>
</body>
</html>