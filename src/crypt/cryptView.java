package crypt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cryptView {
    public JPanel root;
    public JCheckBox infile;
    public JCheckBox keyfile;
    public JButton runButton;
    public JTextField inText;
    public JTextField keyText;
    public JTextField outText;          //Kanske ersättas med textArea om det inte går att skriva i
    public JCheckBox outfile;

    boolean infileb = false;
    boolean outfileb = false;
    boolean keyfileb = false;

    public cryptView() {
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                if(inFileBool == false) {
                    readInput(inText);                      //finns inte än
                } else {
                    readTextfile(inText);
                }

                if (decryptBool == false){
                    String s = crypt(inText, keyText, outText);
                } else {
                    String s = decrypt(intext, keyText, outText);
                }
                outText.append(s);
                writeCryptfileOut();                        // finns inte än

                 */                         //utdaterat, ska deletas
            }
        });
        infile.addActionListener(new ActionListener() {            //Får jag använda de här funktionerna? idk, vet inte varför inte
            @Override
            public void actionPerformed(ActionEvent e) {
                //flippa bool
                infileb = !infileb;
                System.out.println(infileb);
            }
        });
        keyfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //flippa bool
                keyfileb = !keyfileb;
            }
        });
        outfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //flippa bool
                //Kanske flippa om OutText rutan är editable.
                outfileb = !outfileb;
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("cryptView");
        frame.setContentPane(new cryptView().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public String getInput() {
        return inText.getText();
    }

    public String getKey() {
        return keyText.getText();
    }

    public void setOuttext(String crypted) {
        outText.setText(crypted);
    }

    void addRunListener(ActionListener running) {
        runButton.addActionListener(running);
    }
}
