/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import java.util.Map;

/**
 *
 * @author Eric
 */
public class Car {
    private final String _ID;
    private final CarSpecs carSpecs;
    
    public Car(String ID, CarSpecs CarSpecs){
        this._ID = ID;
        this.carSpecs = CarSpecs;
    }
    
    public Map getDetails(){
        return this.carSpecs.getDetails();
    }
    
    public String getID(){
        return this._ID;
    }
    
    //Represent a car object as a string.
    @Override
    public String toString()
    {
        String carAsString = this._ID + ", " + this.carSpecs.getDetails().get("MAKE")+
        ", " + this.carSpecs.getDetails().get("MODEL")+", " + this.carSpecs.getDetails().get("YEAR").toString()+
        ", " + this.carSpecs.getDetails().get("SIZE").toString();
        
        return carAsString;
    }
}
