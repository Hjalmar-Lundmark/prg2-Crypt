package crypt;

import java.io.*;


public class cryptModel {
    String filnamn = "cryptIn.txt";
    String meddelande;
    String keyfilnamn = "cryptkey.txt";
    String key;
    String crypted;
    String cryptOut = "cryptOut.txt";
    String cryptOut2 = "cryptOut2.txt";
    Boolean inFileBool = false;
    Boolean keyFileBool = false;
    Boolean outFileBool = false;


    public void readTextFile() {
        FileReader fr = null;
        try {
            fr = new FileReader(filnamn);
            BufferedReader inFil = new BufferedReader(fr);
            meddelande = inFil.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void crypt() {
        if (key == null) {
            readKey();
        }
        crypted = encrypt(meddelande, key);
    }

    public void readKey() {
        FileReader fr2 = null;
        try {
            fr2 = new FileReader(keyfilnamn);
            BufferedReader inFil2 = new BufferedReader(fr2);
            key = inFil2.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String meddelande, String key) {
        String out = "";
        char keey = key.charAt(0);
        for (int i = 0; i < meddelande.length(); i++) {
            char cIn = meddelande.charAt(i);
            char cOut = (char) (cIn^keey);
            out = out + cOut;
        }
        return out;
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

    public void writeCryptfileOut(String cryptedThing) {
        try {
            FileWriter fw = new FileWriter("cryptOut.txt");
            BufferedWriter bw = new BufferedWriter(fw);             //något här funkar inte
            PrintWriter utFil = new PrintWriter(bw);                //Problemmet är att den skriver inget, utan den ersätter det som står där med ''
                                                                    //dock så fungerar sout på samma sak
            DataOutputStream output2 = new DataOutputStream (new BufferedOutputStream(new FileOutputStream("cryptOut2.txt")));

            for (int o = 0; o < cryptedThing.length(); o++) {
                output2.writeInt(cryptedThing.charAt(o) + ' ');
            }
            utFil.println(cryptedThing);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        cryptModel test = new cryptModel();

        test.readTextFile();
        test.crypt();
        test.writeCryptfileOut(test.crypted);

        System.out.println(test.crypted);
    }
}
// I psvm här över blir det problem om antingen inget annat är static
// ELLER om jag inte gjort en variabel av programmet och kört i det(alltså vad som står här just över)
// dock så testade jag att göra allt i static och det är det som är här under.
// Både fungerar helt och likadant just nu.

/*
public class crypt.cryptModel {
    static String filnamn = "meddelande.txt";
    static String meddelande;
    static String keyfilnamn = "key.txt";
    static String key;
    static String crypted;

    public static String readTextFile(String filnamn, String meddelande) {
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

    public static String crypt(String key, String crypted, String meddelande) {
        if (key == null) {
            key = readKey(key, keyfilnamn);
        }
        crypted = encrypt(meddelande, key);
        return crypted;
    }

    public static String  readKey(String key, String keyfilnamn) {
        FileReader fr2 = null;
        try {
            fr2 = new FileReader(keyfilnamn);
            BufferedReader inFil = new BufferedReader(fr2);
            key = inFil.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return key;
    }

    public static String encrypt(String meddelande, String key) {
        String out = "";
        char keey = key.charAt(0);
        for (int i = 0; i < meddelande.length(); i++) {
            char cIn = meddelande.charAt(i);
            char cOut = (char) (cIn^keey);
            out = out + cOut;
        }
        return out;
    }

    public static void main(String[] args) {
        meddelande = readTextFile(filnamn, meddelande);
        crypted = crypt(key, crypted, meddelande);

        System.out.println(crypted);
    }
}
*/