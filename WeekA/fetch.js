window.onload = function(){
    document.getElementById('fetchJoke').addEventListener('click', getJokeWithFetch);
};

const apiUrl = 'https://icanhazdadjoke.com/';

let state = {
    joke: ''
} // semicolon injection - if JIT compiler percieves the end of a line
    // as the end of a statement, it will inject a semicolon

let updateContent = function() {
    document.getElementById('joke').innerText = state.joke;
}

function getJokeWithFetch() {
    fetch(apiUrl, {method: "GET", headers:{"Accept":"application/json"}})
    //define behavior for when response returns
    .then((response) => {
        //return unwrapped promise object for the next chained operation
        return response.json();
    })
    //utilize unwrapped promise as a JS object
    .then((data) => {
        console.log(data);
        state.joke = data.joke;
        updateContent();
    })
    //what if there's a problem?
    .catch((error) => {
        alert('oh no :(');
        console.log(error);
    });
}
