package de.bunt.alles.de.bunt.gui.experiment;

import javax.swing.*; // Importiere alle Klassen aus dem Swing-Paket
import javax.swing.border.Border;
import java.awt.*; // Importiere alle Klassen aus dem AWT-Paket (für Farben, Fonts etc.)

public class JLabelDesignExperiment extends JFrame {// Klasse erbt von JFrame

    public JLabelDesignExperiment(){
        // --- 1. Grundeinstellungen des Fensters (JFrame) ---
        super("JLabel Design Experiment");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JLabel myLabel = new JLabel("Hallo, diese ist mein erster JLabel!");
        myLabel.setFont(new Font("Arial", Font.BOLD,24));
        myLabel.setForeground(Color.MAGENTA);
        myLabel.setOpaque(true);

        myLabel.setHorizontalAlignment(SwingConstants.CENTER);
        myLabel.setVerticalAlignment(SwingConstants.CENTER);

        //myLabel.setBorder(Border);
        add(myLabel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new JLabelDesignExperiment());
    }
}
