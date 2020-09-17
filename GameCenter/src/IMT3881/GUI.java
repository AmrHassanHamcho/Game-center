package IMT3881;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;


public class GUI extends JPanel {

    private final JFrame jFrame ;
    private JButton rollDice;
    private JButton maxClicks;
    JButton clickMe = new JButton("Click Me");
    private final JButton exit;
    private final Box mainBox;
    int sec = 60;
    int delay = 1000;

    JTextField timer = new JTextField(5);


    Timer downCounter = new Timer(delay, e -> {

        if(sec>0 && sec<=60){
            sec--;
        clickMe.setEnabled(true);
        timer.setText(""+sec);
        }else clickMe.setEnabled(false);

    });
    public GUI(){
        this.mainBox = Box.createVerticalBox();
        this.jFrame = new JFrame("Game center");
        this.clickMe.setEnabled(false);

        //Used this way so that both buttons i,e 'Roll a Dice'  and 'Maximum clicks'  could have the same size

        this.rollDice = new JButton("Roll a Dice")
        {
            {
                setSize(150, 75);
                setMaximumSize(getSize());
           }
       };
        rollDice.addActionListener(roll->rollDice());
        //Used this way so that both buttons could have the same size

        this.maxClicks = new JButton("Maximum Clicks"){
            {
                setSize(150,75);
                setMaximumSize(getSize());
            }

        };
        this.exit = new JButton("Exit");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);


    }
    /**
     * initiates the gui**/
    public void MainPage(){
jFrame.pack();
       // mainBox.setMaximumSize(new Dimension(300,150));
        mainBox.add(Box.createVerticalStrut(40));
        jFrame.setSize(400, 400);
        jFrame.setVisible(true);
        jFrame.getContentPane()
                .setLayout(new BoxLayout(jFrame.getContentPane(),BoxLayout.Y_AXIS));

        mainBox.add(rollDice);
        mainBox.add(Box.createVerticalStrut(20));
        mainBox.add(Box.createHorizontalStrut(100));

mainBox.add(maxClicks);

maxClicks.addActionListener(max->maxClickGui());
        mainBox.add(Box.createVerticalStrut(50));
        mainBox.add(Box.createHorizontalStrut(20));



jFrame.getContentPane().add(mainBox);
mainBox.setAlignmentX(CENTER_ALIGNMENT);

        mainBox.setBorder(BorderFactory.createTitledBorder(" Games"));
        //closes the jFrame when ever the the exit button clickMe
        exit.addActionListener(exiting -> jFrame.dispatchEvent(new WindowEvent(jFrame, WindowEvent.WINDOW_CLOSING)));
        JPanel extPanel = new JPanel();
        extPanel.add(exit,BorderLayout.PAGE_START);
        jFrame.add(extPanel);

        //jFrame.add(exit);
      //  jFrame.pack();
}
/**
 * sets the JFrame frame for Maxclikcs game
 * */
public void maxClickGui(){
    Game game = new Game();
    JFrame maxFrame = new JFrame();
     //   maxFrame.setLocationRelativeTo(null); //serts the location in the middle of the screen



    maxFrame.setVisible(true);


        maxFrame.setTitle("Maximum Clicks");
        maxFrame.setResizable(false);
        maxFrame.setSize(500,400);
        maxFrame.setVisible(true);
        maxFrame.getDefaultCloseOperation();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

             //JPanel
        JPanel panel = new JPanel();
        //Layout
        panel.setLayout(new GridBagLayout());
        //set xx a y position for each components

    JTextField counter = new JTextField(10);


        JLabel infoLabel = new JLabel("See how many clicks you can do in a minute!");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(infoLabel,gbc);


        //gbc.gridwidth = 3;
        //gbc.fill = GridBagConstraints.HORIZONTAL;


    JLabel recordLabel = new JLabel("Record: \t  clicks");

        JButton startBut = new JButton("Start");
        startBut.addActionListener(start->{

            //timer();
            downCounter.stop();
            sec = 60;
            game.setCounter(0);
            clickMe.setEnabled(true);
            timer.setText(""+sec);
            downCounter.start();

            clickMe.setEnabled(true);
        });


    clickMe.addActionListener(click-> counter.setText (""+game.getCounter()));

        JLabel timeInfo = new JLabel("Time Left: ");

        JLabel seconds = new JLabel("seconds");



        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(recordLabel,gbc);


     gbc.gridx = 0;
        gbc.gridy = 2;
    gbc.gridwidth = 2;
    gbc.fill = GridBagConstraints.HORIZONTAL;//Strech startButton
        panel.add(startBut,gbc);//add StartButton
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 1;

        panel.add(clickMe,gbc);

    gbc.gridx = 1;
    gbc.gridy = 3;
        panel.add(counter,gbc);

    gbc.gridx = 0;
    gbc.gridy = 4;
        panel.add(timeInfo,gbc);
    gbc.gridx = 1;
    gbc.gridy = 4;
        panel.add(timer,gbc);
    gbc.gridx = 2;
    gbc.gridy = 4;


    panel.add(seconds,gbc);

        maxFrame.add(panel);




        maxFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //maxFrame.pack();
        maxFrame.setVisible(true);
}
/**
 *
 * ***/
public void rollDice(){
    JFrame rollFrame  = new JFrame("Roll a Dice");

    rollFrame.setSize(500,300);
    rollFrame.setResizable(false);
    rollFrame.setVisible(true);

}


}
