package IMT3881;

import javax.swing.*;
import java.awt.*;

public class RollDiceGUI {
private JLabel info;
private JButton player1;
private JButton player2;
private TextField diceValue;
private int score;
private JLabel playerOneScore;
private JLabel playerTwoScore;


    public RollDiceGUI(){
    this.info = new JLabel();
    info.setText("<html>Each player takes three alternate turns to roll dice.<br>" +
            "The one who scores maximums after three turns <br/> wins the game</html>");

    this.player1 = new JButton(" Player 1");
    this.player2 = new JButton("Player 2");
     this.diceValue = new TextField(10);
     this.score = 0;
     this.playerOneScore = new JLabel();
     this.playerTwoScore = new JLabel();
    }


    public void rollDice(){
        JFrame rollFrame  = new JFrame("Roll a Dice");

        rollFrame.setSize(500,500);
        rollFrame.setResizable(false);
        rollFrame.setVisible(true);
        rollFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        //JPanel
        JPanel panel = new JPanel();
        //Layout
        panel.setLayout(new GridBagLayout());

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill =GridBagConstraints.VERTICAL;
        panel.add(info,gbc);
        rollFrame.add(panel);
        //sets x & y position for player 1

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(player1,gbc);

        //player2
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 2;

        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(player2,gbc);
        //x, position for Dice value
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        panel.add(diceValue,gbc);
//x,y for playerOneScore
        gbc.gridx = 0;
        gbc.gridy = 9;
        playerOneScore.setText("Here p1 score");

        panel.add(playerOneScore,gbc);

        //x,y for playerTwoScore
        gbc.gridx = 4;
        gbc.gridy = 9;

        playerTwoScore.setText("Here p1 score");
        panel.add(playerTwoScore,gbc);


    }

}
