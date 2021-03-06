/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import Code.Global;
import Code.Update;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author reece
 */
public class GUI extends javax.swing.JFrame {

    private final NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.UK);
    Update update = new Update();

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        if (!Global.name.equals("Master Account") && !Global.ID.equals("MASTER")) {
            txtUpHistory.setText("This is the update history page.\n"
                    + "You need to authorise yourself to view this information, for assistance, see your system administrator.\n"
                    + "\n"
                    + "You are not authorised to view this information.");
            mnuServer.setVisible(false);
            mnuServer.setEnabled(false);
            pnlApplication.setVisible(false);
        } else {
            btnRTCPlay.setEnabled(false);
            btnStarBlock.setEnabled(false);
            mnuChangePsw.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnApplication = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRTCPlay = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnStarBlock = new javax.swing.JButton();
        lblDevelopNotice = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pnlApplication = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtUpHistory = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        barOptions = new javax.swing.JMenu();
        mnuServer = new javax.swing.JMenuItem();
        mnuChangePsw = new javax.swing.JMenuItem();
        mnuSignOut = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Access Remote Casino");

        pnApplication.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 51));
        jLabel1.setText("Pick A Game...");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Reelin' In The Cash");

        btnRTCPlay.setText("Play!");
        btnRTCPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRTCPlayActionPerformed(evt);
            }
        });

        jLabel3.setText("Min bet: £1.00");

        jLabel4.setText("Max bet: £250");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setText("Star Block");

        jLabel6.setText("Min Bet: £0.10");

        jLabel7.setText("Max bet: £50");

        btnStarBlock.setText("Play!");
        btnStarBlock.setEnabled(false);
        btnStarBlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStarBlockActionPerformed(evt);
            }
        });

        lblDevelopNotice.setText("Created & Developed by Access Remote - https://accessremote.uk");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRTCPlay, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnStarBlock, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblDevelopNotice)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnRTCPlay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnStarBlock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(lblDevelopNotice))
        );

        pnApplication.addTab("Games", jPanel1);

        jLabel8.setText("Your Account Balance is: ");

        jLabel9.setText(formatter.format(Global.balance));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addContainerGap(247, Short.MAX_VALUE))
        );

        pnApplication.addTab("Account", jPanel2);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtUpHistory.setEditable(false);
        txtUpHistory.setText("V2.0.2:\n*Fixed an issue where the application hangs when updating\n*Fixed bonus table issue, where user balance was not saved when exiting the table\n\nV2.0.1:\n*Fixed a bug where the game crashes when a guaranteed reel nudge is activated\n\nV2.0.0:\n* Repaired broken updater\n* Reelin' In The Cash has now been moved into Casino\n* Casino now has one login to access all games.\n+ Added new game\n- Revoked access to new game (game under development)\n+ Added Server Capability\n- Revoked access to Server Settings (feature under development)\n* Only the master account may see this information.");
        jScrollPane1.setViewportView(txtUpHistory);

        javax.swing.GroupLayout pnlApplicationLayout = new javax.swing.GroupLayout(pnlApplication);
        pnlApplication.setLayout(pnlApplicationLayout);
        pnlApplicationLayout.setHorizontalGroup(
            pnlApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
        );
        pnlApplicationLayout.setVerticalGroup(
            pnlApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
        );

        pnApplication.addTab("Application", pnlApplication);

        barOptions.setText("Options");

        mnuServer.setText("Server Settings");
        mnuServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuServerActionPerformed(evt);
            }
        });
        barOptions.add(mnuServer);

        mnuChangePsw.setText("Change Password");
        mnuChangePsw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuChangePswActionPerformed(evt);
            }
        });
        barOptions.add(mnuChangePsw);

        mnuSignOut.setText("Sign Out");
        mnuSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSignOutActionPerformed(evt);
            }
        });
        barOptions.add(mnuSignOut);

        jMenuBar1.add(barOptions);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnApplication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnApplication, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRTCPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRTCPlayActionPerformed
        new RTC.GUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRTCPlayActionPerformed

    private void btnStarBlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStarBlockActionPerformed
        Runtime.getRuntime().exec("/addon/StarBlock.jar " name, password, id, balance, active, phone, address)
    }//GEN-LAST:event_btnStarBlockActionPerformed

    private void mnuServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuServerActionPerformed
//        new Settings(this).setVisible(true);
        JOptionPane.showMessageDialog(this, "Sorry! We're still working on a few bugs...", "Feature not ready", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_mnuServerActionPerformed

    private void mnuSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSignOutActionPerformed
        Thread signOut = new Thread() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, "You have successfully signed out", "Signed Out", JOptionPane.INFORMATION_MESSAGE);
                new WelcomeUI().setVisible(true);
            }
        };
        signOut.start();
        this.dispose();
    }//GEN-LAST:event_mnuSignOutActionPerformed

    private void mnuChangePswActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuChangePswActionPerformed
        JOptionPane.showMessageDialog(null, "Change Password function is disbled.\n"
                + "This feature is not ready.", "Feature Not Ready", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_mnuChangePswActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu barOptions;
    private javax.swing.JButton btnRTCPlay;
    private javax.swing.JButton btnStarBlock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDevelopNotice;
    private javax.swing.JMenuItem mnuChangePsw;
    private javax.swing.JMenuItem mnuServer;
    private javax.swing.JMenuItem mnuSignOut;
    private javax.swing.JTabbedPane pnApplication;
    private javax.swing.JPanel pnlApplication;
    private javax.swing.JTextPane txtUpHistory;
    // End of variables declaration//GEN-END:variables
}
