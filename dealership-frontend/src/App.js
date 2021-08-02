import React, {useState} from "react";
import Dealership from "./Dealership";
import './App.css';




const App = (props) => {

    const [carMake, setCarMake] = useState();
    const [carModel, setCarModel] = useState();
    const [carPrice, setCarPrice] = useState();
    const [carIsSold, setCarIsSold] = useState();

    return (
        <div className="App">
            <h1>SFC(ret.) JONES' CAR DEALERSHIP</h1>
            <Dealership
                carMake={props.carMake}
                carModel={props.carModel}
                carPrice={props.carPrice}
                carIsSold={props.carIsSold}

            />
        </div>
    );
}

export default App;
