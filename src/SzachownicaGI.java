import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SzachownicaGI extends JFrame {
    //przyciski, panele, pola tekstowe:
    private JButton buttonsTab[][] = new JButton[8][8];
    private JPanel plansza = new JPanel();
    private JPanel sterowanie = new JPanel();
    private JTextField t = new JTextField(10);
    //obiekty figur:
    private Figura figbKrol;
    //inne:
    private Szachownica szachownica;
    private Boolean ustawionyBKrol = false;
    private Color bronze = new Color(210,180,140);
    private JFrame wybor;

    public SzachownicaGI() {
        setTitle("Pat");
        Container cp = getContentPane();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp.setLayout(new GridLayout(1,2));
        cp.add(plansza); cp.add(sterowanie);
        sterowanie.setLayout(new GridLayout(8,1));
        sterowanie.add(t);
        t.setFont(t.getFont().deriveFont(30.0f));
        plansza.setLayout(new GridLayout(8,8));
        szachownica = new Szachownica();
        for (int i=0;i<8;i++)
            for (int j=0;j<8;j++){
                szachownica.postawFigure(i,j,'\0',"");
                buttonsTab[i][j] = new JButton("");
                if((i+j) % 2 == 0) (buttonsTab[i][j]).setBackground(bronze);
                plansza.add(buttonsTab[i][j]);
                (buttonsTab[i][j]).addActionListener(new KlikPoleSzach(i,j));
            }
        szachownica.ustawPionki(Stale.USTAWIENIE2, buttonsTab);
}

    class KlikPoleSzach implements ActionListener {
        int wiersz, kolumna;
        KlikPoleSzach(int wiersz, int kolumna){this.wiersz = wiersz; this.kolumna = kolumna;}
        public void actionPerformed(ActionEvent e) {
            String nazwaPostawionejFig = szachownica.getPlanszaTabFig(wiersz, kolumna).getRodzajFigury();
            if (nazwaPostawionejFig.matches("pionek|goniec|skoczek|wieza|hetman|krol")) {
                t.setText(wiersz +","+ kolumna);
                new WyborFigurGI(buttonsTab, szachownica, wiersz, kolumna, nazwaPostawionejFig);
            }
            else {
                t.setText(wiersz +","+ kolumna);
                if(!ustawionyBKrol) {
                    szachownica.postawFigure(wiersz, kolumna,'b',"Bkrol");
                    figbKrol = szachownica.getPlanszaTabFig(wiersz, kolumna);
                    buttonsTab[wiersz][kolumna].setIcon(Stale.B_KROL);
                    ustawionyBKrol = true;
                } else {
                    szachownica.postawFigure(figbKrol.getWiersz(), figbKrol.getKolumna(),'\0',"");
                    buttonsTab[figbKrol.getWiersz()][figbKrol.getKolumna()].setIcon(null);
                    szachownica.postawFigure(wiersz, kolumna,'b',"Bkrol");
                    figbKrol = szachownica.getPlanszaTabFig(wiersz, kolumna);
                    buttonsTab[wiersz][kolumna].setIcon(Stale.B_KROL);
                }
            }
        }
    }
    public static void main(String[] args) {
        JFrame f =new SzachownicaGI();
        f.setSize(1000,600);
        f.setLocation(500,200);
        f.setVisible(true);
    }
}
