## VIRTUAL CAR DEALERSHIP EXERCISE

In Java, we are going to implement a day at a virtual car dealership.  The dealership has one salesperson and as many cars as you feel like.  Throughout the day, the salesperson has 5 consecutive appointments to show (and hopefully sell) the cars.

### USER STORIES
1. **Show the Cars**
   
    At the beginning of an appointment, the cars for sale should be "shown" by printing them to the console.  Show the car's make, model, and price. That should look something like this:
    ```aidl
    Chevy Volt $4000
    Honda Odyssey $11000
    Porsche 911 $200000
    ``` 
   <br/>

1. **A Car Can be Purchased**

    After showing the available cars, print a prompt to represent the salesperson asking which car the customer would like to purchase.
    How the customer identifies that car is up to you!  If a car is purchased, then it should be 
    considered no longer part of the dealership's inventory and therefore not offered at the next appointment.<br/><br/>

1. **The Salesperson Collects Commission**
    
    The salesperson should receive a 20% commission for every car they sell.<br/><br/>
   
1. **A Customer Can Opt to Not Purchase** 
   
    Allow the customer the option to pass on purchasing a car during their appointment.  This means that
   no commission is earned and that the available car inventory does not change.<br/><br/>
   
1. **The Salesperson Alerts Customers When Out of Cars**
    
    At the beginning of an appointment, the salesperson should inform the customer via a print statement
   if there are no cars left in the inventory.  The customer should not be asked which car they would like to purchase.<br/><br/>

1. **The Dealership Closes After the 5 Appointments Happen**
   
    The dealership closes after all 5 appointments have occurred.  Before closing,
    the salesperson boasts about how much commission they made.<br/><br/>


## Advanced User Stories

1. **Only Show Cars Priced within a Customer's budget** 
   
    Before showing the cars, ask the customer what their maximum budget is.
   Only show the cars that are priced at or below their maximum budget.<br/><br/>
   
   >NOTE:  How might this new feature lead to changes in existing behavior? If there are no cars within a customer's budget, do you turn them away or do you offer them the expensive cars anyways?  
   
    <br/>
1. **The Dealership Can Sell Multiple Cars of the Same Make and Model**
   
    Allow the dealership to carry multiple cars of the same make and model. Since these 
   cars may still be priced differently, a customer should be able to choose which particular car they
   would like to purchase.
   
   >NOTE:  Is the current way a customer specifies their desired purchase specific enough?  
   