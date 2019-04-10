window.onload = function() {
    let myDivs = document.getElementsByTagName("div");
    for (let i = 0; i<myDivs.length; i++) {
        myDivs[i].addEventListener("click", function() {
            //event object changes every time an event occurs
            //the target is the element on which the event occurred
            console.log("target: "+event.target.id+" and the current element: "+this.id);
        }, true);
    }
}