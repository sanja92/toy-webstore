<%@page import="entiteti.Kupci"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web store!</title>
        <style>
            body{
                background-position: center;
                background-image: url("cartoon.png");
                background-attachment: fixed;
                column-fill: balance;
                background-color: whitesmoke;
                text-align: center;
                font-weight: 300;
                height: 200%;
            }
        </style>
    </head>
    <body>
        <%!Kupci user = null;%>
        <%user = (Kupci)session.getAttribute("imeKorisnika");%>
        <h1> </h1><br>
        <h1> </h1><br>
        <h1> </h1><br>
        <h1> </h1><br>
        <h1>Welcome to Toy Store</h1><br>
        <h1> <%=user.getIme()%> </h1><br>
        <a href="ListajServlet">Click here to see all our products</a><br><br><br>
    </body>
</html>
