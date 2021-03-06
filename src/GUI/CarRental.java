/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Business_Logic.*;

/**
 *
 * @author Eric
 */
public class CarRental {
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Controller controller = Controller.instance();
        
        //Create customers, car specs, and cars.
        Customer Jim = new Customer("Jim", "8168888888", "123 School Street");
        Customer Brett = new Customer("Brett", "8176534343", "123 University Street");
        Customer Victor = new Customer("Victor", "9987776543", "123 Elementary Street");
        
        CarSpecs Fusion = new CarSpecs("Ford", "Fusion", 2014, SizeEnum.Midsize);
        CarSpecs Escape = new CarSpecs("Ford", "Escape", 2001, SizeEnum.Large);
        CarSpecs Corvette = new CarSpecs("Chevrolet", "Corvette", 2016, SizeEnum.Small);
        CarSpecs BMW740iL = new CarSpecs("BMW", "740iL", 1996, SizeEnum.Large);
        CarSpecs MercedesSL500 = new CarSpecs("Mercedes","SL500", 2007, SizeEnum.Small);

        Car Fusion_1 = new Car("1FF", Fusion);
        Car Escape_1 = new Car("1FE", Escape);
        Car Corvette_1 = new Car("1CC", Corvette);
        Car BMW_1 = new Car("3A2", BMW740iL);
        Car Mercedes_1 = new Car("5BB",MercedesSL500);
        
        //Add customers and cars.
        controller.addCustomer(Jim);
        controller.addCustomer(Brett);
        controller.addCustomer(Victor);
        
        controller.addCar(Fusion_1);
        controller.addCar(Escape_1);
        controller.addCar(Corvette_1);
        controller.addCar(BMW_1);
        controller.addCar(Mercedes_1);
        
        //Create and display the form.
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerSearch().setVisible(true);
            }
        });
        
        
    }
}
