package Code;

import java.awt.Desktop;
import java.io.*;
import javax.swing.JOptionPane;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

/**
 *
 * @author reece
 */
public class Update {

    Global message = new Global();
    Security sec = new Security();

    public boolean check() throws Exception {
        URL url = new URL("https://accessremote.uk/RTC/curVer.txt");
        Scanner s = new Scanner(url.openStream());
        Global.newVer = s.nextLine();
        if (Global.newVer.equals("")) {
            return true;
        } else {
            return !Global.newVer.equals(Global.currentVersion);
        }
    }

    public void available() {
        int res = JOptionPane.showConfirmDialog(null, "NOTICE: Access Remote reports a different version is available.\n"
                + "Current Version: " + Global.currentVersion + "\n"
                + "New Version: " + Global.newVer + "\n"
                + "Update now?\n"
                        + "*By selecting 'no', you withdraw access to this application.\n"
                        + "**By selecting 'yes' you consent to this update, which may modify application files.", "Update Found!", JOptionPane.YES_NO_OPTION);
        if (res == 0) {
            try {
                download();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void download() throws Exception {
        sec.saveLog("The admin software is being updated...");
        URL website = new URL("https://accessremote.uk/media/software/update/updater.jar");
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream("update.jar");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        URL app = new URL("https://accessremote.uk/media/software/update/Casino.jar");
        FileOutputStream fos2 = new FileOutputStream("new.download");
        ReadableByteChannel rbc2 = Channels.newChannel(app.openStream());
        fos2.getChannel().transferFrom(rbc2, 0, Long.MAX_VALUE);
        //text file, should be opening in default text editor
        sec.saveLog("Installing update...");
        install();
    }

    private void install() throws IOException {
        if (!Desktop.isDesktopSupported()) {
            message.displayMessage(8, "Error");
        } else {
            Runtime.getRuntime().exec("java -jar update.jar 1");
        }
    }
}
