function getBook() {
    var bookSample = `<div class="col-6 col-xs-6 col-sm-3 col-md-3 col-lg-3" style="padding: 2%;">
      <div class="book">
        <div class="panel">
          <img class="poster" src="BookImages/conan.jpg" alt="">
        </div>
        <div class="title">
          <h5>Conan</h5>
          <div>Gosho Aoyama</div>
          <div>⭐⭐⭐⭐⭐</div>
        </div>
      </div>
    </div>`;

    var allBook = "";

    var body = document.getElementById("book");
    for (var i = 0; i < 12; i++) {
        allBook += bookSample;
    }
    body.innerHTML = allBook;
}