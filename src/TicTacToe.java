import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel resetPanel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton resetButton = new JButton("restart");
    boolean player1Turn;

    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 650);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 600, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        for(int i=0; i<9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        resetButton.setFocusable(false);
        resetButton.setBackground(new Color(0, 100, 255));
        resetButton.setForeground(new Color(255, 255, 255));
        resetButton.setFont(new Font("MV Boli", Font.BOLD, 20));
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        titlePanel.add(textfield);
        resetPanel.add(resetButton);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(resetPanel, BorderLayout.SOUTH);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<9; i++) {
            if(e.getSource()==buttons[i]) {
                if(player1Turn) {
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1Turn = false;
                        textfield.setText("O turn");
                        check();
                    }
                } else {
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1Turn = true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(random.nextInt(2)==0) {
            player1Turn = true;
            textfield.setText("X turn");
        } else {
            player1Turn=false;
            textfield.setText("O turn");
        }
    }

    public void check() {
        //check X win conditions
        boolean winnerPresent = false;
        if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")) {
            winnerPresent = true;
            xWins(0, 1, 2);
        }
        if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")) {
            winnerPresent = true;
            xWins(3, 4, 5);
        }
        if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")) {
            winnerPresent = true;
            xWins(6, 7, 8);
        }
        if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")) {
            winnerPresent = true;
            xWins(0, 3, 6);
        }
        if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")) {
            winnerPresent = true;
            xWins(1, 4, 7);
        }
        if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")) {
            winnerPresent = true;
            xWins(2, 5, 8);
        }
        if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")) {
            winnerPresent = true;
            xWins(0, 4, 8);
        }
        if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")) {
            winnerPresent = true;
            xWins(2, 4, 6);
        }

        //check O win conditons
        if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")) {
            winnerPresent = true;
            oWins(0, 1, 2);
        }
        if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")) {
            winnerPresent = true;
            oWins(3, 4, 5);
        }
        if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")) {
            winnerPresent = true;
            oWins(6, 7, 8);
        }
        if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")) {
            winnerPresent = true;
            oWins(0, 3, 6);
        }
        if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")) {
            winnerPresent = true;
            oWins(1, 4, 7);
        }
        if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")) {
            winnerPresent = true;
            oWins(2, 5, 8);
        }
        if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")) {
            winnerPresent = true;
            oWins(0, 4, 8);
        }
        if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")) {
            winnerPresent = true;
            oWins(2, 4, 6);
        }

        // check draw
        boolean isDraw = true;
        for(int i=0; i<9; i++) {
           if(buttons[i].getText().isEmpty()) {
               isDraw = false;
               break;
           }
        }
        if(isDraw) {
            if(!winnerPresent) {
                textfield.setText("draw");
            }
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0; i<9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0; i<9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins");
    }

    public void resetGame() {
        for(int i=0; i<9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
            buttons[i].setBackground(UIManager.getColor("Button.background"));
        }
        firstTurn();
    }
}
