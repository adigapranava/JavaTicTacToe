package frontEnds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class mode extends frontEndUtil{
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public mode(){
        prepareGUI();
    }
    public static void main(String[] args){
        mode  mode = new mode();
        mode.showButtonDemo();
    }
    private void prepareGUI(){
        mainFrame = new JFrame("mode");
        mainFrame.setSize(500, 500);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.getContentPane().setBackground(BACKGROUND_COLOR);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setBackground(BACKGROUND_COLOR);
        statusLabel.setForeground(TEXT_COLOR);
        headerLabel.setBackground(BACKGROUND_COLOR);
        headerLabel.setForeground(TEXT_COLOR);

        statusLabel.setSize(350,100);
        controlPanel = new JPanel();
        controlPanel.setBackground(BACKGROUND_COLOR);
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    public void showButtonDemo(){
        statusLabel.setText("Made with Love");
        statusLabel.setFont(fontReMachine);
        headerLabel.setText("Choose the mode");
        headerLabel.setFont(fontHelsky2);
        JButton easy = new JButton(" Easy ");
        easy.setBackground(X_COLOR);
        easy.setFont(fontNewsPaper2);
        easy.setFocusable(false);

        JButton hard = new JButton(" Hard ");
        hard.setBackground(O_COLOR);
        hard.setFont(fontNewsPaper2);
        hard.setFocusable(false);

        easy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                tictactoe f = new tictactoe(true,false);
            }
        });
        hard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                tictactoe f = new tictactoe(true,true);
            }
        });
        controlPanel.add(easy);
        controlPanel.add(hard);
        mainFrame.setVisible(true);
    }
}
