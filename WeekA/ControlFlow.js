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

    function largestOfThree(a,b,c){
        //return the largest parameter
    }
}


