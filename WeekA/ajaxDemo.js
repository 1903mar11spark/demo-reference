window.onload = function() {
    document.getElementById("weather").addEventListener("click",function(){
        sendAjaxGet('http://api.openweathermap.org/data/2.5/weather?q=Tampa,us&units=imperial&APPID=859d47520ac736ebe8bbce1fef74269c', showWeather)
    });
  /*  let weatherUrl = 'http://api.openweathermap.org/data/2.5/weather?q=Tampa,us&units=imperial&APPID=859d47520ac736ebe8bbce1fef74269c';
    this.setInterval(function(){
        sendAjaxGet(weatherUrl, showWeather)}, 10000); */
}

// url represents resource being requested
// func represents the callback function to be invoked upon successful completion of request
function sendAjaxGet(url, func) {
    // step 1: obtain xhr (note: IE 5,6 do not have this)
    let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
    // step 2: define onreadystatechange function
    xhr.onreadystatechange = function(){
        // readyState of 4 means request is complete
        // status of 200 means OK
        if (this.readyState == 4 && this.status == 200) {
            func(this);
        }
    };
    // step 3: prepare the request with open()
    xhr.open("GET", url, true);
    // step 4: send the request
    xhr.send();
}

function showWeather(xhr) {
    let weatherObj = JSON.parse(xhr.responseText);
    console.log(weatherObj);
    document.getElementById("temperature").innerText = "Current Temperature: "+weatherObj.main.temp;
    document.getElementById("humidity").innerText = "Current Humidity: "+weatherObj.main.humidity;
    document.getElementById("description").innerText = weatherObj.weather[0].description;
}

