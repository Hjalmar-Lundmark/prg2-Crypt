package crypt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cryptController {
    cryptView theView;
    cryptModel theModel;

    public cryptController(cryptView theView, cryptModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addRunListener(new runListener());
    }


    private class runListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String in = "";
            String keyS = "";
            String crypted = "";

            in = theView.getInput();
                if (theView.infileb) {
                    in = theModel.readTextFile(theModel.filnamn, theModel.meddelande);
                }
                keyS = theView.getKey();
                if (theView.keyfileb) {
                    keyS = theModel.readKey(theModel.key, theModel.keyfilnamn);
                }
                crypted = theModel.crypt(in, keyS);
                if (theView.outfileb) {
                    theModel.writeCryptfileOut(crypted, theModel.cryptOut);
                }
                theView.setOuttext(crypted);
            System.out.println("Programmet spottade ut ett svar" + crypted);

        }
    }
}
