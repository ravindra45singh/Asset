
function test(){
alert("hi");
}

function UserAction() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", " http://localhost:9004/app/test/getCapital/india ", true);
    //xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
    var response = JSON.parse(xhttp.responseText);
    alert(response);
}