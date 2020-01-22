function bottom() {
    var toInsert = document.createElement("div");
    toInsert.innerHTML = "Author: Sanja Sukara<br>  e-mail: galicsanja@live.com";
    toInsert.style.position = "absolute";
    toInsert.style.bottom = "0px";
    toInsert.style.textAlign = "center";
    toInsert.style.width = "100%";
    document.body.appendChild(toInsert);
}



