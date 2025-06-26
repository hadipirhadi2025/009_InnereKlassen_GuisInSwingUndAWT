package de.bunt.alles;

import javax.swing.*;
import java.awt.*;

public class ZweitesFenster extends JFrame {

    private JButton klickMich = new JButton("Klick mich");
    private JLabel uhrzeitAnzeige = new JLabel("XX:XX:XX");
    private JButton beenden = new JButton("Schluss");
    private JLabel platz = new JLabel("Experiemente");

    public ZweitesFenster() {
        super("Schönes Fenster");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(klickMich);
        add(uhrzeitAnzeige);
        add(beenden);
        add(platz);
        add(platz);

    }
}
