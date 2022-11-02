import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class FemtonSpel extends JFrame {

    JPanel panelBase = new JPanel(new BorderLayout());
    JPanel panelButtons = new JPanel(new GridLayout(4, 4));
    JButton nyttSpel = new JButton("Nytt spel");
    List<JButton> listOfButtons = new LinkedList<>();
    List<JButton> listOfButtonsToShuffle;
    JButton emptyButton = new JButton("");

    public FemtonSpel() {
        add(panelBase);
        panelBase.add(nyttSpel, BorderLayout.NORTH);
        panelBase.add(panelButtons, BorderLayout.SOUTH);

        nyttSpel.addActionListener(listener);

        // skapa 15 knappar
        for (int i = 1; i <= 15; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.setPreferredSize(new Dimension(50, 30));
            button.setBackground(Color.pink);
            button.addActionListener(listener);
            listOfButtons.add(button);
        }

        // lägga till den 16:e "tomma" knappen (utan lyssnaren)
        listOfButtons.add(emptyButton);

        for (JButton button : listOfButtons)
            panelButtons.add(button);

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

            // blanda knapparna i slumpmässig ordning när man trycker på start-knappen
            if (e.getSource() == nyttSpel) {
                Collections.shuffle(listOfButtonsToShuffle);
                panelButtons.removeAll();
                for (JButton button : listOfButtonsToShuffle) panelButtons.add(button);
                panelButtons.revalidate();
            }

            int index;
            JButton placeToTheRight = null;
            JButton placeToTheLeft = null;
            JButton placeUp = null;
            JButton placeDown = null;

            // testa om det var en knapp som ligger på spelpanelen som användaren har tryckt på
            if (((JButton) e.getSource()).getParent() == panelButtons) {
                index = Arrays.asList(panelButtons.getComponents()).indexOf(((JButton) e.getSource()));

                // tilldela index till möjliga tomma platser
                if (index < panelButtons.getComponents().length - 1)
                    placeToTheRight = (JButton) Arrays.asList(panelButtons.getComponents()).get(index + 1);
                if (index > 0)
                    placeToTheLeft = (JButton) Arrays.asList(panelButtons.getComponents()).get(index - 1);
                if (index >= 4)
                    placeUp = (JButton) Arrays.asList(panelButtons.getComponents()).get(index - 4);
                if (index <= 11)
                    placeDown = (JButton) Arrays.asList(panelButtons.getComponents()).get(index + 4);

                // kolla om "platsen är tom" och i så fall byta plats på 2 knappar
                if (placeToTheRight != null && placeToTheRight==emptyButton) {
                swapThePlaces(placeToTheRight, e, panelButtons, index, index + 1);
                } else if (placeToTheLeft != null && placeToTheLeft==emptyButton) {
                swapThePlaces(placeToTheLeft, e, panelButtons, index, index - 1);
                } else if (placeUp != null && placeUp==emptyButton) {
                swapThePlaces(placeUp, e, panelButtons, index, index - 4);
                } else if (placeDown != null && placeDown==emptyButton) {
                swapThePlaces(placeDown, e, panelButtons, index, index + 4);
                }
            }

            // kontrollera om spelaren vann
            int numberButtonsInRightPlace = 0;
            for (int i = 0; i < listOfButtons.size(); i++) {
                if (panelButtons.getComponent(i) == listOfButtons.get(i)) {
                    numberButtonsInRightPlace++;
                }
            }
            if (numberButtonsInRightPlace == 16) {
                JOptionPane.showMessageDialog(null, "Grattis, du vann!");
            }
        }
    };

    // metod som byter plats på 2 knappar
    public void swapThePlaces(JButton whereToMove, ActionEvent event, JPanel gamePanel, int indexFrom, int indexTo) {
        ((JButton) gamePanel.getComponent(indexTo)).removeAll();
        gamePanel.add(((JButton) event.getSource()), indexTo);
        gamePanel.add(whereToMove, indexFrom);
        gamePanel.revalidate();
    }

    public static void main(String[] args) {
        FemtonSpel femtonSpel = new FemtonSpel();
    }
}