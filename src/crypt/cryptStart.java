package crypt;

public class cryptStart {
    public static void main(String[] args) {
        cryptView theView = new cryptView();
        cryptModel theModel = new cryptModel();
        cryptController theControllertest = new cryptController(theView,theModel);
        theControllertest.setVisible(true);
    }
}
