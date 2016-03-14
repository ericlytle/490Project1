/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import java.util.Calendar;

/**
 *
 * @author Eric
 */
public class Rental {
    //Variables that are bound to change
    private Calendar returnDate;
    private StatusEnum status;
    //Final Variables - these cannot be changed
    private final Car rentalCar;
    private final Calendar rentDate;
    
    public Rental(Calendar RentDate, Car RentalCar){
        this.returnDate = null;
        this.rentDate = RentDate;
        this.status = StatusEnum.Rented;
        this.rentalCar = RentalCar;
    }
    
    public Car returnCar(Calendar ReturnDate){
        this.returnDate = ReturnDate;
        this.status = StatusEnum.Returned;
        return this.rentalCar;
    }
    public Car getCar(){
        return this.rentalCar;
    }
    
    public String getStatus(){
        return String.valueOf(this.status);
    }
    
    public String getRentDate(){
        //return rented date in DAY/MONTH/YEAR format
        return this.rentDate.get(Calendar.MONTH) + "/" + this.rentDate.get(Calendar.DAY_OF_MONTH) + "/" + this.rentDate.get(Calendar.YEAR);
    }
    
    public String getReturnDate(){
        //return rented date in DAY/MONTH/YEAR format
        return this.returnDate.get(Calendar.MONTH) + "/" + this.returnDate.get(Calendar.DAY_OF_MONTH) + "/" + this.returnDate.get(Calendar.YEAR);
    }
}
