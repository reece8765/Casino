/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Code.Global;
import Code.Security;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author reece
 */
public class info {

    private String sName, IP, port, ID;
    Security sec = new Security();

    public void setServer(String name, String IP, String port, String ID) {
        sName = name;
        this.IP = IP;
        this.port = port;
        this.ID = ID;
        setGlobal();
    }

    public void resetServer() {
        sName = "";
        IP = "";
        port = "";
        setGlobal();
        saveSettings(false);
    }

    public String getIP() {
        return IP;
    }

    public String getName() {
        return sName;
    }

    public String getPort() {
        return port;
    }

    private void setGlobal() {
        Global.ServerIP = IP;
        Global.ClientID = ID;
        Global.serverName = sName;
    }

    protected void saveSettings(boolean keep) {
        if (keep) {
            try {
                sec.encryptFile("C:\\RTC\\lockdown\\", "server.dat", sName + "::" + IP + "::" + ID + "::");
            } catch (Exception ex) {
                Logger.getLogger(info.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            File file = new File("C:\\RTC\\lockdown\\server.dat");
            file.delete();
        }
    }

    public void loadSettings() {
        String decode[] = new String[3];
        try {
            decode = sec.decAll("C:\\RTC\\lockdown\\", "server.dat").split("::");
        } catch (Exception ex) {
            Logger.getLogger(info.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (decode != null || !decode.equals("")) {
            Global.serverName = String.valueOf(decode[0]);
            Global.ServerIP = String.valueOf(decode[1]);
            Global.ClientID = String.valueOf(decode[2]);
            setServer(Global.serverName, Global.ServerIP, "5026", Global.ClientID);
        }
    }

    public String sendFile(String filePath, String fileName) throws Exception {
        Socket socket = new Socket(getIP(), 5026);
        System.out.println("Connected to Server: " + socket.getInetAddress() + ": " + getName());
        //send file
        File myFile = new File(filePath + "\\" + fileName);
        if (!myFile.exists()) {
            JOptionPane.showMessageDialog(null, "The file " + fileName + " in the direcory \"" + filePath + "\" does not exist",
                    "File failed to send!", JOptionPane.ERROR_MESSAGE);
            socket.close();
        } else {

            byte[] mybytearray = new byte[(int) myFile.length()];
            int size = mybytearray.length;
            FileInputStream fis = new FileInputStream(myFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = reader.readLine();
            System.out.println(str);
            out.println("login");
            out.flush();
            System.out.println("Trying to login to the server...");

            //Send the file size to the server
            out.println(String.valueOf(size));
            out.flush();
            //Wait for the server to be ready
            while (!str.equals("ready")) {
                str = reader.readLine();
                System.out.println(str);
            }
            bis.read(mybytearray, 0, size);
            OutputStream os = socket.getOutputStream();
            System.out.println("Sending file: " + fileName + " (" + mybytearray.length + " bytes)");
            os.write(mybytearray, 0, mybytearray.length);
            os.flush();
            os.close();
            System.out.println("Done.");
            str = reader.readLine();
            System.out.println(str);
            reader.close();
            socket.close();
            return str;
        }
        return "The username or password is incorrect.";
    }

}
