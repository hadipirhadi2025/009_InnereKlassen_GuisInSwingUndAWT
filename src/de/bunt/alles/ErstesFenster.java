package de.bunt.alles;

import javax.swing.*;
import java.awt.*;

/**
 * <pre>
 *     Demonstriert wie Fenster (für Benutzerinteraktion) erstellt werden
 *     Zeigt, wie Benutzerinteraktionen entgegen genommen werden.
 *
 *     Verwendet werden hier Klassen, die für Benutzerinteraktion vorgehen sind, Fenster, Benutzer, Textfelder ...
 *
 *     Klassen aus dem Package javax.swing: Graphische Komponenten
 *                     Package java.awt: Ereignisbehandlung, Schriften, Farben, Organisation
 *
 *     import javax.swing.*; Alle Klassen aus diesem Package sind importiert.
 *
 *     Die Klasse ErstesFenster ist ein JFrame (oft statt dessen hat ein hat ein JFrame)
 *
 *     HIER: ErstesFenster extends JFrame
 *     OFT:Public class ErstFenster{
 *         private JFrame fenster;
 *     }
 *     JFrame Konfiguration:
 *          super("Schönes Fenster");
 *         setSize(350, 300);
 *         setLocationRelativeTo(null);
 *         setDefaultCloseOperation(EXIT_ON_CLOSE);
 *
 *     Organisiert werden JFrames mit Hilfe von Layout-Managern : java.awt
 *     HIER: FLowLayout, bei Java FX über Parents: zb FlowPanel
 *
 *     setLayout(new FlowLayout()); Anonymes Objekt
 * </pre>
 */
public class ErstesFenster extends JFrame{

    /**
     * <pre>
     *     Demonstriert wie Interaktion mit dem Benutzer (hier Klicken) funktioniert.
     *     Wenn ein JButton geklickt wird: erstellt eine Objekt vom Typ ActionEvent
     *     Intern hält der JButton ein Array von Objekten, die beim JButton registeriert sind ubd
     *     "informiert" werden wollen, wenn der JButton gecklickt wird: Ruf bei den Objekten
     *     die actionPerformed auf, und übergibt als  Parameter das erstellt ActionEvent.
     *     Objekte, die sich beim JButton registrieren möchten, müssen das ActionListener Interface implementieren
     *
     *     Was tun wir?
     *     1) Eigene Klasse schreiben, die das ActionListener Interface implementiert
     *     2) Legt fest, was beim Aufruf (durch JButton) der actionPerformed Metode passieren soll
     *     3) Erstellen eines Objekts dieser Klasse
     *     4) Objekt beim JButton registrieren (addActionListener)
     *     5) testen
     * </pre>
     */

    private JButton klickMich = new JButton("Klick mich");
    /**
     * Wenn der user auf Klickmich JButton Klickt, soll hier die aktuelle Uhrzeit angezeigt werden
     */
    private JLabel uhrzeitAnzeige = new JLabel("XX:XX:XX");

    /**
     * Wird die Anwendung beenden: System.exit(42)
     */
    private JButton beenden = new JButton("Schluss");
    /**
     * Spielewiese
     */
    private JLabel platz = new JLabel("Experiemente");

    /**
     *
     */
    public ErstesFenster()  {
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

        verwendenKlickHandler();
    }

    /**
     * <pre>
     *     1) Eigene Klasse schreiben, die das ActionListener Interface implementiert
     *     2) Legt fest, was beim Aufruf (durch JButton) der actionPerformed Metode passieren soll
     *     3) Erstellen eines Objekts dieser Klasse
     *     4) Objekt beim JButton registrieren (addActionListener)
     *     5) testen
     * </pre>
     */
    private void verwendenKlickHandler() {
//        //Version 1
//        KlickHandler meinHandler = new KlickHandler();
//        klickMich.addActionListener(meinHandler);
        //Version 2
//        Object meinHandler = new KlickHandler();
//        klickMich.addActionListener(meinHandler);
        //Version 2
//        ActionListener meinHandler = new KlickHandler();
//        klickMich.addActionListener(meinHandler);
        //Version 3
        klickMich.addActionListener(new KlickHandler());


    }
}
