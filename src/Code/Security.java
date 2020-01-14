/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.io.*;
import java.net.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

/**
 *
 * @author Reece
 */
public class Security {

    /**
     *
     */
    public static final String encryption = "::";
    
    public void saveLog(String input) {
        File file = new File("C:\\RTC\\data.temp");
        if (!file.exists()) {
            createLog(input, file);
        } else {
            try {
                FileWriter fw = new FileWriter(file, true);
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.append(getTime() + ": " + input);
                    bw.newLine();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error Code: W1", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void createLog(String temp, File file) {
        try {
            FileWriter fw = new FileWriter(file);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.append("");
                bw.close();
                saveLog(temp);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error Code: W1", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getTime() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String time = String.valueOf(dateFormat.format(date));
        return time;
    }
    public String getAdminPassword() throws Exception {
        return decrypt("C:\\RTC\\lockdown\\", "data.dat");
    }

    public boolean verify(String input) {
        boolean valid;

        //String user = getUserName();
        String read = "";
        try {
            BufferedReader reader;
            try (FileReader file = new FileReader("C:\\RTC\\lockdown\\keyCode.sec")) {
                reader = new BufferedReader(file);
                read = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
        }

        String computerName = getCompName();
        String computerNameInput = "";

        try {
            BufferedReader reader;
            try (FileReader file = new FileReader("F:\\RTC\\keyCode2.sec")) {
                reader = new BufferedReader(file);
                computerNameInput = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Key Not Validated", "Error 1", JOptionPane.ERROR_MESSAGE);
        }

        valid = input.equals(read) && computerName.equals(computerNameInput);
        return valid;
    }

    //Get the computers name
    protected String getCompName() {
        String retVal = "";
        try {
            retVal = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "OS Error", "You must be running a supported OS!", JOptionPane.ERROR_MESSAGE);
        }
        return retVal;
    }

    public void encryptFile(String path, String file, String input) throws Exception {
        encrypt(path, file, input, "C:\\RTC\\lockdown\\data.key");
    }

    //encrypt any information with the key generated
    private void encrypt(String path, String file, String input, String keyFile) throws Exception {
        byte[] encrypted = retEnc(input, keyFile);
        boolean overwrite = false;
        if (file.equals("members.dat")) {
            overwrite = true;
        }
        try {
            FileOutputStream fs = new FileOutputStream(path + file, overwrite);
            fs.write(encrypted);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Key Error. Key may not exist.", "Error Encrypting!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public byte[] retEnc(String input, String keyFile) throws Exception {
        byte[] text = input.getBytes("UTF8");

        byte[] encKey;
        try (FileInputStream keyFis = new FileInputStream(keyFile)) {
            encKey = new byte[keyFis.available()];
            keyFis.read(encKey);
        }
        Key key = new SecretKeySpec(encKey, "DES");

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(text);
    }

    private byte[] retKey() { //Load the key file
        byte[] encKey = null;
        try (FileInputStream keyFis = new FileInputStream("C:\\RTC\\lockdown\\data.key")) {
            encKey = new byte[keyFis.available()];
            keyFis.read(encKey);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Key doesn't exist", "Decryption Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Key cannot be loaded\nPlease make sure you have the correct file permissions.", "Decryption Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
        return encKey;
    }
    
    public void prepDomainUser(String input) throws Exception {
        encrypt("C:\\RTC\\", "temp", input, "C:\\RTC\\lockdown\\server.key");
    }

    //Decrypt any information with the key generated
    private String decrypt(String path, String file) throws Exception {
        Key keyFromFile = new SecretKeySpec(retKey(), "DES"); //Load key
        File verify = new File(path + file);
        if (!verify.exists()) {
            verify.createNewFile();
        }
        byte[] encText = null;
        try (FileInputStream encryptedText = new FileInputStream(path + file)) {

            encText = new byte[encryptedText.available()];
            encryptedText.read(encText);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } //Load encrypted text //Load encrypted text

        Cipher decrypter = Cipher.getInstance("DES/ECB/PKCS5Padding");
        decrypter.init(Cipher.DECRYPT_MODE, keyFromFile);
        // Prepare decryptor

        byte[] decryptedText = decrypter.doFinal(encText); //Decrypt text
        return new String(decryptedText); //Return decrypted text as string
    }

    public String[] decDetails(String file) throws Exception {
        String decode[] = decrypt("C:\\RTC\\UserInfo\\", file + ".dat").split("##");
        return decode;
    }

    public void encDetails(String input, String file) throws Exception {
        encrypt("C:\\RTC\\UserInfo\\", file + ".dat", input + "##", "C:\\RTC\\lockdown\\data.key");
    }

    public String decAll(String path, String file) throws Exception {
        return decrypt(path, file); //Decrypt a file with input and file path, then return as plain text string
    }
}