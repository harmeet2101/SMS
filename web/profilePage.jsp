<%-- 
    Document   : profilePage
    Created on : Jul 12, 2018, 3:51:16 PM
    Author     : harmeet.singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <link href="css/myStyle.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
         <h4>Student Management System</h4><hr />
         <h5 style="text-align: center;color: black">User Profile</h5>
         
         <div align="center">
            <s:form action="updateAction" method="post">
                <s:textfield name="firstName" type="text" label="First Name" 
                              value="%{#session.user.firstName}"
                             />
                <s:textfield name="lastName" type="text" label="Last Name" value="%{#session.user.lastName}"/>
                <s:textfield name="email" type="text" label="Email" value="%{#session.user.email}"/>
                <s:select
			            label="Registeration Type"
			            list="{'admin','employee'}"
			            name="registerationType" />
                <s:submit value="Update profile"/>
            </s:form>
        </div>
    </body>
</html>
