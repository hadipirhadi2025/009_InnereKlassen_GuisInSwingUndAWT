package de.bunt.alles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

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
        verwendenLocalKlickHandler(9);
        /// ////////////////////////////
        //dasMacheIchMorgens();
        //dasMacheIchMittags();
        //dasMacheIchAbends();
        /// ////////////////////////////
        verwendenAnonymerKlickHandler();
        verwendenLambdaKlickHandler();
        //me
        VerwendetBeenden();
    }

    /**
     * Interfaces, die gensu eine abstrakte Methode haben, heißen Funktionale Interfaces.
     * Funktionale Interfaces ermöglichen Lambda Ausdrücke
     *
     */
    private void verwendenLambdaKlickHandler() {
        //version1 :Mit Lamda Ausdrücken nocht mölich

        //version2:
//        ActionListener meinHandler = klick -> System.out.println("Grueselig");
//        klickMich.addActionListener(meinHandler);

        //version3
        klickMich.addActionListener(e -> System.out.println("Das ist Lambda Ausdruck"));
    }

    private void VerwendetBeenden() {
        beenden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // --- Hier ist der Code, um das Programm zu beenden ---
                System.out.println("Beenden-Button wurde geklickt. Programm wird geschlossen.");
                System.exit(0); // Beendet die Java Virtual Machine
            }
        });
    }

    /**
     * Anonyme Klassen: Klassen, die keinen Name/Bezeicher haben - > kein Referenztyp
     * Anonyme Klassen kann nur ein einziges Mal instanziert werden: nur ein new-Aufruf
     * Anonyme Klassen werden erstellt, indem beim Konstruktoraufruf angegeben wird, welche Klasse erwitert wird
     * bzw welches Interface implementiert wird
     */
    private void verwendenAnonymerKlickHandler() {
        //Versuib1, Klassenname als Referenztyp, hier nicht möglich, die Klasse hat keinen Name

        //Version2
//        ActionListener meinHandler = new ActionListener() {
//            private int grosse = 10;
//            @Override
//            public void actionPerformed(ActionEvent ereignis) {
//                Font schriftArt = new Font("Comic Sans Ms", Font.BOLD, grosse);
//                beenden.setFont(schriftArt);
//                grosse++;
//            }
//        };
//        klickMich.addActionListener(meinHandler);
//        Random a;
        //Version3
        klickMich.addActionListener(new ActionListener(){
            private int grosse = 10;

            @Override
            public void actionPerformed(ActionEvent e) {
                Font schriftArt = new Font("Comic San Ms", Font.BOLD, grosse);
                beenden.setFont(schriftArt);
                grosse++;
            }
        } );
    }

    /**
     * Lokal Inner Klasse: Zugriff auf Attribute und Methoden (Member) der äüßeren Klasse
     * und hat Zugriff auf lokale Variablen, zb Parameter, falls sie final ist, oder sich wie final verhält:
     * effectiv final
     * @param maximumAnzeige maximale Klicks die angezeigt werden
     */
    private void verwendenLocalKlickHandler(int maximumAnzeige) {
        //String txt = "Geklicked";
        class LocalKlickHandler implements ActionListener {
            private int klickZaehler = 1 ;
            public void actionPerformed(ActionEvent e) {
                //darf nicht
                // txt = txt + ":-)";
                setTitle("Geklickt " + klickZaehler);
                klickZaehler++;
                if(klickZaehler >= maximumAnzeige){
                    klickZaehler = 1;
                }
//                if(klickZaehler==42){
//                    maximumAnzeige=klickZaehler;
//                }
            }
        }
        //System.out.println("Für die Methode wurde eine maximale Klickanzeigen von "+maximumAnzeige+" gewählt:");
        // maximumAnzeige = 200;
        //Version1
        //LocalKlickHandler meinHandler = new LocalKlickHandler();
        //klickMich.addActionListener(meinHandler);
        //Version2
        //ActionListener meinHandler = new LocalKlickHandler();
        //klickMich.addActionListener(meinHandler);
        //Version3
        klickMich.addActionListener(new LocalKlickHandler());
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
