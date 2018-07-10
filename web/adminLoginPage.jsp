<%-- 
    Document   : adminLoginPage
    Created on : Jul 10, 2018, 8:48:01 PM
    Author     : harmeet.singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin LoginPage</title>
        <link href="css/myStyle.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <h4>Student Management System</h4><hr />
        <h5 style="text-align: center;color: black">Login</h5>
        
        <div align="center">
            <s:form action="loginAction" method="post">
                <s:textfield name="email" type="text" label="Email"/>
                <s:textfield name="password" type="password" label="Password"/>
                <s:submit value="login"/>
            </s:form>
        </div>
    </body>
    
    
     <footer>
            <hr />
            <p align="center" style="color: green"> All Rights are reserved with Test Tech pvt ltd.</p>
        </footer>
</html>
