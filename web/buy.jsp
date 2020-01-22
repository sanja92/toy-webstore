<%@page import="model.Usluge"%>
<%@page import="entiteti.Kupci"%>
<%@page import="entiteti.Proizvodi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form</title>
        <link rel = "stylesheet" type = "text/css" href = "MainStyle.css"/>
        <style>
            body{
                text-align: left;
            }
        </style>
    </head>
    <body onload="bottom()">
        <%!String poruka;%>
        <%poruka = (String) request.getAttribute("txt");%>
        <a href='/WebProdavnica/ListajServlet'>Go back to shopping!</a><br><br>
        <%!Kupci k = null;%>
        <%k = (Kupci) session.getAttribute("imeKorisnika");%>
        <%if (poruka != null) {%><p style="color: red"><%=poruka%></p><%}%>
        <p>Insert shipment informations here:</p>
        <form action="MessageServlet" method="POST" name="form">
            <table>
                <tr><td>Name: </td><td><input type="text" name="user" value="" required /></td></tr>
                <tr><td>Address: </td><td><input type="text" name="address" value="" required/></td></tr>
                <tr><td>City:</td><td><input type="text" name="city" value="" required/></td></tr>
                <tr><td>Phone number: </td><td><input type="number" name="phone" value="" required/></td></tr>
                <tr><td colspan="2"><input type="submit" id="submit" name="buy" value="Buy"/></td></tr>
            </table>
        </form>
        <p><b>Payment is made on takeover.</b></p>
        <div>
            <img src="smartie.png" alt="" width="200" />
        </div>
        <script type="text/javascript" src="script.js">
        </script>
    </body>
</html>
