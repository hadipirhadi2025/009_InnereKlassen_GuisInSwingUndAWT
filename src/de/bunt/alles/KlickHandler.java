package de.bunt.alles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *     1) Eigene Klasse schreiben, die das ActionListener Interface implementiert
 *     2) Legt fest, was beim Aufruf (durch JButton) der actionPerformed Metode passieren soll
 *     3) Erstellen eines Objekts dieser Klasse
 *     4) Objekt beim JButton registrieren (addActionListener)
 *     5) testen
 *
 *     Ein Klickhandler ist ein ActcíonListener (imlements)
 *     ActionListener actionListenerReferenz = new KlickHandler();
 *
 *     ------- Im JButton ----------
 *     ActionEvent event = new ActionEvent();
 *     registriertenObjekt[0].actionPerformed(event);
 */
public class KlickHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        LocalTime jetzt = LocalTime.now();
        DateTimeFormatter formatHelfer = DateTimeFormatter.ofPattern("HH:mm:ss");
        String jetztAlsString = jetzt.format(formatHelfer);
        System.out.println(jetztAlsString);

    }
}
