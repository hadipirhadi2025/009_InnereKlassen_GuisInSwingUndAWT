package de.bunt.alles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ZweitesFenster extends JFrame {

    /**
     * Inner Klasse: Wird erstellt innerhalb einer "ormalen" Klasse: äußere Klasse
     * Inner Klassen haben Zugriff auf Attribute und Methoden(Member) der äußeren Klasse
     * Bei Event-Behandlung wird meist inneren Klassen gearbeitet
     */
    private class InnerKlickHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            LocalTime jetzt = LocalTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String jetztAlsString = jetzt.format(dateTimeFormatter);
            uhrzeitAnzeige.setText(jetztAlsString);
        }
    }

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

        verwendenInnerKlickHandler();
    }

    private void verwendenInnerKlickHandler() {
//        //Version1
//        InnerKlickHandler meinHandler = new InnerKlickHandler();
//        klickMich.addActionListener(meinHandler);
//        //Version2
//        ActionListener meinHandler = new InnerKlickHandler();
//        klickMich.addActionListener(meinHandler);
        //Version3
        klickMich.addActionListener(new InnerKlickHandler());
    }
}
