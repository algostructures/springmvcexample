<%--
  Created by IntelliJ IDEA.
  User: prajapas
  Date: 7/31/2017
  Time: 11:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>firstname : ${ref.firstName}</p>
<p>lastname : ${ref.lastName}</p>
<p>email : ${ref.email}</p>
<p>id : ${ref.id}</p>
<input type="button"  onclick="location.href='/blah/addNew/confirm'" value="Confirm" >
<input type="button"  onclick="location.href='/blah/addNew'" value="Edit">
</body>
</html>
