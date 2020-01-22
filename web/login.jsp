<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel = "stylesheet" type = "text/css" href = "MainStyle.css"/>
    </head>
    <body onload="bottom()">
        <%!String poruka;%>
        <%poruka =(String)request.getAttribute("txt");%>
        <%if(poruka!=null){%>
        <p style="color: red"><%=poruka%></p>
        <%}%>
        <form action="LoginServlet" method="POST">
            <table class="place">
        <tr>
            <td><b>E-mail:</b></td>
            <td><input type="text" name="ime"></td>
        </tr>
        <tr>
            <td><b>Password:</b></td>
            <td><input type="password" name="lozinka"></td>
        </tr>
        <tr>
            <td></td> 
            <td><input type="Submit" value="Login" name="submit" /></td>
    </tr>
    <tr><td><a href="register.jsp">Register!</a></td></tr>
     </table>       
   </form> 
        <script src="script.js"></script>
    </body>
</html>