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
    public ErstesFenster()  {
        super("Schönes Fenster");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


    }
}
