<%-- 
    Document   : addStudent
    Created on : Jul 13, 2018, 5:53:45 PM
    Author     : harmeet.singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student Page</title>
        <link href="css/myStyle.css" rel="stylesheet" type="text/css" />
    </head>
   
    <body>
         <h4>Student Management System</h4><hr />
          <h5 style="text-align: center;color: black">Add Student</h5>
           <div align="center">
            <s:form action="addStudent" method="post">
                <s:actionerror/>
                <s:textfield name="firstName" type="text" label="First Name"/>
                <s:textfield name="lastName" type="text" label="Last Name"/>
                <s:textfield name="email" type="text" label="Email"/>
                <s:textfield name="city" type="text" label="City"/>
                <s:textfield name="state" type="text" label="State"/>
                <s:textfield name="mobile" type="text" label="Mobile"/>
                <s:textfield name="course" type="text" label="Course"/>
                <s:submit value="Add"/>
            </s:form>
        </div>
          
    </body>
</html>
