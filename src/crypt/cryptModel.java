package crypt;

import java.io.*;


public class cryptModel {
    String meddelande;
    String key;
    String crypted;

    public String readTextFile(String filnamn) {
        try {
            FileReader fr = new FileReader(filnamn);
            BufferedReader inFil = new BufferedReader(fr);
            meddelande = inFil.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return meddelande; //kanske ta bort det här för att hämta senare
    }

    public String crypt(String meddelande, String key) {
        return encrypt(meddelande, key);
        //crypted = encrypt(meddelande, key);
    }

    public String readKey(String keyfilnamn) {
        try {
            FileReader fr2 = new FileReader(keyfilnamn);
            BufferedReader inFil2 = new BufferedReader(fr2);
            key = inFil2.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return key;        //kanske ta bort det här för att hämta senare
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
            out += cOut;
        }
        return out;
    }

    public String expandKey (String key) {
        return key+key;
    }


    public void writeCryptfileOut(String cryptedThing, String cryptOut) {           //Just nu printar det i både binärt och text i olika hårdkodade filer.
        try {
            /*
            FileWriter fw = new FileWriter(cryptOut);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter utFil = new PrintWriter(bw);

            utFil.println(cryptedThing);

            utFil.flush();
            utFil.close();

             */

            DataOutputStream output2 = new DataOutputStream (new BufferedOutputStream(new FileOutputStream(cryptOut)));

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

    public void setMsg(String msg) {
        this.meddelande = msg;
    }

    public void setkey(String keeey) {
        this.key = keeey;
    }

    public String getcrypt() {
        return crypted;
    }

}

