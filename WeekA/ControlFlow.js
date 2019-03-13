//"use strict";

//apply an event listener to Window object 
//this function will execute when the window loads
window.onload = function(){
    //select the element from the DOM with id "compare"
    //apply an event listener to our Compare button
    //anonymous function provided will be invoked when the element is clicked
    document.getElementById("compare").addEventListener("click", function(){
        //alert("hello from compare button!");
        //retrieve values from user input on the form
        let num1 = document.getElementById("num1").value;
        let num2 = document.getElementById("num2").value;
        let num3 = document.getElementById("num3").value;
        console.log(largestOfThree(num1,num2,num3));
    })    
}

//incrementing, pre and post
function funWithIncrementing(num){
    //num++; //post incrementer, increments after evaluating
    return ++num; //pre incrementer, increments before evaluating
}
//works the same with -- (decrementer)

//LOOPS!
function loops(){
    //declare loop variable(s), condition, and increment/decrement
    for(i=0; i<10; i++) {
        console.log(i);
    }
    let myObj = {name:"Fred",age:40,profession:"astronaut"};
    //we can also iterate over the properties of an object
    for (someThing in myObj){
        console.log(someThing); //just the key (property name)
        console.log(myObj[someThing]); //the value corresponding to property x
        /*
            iteration 0: someThing = name, myObj[someThing] = "Fred"
            etc.
        */
    }
    //while loop: executes until condition is false
    let x = 0;
    while(x < 10){
        console.log(x);
        x++;
    }
    let arr = [2,5,"",77,true];
    let y = 0;
    while (arr[y]){
        console.log(arr[y]);
        y++;
    }  
}


function largestOfThree(a,b,c){
    //return the largest parameter
    //check whether input is of type number
    //note: Number(boolean) will evaluate to 0 or 1
    //use typeof
    if(isNaN(Number(a)) || isNaN(Number(b)) || isNaN(Number(c))){
        return NaN;
    } else {
        let largest = a;
        console.log("largest is "+a);
        if (b > largest) {
            console.log("largest is "+b);
            largest = b;
        }
        if (c > largest) {
            console.log("largest is "+c);
            largest = c;
        }
        return largest;
    }

}