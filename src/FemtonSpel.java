
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FemtonSpel extends JFrame implements ActionListener {

    JPanel p = new JPanel(new BorderLayout());
    JPanel mess = new JPanel();
    JPanel Buttons = new JPanel(new GridLayout(4,4));
    List<JButton> listOfButtons = new LinkedList<>();
    List<JButton> listOfButtonsToShuffle;
    JButton nyttSpel = new JButton("Nytt spel");

    FemtonSpel() {
        this.add(p);
        p.add(nyttSpel, BorderLayout.NORTH);
        p.add(Buttons, BorderLayout.CENTER);
        p.add(mess, BorderLayout.SOUTH);


        for (int i = 1; i <=15; i++) {
            JButton button = new JButton(String.valueOf(i));
            listOfButtons.add(button);
            button.addActionListener(this);
            listOfButtons.add(button);

        }
        for(JButton button : listOfButtons)
            Buttons.add(button);

        nyttSpel.addActionListener(this);


            pack();
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }


                @Override
                public void actionPerformed(ActionEvent e) {

                    if (e.getSource() == nyttSpel) {
                        Collections.shuffle(listOfButtonsToShuffle);
                        p.removeAll();
                        for (JButton button : listOfButtonsToShuffle) p.add(button);
                        p.revalidate();
                    }
                }

                public static void main(String[] args) {
                    FemtonSpel femtonSpel = new FemtonSpel();
                }
            }