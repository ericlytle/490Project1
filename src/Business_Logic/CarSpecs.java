/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Eric
 */
public class CarSpecs {
    private final String make;
    private final String model;
    private final int year;
    private final SizeEnum size;
    private Map details = new HashMap();
    
    public CarSpecs(String make, String model, int year, SizeEnum size){
        this.make = make;
        this.model = model;
        this.year = year;
        this.size = size;
        this.details.put("MAKE", make);
        this.details.put("MODEL", model);
        this.details.put("YEAR", year);
        this.details.put("SIZE", size);
    }
    
    public Map getDetails(){
        return this.details;
    }
    
    //ToDo: REMOVE. TESTING PURPOSES ONLY
    
}
