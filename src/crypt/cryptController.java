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

            if (theView.infileb) {
                theModel.readTextFile(theView.getInput());
            } else {
                theModel.setMsg(theView.getInput());
            }

            if (theView.keyfileb) {
                theModel.readKey(theView.getKey());
            } else {
                theModel.setKey(theView.getKey());
            }

            theModel.encrypt();
            String crypted = theModel.getCrypt();
            if (!theModel.error) {
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
}
