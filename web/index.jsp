<%-- 
    Document   : index
    Created on : Jul 10, 2018, 8:32:39 PM
    Author     : harmeet.singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start Page</title>
        <link href="css/myStyle.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <%
            session = request.getSession(false);
            if(session==null || session.getAttribute("username")!=null){
                request.getRequestDispatcher("homePage.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("welcomePage.jsp").forward(request, response);
            }
        %>
    </body>
</html>
