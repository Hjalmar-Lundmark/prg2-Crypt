package crypt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cryptController {
    cryptView theView;
    cryptModel theModel;

    public void cryptController(cryptView theView, cryptModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addRunListener(new runListener());
    }


    private class runListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String in = "";
            String keyS = "";
            char key = ' ';
            String crypted = "";
            boolean inFileBool;
            boolean keyFileBool;
            boolean outFileBool;

            inFileBool = theView.infileb;
            keyFileBool = theView.keyfileb;
            outFileBool = theView.outfileb;

            in = theView.getInput();
                if (inFileBool) {                  //Det finns inget som flippar de här boolsen än
                    in = theModel.readTextFile(theModel.filnamn, theModel.meddelande);
                }
                keyS = theView.getKey();
                if (keyFileBool) {
                    keyS = theModel.readKey(theModel.key, theModel.keyfilnamn);
                }
                crypted = theModel.crypt(in, keyS);
                if (outFileBool) {
                    theModel.writeCryptfileOut(crypted, theModel.cryptOut);
                }
                theView.setOuttext(crypted);

        }
    }
}
