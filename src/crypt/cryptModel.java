package crypt;

import javax.swing.*;
import java.io.*;


public class cryptModel {
    String meddelande;
    String key;
    String crypted;
    boolean error = false;

    public void readTextFile(String filnamn) {
        try {
            FileReader fr = new FileReader(filnamn);
            BufferedReader inFil = new BufferedReader(fr);
            meddelande = inFil.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            error = true;
            System.out.println("ERROR 12");
            JOptionPane.showMessageDialog(null, "Du måste ge correkt namn på In-linkar");
        }
    }

    public void readKey(String keyfilnamn) {
        try {
            FileReader fr2 = new FileReader(keyfilnamn);
            BufferedReader inFil2 = new BufferedReader(fr2);
            key = inFil2.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            error = true;
            System.out.println("ERROR 31");
            JOptionPane.showMessageDialog(null, "Du måste ge correkt namn på Key-linkar");
        }
    }

    public void encrypt() {
        crypted = "";
        while (key.length() < meddelande.length() && !key.equals("")) {
            key = expandKey(key);
        }
        for (int i = 0; i < meddelande.length(); i++) {
            char cIn = meddelande.charAt(i);
            char keey = key.charAt(i);
            char cOut = (char) (cIn^keey);
            crypted += cOut;
        }
    }

    public String expandKey (String key) {
        return key+key;
    }

    public void writeCryptfileOut(String cryptedThing, String cryptOut) {
        try {
            DataOutputStream output2 = new DataOutputStream (new BufferedOutputStream(new FileOutputStream(cryptOut)));

            for (int o = 0; o < cryptedThing.length(); o++) {
                output2.writeByte(cryptedThing.charAt(o));
                //output2.writeBytes(String.valueOf(Integer.parseInt(Integer.toBinaryString(cryptedThing.charAt(o)))) + ' ');   //För att skriva i binärt alltså 1101001
            }

            output2.flush();
            output2.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMsg(String msg) {
        this.meddelande = msg;
    }

    public void setKey(String keeey) {
        this.key = keeey;
    }

    public String getCrypt() {
        return crypted;
    }

}

