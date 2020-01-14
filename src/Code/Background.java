/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import loader.MemberLoader;
import model.User;

/**
 *
 * @author reece
 */
public class Background {

    private final Security sec = new Security();

    public void setBalance(double input) {
        Global.balance = input;
        updateUser();
    }

    private ArrayList<User> loadUserList() {
        MemberLoader memberLoader = new MemberLoader();
        ArrayList<User> memberList = new ArrayList<>();
        try {
            String[] membersList = sec.decDetails("members");
            for (int i = 0; i < membersList.length; i++) {
                memberList = memberLoader.loadMember(membersList[i]);
            }
        } catch (Exception ex) {
            Logger.getLogger(Background.class.getName()).log(Level.SEVERE, null, ex);
        }
        return memberList;
    }

    private void updateUser() {
        ArrayList<User> members = loadUserList();
        Object[][] data = new Object[members.size()][7];
        for (int i = 0; i < members.size(); i++) {
            User member = members.get(i);
            data[i][0] = member.getId();
            data[i][1] = member.getName();
            data[i][2] = member.getAddress();
            data[i][3] = member.getPhone();
            data[i][4] = member.getActive();
            data[i][5] = member.getPassword();
            data[i][6] = Global.balance;
            if (String.valueOf(data[i][0]).equals(Global.ID) && String.valueOf(data[i][1]).equals(Global.name)) {
                members.remove(i);
                User replace = new User();
                replace.setId(String.valueOf(data[i][0]));
                replace.setName(String.valueOf(data[i][1]));
                replace.setAddress(String.valueOf(data[i][2]));
                replace.setPhone(String.valueOf(data[i][3]));
                replace.setActive(Integer.parseInt(String.valueOf(data[i][4])));
                replace.setPassword(String.valueOf(data[i][5]));
                replace.setBalance(String.valueOf(data[i][6]));
                members.add(replace);
                writeFile();
                break;
            }
        }
    }

    private void writeFile() {
        ArrayList<User> memberList = loadUserList();
        File file = new File("C:\\RTC\\UserInfo\\members.dat");
        try {
            try (FileWriter fw3 = new FileWriter(file, false)) {
                BufferedWriter bw3 = new BufferedWriter(fw3);
                //Make sure the file is blank.
                bw3.write("");
                bw3.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "The system couldn't overwrite the file.\n" + e, "Overwrite Error", JOptionPane.WARNING_MESSAGE);
        }
        String en = Security.encryption;
        Object[][] data = new Object[memberList.size()][7];
        for (int i = 0; i < memberList.size(); i++) {
            User user = memberList.get(i);
            data[i][0] = user.getId();
            data[i][1] = user.getName();
            data[i][2] = user.getAddress();
            data[i][3] = user.getPhone();
            data[i][4] = user.getPassword();
            if (String.valueOf(data[i][0]).equals(Global.ID) && String.valueOf(data[i][1]).equals(Global.name)) {
                data[i][5] = Global.balance;
            } else {
                data[i][5] = user.getBalance();
            }
            data[i][6] = user.getActive();
            //Try to write the above information to the file.

            StringBuilder build = new StringBuilder();
            build.append(data[i][0]).append(en).append(data[i][1]).append(en).append(data[i][2]).append(en).append(data[i][3]).append(en).append(data[i][4]).append(en).append(data[i][5]).append(en).append(data[i][6]);

            try {
                sec.encDetails(String.valueOf(build), "members");
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public boolean verifyUser(boolean domain) {
        if (!domain) {
            System.out.println("Local account is being used.");
            ArrayList<User> members = loadUserList();
            Object[][] data = new Object[members.size()][5];
            for (int i = 0; i < members.size(); i++) {
                User member = members.get(i);
                data[i][0] = member.getId();
                data[i][1] = member.getName();
                data[i][3] = member.getActive();
                data[i][4] = member.getBalance();
                Global.balance = Double.parseDouble(String.valueOf(data[i][4]));
                if (String.valueOf(data[i][0]).equals(Global.ID) && String.valueOf(data[i][1]).equals(Global.name)) {
                    if (Integer.parseInt(String.valueOf(data[i][3])) == 1) {
                        return true;
                    }
                    break;
                }
            }
        } else {
            System.out.println("A domain account is being used...");
            // Send user ID to server which returns a true of false value.
        }

        return false;
    }

    public double getBet() {
        return Global.curBet;
    }

    public void setBet(double bet) {
        Global.curBet = bet;
    }

    public double getRTCWins(int[] reel, double bet) {
        /*
        1 = AR
        2 = A
        3 = 7
        4 = D
        5 = K
        6 = P
        7 = WIN
        8 = J
        9 = BONUS
        10 = Q
        THE SEQUENCE FAILS HERE - REQUIRES RE EVALUATION
        11 = P
        12 = EMPTY
        13 = J
         */
        int reel1 = reel[0];
        int reel2 = reel[1];
        int reel3 = reel[2];
        double winnings = 0.0;

        switch (reel1) {
            case 1:
                switch (reel2) {
                    case 1:
                        switch (reel3) {
                            case 1:
                                winnings = bet * 25;
                                break;
                        }
                        break;
                }
                break;
            case 2:
                switch (reel2) {
                    case 2:
                        switch (reel3) {
                            case 2:
                                winnings = bet * 0.1;
                                break;
                        }
                        break;
                }
                break;
            case 3:
                switch (reel2) {
                    case 3:
                        switch (reel3) {
                            case 3:
                                winnings = bet * 50;
                                break;
                        }
                        break;
                }
                break;
            case 4:
                switch (reel2) {
                    case 4:
                        switch (reel3) {
                            case 4:
                                winnings = bet * 3;
                                break;
                        }
                        break;
                }
                break;
            case 5:
                switch (reel2) {
                    case 5:
                        switch (reel3) {
                            case 5:
                                winnings = bet;
                        }
                        break;
                }
                break;
            case 6:
                switch (reel2) {
                    case 11:
                        switch (reel3) {
                            case 11:
                                winnings = bet / 2;
                                break;
                            case 6:
                                winnings = bet / 2;
                                break;
                        }
                        break;
                    case 6:
                        switch (reel3) {
                            case 6:
                                winnings = bet / 2;
                                break;
                            case 11:
                                winnings = bet / 2;
                                break;
                        }
                        break;
                }
                break;
            case 7:
                switch (reel2) {
                    case 7:
                        switch (reel3) {
                            case 7:
                                winnings = 250;
                                break;
                        }
                        break;
                }
                break;
            case 8:
                switch (reel2) {
                    case 13:
                        switch (reel3) {
                            case 13:
                                winnings = bet * 5;
                                break;
                            case 8:
                                winnings = bet * 5;
                                break;
                        }
                    case 8:
                        switch (reel3) {
                            case 13:
                                winnings = bet * 5;
                                break;
                            case 8:
                                winnings = bet * 5;
                                break;
                        }
                        break;
                }
                break;
            case 10:
                switch (reel2) {
                    case 10:
                        switch (reel3) {
                            case 10:
                                winnings = bet;
                                break;
                        }
                        break;
                }
                break;
            case 11:
                switch (reel2) {
                    case 6:
                        switch (reel3) {
                            case 6:
                                winnings = bet / 2;
                                break;
                            case 11:
                                winnings = bet / 2;
                                break;
                        }
                        break;
                    case 11:
                        switch (reel3) {
                            case 11:
                                winnings = bet / 2;
                                break;
                            case 6:
                                winnings = bet / 2;
                                break;
                        }
                        break;
                }
                break;
            case 12:
                switch (reel2) {
                    case 12:
                        switch (reel3) {
                            case 12:
                                winnings = bet * 2500;
                                break;
                        }
                        break;
                }
                break;
            case 13:
                switch (reel2) {
                    case 8:
                        switch (reel3) {
                            case 13:
                                winnings = bet * 5;
                                break;
                            case 8:
                                winnings = bet * 5;
                                break;
                        }
                    case 13:
                        switch (reel3) {
                            case 8:
                                winnings = bet * 5;
                                break;
                            case 13:
                                winnings = bet * 5;
                                break;
                        }
                        break;
                }
                break;
            default:
                winnings = 0.0;
        }
        return winnings;
    }
}
