/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import java.util.Calendar;
import java.util.LinkedList;

/**
 *
 * @author Eric
 */
public class Customer {
    private String name;
    private String phone;
    private String address;
    private LinkedList<Rental> rentals = new LinkedList<>();
    
    public Customer()
    {
        this.name = "";
        this.phone = "";
        this.address = "";
    }
    
    public Customer(String Name, String Phone, String Address){
        this.name = Name;
        this.phone = Phone;
        this.address = Address;
    }
    
    public void rentCar(Car car){
        
       Rental newRental = new Rental(Calendar.getInstance(),car);
       rentals.add(newRental);
    }
    
    public LinkedList<Rental> getRentals(){
        return this.rentals;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getPhone(){
        return this.phone;
    }
    
    public String getAddress(){
        return this.address;
    }
}
