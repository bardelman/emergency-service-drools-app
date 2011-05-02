/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LiveEmergencyReport.java
 *
 * Created on Apr 29, 2011, 11:40:00 PM
 */
package com.wordpress.salaboy.emergencyservice.dashboard;

import com.wordpress.salaboy.emergencyservice.monitor.EmergencyMonitorPanel;
import com.wordpress.salaboy.model.Emergency;
import com.wordpress.salaboy.model.serviceclient.DistributedPeristenceServerService;
import java.awt.CardLayout;
import java.awt.Dimension;

/**
 *
 * @author salaboy
 */
public class LiveEmergencyReport extends javax.swing.JFrame {
    private Long emergencyId;
    private Emergency emergency;
    private EmergencyMonitorPanel monitor;
    /** Creates new form LiveEmergencyReport */
    public LiveEmergencyReport(Long emergencyId) {
        this.emergencyId = emergencyId;
        System.out.println(">>>>>>>>>> Getting the emergency selected -> "+emergencyId);
        this.emergency = DistributedPeristenceServerService.getInstance().loadEmergency(emergencyId);
        System.out.println(">>>>>>>The emergency selected -> "+emergency);
        initComponents();
        configure();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        auditLogjTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedMonitorPane = new javax.swing.JTabbedPane();

        auditLogjTextArea.setColumns(20);
        auditLogjTextArea.setRows(5);
        jScrollPane1.setViewportView(auditLogjTextArea);
        auditLogjTextArea.setText(DistributedPeristenceServerService.getInstance().getReportByCallId(this.emergency.getCall().getId()).getReportString());

        jLabel1.setText("Contextual Area");

        jLabel2.setText("Audit Log");

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTabbedMonitorPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                            .add(jLabel2)
                            .add(jButton1)))
                    .add(jTabbedMonitorPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTabbedMonitorPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel2)
                .add(5, 5, 5)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            // TODO add your handling code here:
        System.out.println(">>> Report: "+DistributedPeristenceServerService.getInstance().getReportByCallId(this.emergency.getCall().getId()).getReportString());
        auditLogjTextArea.setText(DistributedPeristenceServerService.getInstance().getReportByCallId(this.emergency.getCall().getId()).getReportString());
        pack();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea auditLogjTextArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedMonitorPane;
    // End of variables declaration//GEN-END:variables

    private void configure() {
        monitor = new EmergencyMonitorPanel(emergency.getCall().getId());
        
        jTabbedMonitorPane.add(monitor);

        this.pack();
    }
}
