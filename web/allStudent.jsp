<%-- 
    Document   : allStudent
    Created on : Jul 13, 2018, 6:45:45 PM
    Author     : harmeet.singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Student Page</title>
        <link href="css/myStyle.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h4>Student Management System</h4><hr />
        <h5 style="text-align: center;color: black">List of Students</h5>
        <table style="align:center;width: 100%;border: 1px solid black;" >
           
            <tr>
                    <th>S.no</td>
                    <th>First Name</td>
                    <th>Last Name</td>
                    <th>Email</td>
                    <th>city</td>
                    <th>State</td>
                    <th>Mobile</td>
                    <th>Course</td>
                    <th>Edit Action</a></td>
                    <th>Delete Action</a></td>
                </tr>
            <c:forEach var="s" items="${sbl}">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.firstName}</td>
                    <td>${s.lastName}</td>
                    <td>${s.email}</td>
                    <td>${s.city}</td>
                    <td>${s.state}</td>
                    <td>${s.mobile}</td>
                    <td>${s.course}</td>
                    <td><a href="edit">Edit</a></td>
                    <td><a href="delete">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
