
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class FemtonSpel extends JFrame implements ActionListener {

    //kommentar

    JPanel p = new JPanel(new BorderLayout());
    JPanel Buttons = new JPanel(new GridLayout(4, 4));
    List<JButton> listOfButtons = new LinkedList<>();
    List<JButton> listOfButtonsToShuffle;
    JButton nyttSpel = new JButton("Nytt spel");


    JButton emptyButton = new JButton(" ");

    FemtonSpel() {
        this.add(p);
        p.add(nyttSpel, BorderLayout.NORTH);
        p.add(Buttons, BorderLayout.CENTER);

        nyttSpel.addActionListener(this);

        for (int i = 1; i <= 15; i++) {
            JButton button = new JButton(String.valueOf(i));
            listOfButtons.add(button);
            button.addActionListener(this);
        }

        listOfButtons.add(emptyButton);

        for (JButton button : listOfButtons)
            Buttons.add(button);

        listOfButtonsToShuffle = new LinkedList<>(listOfButtons);

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == nyttSpel) {
            Collections.shuffle(listOfButtonsToShuffle);
            Buttons.removeAll();
            for (JButton button : listOfButtonsToShuffle) Buttons.add(button);
            Buttons.revalidate();
        }

        int index = 0;
        JButton placeToTheRight = null;
        JButton placeToTheLeft = null;
        JButton placeUp = null;
        JButton placeDown = null;

        if (((JButton) e.getSource()).getParent() == Buttons) {
            index = Arrays.asList(Buttons.getComponents()).indexOf(((JButton) e.getSource()));

            if (index < Buttons.getComponents().length - 1)
                placeToTheRight = (JButton) Arrays.asList(Buttons.getComponents()).get(index + 1);
            if (index > 0)
                placeToTheLeft = (JButton) Arrays.asList(Buttons.getComponents()).get(index - 1);
            if (index >= 4)
                placeUp = (JButton) Arrays.asList(Buttons.getComponents()).get(index - 4);
            if (index <= 11)
                placeDown = (JButton) Arrays.asList(Buttons.getComponents()).get(index + 4);


            if (placeToTheRight != null && placeToTheRight==emptyButton) {
                swapThePlaces(placeToTheRight, e, Buttons, index, index + 1);
            } else if (placeToTheLeft != null && placeToTheLeft==emptyButton) {
                swapThePlaces(placeToTheLeft, e, Buttons, index, index - 1);
            } else if (placeUp != null && placeUp==emptyButton) {
                swapThePlaces(placeUp, e, Buttons, index, index - 4);
            } else if (placeDown != null && placeDown==emptyButton) {
                swapThePlaces(placeDown, e, Buttons, index, index + 4);
            }
        }

        int numberButtonsInRightPlace = 0;
        for (int i = 0; i < listOfButtons.size(); i++) {
            if (Buttons.getComponent(i) == listOfButtons.get(i)) {
                numberButtonsInRightPlace++;
            }
        }
        if (numberButtonsInRightPlace == 16) {
            JOptionPane.showMessageDialog(null, "Grattis, du vann!");

        }
    }

        public void swapThePlaces (JButton whereToMove, ActionEvent event, JPanel p, int indexFrom, int indexTo){
            ((JButton) Buttons.getComponent(indexTo)).removeAll();
            Buttons.add(((JButton) event.getSource()), indexTo);
            Buttons.add(whereToMove, indexFrom);
            Buttons.revalidate();
        }

        public static void main (String[]args){
            FemtonSpel femtonSpel = new FemtonSpel();
        }
    }
