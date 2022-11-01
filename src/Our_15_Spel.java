import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Our_15_Spel extends JFrame {

    JPanel basePanel = new JPanel(new BorderLayout());
    JPanel gamePanel = new JPanel(new GridLayout(4, 4));
    JButton startButton = new JButton("Nytt spel");
    List<JButton> listOfButtons = new LinkedList<>();
    List<JButton> listOfButtonsToShuffle;

    public Our_15_Spel() {
        add(basePanel);
        basePanel.add(gamePanel, BorderLayout.NORTH);
        basePanel.add(startButton, BorderLayout.SOUTH);

        startButton.addActionListener(listener);

        // skapa 15 knappar
        for (int i = 1; i <= 15; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.setPreferredSize(new Dimension(50, 30));
            button.setBackground(Color.pink);
            button.addActionListener(listener);
            listOfButtons.add(button);
        }

        // skapa den 16:e osynliga knappen (utan lyssnaren)
        JButton lastButton = new JButton();
        lastButton.setVisible(false);
        listOfButtons.add(lastButton);

        // lägga till alla knappar i gamePanel
        for (JButton button : listOfButtons)
            gamePanel.add(button);

        listOfButtonsToShuffle = new LinkedList<>(listOfButtons);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // skapa en lyssnare
    ActionListener listener = new ActionListener() { // anonym klass
        @Override
        public void actionPerformed(ActionEvent e) {

            // blanda brickorna i slumpmässig ordning när man trycker på start-knappen
            if (e.getSource() == startButton) {
                Collections.shuffle(listOfButtonsToShuffle);
                gamePanel.removeAll();
                for (JButton button : listOfButtonsToShuffle) gamePanel.add(button);
                gamePanel.revalidate();
            }
        }
    };

    public static void main(String[] args) {
        Our_15_Spel game = new Our_15_Spel();
    }
}