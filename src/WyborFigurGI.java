import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class WyborFigurGI extends JFrame {
    //przyciski:
    private JButton goniecButton = new JButton();
    private JButton skoczekButton = new JButton();
    private JButton wiezaButton = new JButton();
    private JButton hetmanButton = new JButton();
    private JButton krolButton = new JButton();
    private JButton pionekButton = new JButton();
    //inne:
    private JButton buttonsTab[][];
    private int wiersz, kolumna;
    private Figura postawionaFig;
    private Pat pat;
    private Szachownica szachownica;
    private Historia historia;
    //Figury:
    private static Krol krol = new Krol(Kolor.CZARNY);
    private static Hetman hetman = new Hetman(Kolor.CZARNY);
    private static Wieza wieza1 = new Wieza(Kolor.CZARNY);
    private static Wieza wieza2 = new Wieza(Kolor.CZARNY);
    private static Goniec goniec1 = new Goniec(Kolor.CZARNY);
    private static Goniec goniec2 = new Goniec(Kolor.CZARNY);
    private static Skoczek skoczek1 = new Skoczek(Kolor.CZARNY);
    private static Skoczek skoczek2  = new Skoczek(Kolor.CZARNY);


    public WyborFigurGI(JButton ButtonsTab[][], Szachownica szachownica, int wiersz, int kolumna, Figura postawionaFig,
                        Pat pat, Historia historia) {
        this.buttonsTab = ButtonsTab;
        this.wiersz = wiersz;
        this.kolumna = kolumna;
        this.postawionaFig = postawionaFig;
        this.szachownica = szachownica;
        this.pat = pat;
        this.historia = historia;
        setTitle("Wybor");
        setSize(200,500);
        setLocation(300,200);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(pionekButton);
        cp.add(goniecButton);
        cp.add(skoczekButton);
        cp.add(wiezaButton);
        cp.add(hetmanButton);
        cp.add(krolButton);
        pionekButton.addActionListener(new KlikFigura(new Pionek(Kolor.CZARNY), null, Pionek.getDefaultIcon(), pionekButton));
        goniecButton.addActionListener(new KlikFigura(goniec1, goniec2, Goniec.getDefaultIcon(), goniecButton));
        skoczekButton.addActionListener(new KlikFigura(skoczek1, skoczek2, Skoczek.getDefaultIcon(), skoczekButton));
        wiezaButton.addActionListener(new KlikFigura(wieza1, wieza2, Wieza.getDefaultIcon(), wiezaButton));
        hetmanButton.addActionListener(new KlikFigura(hetman, null, Hetman.getDefaultIcon(), hetmanButton));
        krolButton.addActionListener(new KlikFigura(krol, null, Krol.getDefaultIcon(), krolButton));
        setVisible(true);
    }

    public WyborFigurGI(Szachownica szachownica) {
        this.szachownica = szachownica;
    }

    public void aktualizujFigury() {
        szachownica.aktualizujFigury(Krol.class, buttonsTab, krol);
        szachownica.aktualizujFigury(Hetman.class, buttonsTab, hetman);
        szachownica.aktualizujFigury(Wieza.class, buttonsTab, wieza1, wieza2);
        szachownica.aktualizujFigury(Goniec.class, buttonsTab, goniec1, goniec2);
        szachownica.aktualizujFigury(Skoczek.class, buttonsTab, skoczek1, skoczek2);
    }

    class KlikFigura implements ActionListener {
        Figura figura1;
        Figura figura2;
        ImageIcon ikona;

        public KlikFigura(Figura figura1, Figura figura2, ImageIcon ikona, JButton przycisk) {
            przycisk.setIcon(ikona);
            this.figura1 = figura1;
            this.figura2 = figura2;
            this.ikona = ikona;
        }
        public void actionPerformed(ActionEvent e) {
            if(figura1 != null && !(figura1.getFiguraPostawiona())) {
                szachownica.zdejmijFigure(postawionaFig, buttonsTab);
                szachownica.postawFigure(wiersz, kolumna, figura1, buttonsTab);
                historia.subHistoria(0, historia.getBiezInd());
                historia.dodajRuch(new Ruch(postawionaFig, figura1, wiersz, kolumna));
                historia.setBiezInd(historia.getHistoriaSize());
            }
            else if(figura2 != null && !(figura2.getFiguraPostawiona())) {
                szachownica.zdejmijFigure(postawionaFig, buttonsTab);
                szachownica.postawFigure(wiersz, kolumna, figura2, buttonsTab);
                historia.subHistoria(0, historia.getBiezInd());
                historia.dodajRuch(new Ruch(postawionaFig, figura2, wiersz, kolumna));
                historia.setBiezInd(historia.getHistoriaSize());
            }
            dispose();
        }
    }
}
