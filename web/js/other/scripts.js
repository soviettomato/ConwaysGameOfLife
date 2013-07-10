function getXmlHttpObject(){
    var xmlHttp;
    if(window.XMLHttpRequest){
        xmlHttp = new XMLHttpRequest();
    } else{
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xmlHttp;
}

function createTable(){
    var request = getXmlHttpObject();
    request.onreadystatechange = function(){
        if(isGoodRequest(request)){
            var txt = request.responseText;
            document.getElementById("table-div").innerHTML = txt;
        }
    }
    var rows = document.getElementById("countRows").value;
    var columns = document.getElementById("countColumns").value;
    var url = "table?rows=" + rows + "&columns=" + columns;
    request.open("GET", url, true);
    request.send();
}

function transformCell(id){
    var request = getXmlHttpObject();
    var tagCell = document.getElementById(id);
    var isLifeAttr = tagCell.getAttribute("data-islife");
    var url = "cell?id=" + id + "&islife=" + isLifeAttr;

    request.onreadystatechange = function(){
        if(isGoodRequest(request)){
            if(isLifeAttr == "true"){
                tagCell.setAttribute("data-islife", "false");
                tagCell.setAttribute("bgcolor", "#FFFFFF");
            } else {
                tagCell.setAttribute("data-islife", "true");
                tagCell.setAttribute("bgcolor", "#68DFF2");
            }
        }
    }
    request.open("GET", url, true);
    request.send();
}

function mouseOut(obj){
    var color
    color = obj.getAttribute("data-islife") == "true" ? "#68DFF2":"#FFFFFF";
    obj.setAttribute("bgcolor", color);
}

function isGoodRequest(request){
    if((request.readyState == 4) && (request.status == 200)){
        return true;
    } else {
        return false;
    }
}