package frontEnds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.plaf.metal.MetalButtonUI;

import utils.*;
import algos.*;
import music.musicPlayer;

public class tictactoe extends frontEndUtil implements ActionListener {
    Boolean SINGELPLAYER = false;
    Boolean HARD = false;

    Character PLAYER = 'X';
    Character BOT = 'O';

    // int noOfComparision=0;
    private ArrayList<Character> origBoard = new ArrayList<Character>();

    boolean XTurn = true;

    JFrame frame = new JFrame();
    JPanel HEADDER = new JPanel();
    JLabel TITLE = new JLabel("TicTacToe");
    JPanel BODY = new JPanel();
    JPanel BOARD = new JPanel();
    ArrayList<JButton> buttons = new ArrayList<JButton>();
    JPanel FOOTER = new JPanel();
    JButton RERUN = new JButton(" ");

    public void init() {
        XTurn = true;
        for (int i = 0; i < 9; i++) {
            origBoard.set(i, ' ');
            buttons.get(i).setBackground(CELL_COLOR);
            buttons.get(i).setText("");
            buttons.get(i).setEnabled(true);
        }
    }

    tictactoe(Boolean SINGLEPLAYER, Boolean HARD){
        this.SINGELPLAYER = SINGLEPLAYER;
        this.HARD = HARD;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(SIZE, SIZE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(BACKGROUND_COLOR);

        HEADDER.setBackground(BACKGROUND_COLOR);
        HEADDER.setBounds(0, 0, SIZE, (SIZE-BOARD_SIZE)/3);

        TITLE.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        TITLE.setAlignmentY(JLabel.BOTTOM_ALIGNMENT);
        TITLE.setForeground(TEXT_COLOR);
        
        TITLE.setFont(fontHelsky);
        HEADDER.add("JLabel", TITLE);
        frame.add(HEADDER);

        BODY.setBackground(BACKGROUND_COLOR);
        BODY.setBounds(0, (SIZE-BOARD_SIZE)/3, SIZE, BOARD_SIZE);
        BODY.setLayout(null);

        BOARD.setBounds((SIZE-BOARD_SIZE)/2, 0, BOARD_SIZE, BOARD_SIZE);
        BOARD.setBackground(BACKGROUND_COLOR);
        BOARD.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            origBoard.add(' ');

            buttons.add(new JButton());
            BOARD.add(buttons.get(i));
            buttons.get(i).setBorder(borderCell);
            buttons.get(i).setForeground(BACKGROUND_COLOR);
            buttons.get(i).setBackground(CELL_COLOR);
            buttons.get(i).setFocusable(false);
            buttons.get(i).setFont(fontNewsPaper);
            buttons.get(i).addActionListener(this);

        }
        BODY.add(BOARD);
        frame.add(BODY);

        JPanel FOOTER = new JPanel();
        FOOTER.setBackground(BACKGROUND_COLOR);
        FOOTER.setBounds(0, SIZE - 2*(SIZE-BOARD_SIZE)/3 +10, SIZE, 2*(SIZE-BOARD_SIZE)/3);
        RERUN.addActionListener(this);
        RERUN.setBackground(X_COLOR);
        RERUN.setEnabled(false);
        RERUN.setFocusable(false);
        FOOTER.add(RERUN);
        frame.add(FOOTER);
        // System.out.println(buttons[0].getText().equals(""));
    }

    public void displayWinningTripplets(int winningPairs[]) {
        for (int j = 0; j < winningPairs.length; j++) {
            buttons.get(winningPairs[j]).setBackground(WINNING_PAIRS);
        }
    }

    public int bestSpot() {
        ArrayList<Character> object = new ArrayList<Character>(origBoard);

        if (HARD) {
            return tictactoeAlgo.miniMax(object, true).getIndex();
        } else {
            return tictactoeAlgo.EasyAlgo(object, true).getIndex();
        }
    }
    public void declareWinner(String opString) {
        TITLE.setText(opString);
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setEnabled(false);
            buttons.get(i).setUI(new MetalButtonUI(){
                protected Color getDisabledTextColor() {
                    return BACKGROUND_COLOR;
                }
            });
        }
        RERUN.setText("Play Again");
        RERUN.setEnabled(true);
        RERUN.setFont(fontNewsPaper2);
    }

    public Boolean check(Character who) {
        wonUtil obj = tictactoeAlgo.checkWin(origBoard, who);
        if(obj.won){
            displayWinningTripplets(obj.winningTriplets);
            declareWinner(who+" won!!");
            return true;
        }
        if(tictactoeAlgo.checkTie(origBoard)){
            declareWinner("Tie Game");
            return true;
        }
        return false;
    }

    public void playBot() {
        int pos = bestSpot();
        // System.out.println(pos);
        try {
            buttons.get(pos).setBackground(O_COLOR);
            buttons.get(pos).setText(Character.toString(BOT));
            origBoard.set(pos, BOT);
        } catch (Exception e) {
            System.out.println(e);
        }
        XTurn = true;
        check(BOT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if(e.getSource() ==  buttons.get(i)){
                if(XTurn){
                    if(buttons.get(i).getText() ==""){
                        // buttons.get(i).setForeground(X_COLOR);
                        buttons.get(i).setBackground(X_COLOR);
                        buttons.get(i).setText(Character.toString(PLAYER));
                        origBoard.set(i, PLAYER);
                        XTurn = false;

                        if(!SINGELPLAYER)
                            RERUN.setBackground(O_COLOR);

                        if(!check(PLAYER) && SINGELPLAYER){
                                playBot();
                        }
                    }
                }else{
                    if(buttons.get(i).getText() ==""){
                        // buttons.get(i).setForeground(O_COLOR);
                        buttons.get(i).setBackground(O_COLOR);
                        buttons.get(i).setText(Character.toString(BOT));
                        origBoard.set(i, BOT);
                        // System.out.println(origBoard);
                        XTurn = true;
                        RERUN.setBackground(X_COLOR);
                        check(BOT);
                    }
                }
            }
        }
        if(e.getSource() == RERUN){
            frame.setVisible(false);
            players p = new players();
            p.showButtonDemo();
        }
    }
}
