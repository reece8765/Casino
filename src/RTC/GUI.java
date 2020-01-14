/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RTC;

import menu.WelcomeUI;
import Code.Global;
import Code.Background;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author reece
 */
public class GUI extends javax.swing.JFrame {

    Background back = new Background();
    private final NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.UK);
    private boolean clicked = false;

    /**
     * Creates new form GUI
     */
    int[] reels = {0, 0, 0};

    private void initialise() {
        reel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RTCImages/" + reels[0] + ".jpg")));
        reel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RTCImages/" + reels[1] + ".jpg")));
        reel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RTCImages/" + reels[2] + ".jpg")));
        txtAutoInfo.setVisible(false);
        txtAutoSpin.setVisible(false);
        txtWinSpin.setVisible(false);
        txtRandomNum.setVisible(false);
        txtFreeSpins.setVisible(false);
    }

    Random random = new Random();

    private void winReel() {
        txtWinSpin.setVisible(true);
        txtName.setText("WINNER!!!");
    }

    private int genReelNo() {
        int temp = 0;
        //Generate a random number between 1 and 13, then return this number.
        while (temp == 0 || temp > 13) {
            temp = random.nextInt(14);
        }
        return temp;
    }

    public GUI() {
        //Prepare the screen.
        initComponents();
        //Generate random reel positions
        reels[0] = genReelNo();
        reels[1] = genReelNo();
        reels[2] = genReelNo();
        //Set graphics
        initialise();
        //Allow the user to see the screen
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Reelin' In The Cash " + Global.currentVersion);
    }

    private void reels(int number, GUI game, boolean debug) {

        //Run on a new thread so as the application doesn't hang until this is completed.
        Thread spin = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < number; i++) {
                    if (back.verifyUser(Global.domainAccount)) {
                        if (Global.balance - back.getBet() < 0) {
                            System.out.println("Spinning STOPPED - Low Funds");
                            JOptionPane.showMessageDialog(null, "Your balance is too low for this bet!");
                            btnAutoSpin.setText("Auto");
                            btnAutoSpin.setEnabled(true);
                            btnIncBet.setEnabled(true);
                            btnDecBet.setEnabled(true);
                            btnSpin.setEnabled(true);
                            Global.autoSpin = 0;
                            break;
                        }
                        if (clicked) {
                            clicked = false;
                            btnAutoSpin.setText("Auto");
                            btnIncBet.setEnabled(true);
                            btnDecBet.setEnabled(true);
                            btnSpin.setEnabled(true);
                            Global.autoSpin = 0;
                            System.out.println("--SPINNING STOPPED--\nSystem stopped spinning: User action.");
                            break;
                        }
                        if (number > 1 && i + 1 < number) {
                            txtAutoSpin.setVisible(true);
                            if (i + 2 == number) {
                                txtAutoSpin.setText("Auto Spinning... " + (number - (i + 1)) + " spin remaining.");
                            } else {
                                txtAutoSpin.setText("Auto Spinning... " + (number - (i + 1)) + " spins remaining.");
                            }
                        } else {
                            txtAutoSpin.setVisible(false);
                        }
                        txtWinSpin.setVisible(false);
                        txtRandomNum.setVisible(false);
                        System.out.println("Spinning... " + String.valueOf(i + 1) + " of " + number + ".");
                        int match = random.nextInt(100);
                        int win = random.nextInt(100);
                        txtWinningNumber.setText("Winning number: " + win);
                        if (!debug) {
                            //Only take funds if the application is NOT in debug mode.
                            back.setBalance(Global.balance - back.getBet());
                        }
                        txtBalance.setText("Current Balance: " + formatter.format(Global.balance));
                        txtTotalWin.setText("Total Win: £0.00");
                        setBalance();
                        System.out.println(txtBalance.getText());

                        //Spin normally if the user has lost less than 10 times
                        if (Global.loseCount <= 6) {
                            //Look at this code and compare to remainder of the reels method. This code is cleaner for GUI
                            if (!debug) {
                                spinning(false, win, match);
                            } else {
                                //When debugging or testing, always win.
                                spinning(true, win, match);
                            }

                        } else {
                            //If the user has lost 10 times, offer a chance for a guaranteed win
                            //Reset lose variables
                            Global.loseCount = 0;
                            Global.lastWin = true;
                            //Generate a random number
                            int winThisTime = random.nextInt(41);
                            //Odds of winning
                            if (winThisTime >= 35) {
                                System.out.println("The user is guaranteed to win.");
                                winReel();
                                spinning(true, win, match);
                            } else {
                                System.out.println("The user has no guarantee of winning this time");
                                spinning(false, win, match);
                            }
                        }
                        System.out.println("Match number is: " + match);
                        //Reels match - get wins and apply it to their balance
                        double earned = back.getRTCWins(reels, back.getBet());
                        if (earned > 0) {
                            System.out.println("User won with value: " + reels[0] + "," + reels[1] + "," + reels[2]);
                            Global.lastWin = true;
                            Global.loseCount = 0;
                            txtTotalWin.setText("Total Win: " + formatter.format(earned));

                        } else {
                            System.out.println("User lost with value: " + reels[0] + "," + reels[1] + "," + reels[2]);
                            Global.loseCount += 1;
                            Global.lastWin = false;
                            System.out.println("User lost: " + Global.loseCount + " times.");
                            if (Global.loseCount > 2 && !Global.lastWin) {
                                int maxRandomNum = 21 - (Global.loseCount * 2);
                                int ranNum = random.nextInt(maxRandomNum);
                                System.out.println("The guaranteed win if first two reels match and third one doesn't depends if " + ranNum + " out of " + maxRandomNum + " is lower or equal to 5.");
                                if (ranNum <= 5) {

                                    while (reels[0] - reels[1] == 0 && reels[2] - reels[1] != 0) {
                                        Global.lastWin = true;
                                        System.out.println("Nudging third wheel. The user will win.");
                                        i = 2;
                                        reels[i] = reels[i] + 1;
                                        if (reels[i] <= 0) {
                                            reels[i] = 1;
                                        } else if (reels[i] > 13) {
                                            reels[i] = 1;
                                        }
                                        System.out.println("Reel " + String.valueOf(i + 1) + " = " + reels[i] + " due to guaranteed win.");
                                        //Set the images of the reels depending on the reel index nmber
                                        reel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RTCImages/" + reels[i] + ".jpg")));
                                        try {
                                            Thread.sleep(750);
                                        } catch (InterruptedException ex) {
                                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    earned = back.getRTCWins(reels, back.getBet());
                                }
                            }
                        }
                        if (!debug) {
                            //Only update the users balance if the application is NOT in debug mode
                            back.setBalance(Global.balance += earned);
                        }

                        //If the user gets the bonus reels on the winline, regenerate their number
                        if (reels[0] == 9 && reels[1] == 9 && reels[2] == 9) {
                            int board = random.nextInt(11);
                            if (board == 0) {
                                board = 1;
                            }
                            if (board <= 4) {
                                new BonusBoard(game, board).setVisible(true);
                                game.setVisible(false);
                                stopSpin("User entered bonus board");
                                break;
                            } else {
                                txtRandomNum.setVisible(true);
                                Global.lastWin = true;
                                Global.loseCount = 0;
                                txtYourNumber.setText("REGENERATING NUMBER!");
                                try {
                                    Thread.sleep(5000);
                                    match = random.nextInt(100);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                txtYourNumber.setText("Your number: " + match);
                            }
                            stopSpin("Number was regenerated due to bonus reels");
                            break;
                        }
                        txtBalance.setText("Current Balance: " + formatter.format(Global.balance));
                        txtName.setText("Reelin' In The Cash");
                        if (number - (i + 1) == 0) {
                            stopSpin("No more spins");
                            break;
                        } else {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else {
                        userDisabled();
                        stopSpin("User account was suspended during the spin attempt");
                        break;
                    }
                }

            }

            private void stopSpin(String reason) {
                btnSpin.setEnabled(true);
                btnIncBet.setEnabled(true);
                btnDecBet.setEnabled(true);
                btnAutoSpin.setEnabled(true);
                btnAutoSpin.setText("Auto");
                System.out.println("Spinning stopped. Reason: " + reason + ".");
                txtAutoSpin.setVisible(false);
            }

            private void spinning(boolean winner, int win, int match) {
                for (int i = 0; i < reels.length; i++) {
                    int spinFor = random.nextInt(24);
                    while (spinFor < 13) {
                        spinFor = random.nextInt(24);
                    }
                    for (int j = 0; j < spinFor; j++) {
                        if (winner && reels[i] == 9) {
                            break;
                        }
                        reels[i] = reels[i] + 1;
                        if (reels[i] <= 0) {
                            reels[i] = 1;
                        } else if (reels[i] > 13) {
                            reels[i] = 1;
                        }
                        if (debug) {
                            System.out.println("Reel " + String.valueOf(i + 1) + " = " + reels[i]);
                        }
                        //Set the images of the reels depending on the reel index nmber
                        switch (i + 1) {
                            case 1:
                                reel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RTCImages/" + reels[i] + ".jpg")));
                                break;
                            case 2:
                                txtYourNumber.setText("Your number: " + match);
                                reel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RTCImages/" + reels[i] + ".jpg")));
                                break;
                            case 3:
                                reel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RTCImages/" + reels[i] + ".jpg")));
                                break;
                        }
                        try {
                            Thread.sleep(70);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    System.out.println("Reel " + String.valueOf(i + 1) + " Spun " + spinFor + " times.");
                }
                //if the user has two matching numbers, and the last win is false (they didnt win before the numbers matched),
                //spin a win reel
                if (win == match && !Global.lastWin) {
                    System.out.println("Repeating spin -- BONUS or WIN Activated!");
                    winReel();
                    //Be sure that the winning number doesn't cause a loop, add 3 to the number.
                    spinning(true, win, win + 3);
                }
            }
        };
        btnSpin.setEnabled(false);
        btnIncBet.setEnabled(false);
        btnDecBet.setEnabled(false);
        if (Global.autoSpin > 1) {
            btnAutoSpin.setEnabled(true);
            btnAutoSpin.setText("STOP");
        } else {
            btnAutoSpin.setText("Auto");
            btnAutoSpin.setEnabled(false);
        }
        spin.start();

    }

    public void setBalance() {
        txtBalance.setText("Current Balance: " + formatter.format(Global.balance));
    }

    private void userDisabled() {
        JOptionPane.showMessageDialog(this, "Sorry, you user has been disabled, or removed.\n"
                + "Please see you system administrator.", "Access Revoked", JOptionPane.WARNING_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        txtName = new javax.swing.JLabel();
        reel2 = new javax.swing.JLabel();
        reel3 = new javax.swing.JLabel();
        reel1 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JLabel();
        txtBet = new javax.swing.JLabel();
        txtTotalWin = new javax.swing.JLabel();
        btnIncBet = new javax.swing.JButton();
        btnDecBet = new javax.swing.JButton();
        btnSpin = new javax.swing.JButton();
        txtWinningNumber = new javax.swing.JLabel();
        txtYourNumber = new javax.swing.JLabel();
        txtWinSpin = new javax.swing.JLabel();
        txtRandomNum = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtFreeSpins = new javax.swing.JLabel();
        btnAutoSpin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtAutoInfo = new javax.swing.JLabel();
        txtAutoSpin = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reelin' In The Cash");

        txtName.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 2, 48)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 51, 0));
        txtName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtName.setText("Reelin' In The Cash");

        reel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RTCImages/1.jpg"))); // NOI18N

        reel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RTCImages/1.jpg"))); // NOI18N

        reel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RTCImages/1.jpg"))); // NOI18N

        txtBalance.setText("Current Balance: " + formatter.format(Global.balance));

        txtBet.setText("Total Bet: " + formatter.format(back.getBet()));

        txtTotalWin.setText("Total Win: £0.00");

        btnIncBet.setText("Increase Bet");
        btnIncBet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncBetActionPerformed(evt);
            }
        });

        btnDecBet.setText("Decrease Bet");
        btnDecBet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecBetActionPerformed(evt);
            }
        });

        btnSpin.setText("Spin!");
        btnSpin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpinActionPerformed(evt);
            }
        });

        txtWinningNumber.setText("Winning Number: N/A");

        txtYourNumber.setText("Your Number: N/A");

        txtWinSpin.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtWinSpin.setForeground(new java.awt.Color(0, 204, 0));
        txtWinSpin.setText("GUARANTEED WIN SPIN");

        txtRandomNum.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        txtRandomNum.setForeground(new java.awt.Color(0, 204, 204));
        txtRandomNum.setText("BONUS CHANCE - BOARD OR NUMBER");

        jLabel1.setText("Winline ->");

        txtFreeSpins.setBackground(new java.awt.Color(255, 51, 51));
        txtFreeSpins.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtFreeSpins.setForeground(new java.awt.Color(255, 102, 51));
        txtFreeSpins.setText("Free Spins! Remaining: 0");

        btnAutoSpin.setText("Auto");
        btnAutoSpin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutoSpinActionPerformed(evt);
            }
        });

        jLabel2.setText("User: " + Global.name + " - ID: " + Global.ID);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reel1)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFreeSpins, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtWinningNumber)
                            .addComponent(txtYourNumber)
                            .addComponent(txtBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(102, 102, 102)))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reel2)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnIncBet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDecBet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSpin)
                                    .addComponent(btnAutoSpin))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(txtBet)
                        .addGap(103, 103, 103)))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reel3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(txtTotalWin)
                        .addGap(73, 73, 73))
                    .addComponent(txtWinSpin)
                    .addComponent(txtRandomNum))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(175, 175, 175))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(txtName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reel2)
                    .addComponent(reel3)
                    .addComponent(reel1)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel1)))
                .addGap(12, 12, 12)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBet)
                            .addComponent(txtTotalWin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIncBet)
                            .addComponent(btnSpin)
                            .addComponent(txtWinSpin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnDecBet)
                                .addComponent(btnAutoSpin))
                            .addComponent(txtRandomNum, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(txtFreeSpins)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBalance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtWinningNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtYourNumber))))
        );

        txtAutoInfo.setText("Auto Spinning... Remaining Spins:");

        txtAutoSpin.setText("0");

        jMenu1.setText("Options");

        jMenuItem3.setText("Pay Table");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setText("Sign Out");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtAutoInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAutoSpin)
                .addGap(10, 10, 10))
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAutoInfo)
                    .addComponent(txtAutoSpin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnSpinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpinActionPerformed
        if (back.verifyUser(Global.domainAccount)) {
            if (Global.autoSpin == 0) {
                Global.autoSpin = 1;
            }
            reels(Global.autoSpin, this, false);
        } else {
            userDisabled();
        }
        Global.autoSpin = 0;
    }//GEN-LAST:event_btnSpinActionPerformed

    private void btnIncBetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncBetActionPerformed
        double curBet = back.getBet();
        if (curBet < 250.0) {
            if (curBet == 1.0) {
                curBet = 10;
                back.setBet(curBet);
                txtBet.setText("Total Bet: " + formatter.format(back.getBet()));
            } else {
                curBet = curBet + 10;
                back.setBet(curBet);
                txtBet.setText("Total Bet: " + formatter.format(back.getBet()));
            }
        }
    }//GEN-LAST:event_btnIncBetActionPerformed

    private void btnDecBetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecBetActionPerformed
        double curBet = back.getBet();
        if (curBet >= 10.0) {
            if (curBet == 10.0) {
                curBet = 1;
                back.setBet(curBet);
                txtBet.setText("Total Bet: " + formatter.format(back.getBet()));
            } else {
                curBet = curBet - 10;
                back.setBet(curBet);
                txtBet.setText("Total Bet: " + formatter.format(back.getBet()));
            }
        }
    }//GEN-LAST:event_btnDecBetActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new WelcomeUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new PayTableGUI().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btnAutoSpinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutoSpinActionPerformed
        if (btnAutoSpin.getText().equals("Auto")) {
            //Allow the user to set an auto spin value.
            new AutoSpin().setVisible(true);
        } else {
            //Set the variables in place to stop autospinning...
            clicked = true;
            btnAutoSpin.setEnabled(false);
        }
    }//GEN-LAST:event_btnAutoSpinActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutoSpin;
    private javax.swing.JButton btnDecBet;
    private javax.swing.JButton btnIncBet;
    private javax.swing.JButton btnSpin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel reel1;
    private javax.swing.JLabel reel2;
    private javax.swing.JLabel reel3;
    private javax.swing.JLabel txtAutoInfo;
    private javax.swing.JLabel txtAutoSpin;
    private javax.swing.JLabel txtBalance;
    private javax.swing.JLabel txtBet;
    private javax.swing.JLabel txtFreeSpins;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtRandomNum;
    public javax.swing.JLabel txtTotalWin;
    private javax.swing.JLabel txtWinSpin;
    private javax.swing.JLabel txtWinningNumber;
    private javax.swing.JLabel txtYourNumber;
    // End of variables declaration//GEN-END:variables
}
