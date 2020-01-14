/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RTC;

import Code.Background;
import Code.Global;
import java.awt.Color;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author reece
 */
public class BonusBoard extends javax.swing.JFrame {

    Background back = new Background();
    int position = 0;
    int lives = 0;
    int nextNumber = 0;
    Random random = new Random();
    boolean end = false;
    private final GUI mw;
    private int win;
    private int points = 0;

    /**
     * Creates new form BonusBoard
     *
     * @param mw
     * @param win
     */
    public BonusBoard(GUI mw, int win) {
        System.out.println("BONUS BOARD START\nInitialising Bonus Board...");
        initComponents();
        blinker();
        this.mw = mw;
        this.win = win;
        txtPrize.setText("PRIZE: £" + win + ".00");
        System.out.println("Ready.");
    }

    private void dispPoints(int points) {
        switch (points) {
            case 1:
                txt1.setForeground(Color.green);
                break;
            case 2:
                txt1.setForeground(Color.green);
                txt2.setForeground(Color.green);
                break;
            case 3:
                txt1.setForeground(Color.green);
                txt2.setForeground(Color.green);
                txt3.setForeground(Color.green);
                break;
            case 4:
                txt1.setForeground(Color.green);
                txt2.setForeground(Color.green);
                txt3.setForeground(Color.green);
                txt4.setForeground(Color.green);
                break;
            case 5:
                txt1.setForeground(Color.green);
                txt2.setForeground(Color.green);
                txt3.setForeground(Color.green);
                txt4.setForeground(Color.green);
                txt5.setForeground(Color.green);
                break;
            case 6:
                txt1.setForeground(Color.green);
                txt2.setForeground(Color.green);
                txt3.setForeground(Color.green);
                txt4.setForeground(Color.green);
                txt5.setForeground(Color.green);
                txt6.setForeground(Color.green);
                break;
            case 7:
                txt1.setForeground(Color.green);
                txt2.setForeground(Color.green);
                txt3.setForeground(Color.green);
                txt4.setForeground(Color.green);
                txt5.setForeground(Color.green);
                txt6.setForeground(Color.green);
                txt7.setForeground(Color.green);
                break;
            case 8:
                txt1.setForeground(Color.green);
                txt2.setForeground(Color.green);
                txt3.setForeground(Color.green);
                txt4.setForeground(Color.green);
                txt5.setForeground(Color.green);
                txt6.setForeground(Color.green);
                txt7.setForeground(Color.green);
                txt8.setForeground(Color.green);
                break;
            case 9:
                txt1.setForeground(Color.green);
                txt2.setForeground(Color.green);
                txt3.setForeground(Color.green);
                txt4.setForeground(Color.green);
                txt5.setForeground(Color.green);
                txt6.setForeground(Color.green);
                txt7.setForeground(Color.green);
                txt8.setForeground(Color.green);
                txt9.setForeground(Color.green);
                break;
            case 10:
                txt1.setForeground(Color.green);
                txt2.setForeground(Color.green);
                txt3.setForeground(Color.green);
                txt4.setForeground(Color.green);
                txt5.setForeground(Color.green);
                txt6.setForeground(Color.green);
                txt7.setForeground(Color.green);
                txt8.setForeground(Color.green);
                txt9.setForeground(Color.green);
                txt10.setForeground(Color.green);
                break;
            case 11:
                txt1.setForeground(Color.green);
                txt2.setForeground(Color.green);
                txt3.setForeground(Color.green);
                txt4.setForeground(Color.green);
                txt5.setForeground(Color.green);
                txt6.setForeground(Color.green);
                txt7.setForeground(Color.green);
                txt8.setForeground(Color.green);
                txt9.setForeground(Color.green);
                txt10.setForeground(Color.green);
                txt11.setForeground(Color.green);
                break;
            case 12:
                txt1.setForeground(Color.green);
                txt2.setForeground(Color.green);
                txt3.setForeground(Color.green);
                txt4.setForeground(Color.green);
                txt5.setForeground(Color.green);
                txt6.setForeground(Color.green);
                txt7.setForeground(Color.green);
                txt8.setForeground(Color.green);
                txt9.setForeground(Color.green);
                txt10.setForeground(Color.green);
                txt11.setForeground(Color.green);
                txt12.setForeground(Color.green);
                break;
            default:
                txt1.setForeground(Color.black);
                txt2.setForeground(Color.black);
                txt3.setForeground(Color.black);
                txt4.setForeground(Color.black);
                txt5.setForeground(Color.black);
                txt6.setForeground(Color.black);
                txt7.setForeground(Color.black);
                txt8.setForeground(Color.black);
                txt9.setForeground(Color.black);
                txt10.setForeground(Color.black);
                txt11.setForeground(Color.black);
                txt12.setForeground(Color.black);
                break;
        }
    }

    private void blinker() {
        Thread begin = new Thread() {
            int pos = position;

            private void sleep() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ignore) {
                    System.out.println(pos + " - Position error. " + ignore);
                }
            }

            @Override
            public void run() {
                System.out.println("Blinker is active");
                while (true) {
                    pos = position;
                    switch (pos) {
                        case 0:
                            START.setBackground(Color.BLUE);
                            sleep();
                            START.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 1:
                            pnl1.setBackground(Color.BLUE);
                            sleep();
                            pnl1.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 2:
                            pnl2.setBackground(Color.BLUE);
                            sleep();
                            pnl2.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 3:
                            pnl3.setBackground(Color.BLUE);
                            sleep();
                            pnl3.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 4:
                            pnl4.setBackground(Color.BLUE);
                            sleep();
                            pnl4.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 5:
                            pnl5.setBackground(Color.BLUE);
                            sleep();
                            pnl5.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 6:
                            pnl6.setBackground(Color.BLUE);
                            sleep();
                            pnl6.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 7:
                            pnl7.setBackground(Color.BLUE);
                            sleep();
                            pnl7.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 8:
                            pnl8.setBackground(Color.BLUE);
                            sleep();
                            pnl8.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 9:
                            pnl9.setBackground(Color.BLUE);
                            sleep();
                            pnl9.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 10:
                            pnl10.setBackground(Color.BLUE);
                            sleep();
                            pnl10.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 11:
                            pnl11.setBackground(Color.BLUE);
                            sleep();
                            pnl11.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 12:
                            pnl12.setBackground(Color.BLUE);
                            sleep();
                            pnl12.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 13:
                            pnl13.setBackground(Color.BLUE);
                            sleep();
                            pnl13.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 14:
                            pnl14.setBackground(Color.BLUE);
                            sleep();
                            pnl14.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 15:
                            pnl15.setBackground(Color.BLUE);
                            sleep();
                            pnl15.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 16:
                            pnl16.setBackground(Color.BLUE);
                            sleep();
                            pnl16.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 17:
                            pnl17.setBackground(Color.BLUE);
                            sleep();
                            pnl17.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 18:
                            pnl18.setBackground(Color.BLUE);
                            sleep();
                            pnl18.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 19:
                            pnl19.setBackground(Color.BLUE);
                            sleep();
                            pnl19.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 20:
                            pnl20.setBackground(Color.BLUE);
                            sleep();
                            pnl20.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 21:
                            pnl21.setBackground(Color.BLUE);
                            sleep();
                            pnl21.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 22:
                            pnl22.setBackground(Color.BLUE);
                            sleep();
                            pnl22.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 23:
                            pnl23.setBackground(Color.BLUE);
                            sleep();
                            pnl23.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 24:
                            pnl24.setBackground(Color.BLUE);
                            sleep();
                            pnl24.setBackground(Color.GRAY);
                            sleep();
                            break;
                        case 25:
                            pnl25.setBackground(Color.BLUE);
                            sleep();
                            pnl25.setBackground(Color.GRAY);
                            sleep();
                            break;
                    }
                    if (end) {
                        break;
                    }
                }
                mw.setVisible(true);
            }
        };
        begin.start();
    }

    private void getWin() {
        int add;
        int ran;
        switch (position) {
            case 6:
                win *= 2;
                break;
            case 7:
                lives++;
                txtLives.setText("Lives: " + lives);
                break;
            case 9:
                if (lives > 0) {
                    lives = lives - 1;
                    txtLives.setText("Lives: " + lives);
                } else {
                    win = 0;
                }
                break;
            case 13:
                add = random.nextInt(5);
                if (add <= 0) {
                    add = 1;
                } 
                points += add;
                if (points > 12) {
                    points = 12;
                }
                break;
            case 14:
                if (lives > 0) {
                    lives = lives - 1;
                    txtLives.setText("Lives: " + lives);
                } else {
                    win = 0;
                    exit();
                }
            case 15:
                win += 10;
                break;
            case 16:
                win *= 5;
                break;
            case 17:
                if (lives > 0) {
                    lives = lives - 1;
                    txtLives.setText("Lives: " + lives);
                } else {
                    win = 0;
                }
                break;
            case 18:
                ran = random.nextInt(8);
                switch (ran) {
                    case 1:
                        points = 0;
                        JOptionPane.showMessageDialog(null, "Your points were reset to 0.", "Points Reset", JOptionPane.WARNING_MESSAGE);
                        break;
                    case 2:
                        lives = 3;
                        JOptionPane.showMessageDialog(null, "Your lives have been changed to 3, regardless of how many you had.", "3 Lives", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 3:
                        lives = 0;
                        JOptionPane.showMessageDialog(null, "All your lives were lost, regardless of how many you had.", "No lives", JOptionPane.WARNING_MESSAGE);
                        break;
                    default:
                        win = 0;
                        JOptionPane.showMessageDialog(null, "Uh oh, you paid an outstanding debt... All your earnings are gone!\nDon't worry, you can always earn more though!", "WHERE'S MY MONEY!?", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case 22:
                add = random.nextInt(5);
                if (add <= 0) {
                    add = 1;
                }
                points += add;
                if (points > 12) {
                    points = 12;
                }

                break;
            case 24:
                win += 10;
                break;
            case 25:
                win += 60;
                break;
            default:
                break;
        }
        txtPrize.setText("PRIZE: £" + win + ".00");
        dispPoints(points);
        txtLives.setText("Lives: " + lives);
    }

    private void exit() {
        System.out.println("Exiting the bonus board...");
        Global.balance += win;
        mw.setVisible(true);
        mw.setBalance();
        back.setBalance(Global.balance);
        System.out.println("BONUS BOARD INACTIVE");
        this.dispose();
    }

    private void scroll(String betHighLow) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                int lastNumber = nextNumber;
                genNum(betHighLow);
                switch (betHighLow) {
                    case "":
                        move();
                        break;
                    case "high":
                        if (nextNumber < lastNumber) {
                            if (lives > 0) {
                                lives = lives - 1;
                                enableButtons(true);
                            } else {
                                enableButtons(true);
                                win = 0;
                                exit();
                            }
                        } else {
                            getWin();
                            enableButtons(true);
                        }
                        break;
                    case "low":
                        if (nextNumber > lastNumber) {
                            if (lives > 0) {
                                lives = lives - 1;
                                enableButtons(true);
                            } else {
                                enableButtons(true);
                                win = 0;
                                exit();
                            }
                        } else {
                            getWin();
                            enableButtons(true);
                        }
                        break;
                    default:
                        break;
                }
                txtLives.setText("Lives: " + lives);
            }

            private void enableButtons(boolean enable) {
                btnPlay.setEnabled(enable);
                btnHigh.setEnabled(enable);
                btnLow.setEnabled(enable);
                btnTake.setEnabled(enable);
            }

            private void verifyNumber() {
                if (nextNumber < 1) {
                    nextNumber = 1;
                } else if (nextNumber > 12) {
                    nextNumber = 12;
                }
            }

            private void genNum(String bet) {
                //Initialise settings for number generation
                int currentNum = Integer.parseInt(txtNum.getText());
                int lose = 0;

                switch (bet) {
                    case "high":
                        //Luck parameters - the higer the nextInt number, the less luck the user will have.
                        lose = random.nextInt(7);
                        //Generate a number
                        nextNumber = random.nextInt(13);
                        verifyNumber();
                        if (lose < 2 && currentNum != 1) {
                            while (currentNum <= nextNumber) {
                                nextNumber = random.nextInt(13);
                                verifyNumber();
                            }
                        }
                        break;
                    case "low":
                        //Luck parameters - the higer the nextInt number, the less luck the user will have.
                        lose = random.nextInt(7);
                        //Generate a number
                        nextNumber = random.nextInt(13);
                        verifyNumber();
                        if (lose < 2 && currentNum != 12) {

                            while (currentNum >= nextNumber) {
                                nextNumber = random.nextInt(13);
                                verifyNumber();
                            }
                        }
                        break;
                    default:
                        nextNumber = random.nextInt(13);
                        verifyNumber();
                        while (currentNum == nextNumber) {
                            nextNumber = random.nextInt(13);
                            verifyNumber();
                        }
                        break;
                }

                enableButtons(false);

                //While the current number is not equal to the next position, stay in the loop.
                while (currentNum != nextNumber) {
                    if (currentNum + 1 > 12) {
                        currentNum = 1;
                    } else {
                        currentNum++;
                    }
                    txtNum.setText(String.valueOf(currentNum));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ignore) {

                    }
                }
            }
        };
        thread.start();
    }

    private void move() {
        Thread begin = new Thread() {
            int next = nextNumber;

            @Override
            public void run() {
                int temp = 0;
                for (int i = 0; i < next; i++) {
                    temp = position + 1;
                    if (temp > 25) {
                        position = 0;
                    } else {
                        position++;
                    }
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException ignore) {

                    }
                }
                btnPlay.setEnabled(true);
                btnHigh.setEnabled(true);
                btnLow.setEnabled(true);
                btnTake.setEnabled(true);
                getWin();
            }
        };
        begin.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        START = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnl1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnl2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pnl3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pnl4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnl5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        pnl6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        pnl7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        pnl8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        pnl9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        pnl14 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        pnl13 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        pnl15 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        pnl16 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        pnl17 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        pnl18 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        pnl19 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        pnl20 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        pnl21 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        pnl25 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        pnl24 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        pnl23 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        pnl22 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        pnl12 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        pnl11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        pnl10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pnlScore = new javax.swing.JPanel();
        btnPlay = new javax.swing.JButton();
        pnlSpin = new javax.swing.JPanel();
        txtNum = new javax.swing.JLabel();
        btnHigh = new javax.swing.JButton();
        btnLow = new javax.swing.JButton();
        txtPrize = new javax.swing.JLabel();
        txtLives = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt1 = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        txt3 = new javax.swing.JLabel();
        txt4 = new javax.swing.JLabel();
        txt5 = new javax.swing.JLabel();
        txt6 = new javax.swing.JLabel();
        txt7 = new javax.swing.JLabel();
        txt8 = new javax.swing.JLabel();
        txt9 = new javax.swing.JLabel();
        txt10 = new javax.swing.JLabel();
        txt11 = new javax.swing.JLabel();
        txt12 = new javax.swing.JLabel();
        btnTake = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("BONUS BOARD");
        setResizable(false);

        START.setBackground(new java.awt.Color(102, 102, 102));
        START.setMaximumSize(new java.awt.Dimension(60, 60));
        START.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("START");

        javax.swing.GroupLayout STARTLayout = new javax.swing.GroupLayout(START);
        START.setLayout(STARTLayout);
        STARTLayout.setHorizontalGroup(
            STARTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(STARTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        STARTLayout.setVerticalGroup(
            STARTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(STARTLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pnl1.setBackground(new java.awt.Color(102, 102, 102));
        pnl1.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl1.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("1");

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pnl2.setBackground(new java.awt.Color(102, 102, 102));
        pnl2.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl2.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("2");

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnl3.setBackground(new java.awt.Color(102, 102, 102));
        pnl3.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl3.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("3");

        javax.swing.GroupLayout pnl3Layout = new javax.swing.GroupLayout(pnl3);
        pnl3.setLayout(pnl3Layout);
        pnl3Layout.setHorizontalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(25, 25, 25))
        );
        pnl3Layout.setVerticalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pnl4.setBackground(new java.awt.Color(102, 102, 102));
        pnl4.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl4.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("4");

        javax.swing.GroupLayout pnl4Layout = new javax.swing.GroupLayout(pnl4);
        pnl4.setLayout(pnl4Layout);
        pnl4Layout.setHorizontalGroup(
            pnl4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pnl4Layout.setVerticalGroup(
            pnl4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnl5.setBackground(new java.awt.Color(102, 102, 102));
        pnl5.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl5.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("5");

        javax.swing.GroupLayout pnl5Layout = new javax.swing.GroupLayout(pnl5);
        pnl5.setLayout(pnl5Layout);
        pnl5Layout.setHorizontalGroup(
            pnl5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl5Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(26, 26, 26))
        );
        pnl5Layout.setVerticalGroup(
            pnl5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pnl6.setBackground(new java.awt.Color(102, 102, 102));
        pnl6.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl6.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 204, 0));
        jLabel8.setText("X2");

        javax.swing.GroupLayout pnl6Layout = new javax.swing.GroupLayout(pnl6);
        pnl6.setLayout(pnl6Layout);
        pnl6Layout.setHorizontalGroup(
            pnl6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel8)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnl6Layout.setVerticalGroup(
            pnl6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl6Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(22, 22, 22))
        );

        pnl7.setBackground(new java.awt.Color(102, 102, 102));
        pnl7.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl7.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("+1 LIFE");

        javax.swing.GroupLayout pnl7Layout = new javax.swing.GroupLayout(pnl7);
        pnl7.setLayout(pnl7Layout);
        pnl7Layout.setHorizontalGroup(
            pnl7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl7Layout.setVerticalGroup(
            pnl7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl7Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(22, 22, 22))
        );

        pnl8.setBackground(new java.awt.Color(102, 102, 102));
        pnl8.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl8.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("8");

        javax.swing.GroupLayout pnl8Layout = new javax.swing.GroupLayout(pnl8);
        pnl8.setLayout(pnl8Layout);
        pnl8Layout.setHorizontalGroup(
            pnl8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl8Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(26, 26, 26))
        );
        pnl8Layout.setVerticalGroup(
            pnl8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel10)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pnl9.setBackground(new java.awt.Color(102, 102, 102));
        pnl9.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl9.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("ERASE");

        javax.swing.GroupLayout pnl9Layout = new javax.swing.GroupLayout(pnl9);
        pnl9.setLayout(pnl9Layout);
        pnl9Layout.setHorizontalGroup(
            pnl9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl9Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );
        pnl9Layout.setVerticalGroup(
            pnl9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel11)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pnl14.setBackground(new java.awt.Color(102, 102, 102));
        pnl14.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl14.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("EXIT");

        javax.swing.GroupLayout pnl14Layout = new javax.swing.GroupLayout(pnl14);
        pnl14.setLayout(pnl14Layout);
        pnl14Layout.setHorizontalGroup(
            pnl14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl14Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(18, 18, 18))
        );
        pnl14Layout.setVerticalGroup(
            pnl14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl14Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl13.setBackground(new java.awt.Color(102, 102, 102));
        pnl13.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl13.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setText("POINT");

        javax.swing.GroupLayout pnl13Layout = new javax.swing.GroupLayout(pnl13);
        pnl13.setLayout(pnl13Layout);
        pnl13Layout.setHorizontalGroup(
            pnl13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl13Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap())
        );
        pnl13Layout.setVerticalGroup(
            pnl13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl13Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(21, 21, 21))
        );

        pnl15.setBackground(new java.awt.Color(102, 102, 102));
        pnl15.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl15.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 204, 0));
        jLabel17.setText("£10");

        javax.swing.GroupLayout pnl15Layout = new javax.swing.GroupLayout(pnl15);
        pnl15.setLayout(pnl15Layout);
        pnl15Layout.setHorizontalGroup(
            pnl15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl15Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(18, 18, 18))
        );
        pnl15Layout.setVerticalGroup(
            pnl15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl15Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl16.setBackground(new java.awt.Color(102, 102, 102));
        pnl16.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl16.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 204, 0));
        jLabel18.setText("X5");

        javax.swing.GroupLayout pnl16Layout = new javax.swing.GroupLayout(pnl16);
        pnl16.setLayout(pnl16Layout);
        pnl16Layout.setHorizontalGroup(
            pnl16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl16Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(20, 20, 20))
        );
        pnl16Layout.setVerticalGroup(
            pnl16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl16Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl17.setBackground(new java.awt.Color(102, 102, 102));
        pnl17.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl17.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("ERASE");

        javax.swing.GroupLayout pnl17Layout = new javax.swing.GroupLayout(pnl17);
        pnl17.setLayout(pnl17Layout);
        pnl17Layout.setHorizontalGroup(
            pnl17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl17Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addContainerGap())
        );
        pnl17Layout.setVerticalGroup(
            pnl17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl17Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl18.setBackground(new java.awt.Color(102, 102, 102));
        pnl18.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl18.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("?");

        javax.swing.GroupLayout pnl18Layout = new javax.swing.GroupLayout(pnl18);
        pnl18.setLayout(pnl18Layout);
        pnl18Layout.setHorizontalGroup(
            pnl18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl18Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel20)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pnl18Layout.setVerticalGroup(
            pnl18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl18Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl19.setBackground(new java.awt.Color(102, 102, 102));
        pnl19.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl19.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("19");

        javax.swing.GroupLayout pnl19Layout = new javax.swing.GroupLayout(pnl19);
        pnl19.setLayout(pnl19Layout);
        pnl19Layout.setHorizontalGroup(
            pnl19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl19Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(23, 23, 23))
        );
        pnl19Layout.setVerticalGroup(
            pnl19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl19Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel21)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pnl20.setBackground(new java.awt.Color(102, 102, 102));
        pnl20.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl20.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("20");

        javax.swing.GroupLayout pnl20Layout = new javax.swing.GroupLayout(pnl20);
        pnl20.setLayout(pnl20Layout);
        pnl20Layout.setHorizontalGroup(
            pnl20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl20Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(23, 23, 23))
        );
        pnl20Layout.setVerticalGroup(
            pnl20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl20Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl21.setBackground(new java.awt.Color(102, 102, 102));
        pnl21.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl21.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("21");

        javax.swing.GroupLayout pnl21Layout = new javax.swing.GroupLayout(pnl21);
        pnl21.setLayout(pnl21Layout);
        pnl21Layout.setHorizontalGroup(
            pnl21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl21Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel23)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnl21Layout.setVerticalGroup(
            pnl21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(22, 22, 22))
        );

        pnl25.setBackground(new java.awt.Color(102, 102, 102));
        pnl25.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl25.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 204, 0));
        jLabel27.setText("£60");

        javax.swing.GroupLayout pnl25Layout = new javax.swing.GroupLayout(pnl25);
        pnl25.setLayout(pnl25Layout);
        pnl25Layout.setHorizontalGroup(
            pnl25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl25Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        pnl25Layout.setVerticalGroup(
            pnl25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl25Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel27)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnl24.setBackground(new java.awt.Color(102, 102, 102));
        pnl24.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl24.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 204, 0));
        jLabel26.setText("£10");

        javax.swing.GroupLayout pnl24Layout = new javax.swing.GroupLayout(pnl24);
        pnl24.setLayout(pnl24Layout);
        pnl24Layout.setHorizontalGroup(
            pnl24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl24Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(18, 18, 18))
        );
        pnl24Layout.setVerticalGroup(
            pnl24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl24Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel26)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnl23.setBackground(new java.awt.Color(102, 102, 102));
        pnl23.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl23.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("23");

        javax.swing.GroupLayout pnl23Layout = new javax.swing.GroupLayout(pnl23);
        pnl23.setLayout(pnl23Layout);
        pnl23Layout.setHorizontalGroup(
            pnl23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl23Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel25)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnl23Layout.setVerticalGroup(
            pnl23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl23Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel25)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pnl22.setBackground(new java.awt.Color(102, 102, 102));
        pnl22.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl22.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel24.setForeground(new java.awt.Color(0, 0, 255));
        jLabel24.setText("POINT");

        javax.swing.GroupLayout pnl22Layout = new javax.swing.GroupLayout(pnl22);
        pnl22.setLayout(pnl22Layout);
        pnl22Layout.setHorizontalGroup(
            pnl22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl22Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addContainerGap())
        );
        pnl22Layout.setVerticalGroup(
            pnl22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(22, 22, 22))
        );

        pnl12.setBackground(new java.awt.Color(102, 102, 102));
        pnl12.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl12.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("12");

        javax.swing.GroupLayout pnl12Layout = new javax.swing.GroupLayout(pnl12);
        pnl12.setLayout(pnl12Layout);
        pnl12Layout.setHorizontalGroup(
            pnl12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl12Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel14)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnl12Layout.setVerticalGroup(
            pnl12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel14)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pnl11.setBackground(new java.awt.Color(102, 102, 102));
        pnl11.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl11.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("11");

        javax.swing.GroupLayout pnl11Layout = new javax.swing.GroupLayout(pnl11);
        pnl11.setLayout(pnl11Layout);
        pnl11Layout.setHorizontalGroup(
            pnl11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl11Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel13)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnl11Layout.setVerticalGroup(
            pnl11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl11Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel13)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pnl10.setBackground(new java.awt.Color(102, 102, 102));
        pnl10.setMaximumSize(new java.awt.Dimension(60, 60));
        pnl10.setMinimumSize(new java.awt.Dimension(60, 60));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("10");

        javax.swing.GroupLayout pnl10Layout = new javax.swing.GroupLayout(pnl10);
        pnl10.setLayout(pnl10Layout);
        pnl10Layout.setHorizontalGroup(
            pnl10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel12)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnl10Layout.setVerticalGroup(
            pnl10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl10Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(22, 22, 22))
        );

        pnlScore.setBackground(new java.awt.Color(204, 153, 255));

        btnPlay.setText("Play!");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        txtNum.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNum.setText("1");

        javax.swing.GroupLayout pnlSpinLayout = new javax.swing.GroupLayout(pnlSpin);
        pnlSpin.setLayout(pnlSpinLayout);
        pnlSpinLayout.setHorizontalGroup(
            pnlSpinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        pnlSpinLayout.setVerticalGroup(
            pnlSpinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSpinLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtNum))
        );

        btnHigh.setText("High");
        btnHigh.setEnabled(false);
        btnHigh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHighActionPerformed(evt);
            }
        });

        btnLow.setText("Low");
        btnLow.setEnabled(false);
        btnLow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLowActionPerformed(evt);
            }
        });

        txtPrize.setText("PRIZE: £");

        txtLives.setText("Lives: 0");

        jLabel2.setText("Points:");

        txt1.setText("1");

        txt2.setText("2");

        txt3.setText("3");

        txt4.setText("SPIN");

        txt5.setText("5");

        txt6.setText("6");

        txt7.setText("7");

        txt8.setText("8");

        txt9.setText("£10");

        txt10.setText("£20");

        txt11.setText("£40");

        txt12.setText("£80");

        btnTake.setText("Take");
        btnTake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTakeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlScoreLayout = new javax.swing.GroupLayout(pnlScore);
        pnlScore.setLayout(pnlScoreLayout);
        pnlScoreLayout.setHorizontalGroup(
            pnlScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlScoreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlScoreLayout.createSequentialGroup()
                        .addComponent(btnPlay)
                        .addGap(18, 18, 18)
                        .addComponent(btnTake))
                    .addComponent(jLabel2)
                    .addGroup(pnlScoreLayout.createSequentialGroup()
                        .addComponent(txt1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlScoreLayout.createSequentialGroup()
                                .addComponent(txt4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt12))
                            .addGroup(pnlScoreLayout.createSequentialGroup()
                                .addComponent(btnLow)
                                .addGap(18, 18, 18)
                                .addGroup(pnlScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrize)
                                    .addGroup(pnlScoreLayout.createSequentialGroup()
                                        .addComponent(pnlSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnHigh))
                                    .addComponent(txtLives))))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnlScoreLayout.setVerticalGroup(
            pnlScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlScoreLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLow)
                    .addComponent(pnlSpin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHigh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPrize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLives)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt1)
                    .addComponent(txt2)
                    .addComponent(txt3)
                    .addComponent(txt4)
                    .addComponent(txt5)
                    .addComponent(txt6)
                    .addComponent(txt7)
                    .addComponent(txt8)
                    .addComponent(txt9)
                    .addComponent(txt10)
                    .addComponent(txt11)
                    .addComponent(txt12))
                .addGap(21, 21, 21)
                .addGroup(pnlScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPlay)
                    .addComponent(btnTake))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnl25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(START, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnl4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnl5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnl6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnl7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnl8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnl10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnl9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnl11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnl12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnl13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(START, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnl4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnl5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnl6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnl7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnl8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnl25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnl24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnl23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnl20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        scroll("");
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnLowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLowActionPerformed
        scroll("low");
    }//GEN-LAST:event_btnLowActionPerformed

    private void btnHighActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHighActionPerformed
        scroll("high");
    }//GEN-LAST:event_btnHighActionPerformed

    private void btnTakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTakeActionPerformed
        exit();
    }//GEN-LAST:event_btnTakeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel START;
    private javax.swing.JButton btnHigh;
    private javax.swing.JButton btnLow;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnTake;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl10;
    private javax.swing.JPanel pnl11;
    private javax.swing.JPanel pnl12;
    private javax.swing.JPanel pnl13;
    private javax.swing.JPanel pnl14;
    private javax.swing.JPanel pnl15;
    private javax.swing.JPanel pnl16;
    private javax.swing.JPanel pnl17;
    private javax.swing.JPanel pnl18;
    private javax.swing.JPanel pnl19;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnl20;
    private javax.swing.JPanel pnl21;
    private javax.swing.JPanel pnl22;
    private javax.swing.JPanel pnl23;
    private javax.swing.JPanel pnl24;
    private javax.swing.JPanel pnl25;
    private javax.swing.JPanel pnl3;
    private javax.swing.JPanel pnl4;
    private javax.swing.JPanel pnl5;
    private javax.swing.JPanel pnl6;
    private javax.swing.JPanel pnl7;
    private javax.swing.JPanel pnl8;
    private javax.swing.JPanel pnl9;
    private javax.swing.JPanel pnlScore;
    private javax.swing.JPanel pnlSpin;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt10;
    private javax.swing.JLabel txt11;
    private javax.swing.JLabel txt12;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    private javax.swing.JLabel txt4;
    private javax.swing.JLabel txt5;
    private javax.swing.JLabel txt6;
    private javax.swing.JLabel txt7;
    private javax.swing.JLabel txt8;
    private javax.swing.JLabel txt9;
    private javax.swing.JLabel txtLives;
    private javax.swing.JLabel txtNum;
    private javax.swing.JLabel txtPrize;
    // End of variables declaration//GEN-END:variables
}
