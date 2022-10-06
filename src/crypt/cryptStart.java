package crypt;

public class cryptStart {
    public static void main(String[] args) {
        cryptView theView = new cryptView();
        cryptModel theModel = new cryptModel();
        cryptController theController = new cryptController(theView,theModel);
        theView.setVisible(true);
    }
}
