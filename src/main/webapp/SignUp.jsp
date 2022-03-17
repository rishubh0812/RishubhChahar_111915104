<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <div align="center">
  <h1>Employee SignUp</h1>
  <form action="/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>employeeID</td>
     <td><input type="text" name="employeeID" /></td>
    </tr>
    <tr>
     <td>FirstName</td>
     <td><input type="text" name="FirstName" /></td>
    </tr>
    <tr>
     <td>LastName</td>
     <td><input type="text" name="LastName" /></td>
    </tr>
    <tr>
     <td>DOB</td>
     <td><input type="text" name="DOB" /></td>
    </tr>
    <tr>
     <td>Contact Number</td>
     <td><input type="password" name="Contact Number" /></td>
    </tr>


   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>