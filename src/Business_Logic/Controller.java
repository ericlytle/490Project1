/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Eric
 */
public class Controller {
    private static Controller singleton;
    private LinkedList<Car> availCars = new LinkedList<>();
    private LinkedList<Customer> customers = new LinkedList<>();
    
    //*******************************************************************    
    //This is updated with customers from the search result
    private LinkedList<Customer> searchResults = new LinkedList<>();
    
    //The customer whose account is to be viewed.
    private Customer selectedCustomer = new Customer();
    
    //Return the selected Customer;
    public Customer getSelectedCustomer()
    {
        return selectedCustomer;
    }
    
    public void addSearchCustomer(Customer customer)
    {
        searchResults.add(customer);
    }
    
    public List<Customer> getSearchResults()
    {
        return Collections.unmodifiableList(searchResults);
    }
    
    public void resetSearchResults()
    {
        searchResults.clear();
    }
    
    public void setSelectedCustomer(Customer cust)
    {
        selectedCustomer = cust;
    }
    //*******************************************************************

    public static Controller instance(){
        if (singleton == null){
            singleton = new Controller();
        }
        return singleton;
    }
    
    public void addCar(Car car){
        availCars.add(car);
    }
    
    public List<Customer> getAllCustomers(){
        return Collections.unmodifiableList(customers);
    }
    
    public List<Car> getAvailableCars(){
        return Collections.unmodifiableList(availCars);
    }
    
    public void addCustomer(Customer cust){
        customers.add(cust);
    }
    
    //Returns a list of customers that contain/satisfy the search criteria.
    public List<Customer> customerSearch(String query)
    {
        List<Customer> results = new LinkedList<>();
        
        for (Customer customer : customers)
        {
            if (customer.getName().toLowerCase().contains(query) ||
                    customer.getPhone().toLowerCase().contains(query) ||
                    customer.getAddress().toLowerCase().contains(query))
            {
                results.add(customer);
            }
        }
                
        return results;
    }
    
    public void rentCar(String CarID, Customer Cust){
        for (Car car: availCars){
            if (car.getID().equals(CarID)){
                Cust.rentCar(car);
                availCars.remove(car);
                return;
            }
        }
    }
    public void returnCar(String CarID, Customer Cust){
        for (Rental rental : Cust.getRentals()){
            if (rental.getCar().getID().equals(CarID)){
                availCars.add(rental.returnCar(Calendar.getInstance()));
            }
        }
    }
    
    //(String make, String model, int year, SizeEnum size){
//    public static void main(String[] args){
//        addCar("1", new CarSpecs("Ford", "Fusion", 2014, SizeEnum.Midsize));
//        Car test = cars.getFirst();
//        String tester;
//        tester = String.valueOf(test.getDetails().get("MAKE"));
//        addCar("1", new CarSpecs("Ford", "Fusion", 2014, SizeEnum.Midsize));
//    }
}
