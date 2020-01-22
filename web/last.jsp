<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informations</title>
        <link rel = "stylesheet" type = "text/css" href = "MainStyle.css"/>
        <style>
            body{
                text-align: left;
            }
        </style>
    </head>
    <body>
        <%!String proizvod = null;%>
        <%proizvod = (String) request.getAttribute("itemName");%>
        <a href='/WebProdavnica/ListajServlet'>Go back to shopping!</a><br><br>
        <p style="color: white">Thank you for your purchase. You successfully bought <b><%=proizvod%></b>. If you want to contact us send us mail in text area below. </p>
        <form action="" method="POST">
            <textarea name="message" rows="10" cols="30">Insert your text here.</textarea><br>
            <input type="submit" value="Send" name="message" />  
        </form>
    </body>
</html>
