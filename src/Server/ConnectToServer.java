/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Code.Global;
import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author reece
 */
public final class ConnectToServer {

    private Socket socket;
    boolean success = false;

    private void setSocket(InetAddress serverAddress, int serverPort) throws Exception {
        this.socket = new Socket(serverAddress, serverPort);
    }

    public boolean setup(String command[]) {
        try {
            //Connect to the server with the SERVERS IP address
            setSocket(InetAddress.getByName(Global.ServerIP), 5026);
            System.out.println("Connected to Server: " + socket.getInetAddress());
            start(command);
        } catch (Exception ignore) {
            System.out.println("Connection to server failed.");
        }
        return success;
    }

    private void getKey() throws Exception {
        // receive file
        byte[] mybytearray = new byte[900];
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("C:\\RTC\\lockdown\\server.key");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int bytesRead = is.read(mybytearray, 0, mybytearray.length);
        int current = bytesRead;

        do {
            bytesRead = is.read(mybytearray, current, (mybytearray.length - current));
            if (bytesRead >= 0) {
                current += bytesRead;
            }
        } while (bytesRead > -1);

        bos.write(mybytearray, 0, current);
        bos.flush();
        System.out.println("The key was downlaoded (" + current + " bytes read)");
    }

    private void start(String command[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        String str = reader.readLine();
        while (str.equals("Waiting for server to become available...")) {
            try {
                str = reader.readLine();
                System.out.println(str);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        System.out.println(str);
        System.out.println("Server requests a response for what we want...");

        if (command[0].equals("registerClient")) {
            //Command[0] = Response to server.
            //Command[1] = Server password.

            //Send the register command
            System.out.println("We're going to try and register...");
            out.println(command[0]);
            out.flush();

            //Send the client name...
            str = reader.readLine();
            System.out.println(str);
            System.out.println("Sending client name...");
            out.println(Global.ClientID);
            out.flush();

            //Get server response
            str = reader.readLine();
            System.out.println(str);

            //Send this machine IP to server...
            System.out.println("Sending IP...");
            //Send the clients local IP
            out.println(Inet4Address.getLocalHost().getHostAddress());
            out.flush();

            //Get server response
            str = reader.readLine();
            System.out.println(str);

            //Finalise.
            System.out.println("Sending password...");
            //Sent the admin password
            out.println(command[1]);
            System.out.println(command[1]);
            str = reader.readLine();
            System.out.println(str);
            if (str.equals("Registered")) {
                try {
                    getKey();
                    success = true;
                } catch (Exception ex) {
                    Logger.getLogger(ConnectToServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("Password might be incorrect, or out of sync with server...");
            }
            out.flush();
            out.close();
            reader.close();
        } else if (command[0].equals("login")) {
            //Command[0] = response to server.

            System.out.println("Trying to sign in using the server...");
            out.println(command[0]);
            out.flush();
            out.println(command[1]);
            out.flush();
            out.println(command[2]);
            out.flush();
            String response = reader.readLine();
            if (response.equals("valid")) {
                System.out.println("login successful!");
            } else {
                System.out.println("Login unsuccessful...");
            }
            out.close();
            reader.close();
        }
    }
}
