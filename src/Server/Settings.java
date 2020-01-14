/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Code.Global;
import Code.Security;
import java.io.File;
import javax.swing.JOptionPane;
import menu.GUI;

/**
 *
 * @author reece
 */
public class Settings extends javax.swing.JFrame {

    info setup = new info();
    GUI mw;
    Security sec = new Security();

    /**
     * Creates new form Settings
     *
     * @param mw
     */
    public Settings(GUI mw) {
        this.mw = mw;
        initComponents();
        load();
    }
    
    private boolean passChangable = false;

    private void load() {
        mw.setVisible(false);
        txtServerName.setText(Global.serverName);
        txtServerIP.setText(Global.ServerIP);
        txtServerPort.setText("5026");
        lblConnected.setText("Not Connected");
        txtID.setText(Global.ClientID);
        if (!Global.serverName.equals("")) {
            lblConnected.setText("Registered");
            btnConnect.setEnabled(false);
            pswServerPass.setText("password");
            passChangable = true;
        } else {
            btnDisconnect.setEnabled(false);
        }
    }

    private void save() {
        setup.setServer(txtServerName.getText(), txtServerIP.getText(), txtServerPort.getText(), txtID.getText());
        String command[] = new String[2];
        command[0] = "registerClient";
        command[1] = String.valueOf(String.valueOf(pswServerPass.getPassword()));
        ConnectToServer connect = new ConnectToServer();
        boolean success = connect.setup(command);
        if (success) {
            setup.saveSettings(true);
            JOptionPane.showMessageDialog(this, "Welcome to the " + setup.getName() + " domain.");
            mw.setVisible(true);
            this.dispose();
        } else {
            setup.resetServer();
            setup.saveSettings(false);
            JOptionPane.showMessageDialog(this, "Error: Couldn't register with server.\n"
                    + "Please check all of the details you entered, then try again.", "Not Registered", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtServerName = new javax.swing.JTextField();
        txtServerIP = new javax.swing.JTextField();
        txtServerPort = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pswServerPass = new javax.swing.JPasswordField();
        btnConnect = new javax.swing.JButton();
        lblConnected = new javax.swing.JLabel();
        btnDisconnect = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Client Settings");
        setResizable(false);

        jLabel1.setText("Server Name: ");

        jLabel2.setText("Server IP: ");

        jLabel3.setText("Server Port: ");

        txtServerName.setText("My Server");
        txtServerName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtServerNameMouseClicked(evt);
            }
        });
        txtServerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServerNameActionPerformed(evt);
            }
        });

        txtServerIP.setText("192.168.x.x");
        txtServerIP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtServerIPMouseClicked(evt);
            }
        });

        txtServerPort.setEditable(false);
        txtServerPort.setText("5096");
        txtServerPort.setEnabled(false);
        txtServerPort.setFocusable(false);

        jLabel4.setText("Server Status: ");

        jLabel5.setText("Server password:");

        pswServerPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pswServerPassMouseClicked(evt);
            }
        });
        pswServerPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pswServerPassActionPerformed(evt);
            }
        });

        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        lblConnected.setText("Not Connected");

        btnDisconnect.setText("Disconnect");
        btnDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisconnectActionPerformed(evt);
            }
        });

        txtID.setText("CLIENT");
        txtID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIDMouseClicked(evt);
            }
        });
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel6.setText("Machine ID: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblConnected))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtServerName)
                            .addComponent(txtServerIP, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDisconnect)
                        .addGap(12, 12, 12)
                        .addComponent(btnConnect))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pswServerPass, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(23, 23, 23)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtServerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtServerIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pswServerPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblConnected))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDisconnect)
                    .addComponent(btnConnect))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtServerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServerNameActionPerformed
        //Nothing happens here
    }//GEN-LAST:event_txtServerNameActionPerformed

    private void pswServerPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pswServerPassActionPerformed
        
    }//GEN-LAST:event_pswServerPassActionPerformed

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        save();
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisconnectActionPerformed
        if (!Global.serverName.equals("")) {
            File key = new File("C:\\RTC\\lockdown\\server.key");
            File data = new File("C:\\RTC\\lockdown\\server.dat");
            if (key.exists()) {
                key.delete();
                System.out.println("Server key file removed.");
            }
            if (data.exists()) {
                data.delete();
                System.out.println("Server data file removed.");
            }
            setup.resetServer();
            System.out.println("Server information reset");
            sec.saveLog("Disconnected from domain.");
            JOptionPane.showMessageDialog(this, "The application will now restart.");
            new menu.WelcomeUI().setVisible(true);
            mw.dispose();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Your application is not joined to a domain.");
            System.out.println("No action was performed.");
        }
    }//GEN-LAST:event_btnDisconnectActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void pswServerPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pswServerPassMouseClicked
        if (passChangable) {
            btnConnect.setEnabled(true);
            pswServerPass.setText("");
            btnConnect.setText("Update Server Info");
            passChangable = false;
        }
    }//GEN-LAST:event_pswServerPassMouseClicked

    private void txtServerNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtServerNameMouseClicked
        if (passChangable) {
            btnConnect.setEnabled(true);
            btnConnect.setText("Update Server Info");
            passChangable = false;
        }
    }//GEN-LAST:event_txtServerNameMouseClicked

    private void txtServerIPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtServerIPMouseClicked
        if (passChangable) {
            btnConnect.setEnabled(true);
            txtServerIP.setText("192.168.");
            btnConnect.setText("Update Server Info");
            passChangable = false;
        }
    }//GEN-LAST:event_txtServerIPMouseClicked

    private void txtIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDMouseClicked
        if (passChangable) {
            btnConnect.setEnabled(true);
            txtID.setText("CLIENT");
            btnConnect.setText("Update Server Info");
            passChangable = false;
        }
    }//GEN-LAST:event_txtIDMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnDisconnect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    protected static javax.swing.JLabel lblConnected;
    private javax.swing.JPasswordField pswServerPass;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtServerIP;
    private javax.swing.JTextField txtServerName;
    private javax.swing.JTextField txtServerPort;
    // End of variables declaration//GEN-END:variables
}
