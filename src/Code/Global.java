package Code;

import javax.swing.JOptionPane;

/**
 *
 * @author reece8765
 */
public class Global {

    public static final String currentVersion = "V2.0.2";
    public static double balance;
    public static double curBet = 1.0;
    public static boolean lastWin, domainAccount = false;
    public static int loseCount, autoSpin = 0;
    public static String ID, name, ServerIP, ClientID, serverName, newVer;

    Security sec = new Security();

    private String error(int errorCode) {
        switch (errorCode) {
            case 1:
                return "Critical files failed to load! Error Code: 4000";
            case 2:
                return "Decryption Key Files Not Found! Error Code: 4001";
            case 3:
                return "Couldn't connect to the servers... Error Code: 4002";
            case 4:
                return "Couldn't determine update status... Error Code: 4003";
            case 5:
                return "Couldn't write required files... Error Code: 4004";
            case 6:
                return "This application requires the latest updates.\nYou must be online and able to access the website 'accessremote.uk'\nMake sure you're connected and try again.";
            case 7:
                return "The credentials you entered were incorrect. Error Code: 4006";
            case 8:
                return "Update Failed. Error Code: 4007";
            case 9:
                return "Invalid Input. Error Code: 4008";
            case 10:
                return "Your User Account has been Disabled by your Administrator\n"
                        + "Please seek advice from your admin.";
            default:
                return "An unknown error occured... (5000)";
        }
    }

    private String inform(int errorCode) {
        switch (errorCode) {
            default:
                return "An unknown error occured (5000)";
        }
    }

    private String warn(int errorCode) {
        switch (errorCode) {
            case 1:
                return "This option was disabled by your administrator.";
            default:
                return "An unknown error occured (5000)";
        }
    }

    public void displayMessage(int errorCode, String mode) {
        switch (mode) {
            case "Error":
                JOptionPane.showMessageDialog(null, error(errorCode), "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case "Inform":
                JOptionPane.showMessageDialog(null, inform(errorCode), "Important!", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Warn":
                JOptionPane.showMessageDialog(null, warn(errorCode), "Notice", JOptionPane.WARNING_MESSAGE);
                break;
        }

    }
}
