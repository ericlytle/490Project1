/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        DateFormat df = new SimpleDateFormat("MM/dd/yy"); // Just the year, with 2 digits
        String formattedDate = df.format(this.rentDate.getTime());
        return formattedDate;
    }
    
    public String getReturnDate(){
        //return rented date in DAY/MONTH/YEAR format
        DateFormat df = new SimpleDateFormat("MM/dd/yy"); // Just the year, with 2 digits
        String formattedDate = df.format(this.returnDate.getTime());
        return formattedDate;
    }
}
