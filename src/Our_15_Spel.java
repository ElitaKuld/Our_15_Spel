import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class Our_15_Spel extends JFrame {

    JPanel basePanel = new JPanel();
    JPanel gamePanel = new JPanel();

    // skapa 15 knappar
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton button10 = new JButton("10");
    JButton button11 = new JButton("11");
    JButton button12 = new JButton("12");
    JButton button13 = new JButton("13");
    JButton button14 = new JButton("14");
    JButton button15 = new JButton("15");

    JButton startButton = new JButton("Start");
    List<JButton> listOfButtons = new LinkedList<>();

    public Our_15_Spel() {
        add(basePanel);
        basePanel.setLayout(new BorderLayout());
        basePanel.add(gamePanel, BorderLayout.WEST);
        basePanel.add(startButton, BorderLayout.EAST);
        gamePanel.setLayout(new GridLayout(4, 4));

        // lägga till 15 knappar på gamePanel
        gamePanel.add(button1);
        gamePanel.add(button2);
        gamePanel.add(button3);
        gamePanel.add(button4);
        gamePanel.add(button5);
        gamePanel.add(button6);
        gamePanel.add(button7);
        gamePanel.add(button8);
        gamePanel.add(button9);
        gamePanel.add(button10);
        gamePanel.add(button11);
        gamePanel.add(button12);
        gamePanel.add(button13);
        gamePanel.add(button14);
        gamePanel.add(button15);

        // lägga till en lyssnare
        button1.addActionListener(listener);
        button2.addActionListener(listener);
        button3.addActionListener(listener);
        button4.addActionListener(listener);
        button5.addActionListener(listener);
        button6.addActionListener(listener);
        button7.addActionListener(listener);
        button8.addActionListener(listener);
        button9.addActionListener(listener);
        button10.addActionListener(listener);
        button11.addActionListener(listener);
        button12.addActionListener(listener);
        button13.addActionListener(listener);
        button14.addActionListener(listener);
        button15.addActionListener(listener);

        startButton.addActionListener(listener);

        // lägga knappar i en lista
        listOfButtons.add(button1);
        listOfButtons.add(button2);
        listOfButtons.add(button3);
        listOfButtons.add(button4);
        listOfButtons.add(button5);
        listOfButtons.add(button6);
        listOfButtons.add(button7);
        listOfButtons.add(button8);
        listOfButtons.add(button9);
        listOfButtons.add(button10);
        listOfButtons.add(button11);
        listOfButtons.add(button12);
        listOfButtons.add(button13);
        listOfButtons.add(button14);
        listOfButtons.add(button15);
        listOfButtons.add(null);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // skapa en lyssnare
    ActionListener listener = new ActionListener() { // anonym klass
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    };

    public static void main(String[] args) {
        Our_15_Spel game = new Our_15_Spel();
    }
}