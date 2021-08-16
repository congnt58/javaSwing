package com.congnt.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

public class App {
    private JButton button1;
    private JTextField textField1;
    private JTextPane textPane1;
    private JPanel panelMain;

    public App() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // JOptionPane.showMessageDialog(null, textField1.getText());
                String t = textField1.getText();
                HoanVi hoanVi = new HoanVi(t);
                textPane1.setText("Da copy");
                StringSelection stringSelection = new StringSelection(hoanVi.getStringResult());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        });


    }

    public static void main(String[] args) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        App app = new App();
        Dimension panelSize = app.panelMain.getPreferredSize();
        JFrame frame = new JFrame("AppCopy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(((dim.width)/2) - (panelSize.width/2), ((dim.height)/2) - (panelSize.height));
        frame.setContentPane(app.panelMain );
        frame.pack();
        frame.setVisible(true);
    }

}
