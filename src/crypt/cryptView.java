package crypt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cryptView extends JFrame {

    public JPanel root;
    public JCheckBox infile;
    public JCheckBox keyfile;
    public JCheckBox outfile;
    public JButton runButton;
    public JTextField inText;
    public JTextField keyText;
    public JTextField outText;          //Kanske ersättas med textArea om det inte går att skriva i
    public JButton hejsan = new JButton("hejsan");      //This works, but why?

    boolean infileb = false;
    boolean outfileb = false;
    boolean keyfileb = false;

    cryptView() {
        JFrame cryptPanel = new JFrame("cryptView");
        //this.setContentPane(new cryptView().root);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);


        // om jag addar med this.add så läggs de i fönstret om de är skapade som 'hejsan'
        // att lägga cryptPanel så funkar dock inte
        cryptPanel.add(infile);
        cryptPanel.add(keyfile);
        cryptPanel.add(outfile);
        cryptPanel.add(runButton);
        cryptPanel.add(inText);
        cryptPanel.add(keyText);
        cryptPanel.add(outText);
        //cryptPanel.add(root);
        this.add(cryptPanel);

        cryptPanel.setVisible(true);

        infile.addActionListener(new ActionListener() {            //Får jag använda de här funktionerna? idk, vet inte varför inte
            @Override
            public void actionPerformed(ActionEvent e) {
                infileb = !infileb;
                System.out.println(infileb);            //testing
            }
        });
        keyfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyfileb = !keyfileb;
            }
        });
        outfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outfileb = !outfileb;
                outText.setEditable(outfileb);
            }
        });


        //frame.pack();
        //frame.setVisible(true);
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

    /*
    public static void main(String[] args) {
        JFrame frame = new JFrame("cryptView");
        frame.setContentPane(new cryptView().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

     */
}
