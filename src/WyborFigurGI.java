import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WyborFigurGI extends JFrame {
    //przyciski:
    private JButton goniec = new JButton();
    private JButton skoczek = new JButton();
    private JButton wieza = new JButton();
    private JButton hetman = new JButton();
    private JButton krol = new JButton();
    private JButton pionek = new JButton();
    //inne:
    private JButton ButtonsTab[][];
    private Szachownica szachownica;
    private int wiersz, kolumna;
    private String nazwaPostawionejFig;

    public WyborFigurGI(JButton ButtonsTab[][], Szachownica szachownica, int wiersz, int kolumna, String nazwaPostawionejFig) {
        this.ButtonsTab = ButtonsTab;
        this.szachownica = szachownica;
        this.wiersz = wiersz;
        this.kolumna = kolumna;
        this.nazwaPostawionejFig = nazwaPostawionejFig;
        setTitle("Wybor");
        setSize(200,500);
        setLocation(300,200);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(pionek);
        cp.add(goniec);
        cp.add(skoczek);
        cp.add(wieza);
        cp.add(hetman);
        cp.add(krol);
        pionek.addActionListener(new KlikFigura("pionek", Stale.CZ_PIONEK, pionek));
        goniec.addActionListener(new KlikFigura("goniec", Stale.CZ_GONIEC, goniec));
        skoczek.addActionListener(new KlikFigura("skoczek", Stale.CZ_SKOCZEK, skoczek));
        wieza.addActionListener(new KlikFigura("wieza", Stale.CZ_WIEZA, wieza));
        hetman.addActionListener(new KlikFigura("hetman", Stale.CZ_HETMAN, hetman));
        krol.addActionListener(new KlikFigura("krol", Stale.CZ_KROL, krol));
        setVisible(true);
    }

    class KlikFigura implements ActionListener {
        String rodzajFigury;
        ImageIcon ikona;

        public KlikFigura(String rodzajFigury, ImageIcon ikona, JButton przycisk) {
            przycisk.setIcon(ikona);
            this.rodzajFigury = rodzajFigury;
            this.ikona = ikona;
        }
        public void actionPerformed(ActionEvent e) {
            if(szachownica.postawFigure(wiersz, kolumna,'c', rodzajFigury, nazwaPostawionejFig) == 0)
                ButtonsTab[wiersz][kolumna].setIcon(ikona);
            dispose();
        }
    }
}
