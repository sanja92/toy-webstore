<%@page import="model.Usluge"%>
<%@page import="entiteti.Proizvodi"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html id="listaj">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            .list{
                color: white;
                text-align: left;
            }
            #myImg {
                border-radius: 5px;
                cursor: pointer;
                transition: transform .2s;
                padding: 20px;
                padding-bottom: 5px;
                margin-bottom: 5px;
            }
            #myImg:hover{
                transform: scale(2.5);
                margin: 5%;
                padding: 50px;
            }
            #div{
                border-style: solid;
                border-width: 2px;
                border-bottom-width: 1px;
                border-top-width: 1px;
                border-color: black; 
                border-collapse: initial;
            }
        </style>
        <link rel = "stylesheet" type = "text/css" href = "MainStyle.css"/>
        <title>All products list</title>
    </head>
    <body class="list">
        <%!String poruka;%>
        <%poruka = (String) request.getAttribute("txt");%>
        <%!Integer kolicina = 0;%>
        <%kolicina = (Integer) request.getAttribute("kolicina");%>
        <%!List<Proizvodi> lista = null;%>
        <%lista = (List<Proizvodi>) request.getAttribute("listajSve");%>
        <%for (Proizvodi k : lista) {%>
        <div id="div"> <img src="productImages/<%=k.getImg()%>" alt="" width="10%" id="myImg" onclick="large()"><br>
            <%=k.getNazivProizvoda()%>&nbsp;&nbsp;<b><%=k.getCena()%> $</b><br>
            Amount available: <%=k.getKolicina()%><br>
            <form action="KorpaServlet" method="POST">
                <input type="text" name="kolicina" value="1">
                <input type="hidden" name="hiddenCena" value="<%=k.getCena()%>" />
                <input type="hidden"  id="naziv" name="hiddenNaziv" value="<%=k.getNazivProizvoda()%>" />
                <input type="submit" name="submitKupi" value="Buy">
            </form>
        </div>
        <%if (poruka != null) {%><p style="color: red"><%=poruka%></p><%}%>
        <%}%> 
        <script>
            /* Tried to open a new window after clicking every image, but only firt picture is opening on 
             *click on every image... Having problem with it. Still learning javaScript.
             * */
            function large(){
            var largeImage = document.getElementById('myImg');
            largeImage.style.display = 'block';
            largeImage.style.width = 200 + "px";
            largeImage.style.height = 200 + "px";
            var url = largeImage.getAttribute('src');
            window.open(url, "", "width=largeImage.style.width, height=largeImage.style.height");
        }
        </script>
    </body>
</html>
