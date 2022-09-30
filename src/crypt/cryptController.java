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
            // Surround interactions with the view with
            // a try block in case numbers weren't
            // properly entered
            try{
                in = theView.getInput();
                keyS = theView.getKey();
                if (theModel.keyFileBool) {
                    keyS = theModel.readKey(theModel.key, theModel.keyfilnamn);
                }
                theModel.crypt(in, keyS);
                theView.setOuttext(theModel.crypted);
            }
            catch(NumberFormatException ex){
                System.out.println(ex);
                //theView.displayErrorMessage("You Need to Enter 2 Integers");
            }
        }
    }
}
