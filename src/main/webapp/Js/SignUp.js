function sendDataOwner() {
    var http = new XMLHttpRequest()
    var name = document.getElementById("usrnm").value
    var email = document.getElementById("Email").value
    var address = document.getElementById("Adress").value
    var neighborhood = document.getElementById("neighborhood").value
    var username = document.getElementById("username").value
    var passsword = document.getElementById("pwrd").value
    var confirmPassword = document.getElementById("confirm").value


    if(passsword != confirmPassword){
        alert("You do have mistakes in inputs:" +
            "\n-password and confirm password, this inputs should same !!!!")
    }else{

        var url = 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/owners/' + username + '/' + name + "/" + email + '/' + address +'/'+neighborhood+'/'+passsword

        http.open("POST", url, true)
        http.onreadystatechange = function () {

            if (http.readyState == 4 && http.status == 201) {
                alert("Owner created successfully")
            } else if (http.readyState == 4 && http.status == 406) {
                alert("you should check all input for this form: \n" +
                    "    -This inputs don´t shoudl null")
            } else if (http.readyState == 4 && http.status != 201 && http.status != 406) {
                alert(http.responseText)
            }else if(http.readyState == 4 && http.status != 404){
                alert("Not found html ")
            }
        }
        http.send()

    }
}

function sendDataOficial() {


    var name = document.getElementById("name").value
    var userName = document.getElementById("userName").value
    var email = document.getElementById("email").value
    var password = document.getElementById("pwrd").value
    var checkpassw = document.getElementById("chechpwrd").value
    var role = "oficial"


    if (password != checkpassw) {

        alert("You do have mistakes in inputs:" +
            "\n-password and confirm password, this inputs should same !!!!")
    } else {
        var http = new XMLHttpRequest()
        var uri = "http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/oficial/" + userName + '/' + password + '/' + email + '/' + name

        http.open("POST", uri, true)
        http.onreadystatechange = function () {

            if (http.readyState == 4 && http.status == 201) {
                alert("Oficial created successfully")
            } else if (http.readyState == 4 && http.status == 406) {
                alert("you should check all input for this form: \n" +
                    "    -This inputs don´t shoudl null")
            } else if (http.readyState == 4 && http.status != 201 && http.status != 406) {
                alert(http.responseText)
            }
        }
        http.send()

    }
}

function sendDataVet() {
    var userName = document.getElementById("username").value
    var name = document.getElementById("name").value
    var email = document.getElementById("email").value
    var password = document.getElementById("pwrd").value
    var check = document.getElementById("confirm").value
    var adress = document.getElementById("adress").value
    var neighborhood = document.getElementById("neighborhood").value

    if (password == check) {
        var http = new XMLHttpRequest()
        var uri = 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/vet/' + userName + '/' + password + "/" + email
            + '/' + name + '/' + adress + '/' + neighborhood

        http.open("POST", uri, true)
        http.onreadystatechange = function () {
            if (http.readyState == 4 && http.status == 201) {
                alert("Vet created successfully")
            } else if (http.readyState == 4 && http.status == 406) {
                alert("you should check all input for this form: \n" +
                    "    -This inputs don´t shoudl null")
            } else if (http.readyState == 4 && http.status != 201 && http.status != 406) {
                alert(http.responseText)
            }
        }
        http.send()

    } else {
        alert("You do have mistakes in inputs:" +
            "\n-password and confirm password, this inputs should same !!!!")
    }
}


