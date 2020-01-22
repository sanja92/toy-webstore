<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert</title>
        <link rel = "stylesheet" type = "text/css" href = "MainStyle.css"/>
    </head>
    <body onload="bottom()">
        <%!String txt;%>
        <%txt = (String) request.getAttribute("txt");%>
        <%if (txt != null) {%>
        <p style="color: red"><%=txt%></p>
        <%}%>
        <form action="RegisterServlet" method="POST">
            <table class="place">
                <tr>
                    <td>Insert name: </td>
                    <td><input type="text" name="ime"/><br></td>
                </tr>
                <tr>
                    <td>Insert e-mail: </td>
                    <td><input type="text" name="e-mail"/><br></td>
                </tr>
                <tr>
                    <td>Insert password:</td>
                    <td><input type="password" name="lozinka1"/></br></td>
                </tr>
                <tr>
                    <td>Repeat password:</td>
                    <td><input type="password" name="lozinka2"/></br></td>
                </tr>
                <tr>
                    <td>Insert address:</td>
                    <td><input type="text" name="adresa"/></br></td>
                </tr>
                <br>
                <tr><td><input type="submit" name="submit" value="Register" /></td></tr>
            </table>
        </form>
        <a href="login.jsp">Login!</a>
        <script src="script.js"></script>
    </body>
</html>
