
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>New Ninja</title>
</head>
<body>
<h1>New Ninja</h1>
<form:form method="POST" action="/ninjas/new" modelAttribute="ninja">

	<p><form:label path="dojo">Dojo
    <form:errors path="dojo"/>
    <form:select path="dojo">
    	<c:forEach items= "${dojos}" var ="dojo">
    		<option value="${dojo.id}">${dojo.name}</option>
    	</c:forEach> 
    </form:select>
    </form:label></p>
    
    <p><form:label path="firstName">First Name
    <form:errors path="firstName"/>
    <form:input path="firstName"/></form:label></p>
    
    <p><form:label path="lastName">Last Name
    <form:errors path="lastName"/>
    <form:input path="lastName"/></form:label></p>
    
    <p><form:label path="age">Age
    <form:errors path="age"/>
    <form:input path="age"/></form:label></p>
        
    <input type="submit" value="Create Ninja"/>
</form:form>
</body>
</html>