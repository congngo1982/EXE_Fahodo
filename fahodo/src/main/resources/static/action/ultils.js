function includeHTML() {
    var z, i, elmnt, file, xhttp;
    /*loop through a collection of all HTML elements:*/
    z = document.getElementsByTagName("*");
    for (i = 0; i < z.length; i++) {
        elmnt = z[i];
        /*search for elements with a certain atrribute:*/
        file = elmnt.getAttribute("w3-include-html");
        if (file) {
            /*make an HTTP request using the attribute value as the file name:*/
            xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4) {
                    if (this.status == 200) { elmnt.innerHTML = this.responseText; }
                    if (this.status == 404) { elmnt.innerHTML = "Page not found."; }
                    /*remove the attribute, and call this function once more:*/
                    elmnt.removeAttribute("w3-include-html");
                    includeHTML();
                }
            }
            xhttp.open("GET", file, true);
            xhttp.send();
            /*exit the function:*/
            return;
        }
    }
};

function OnScroll() {
    var header = document.getElementById("header");
    if (window.pageYOffset > 70) {
        header.style.position = "absolute";
        header.style.top = pageYOffset + "px";
        document.getElementsByClassName("header")[0].style.display = "none";
    } else {
        header.style.position = "";
        header.style.top = "";
        document.getElementsByClassName("header")[0].style.display = "";
    }
}

function GetAuthen() {
    const xhttp = new XMLHttpRequest();
    var result;
    xhttp.onload = function () {
        if (this.status == 200) {
            var response = this.responseText;
            if (response != "") {
                result = response;
                document.getElementById("headerReference").innerHTML = `<div class="col-12 col-xs-2 col-sm-2 col-md-2 col-lg-2 logo">
              <h2><span style="color: #A18A68;">F</span><span>ahodo</span></h2>
          </div>
          <div class="col-12 col-xs-6 col-sm-6 col-md-6 col-lg-6">
              <form id="searchForm">
                  <input type="text" class="form-control" placeholder="Tìm sách" id="txtSearch" name="txtSearch">
              </form>
          </div>
          <div class="col-12 col-xs-4 col-sm-4 col-md-4 col-lg-4">
              <div class="row">
                  <a href="signup.html" class="col-12 col-xs-4 col-sm-4 col-md-4 col-lg-4 nav_item nav_effect">
                      <img src="images/account.png" class="nav_icon" alt="Image">
                      Tài khoản
                  </a>
                  <a href="/logout" class="col-12 col-xs-4 col-sm-4 col-md-4 col-lg-4 nav_item nav_effect">
                      Đăng xuất
                  </a>
                  <a href="/profile.html" class="col-12 col-xs-4 col-sm-4 col-md-4 col-lg-4 nav_effect">
                      <img src="images/heart.png" class="nav_icon" alt="Image">
                      Cá nhân
                  </a>
              </div>
          </div>`;
            }
        }
    }
    xhttp.open("GET", "/account/authentication", false);
    xhttp.send();
    return result;
}