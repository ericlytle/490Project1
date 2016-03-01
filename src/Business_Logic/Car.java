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
}
