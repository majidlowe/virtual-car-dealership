import React, {useState} from "react";


export default  ({carId,carMake,carModel,carPrice,carIsSold}) =>
{

const  [_carIsSold, setCarIsSold] = useState(carIsSold);
return  !_carIsSold &&  <h3> {carMake} {carModel} {carPrice} <button onClick={()=>setCarIsSold(true)}>Buy Me!</button></h3>
}








