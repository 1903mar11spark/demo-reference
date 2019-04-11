window.onload = function() {
    isLoggedIn = false;
    failedLoginCounter = getCount();
}

function login() {
    let userElement = document.getElementById("username");
    let username = userElement.value;
    let passElement = document.getElementById("password");
    let password = passElement.value;
    if (username && password) {
        if (username === "Merlin" && password === "cat") {
            isLoggedIn = true;
            console.log("success");
            window.location = "books.html"
        } else {
            isLoggedIn = false;
            if (failedLoginCounter() > 3) {
                alert("too many attempts!");
                //disable button or require password change or... 
            }
        }
    }
    userElement.value = "";
    passElement.value = "";
}

//counter for login attempts
function getCount() {
    let count = 0;
    return function() {
        count +=1;
        console.log("login attempt count is: "+count);
        return count;
    }
}