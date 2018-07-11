<%-- 
    Document   : registerPage
    Created on : Jul 11, 2018, 2:12:50 PM
    Author     : harmeet.singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link href="css/myStyle.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <h4>Student Management System</h4><hr />
        <h5 style="text-align: center;color: black">Register</h5>
        
        <div align="center">
            <s:form action="registerAction" method="post">
                <s:textfield name="firstName" type="text" label="First Name"/>
                <s:textfield name="lastName" type="text" label="Last Name"/>
                <s:textfield name="email" type="text" label="Email"/>
                <s:textfield name="password" type="password" label="Password"/>
                <s:select
			            label="Registeration Type"
			            list="{'admin','employee'}"
			            name="registerationType"/>
                <s:submit value="Register"/>
            </s:form>
        </div>
    </body>
    
     <footer>
            <hr />
            <p align="center" style="color: green"> All Rights are reserved with Test Tech pvt ltd.</p>
        </footer>
</html>
