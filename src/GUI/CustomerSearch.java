/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Business_Logic.CarSpecs;
import Business_Logic.Controller;
import Business_Logic.Customer;
import Business_Logic.SizeEnum;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eric
 */
public class CustomerSearch extends javax.swing.JFrame {
    Controller controller = Controller.instance();
    AccountView accountView = new AccountView();
    /**
     * Creates new form CustomerSearch
     */
    public CustomerSearch() {
        initComponents();
        LoadAllCustomers(controller.getAllCustomers());
        
        //Prevent multiple selections from occuring at once.
        tblCustomers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    //Verify that a user is selected before preceding.
    public boolean checkSelection()
    {
        if (tblCustomers.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Please select a customer!");
            return false;
        }
        else
        {
            //Set the selected customer
            //Still need to figure this one out.
            //Fetching Customer object from tblCustomers selection didn't work.
            return true;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnRentCar = new javax.swing.JButton();
        btnRentedCars = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Phone", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCustomers);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnRentCar.setText("Rent Car");
        btnRentCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentCarActionPerformed(evt);
            }
        });

        btnRentedCars.setText("Rented Cars");
        btnRentedCars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentedCarsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRentCar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRentedCars))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRentCar)
                    .addComponent(btnRentedCars))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRentCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentCarActionPerformed
        //Select the FindCar tab.       
        accountView.setStartTab(0);
        
        //Verify a customer is selected and show form.
        if (checkSelection() == true){
            accountView.setVisible(true);
        }
    }//GEN-LAST:event_btnRentCarActionPerformed

    private void btnRentedCarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentedCarsActionPerformed
        //Select the ReturnedCars tab.
        accountView.setStartTab(1);

        if (checkSelection() == true){
            accountView.setVisible(true);
        }
    }//GEN-LAST:event_btnRentedCarsActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
      
        //Clear any existing selections.
        tblCustomers.clearSelection();
        
        //Clear the existing data in the table.
        DefaultTableModel blankModel = (DefaultTableModel) tblCustomers.getModel();
        blankModel.setRowCount(0);
        
        //Search for the customers and repopulate table.
        LoadAllCustomers(controller.customerSearch(txtSearch.getText().trim().toLowerCase()));
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void LoadAllCustomers(List<Customer> customers){
        DefaultTableModel yourModel = (DefaultTableModel) tblCustomers.getModel();
        for (Customer cust:customers){
            //Hiding the customer object in the row for access after selection (This probably won't work).
            yourModel.addRow(new Object[]{cust.getName(), cust.getPhone(), cust.getAddress(), cust});
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRentCar;
    private javax.swing.JButton btnRentedCars;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
