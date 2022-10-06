package crypt;

import java.io.*;


public class cryptModel {
    String filnamn = "cryptIn.txt";
    String meddelande;
    String keyfilnamn = "cryptkey.txt";
    String key;
    String crypted;
    String cryptOut = "cryptOut.txt";
    //String cryptOut2 = "cryptOut2.txt";
    char esdfgh = 'e';

    public String readTextFile(String filnamn, String meddelande) {
        FileReader fr = null;
        try {
            fr = new FileReader(filnamn);
            BufferedReader inFil = new BufferedReader(fr);
            meddelande = inFil.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return meddelande;
    }

    public String crypt(String key, String meddelande) {
        String crypted = encrypt(meddelande, key);
        return crypted;
    }

    public String readKey(String key, String keyfilnamn) {
        try {
            FileReader fr2 = new FileReader(keyfilnamn);
            BufferedReader inFil2 = new BufferedReader(fr2);
            key = inFil2.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return key;
    }

    public String encrypt(String meddelande, String key) {
        String out = "";
        while (key.length() < meddelande.length()) {
            key = expandKey(key);
        }
        for (int i = 0; i < meddelande.length(); i++) {
            char cIn = meddelande.charAt(i);
            char keey = key.charAt(i);
            char cOut = (char) (cIn^keey);
            out = out + cOut;
        }
        return out;
    }

    public String expandKey (String key) {
        return key+key;
    }

    public String deEncrypt(String meddelande, String key) {            //idk varför det här är här, att cryptera och deCryptera är samma sak här
        String out = "";
        char keey = key.charAt(0);
        for (int i = 0; i < meddelande.length(); i++) {
            char cIn = meddelande.charAt(i);
            char cOut = (char) (cIn^keey);
            out = out + cOut;
        }
        return out;
    }

    public void writeCryptfileOut(String cryptedThing, String cryptOut) {           //Just nu printar det i både binärt och text i olika filer.
        try {
            FileWriter fw = new FileWriter(cryptOut);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter utFil = new PrintWriter(bw);

            utFil.println(cryptedThing);

            utFil.flush();
            utFil.close();

            DataOutputStream output2 = new DataOutputStream (new BufferedOutputStream(new FileOutputStream("cryptOut2.txt")));

            for (int o = 0; o < cryptedThing.length(); o++) {
                output2.writeBytes(String.valueOf(Integer.parseInt(Integer.toBinaryString(cryptedThing.charAt(o)))) + ' ');
            }

            output2.flush();
            output2.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        cryptModel test = new cryptModel();

        test.meddelande = test.readTextFile(test.filnamn, test.meddelande);
        test.key = test.readKey(test.key, test.keyfilnamn);
        test.crypted = test.crypt(test.key, test.meddelande);
        test.writeCryptfileOut(test.crypted, test.cryptOut);

        System.out.println(test.crypted);
    }
}

