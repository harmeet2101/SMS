<%-- 
    Document   : homePage
    Created on : Jul 11, 2018, 2:11:05 PM
    Author     : harmeet.singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="css/myStyle.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h4>Student Management System</h4><hr />
        
        <h5>Welcome, ${username}</h5>
        <div style="float: left">
        <a href="addStudent.jsp">Add Student</a> | 
        <a href="allStudents">View All Students</a>    
        </div>
        
        <div style="float: right">
        <a href="viewProfile">Profile</a> | 
        <a href="doLogout">Logout</a>    
        </div>
        
    </body>
    
    <footer>
            <hr />
            <p align="center" style="color: green"> All Rights are reserved with Test Tech pvt ltd.</p>
        </footer>
</html>
