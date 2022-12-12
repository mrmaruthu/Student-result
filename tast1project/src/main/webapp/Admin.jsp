<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

<h1 style="text-align: center"> ADMIN VIEW</h1>
<form action="view" method="get">
<table align="center">
     <tr><td><input type="submit" name=" view" placeholder="view"></td></tr>
</table>
</form>
    <h1 style="text-align: center">STUDENT UPTADE</h1>
    <form action="admin" method="get">
    <table align="center"  >
    <tr><td><input type="text" name="regno" placeholder="Reg No"></td></tr>
    <tr><td><input type="text" name="name" placeholder="Name"></td></tr>
    <tr><td><input type="text" name="tamil" placeholder="Tamil"></td></tr>
    <tr><td><input type="text" name="english" placeholder="English"></td></tr>
    <tr><td><input type="text" name="maths" placeholder="Maths"></td></tr>
    <tr><td><input type="text" name="science" placeholder="Science"></td></tr>
    <tr><td><input type="text" name="social" placeholder="Social"></td></tr>
     <tr><td><input type="submit"  ></td></tr>
     </table>
    
      </form>
</body>
</html>