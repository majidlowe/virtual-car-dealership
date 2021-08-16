import React from "react";
import Car from './Car'
import {fakeCars} from "./fakeCars";


export default () => fakeCars.map((car, ind) => (
    <ol key={ind}>
        <Car carId={car.carId}
             carMake={car.carMake}
             carModel={car.carModel}
             carPrice={car.carPrice}
             carIsSold={car.carIsSold}
        />
    </ol>))
