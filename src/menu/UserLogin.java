package menu;

import Code.Global;
import Code.Security;
import Server.info;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import loader.MemberLoader;
import model.User;

/**
 *
 * @author reece8765
 */
public class UserLogin extends javax.swing.JFrame {

    private final MemberLoader members;
    private final Global message = new Global();
    private final Security sec = new Security();
    private ArrayList<User> memberList;
    private String[] membersList;
    info domain = new info();

    /**
     * Creates new form UserLogin
     */
    public UserLogin() {
        initComponents();
        try {
            domain.loadSettings();
        } catch (Exception ignore) {
        }
        try {
            if (!domain.getName().equals("") || !domain.getName().equals(null)) {
                cmbDomain.addItem(domain.getName());
                cmbDomain.setSelectedIndex(1);
            }
        } catch (Exception ignore) {
        }
        //Create an object of members, so we can load the members into the members structure.
        members = new MemberLoader();
    }

    private void login(UserLogin mw) {
        Thread thread = new Thread() {
            @Override
            public void start() {
                icnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RTCImages/Processing.gif")));

                if (cmbDomain.getSelectedIndex() == 0 && !txtUsername.getText().equals("master")) {
                    Global.domainAccount = false;
                    try {
                        //Decrypt members file
                        membersList = sec.decDetails("members");
                        //Load the members list
                        for (int i = 0; i < membersList.length; i++) {
                            memberList = members.loadMember(membersList[i]);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //Sort the data and search for a match.
                    Object[][] data = new Object[memberList.size()][3];
                    boolean match = false;
                    for (int i = 0; i < memberList.size(); i++) {
                        User member = memberList.get(i);
                        data[i][0] = member.getId();
                        data[i][1] = member.getPassword();
                        data[i][2] = member.getActive();
                        if (String.valueOf(txtUsername.getText()).equals(data[i][0]) && String.valueOf(pswPassword.getPassword()).equals(data[i][1])) {
                            if (Integer.parseInt(String.valueOf(data[i][2])) == 0) {
                                icnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RTCImages/Error.gif")));
                                icnStatus.setText("Error: Account Disabled.");
                                match = true;
                                break;
                            } else {
                                //The user is active and passwords match, start the login process.
                                //Set user variables
                                Global.ID = member.getId();
                                Global.name = member.getName();
                                Global.balance = member.getBalance();
                                //Display the game GUI
                                new menu.GUI().setVisible(true);
                                //Prevent the data being deleted accidentally from RAM
                                match = true;
                                //Delete the window and all content relating to the window from RAM and screen.
                                mw.dispose();
                                //Break the statement, in case it isn't broken already
                                break;
                            }
                        }
                    }
                    //Safety measures, remove all data from RAM
                    if (!match) {
                        pswPassword.setText("");
                        pswPassword.requestFocus(true);
                        //Inform user about incorrect details
                        message.displayMessage(7, "Error");
                        //Display error icon & message in logon window
                        icnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RTCImages/Error.gif")));
                        icnStatus.setText("Invalid Credentials!");
                        //Clear content ready for new content
                        memberList = null;
                        membersList = null;
                    }
                } else if (cmbDomain.getSelectedIndex() == 1) {
                    Global.domainAccount = true;
                    //send the username and password to the server as an encrypted file, then wait for a response.
                    String usernameandpassword = txtUsername.getText() + "::" + String.valueOf(pswPassword.getPassword());
                    try {
                        sec.prepDomainUser(usernameandpassword);
                    } catch (Exception ex) {
                        Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        //Send the file to the server
                        String response[] = domain.sendFile("C:\\RTC", "temp").split("::");
                        switch (response[0]) {
                            case "Invalid":
                            case "":
                                JOptionPane.showMessageDialog(null, "Invalid logon details.", "Login Error", JOptionPane.ERROR_MESSAGE);
                                icnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RTCImages/Error.gif")));
                                icnStatus.setText("Invalid Credentials!");
                                break;
                            case "inactive":
                                JOptionPane.showMessageDialog(null, "Your account has been disabled.\n"
                                        + "Please see you network administrator.", "Account Disabled", JOptionPane.WARNING_MESSAGE);
                                icnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RTCImages/Error.gif")));
                                icnStatus.setText("Account Access Revoked");
                                break;
                            case "active":
                                Global.ID = response[1];
                                Global.name = response[4];
                                Global.balance = Double.parseDouble(response[3]);
                                new menu.GUI().setVisible(true);
                                mw.dispose();
                                break;
                            default:
                                icnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RTCImages/Error.gif")));
                                icnStatus.setText("Server Error");
                                break;
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (txtUsername.getText().equals("master") && cmbDomain.getSelectedIndex() == 0) {
                    Global.domainAccount = true;
                    //Confirm the master account password.
                    String passText = new String(pswPassword.getPassword());
                    try {
                        String password = sec.getAdminPassword();
                        if (passText.equals(password)) {
                            sec.saveLog("master logged onto the Casino application.");
                            Global.balance = 0.0;
                            Global.ID = "MASTER";
                            Global.name = "Master Account";
                            new menu.GUI().setVisible(true);
                            mw.dispose();
                        } else {
                            icnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RTCImages/Error.gif")));
                            icnStatus.setText("Invalid Credentials!");
                            message.displayMessage(7, "Error");
                            pswPassword.setText("");
                        }
                    } catch (Exception e) {
                        icnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RTCImages/Error.gif")));
                        icnStatus.setText("An error occurred");
                    }
                }
            }
        };
        thread.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        pswPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnLoginHelp = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        icnStatus = new javax.swing.JLabel();
        cmbDomain = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Casino - Login");
        setResizable(false);

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });

        pswPassword.setPreferredSize(new java.awt.Dimension(120, 20));
        pswPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pswPasswordActionPerformed(evt);
            }
        });
        pswPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pswPasswordKeyPressed(evt);
            }
        });

        jLabel1.setText("User ID:");

        jLabel2.setText("Password:");

        btnLogin.setText("Login");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnLoginHelp.setText("Help");
        btnLoginHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginHelpActionPerformed(evt);
            }
        });

        jLabel3.setText("Domain:");

        icnStatus.setFont(new java.awt.Font("Tw Cen MT", 2, 12)); // NOI18N
        icnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RTCImages/Loading-gif.gif"))); // NOI18N
        icnStatus.setText("Waiting for User Credentials...");

        cmbDomain.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "This computer" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pswPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtUsername)
                            .addComponent(cmbDomain, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLoginHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(icnStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnLogin)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pswPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnLoginHelp)
                    .addComponent(cmbDomain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(icnStatus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (!String.valueOf(txtUsername.getText()).equals("") && !String.valueOf(pswPassword.getPassword()).equals("")) {
            login(this);
        } else {
            JOptionPane.showMessageDialog(this, "A username and password is required to logon.\n"
                    + "If you do not have a password, please speak to you system administartor or account operator.",
                    "Login Details Error", JOptionPane.WARNING_MESSAGE);
            icnStatus.setText("Please enter a username and a password!");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        new WelcomeUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void pswPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pswPasswordActionPerformed
        //Doesn't do anything - this was generated and isn't needed.
    }//GEN-LAST:event_pswPasswordActionPerformed

    private void pswPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswPasswordKeyPressed
        if (evt.getKeyCode() == VK_ENTER) {
            login(this);
        }
    }//GEN-LAST:event_pswPasswordKeyPressed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        //Doesn't do anything - this was generated and isn't needed.
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        if (evt.getKeyCode() == VK_ENTER) {
            pswPassword.requestFocus(true);
        }
    }//GEN-LAST:event_txtUsernameKeyPressed

    private void btnLoginHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginHelpActionPerformed
        new LoginHelp(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLoginHelpActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLoginHelp;
    private javax.swing.JComboBox<String> cmbDomain;
    private javax.swing.JLabel icnStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pswPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
