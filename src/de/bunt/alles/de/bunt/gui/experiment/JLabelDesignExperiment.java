package de.bunt.alles.de.bunt.gui.experiment;

import javax.swing.*; // Importiere alle Klassen aus dem Swing-Paket
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*; // Importiere alle Klassen aus dem AWT-Paket (für Farben, Fonts etc.)
import java.awt.event.*;

public class JLabelDesignExperiment extends JFrame {// Klasse erbt von JFrame

    private JLabel myLabel;
    private String htmlContent;
    private JButton exitButton;
    private JCheckBox boldCheckBox;
    private JCheckBox italicCheckBox;

    public JLabelDesignExperiment(){
        // --- 1. Grundeinstellungen des Fensters (JFrame) ---
        super("JLabel Design Experiment");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        htmlContent = "<html>" +
                "<h1 style='color:green;'>Willkommen bei Swing GUI!</h1>" + // Überschrift mit grüner Farbe
                "<p>Dies ist ein <b>Test</b> von <i>HTML-Inhalten</i> in einem " +
                "<font color='blue'>JLabel</font>.</p>" + // Text mit Fett, Kursiv und Farbe
                "<hr>" + // Horizontale Linie
                "<p><u>Einige interessante Fakten:</u></p>" + // Unterstrichener Text
                "<ul>" + // Ungeordnete Liste
                "<li>HTML kann hier verwendet werden.</li>" +
                "<li>Tags wie &lt;b&gt;, &lt;i&gt;, &lt;u&gt; und &lt;font&gt; funktionieren.</li>" +
                "<li>Absätze (&lt;p&gt;) und Zeilenumbrüche (&lt;br&gt;) sind nützlich.</li>" +
                "<li>Auch einfache CSS-Stile mit 'style'-Attribut sind möglich.</li>" +
                "</ul>" +
                "<p style='text-align:center; font-size:16px; color:purple;'>Viel Spaß beim Experimentieren!</p>" + // Zentrierter Text mit Stil
                "</html>";
        //JLabel myLabel = new JLabel("Hallo, diese ist mein erster JLabel!");
        myLabel = new JLabel(htmlContent);
        //myLabel.setFont(new Font("Arial", Font.BOLD,24));
        //myLabel.setForeground(Color.MAGENTA);
        myLabel.setBackground(new Color(240, 240, 240));
        myLabel.setOpaque(true);

        myLabel.setHorizontalAlignment(SwingConstants.CENTER);
        myLabel.setVerticalAlignment(SwingConstants.CENTER);

        //myLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        myLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(myLabel, BorderLayout.CENTER);

        boldCheckBox = new JCheckBox("Bold");
        boldCheckBox.setMnemonic(KeyEvent.VK_B);
        boldCheckBox.setSelected(false);
        boldCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Font currentFont = boldCheckBox.getFont();
                if(boldCheckBox.isSelected()){
                    boldCheckBox.setFont(currentFont.deriveFont(Font.BOLD));
                }else{
                    boldCheckBox.setFont(currentFont.deriveFont(Font.PLAIN));
                }

            }
        });

        italicCheckBox = new JCheckBox("Italic");
        italicCheckBox.setMnemonic(KeyEvent.VK_I);
        italicCheckBox.setSelected(true);
        italicCheckBox.addItemListener(e-> {
            Font currentFont = italicCheckBox.getFont();
            if(italicCheckBox.isSelected()){
                italicCheckBox.setFont(currentFont.deriveFont(Font.ITALIC));
            }else{
                italicCheckBox.setFont(currentFont.deriveFont(Font.PLAIN));
            }
        });

        JPanel checkBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        checkBoxPanel.add(boldCheckBox);
        checkBoxPanel.add(italicCheckBox);
        add(checkBoxPanel, BorderLayout.NORTH);

        exitButton = new JButton("Programm beenden");
        add(exitButton, BorderLayout.SOUTH);
        addExitButtonActionListener();
        addWindowClosingListener();



        setVisible(true);
    }

    private void itemStateChanged() {

    }

    private void addWindowClosingListener() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                showExitConfirmation();
            }
        });
    }

    private void addExitButtonActionListener() {
        exitButton.addActionListener(e -> showExitConfirmation());
    }

    private void showExitConfirmation() {
        int result = JOptionPane.showConfirmDialog(
                this,
                "Sind Sie sicher, dass Sie das Programm beenden möchten?",
                "Beenden bestätigen",
                JOptionPane.YES_NO_OPTION);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new JLabelDesignExperiment());
    }
}
