/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author Eric
 */
public class Controller {
    private static LinkedList<Car> cars = new LinkedList<>();
    private static LinkedList<Customer> customers = new LinkedList<>();

    public static void addCar(String ID, CarSpecs carSpecs){
        cars.add(new Car(ID, carSpecs));
    }
    
    //(String make, String model, int year, SizeEnum size){
    public static void main(String[] args){
        addCar("1", new CarSpecs("Ford", "Fusion", 2014, SizeEnum.Midsize));
        Car test = cars.getFirst();
        String tester;
        tester = String.valueOf(test.getDetails().get("MAKE"));
        addCar("1", new CarSpecs("Ford", "Fusion", 2014, SizeEnum.Midsize));
    }
}
