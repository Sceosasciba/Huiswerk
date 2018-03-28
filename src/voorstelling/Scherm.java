/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voorstelling;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Stan
 */
public class Scherm extends JFrame implements ActionListener {

    private Voorstelling voorstelling;
    private JLabel jlAantalPlaatsen;
    private JLabel jlAantalVerkocht;
    private JButton jbVerkoop;
    private JButton jbAnnuleer;
    private JTextField jtVerkoop;
    private JTextField jtAnnuleer;
    private JLabel jlTekst;

    public Scherm(Voorstelling voorstelling) {
        this.voorstelling = voorstelling;

        setTitle("Voorstelling " + voorstelling.getNaam());
        setSize(300, 200);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("aantal plaatsen vrij: "));
        String aantalPlaatsen = String.valueOf(voorstelling.getAantalPlaatsen());
        jlAantalPlaatsen = new JLabel(aantalPlaatsen);
        add(jlAantalPlaatsen);

        add(new JLabel("aantal verkocht: "));
        String aantalVerkocht = String.valueOf(voorstelling.getAantalVerkocht());
        jlAantalVerkocht = new JLabel(aantalVerkocht);
        add(jlAantalVerkocht);

        jtVerkoop = new JTextField(10);
        add(jtVerkoop);

        jbVerkoop = new JButton("Verkoop kaartje");
        add(jbVerkoop);
        jbVerkoop.addActionListener(this);

        jtAnnuleer = new JTextField(10);
        add(jtAnnuleer);

        jbAnnuleer = new JButton("Annuleer kaartje");
        add(jbAnnuleer);
        jbAnnuleer.addActionListener(this);

        jlTekst = new JLabel("");
        add(jlTekst);

        setVisible(true);
    }

    public static void main(String[] args) {
        Voorstelling voorstelling = new Voorstelling("van Schaffelaar", 10);
        Scherm schermpje = new Scherm(voorstelling);
        schermpje.setDefaultCloseOperation(Scherm.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // code voor afhandeling knop
        try {

            if (e.getSource() == jbVerkoop) {
                //handel verkoop-knop af
                if (voorstelling.getAantalPlaatsen() <= 0) {
                    int verkoopKaartje = Integer.parseInt(jtVerkoop.getText());
                    voorstelling.verkoopKaartje(verkoopKaartje);

                    jlAantalPlaatsen.setText("UITVERKOCHT");
                    jlAantalVerkocht.setText(Integer.toString(voorstelling.getAantalVerkocht()));
                } else {
                    int verkoopKaartje = Integer.parseInt(jtVerkoop.getText());
                    voorstelling.verkoopKaartje(verkoopKaartje);
                    jlAantalPlaatsen.setText(Integer.toString(voorstelling.getAantalPlaatsen()));
                    jlAantalVerkocht.setText(Integer.toString(voorstelling.getAantalVerkocht()));

                    if (voorstelling.getAantalPlaatsen() == 0) {
                        jlAantalPlaatsen.setText("UITVERKOCHT");
                    }
                }

            } else if (e.getSource() == jbAnnuleer) {
                //handel annuleer-knop af
                int annuleerKaartje = Integer.parseInt(jtAnnuleer.getText());
                voorstelling.annuleerKaartje(annuleerKaartje);
                jlAantalPlaatsen.setText(Integer.toString(voorstelling.getAantalPlaatsen()));
                jlAantalVerkocht.setText(Integer.toString(voorstelling.getAantalVerkocht()));

                if (voorstelling.getAantalPlaatsen() == 0) {
                    jlAantalPlaatsen.setText("UITVERKOCHT");
                }
            }

        } catch (NumberFormatException nfe) {
            jlTekst.setText("Voer een getal in");
        }

    }

}
