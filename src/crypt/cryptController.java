package crypt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cryptController extends JFrame {
    cryptView theView;
    cryptModel theModel;

    public cryptController(cryptView theView, cryptModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.setContentPane(theView.getPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setVisible(true);

        this.theView.addRunListener(new runListener());
    }


    private class runListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String in = theView.getInput();
                if (theView.infileb) {
                    in = theModel.readTextFile(in);
                }
                String keyS = theView.getKey();
                if (theView.keyfileb) {
                    keyS = theModel.readKey(keyS);
                }
                String crypted = theModel.crypt(in, keyS);
                if (theView.outfileb) {
                    String cryptFile = theView.getcryptfile();
                    theModel.writeCryptfileOut(crypted, cryptFile);
                } else {
                    theView.setOuttext(crypted);
                }
            System.out.println("Programmet spottade ut ett svar: " + crypted);      //testing
        }
    }
}
