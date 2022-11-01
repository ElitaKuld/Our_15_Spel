import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Our_15_Spel extends JFrame {

    JPanel basePanel = new JPanel();
    JPanel gamePanel = new JPanel();

    // skapa 16 paneler
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();
    JPanel panel7 = new JPanel();
    JPanel panel8 = new JPanel();
    JPanel panel9 = new JPanel();
    JPanel panel10 = new JPanel();
    JPanel panel11 = new JPanel();
    JPanel panel12 = new JPanel();
    JPanel panel13 = new JPanel();
    JPanel panel14 = new JPanel();
    JPanel panel15 = new JPanel();
    JPanel panel16 = new JPanel();

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
    List<JPanel> listOfPanels = new LinkedList<>();

    public Our_15_Spel() {
        add(basePanel);
        basePanel.setLayout(new BorderLayout());
        basePanel.add(gamePanel, BorderLayout.WEST);
        basePanel.add(startButton, BorderLayout.EAST);
        gamePanel.setLayout(new GridLayout(4, 4));

        // lägga till 16 paneler i gamePanel
        gamePanel.add(panel1);
        gamePanel.add(panel2);
        gamePanel.add(panel3);
        gamePanel.add(panel4);
        gamePanel.add(panel5);
        gamePanel.add(panel6);
        gamePanel.add(panel7);
        gamePanel.add(panel8);
        gamePanel.add(panel9);
        gamePanel.add(panel10);
        gamePanel.add(panel11);
        gamePanel.add(panel12);
        gamePanel.add(panel13);
        gamePanel.add(panel14);
        gamePanel.add(panel15);
        gamePanel.add(panel16);

        // lägga till 15 knappar
        panel1.add(button1);
        panel2.add(button2);
        panel3.add(button3);
        panel4.add(button4);
        panel5.add(button5);
        panel6.add(button6);
        panel7.add(button7);
        panel8.add(button8);
        panel9.add(button9);
        panel10.add(button10);
        panel11.add(button11);
        panel12.add(button12);
        panel13.add(button13);
        panel14.add(button14);
        panel15.add(button15);

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

        // lägga paneler i en lista
        listOfPanels.add(panel1);
        listOfPanels.add(panel2);
        listOfPanels.add(panel3);
        listOfPanels.add(panel4);
        listOfPanels.add(panel5);
        listOfPanels.add(panel6);
        listOfPanels.add(panel7);
        listOfPanels.add(panel8);
        listOfPanels.add(panel9);
        listOfPanels.add(panel10);
        listOfPanels.add(panel11);
        listOfPanels.add(panel12);
        listOfPanels.add(panel13);
        listOfPanels.add(panel14);
        listOfPanels.add(panel15);
        listOfPanels.add(panel16);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // skapa en lyssnare
    ActionListener listener = new ActionListener() { // anonym klass
        @Override
        public void actionPerformed(ActionEvent e) {
            // blanda brickorna(panelerna) i slumpmässig ordning
            if (e.getSource() == startButton) {
                Collections.shuffle(listOfPanels);
                gamePanel.removeAll();
                for (JPanel panel : listOfPanels) gamePanel.add(panel);
                gamePanel.revalidate();
            }
        }
    };

    public static void main(String[] args) {
        Our_15_Spel game = new Our_15_Spel();
    }
}