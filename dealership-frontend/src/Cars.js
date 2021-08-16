import React, {useState} from "react";
import Car from './Car'


export const Cars = () => {

}
let animals = [{name: "Squirrel", age: 5}, {name: "cow", age: 21}, {name: "Chicken", age: 1}]
//age < 2 do not need a ticket and seat basic , ticket isAdult
//=>[{name: "Squirrel", seat:"basic", age: 5,isAdult:false},{name: "cow", age: 21,seat:"basic",isAdult:ture} ]

let airplaneSeatMap = (item) => {
    return {...item, seat: "basic", isAdult:item.age > 18 }

}
let isBabyFn = (item)=>{
    if(item.age >= 2) return true

}

let seatingChart = animals.map(airplaneSeatMap).filter(isBabyFn);
let fileredSeatingChart = seatingChart.filter(isBabyFn)

// if item is {name: "Squirrel", age: 5} ->{title: "Squirrel", monthsAge: 5*12,firstCharOfName:"S"}}
//item={name: "Squirrel", age: 5}

let item = {name: "Squirrel", age: 5}
// getFirstChar(string)=>
let convertFn = (item) => {
    return {title: item.name, monthsAge: item.age * 12, firstCharOfName: item.name.charAt(0)};
}

let filterfn = (item) => {
    if (item.age <= 10) {
        return {title: item.name, age: item.age}
    }
}

let Mfilter = (arr,fn)=>{

     if(age>10){
         return fn(arr[1])
     }
}

let Mfilter =(age)=> (arr,fn)=>{

    if(11>10){
        return fn(arr[1])
    }
}

let filter = Mfilter(11)


let newAnimals = animals.map(convertFn)

let newerAnimals = animals.filter((item) => {
    if (item.age <= 10) {
        return {title: item.name, age: item.age}
    }
})

let newerAnimals = animals.filter(filterfn)


//
// if(fn){
//     newArray.push(arr[i])
// }
//newArray[i]= fn(arr[i],index,array)

// newArray[i]= fn(arr[i],index,array)

// let  filter=(arr,fn)=>{
//return new array
// }

//let ingredients= [{name:"corn"},{"name":"beef"},{"name":"chicken"}]
//let dish= [{name:"popcorn"},{"name":"burger"},{"name":"egg"}]
export default Cars;