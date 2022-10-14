package crypt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cryptView extends JFrame {

    private JPanel root;
    private JCheckBox infile;
    private JCheckBox keyfile;
    private JCheckBox outfile;
    private JButton runButton;
    private JTextField inText;
    private JTextField keyText;
    private JTextField outText;
    private JTextArea textArea1;
    private JButton Decrypt;

    boolean infileb = false;
    boolean outfileb = false;
    boolean keyfileb = false;

    public cryptView() {

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

        Decrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inText.setText(outText.getText());
            }
        });
    }

    public JPanel getPanel() {
        return root;
    }


    public String getInput() {
        return inText.getText();
    }

    public String getKey() {
        return keyText.getText();
    }

    public void setOuttext(String crypted) {
        outText.setText(crypted);
        textArea1.append(crypted + "\n");
    }

    void addRunListener(ActionListener running) {
        runButton.addActionListener(running);
    }

    public String getcryptfile() {
        return outText.getText();
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
