/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Business_Logic.*;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Tamas
 */
public class AccountView extends javax.swing.JFrame {
    Controller controller = Controller.instance();
    
    //Constructor
    public AccountView() {
        initComponents();
        loadAvailableCars(controller.getAvailableCars());
    }
    
    //Preliminary update of GUI components
    public void updateAccount()
    {
        //Make only the customer's name bold.
        String custName = "<html><b>" + controller.getSelectedCustomer().getName() + "</b>'s Account</html>";
        lblCustomerName.setText(custName);
        //Derive 'special' bold font.
        lblCustomerName.setFont(lblCustomerName.getFont().deriveFont(Font.PLAIN));
        populateRentedCars();
        populateReturnedCars();
    }
    private void populateRentedCars()
    {
        DefaultTableModel rentedModel = (DefaultTableModel) tblRentedCars.getModel();
        //remove all rows before populating them
        rentedModel.setRowCount(0);
        //spin through the customers rentals and populate the rentals table
        for (Rental rental : controller.getSelectedCustomer().getRentals())
        {
            if (rental.getStatus().equals(String.valueOf(StatusEnum.Rented))){
                Map rentedCarDetails = rental.getCar().getDetails();
                rentedModel.addRow(new Object[]{false, rental.getCar().getID(), rentedCarDetails.get("MAKE"),
                    rentedCarDetails.get("MODEL"),
                    rentedCarDetails.get("YEAR"),
                    rental.getRentDate()
                });
            }
        }
    }
    
    private void populateReturnedCars()
    {
        DefaultTableModel returnedModel = (DefaultTableModel) tblReturnedCars.getModel();
        //clear the table before populating it
        returnedModel.setRowCount(0);
        //spin through customer rentals and populate returned cars on the table
        for (Rental rental : controller.getSelectedCustomer().getRentals())
        {
            if (rental.getStatus().equals(String.valueOf(StatusEnum.Returned))){
                Map rentedCarDetails = rental.getCar().getDetails();
                returnedModel.addRow(new Object[]{rental.getCar().getID(), rentedCarDetails.get("MAKE"),
                    rentedCarDetails.get("MODEL"),
                    rentedCarDetails.get("YEAR"),
                    rental.getRentDate(),
                    rental.getReturnDate()
                });
            }
        }
    }
    
    //Sets the specified tab to show when AccountView is first displayed.
    public void setStartTab(int tab)
    {
        switch (tab)
        {
            case 0: tabContainer.setSelectedComponent(tabFindCar);
                break;
            case 1: tabContainer.setSelectedComponent(tabRentedCars);
                break;
            case 2: tabContainer.setSelectedComponent(tabReturnedCars);
                break;                    
        }     
    }
    
    private void loadAvailableCars(List<Car> cars)
    {
        DefaultTableModel yourModel = (DefaultTableModel) tblAvailableCars.getModel();
        yourModel.setRowCount(0); //Empty the table before repopulating data.
        //sprin through cars linked list and populate table with available cars
        for (Car car: cars)
        {
            yourModel.addRow(new Object[]{false, car.getID(), car.getDetails().get("MAKE"),
            car.getDetails().get("MODEL"), car.getDetails().get("YEAR"), car.getDetails().get("SIZE")});
        }
    }
    
    //Rents or returns a car given specified inputs.
    //Parameters:   JTable object to iterate through,
    //              "rent" or "return" string to process.
    private void processCar(javax.swing.JTable table, String processType)
    {
        boolean success = false; //To keep track if a vehicle is selected or not.
        
        //Grab selected cars and add car to rental object for customer.
        for (int i = 0; i < table.getRowCount(); i++)
        {
            String sDate;
            Calendar cCal = Calendar.getInstance();
            Date dDate;
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            boolean value = (boolean) table.getValueAt(i,0);
            String carID = (String) table.getValueAt(i,1);
            
            //If something is selected, proceed with the rental.
            if (value == true){
                //display date dialog for each car entry selected along with the car ID in the title
                //default text is set to the current days date
                sDate = JOptionPane.showInputDialog(null, "Please enter " + processType +" date  (YYYY-MM_DD):", "Car " + carID + " " + processType+ " Date Entry", 
                            JOptionPane.QUESTION_MESSAGE,null,null,format.format(cCal.getTime())).toString();
                //attempt to format the entered date for storage
                //display error message on incorrect date entry
                try
                {
                    dDate = format.parse(sDate);
                    cCal.setTime(dDate);
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, "Invalid Date Entry");
                    return;
                }
                
                //process the rental based on process type
                if (processType == "rent"){

                    controller.rentCar(carID, cCal);
                }
                else if (processType == "return"){
                    controller.returnCar(carID, cCal);
                }
                //if we get here, we have a car selected and processed
                success = true;
            }
        }
        if (success == false){
            JOptionPane.showMessageDialog(null, "Please select a car to " + processType +"!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCustomerName = new javax.swing.JLabel();
        tabContainer = new javax.swing.JTabbedPane();
        tabFindCar = new javax.swing.JPanel();
        txtFindCar = new javax.swing.JTextField();
        btnFindCarSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAvailableCars = new javax.swing.JTable();
        btnRentSelected = new javax.swing.JButton();
        tabRentedCars = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRentedCars = new javax.swing.JTable();
        btnReturnSelected = new javax.swing.JButton();
        tabReturnedCars = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReturnedCars = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCustomerName.setText("Customer's Account");

        btnFindCarSearch.setLabel("Search");
        btnFindCarSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindCarSearchActionPerformed(evt);
            }
        });

        tblAvailableCars.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Select", "ID", "Make", "Model", "Year", "Size"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAvailableCars);

        btnRentSelected.setText("Rent Selected");
        btnRentSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentSelectedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabFindCarLayout = new javax.swing.GroupLayout(tabFindCar);
        tabFindCar.setLayout(tabFindCarLayout);
        tabFindCarLayout.setHorizontalGroup(
            tabFindCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabFindCarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabFindCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabFindCarLayout.createSequentialGroup()
                        .addComponent(txtFindCar, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFindCarSearch))
                    .addComponent(btnRentSelected)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        tabFindCarLayout.setVerticalGroup(
            tabFindCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabFindCarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabFindCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFindCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindCarSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRentSelected)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        tabContainer.addTab("Find Car", tabFindCar);

        tblRentedCars.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Select", "ID", "Make", "Model", "Year", "Rented"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblRentedCars);

        btnReturnSelected.setText("Return Selected");
        btnReturnSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnSelectedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabRentedCarsLayout = new javax.swing.GroupLayout(tabRentedCars);
        tabRentedCars.setLayout(tabRentedCarsLayout);
        tabRentedCarsLayout.setHorizontalGroup(
            tabRentedCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabRentedCarsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabRentedCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReturnSelected))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        tabRentedCarsLayout.setVerticalGroup(
            tabRentedCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabRentedCarsLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(btnReturnSelected)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        tabContainer.addTab("Rented Cars", tabRentedCars);

        tblReturnedCars.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Make", "Model", "Year", "Rented", "Returned"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblReturnedCars);

        javax.swing.GroupLayout tabReturnedCarsLayout = new javax.swing.GroupLayout(tabReturnedCars);
        tabReturnedCars.setLayout(tabReturnedCarsLayout);
        tabReturnedCarsLayout.setHorizontalGroup(
            tabReturnedCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabReturnedCarsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        tabReturnedCarsLayout.setVerticalGroup(
            tabReturnedCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabReturnedCarsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabContainer.addTab("Returned Cars", tabReturnedCars);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCustomerName)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tabContainer))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblCustomerName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindCarSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindCarSearchActionPerformed
        //Search for available cars
        String query = txtFindCar.getText().trim().toLowerCase();
        loadAvailableCars(controller.searchCars(query)); //Refresh        
    }//GEN-LAST:event_btnFindCarSearchActionPerformed

    private void btnRentSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentSelectedActionPerformed
        //Rent the selected cars to the customer.
        processCar(tblAvailableCars,"rent");
        
        //Reload the available cars and rented cars tables.
        loadAvailableCars(controller.getAvailableCars());
        populateRentedCars();
    }//GEN-LAST:event_btnRentSelectedActionPerformed

    private void btnReturnSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnSelectedActionPerformed
        //return the selected car
        processCar(tblRentedCars,"return");
        
        //Reload the available cars, rented cars and returned cars tables
        loadAvailableCars(controller.getAvailableCars());
        populateRentedCars();
        populateReturnedCars();
    }//GEN-LAST:event_btnReturnSelectedActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFindCarSearch;
    private javax.swing.JButton btnRentSelected;
    private javax.swing.JButton btnReturnSelected;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JTabbedPane tabContainer;
    private javax.swing.JPanel tabFindCar;
    private javax.swing.JPanel tabRentedCars;
    private javax.swing.JPanel tabReturnedCars;
    private javax.swing.JTable tblAvailableCars;
    private javax.swing.JTable tblRentedCars;
    private javax.swing.JTable tblReturnedCars;
    private javax.swing.JTextField txtFindCar;
    // End of variables declaration//GEN-END:variables
}
