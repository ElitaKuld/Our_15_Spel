import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
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
        // skapa den 16:e osynliga knappen (och utan lyssnaren)
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

            int index;
            JButton placeToTheRight = null;
            JButton placeToTheLeft = null;
            JButton placeUp = null;
            JButton placeDown = null;

            // testa om det var en knapp som ligger på spelpanelen som användaren har tryckt på
            if (((JButton) e.getSource()).getParent() == gamePanel) {
                index = Arrays.asList(gamePanel.getComponents()).indexOf(((JButton) e.getSource()));

                // tilldela index till möjliga tomma platser
                if (index < gamePanel.getComponents().length - 1)
                    placeToTheRight = (JButton) Arrays.asList(gamePanel.getComponents()).get(index + 1);
                if (index > 0)
                    placeToTheLeft = (JButton) Arrays.asList(gamePanel.getComponents()).get(index - 1);
                if (index >= 4)
                    placeUp = (JButton) Arrays.asList(gamePanel.getComponents()).get(index - 4);
                if (index <= 11)
                    placeDown = (JButton) Arrays.asList(gamePanel.getComponents()).get(index + 4);

                // kolla om platsen är tomm och i så fall byta plats på 2 knappar
                if (placeToTheRight != null && !placeToTheRight.isVisible()) {
                    swapThePlaces(placeToTheRight, e, gamePanel, index, index + 1);
                } else if (placeToTheLeft != null && !placeToTheLeft.isVisible()) {
                    swapThePlaces(placeToTheLeft, e, gamePanel, index, index - 1);
                } else if (placeUp != null && !placeUp.isVisible()) {
                    swapThePlaces(placeUp, e, gamePanel, index, index - 4);
                } else if (placeDown != null && !placeDown.isVisible()) {
                    swapThePlaces(placeDown, e, gamePanel, index, index + 4);
                }
            }

            // kontrollera om spelaren vann
            int numberButtonsInRightPlace = 0;
            for (int i = 0; i < listOfButtons.size(); i++) {
                if (gamePanel.getComponent(i) == listOfButtons.get(i)) {
                    numberButtonsInRightPlace++;
                }
            }
            if (numberButtonsInRightPlace == 16) {
                JOptionPane.showMessageDialog(null, "Grattis, du vann!");
            }
        }
    };

    public void swapThePlaces(JButton whereToMove, ActionEvent event, JPanel gamePanel, int indexFrom, int indexTo) {
        ((JButton) gamePanel.getComponent(indexTo)).removeAll();
        gamePanel.add(((JButton) event.getSource()), indexTo);
        gamePanel.add(whereToMove, indexFrom);
        gamePanel.revalidate();
    }

    public static void main(String[] args) {
        Our_15_Spel spel = new Our_15_Spel();
    }
}