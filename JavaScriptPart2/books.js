window.onload = function () {
    let booksJSON = '{"books":[{"author":"JK Rowling","title":"Harry Potter and the Philsopher\'s Stone"},'
        + '{"author":"Alexandre Dumas","title":"The Count of Monte Cristo"},'
        + '{"author":"Dr. Seuss","title":"The Cat in the Hat"}]}';
    let booksObj = JSON.parse(booksJSON);
    //display books on the page
    for (let i=0; i < booksObj.books.length; i++) {
        let book = booksObj.books[i];
        let newDiv = document.createElement("div");
        let newPara = document.createElement("p");
        newPara.innerText = "title: "+book.title+"; author: "+book.author;
        newDiv.appendChild(newPara);
        document.getElementById("div1").appendChild(newDiv);
    }
}
