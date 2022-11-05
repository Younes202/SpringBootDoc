<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form method="post" action="">
        <p>
            <label for="lastname">Lastname : </label>
            <input type="text" name="lastname" id="lastname" />
        </p>
        <p>
            <label for="name">Name : </label>
            <input type="text" name="name" id="name" />
        </p>
		<button type="submit">Ok</button>        
    </form>
    
    <ul>
        <c:forEach var="user" items="${ users }">
            <li><c:out value="${ user.name}" /> <c:out value="${ user.lastname }" /></li>
        </c:forEach>
    </ul>  </body>
</html>