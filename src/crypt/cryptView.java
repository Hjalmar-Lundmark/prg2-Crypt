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

    public cryptView() {
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                if(infileBool == false) {
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

                 */
            }
        });
        infile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //flippa bool
            }
        });
        outfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //flippa bool
            }
        });
        keyfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //flippa bool
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
}
