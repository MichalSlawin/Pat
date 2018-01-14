//Autor: Michał Sławiński 246803 gr.5

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SzachownicaGI extends JFrame {
    //przyciski, panele, pola tekstowe:
    private JButton buttonsTab[][] = new JButton[Stale.WIELK_SZACHOWNICY][Stale.WIELK_SZACHOWNICY];
    private JTextField status = new JTextField();
    private JButton warWygranej = new JButton("Status zagadki");
    private JButton zmianaZagadki = new JButton("Nastepna zagadka");
    private JButton cofnij = new JButton("Cofnij");
    private JButton dalej = new JButton("Dalej");
    private JButton zapisz = new JButton("Zapisz");
    private JButton wczytaj = new JButton("Wczytaj");
    private JButton pomoc = new JButton("Pomoc");
    private JPanel plansza = new JPanel();
    private JPanel sterowanie = new JPanel();
    //inne:
    private Color bronze = new Color(210,180,140);
    private JFrame wybor;
    private Pat pat;
    private Szachownica szachownica;
    private BKrol bKrol = new BKrol();
    private int wiel = Stale.WIELK_SZACHOWNICY;
    private static int nrZagadki = 1;
    private Historia historia = new Historia();

    public SzachownicaGI() {
        setTitle("Pat");
        Container cp = getContentPane();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp.setLayout(new GridLayout(1,2));
        cp.add(plansza);
        cp.add(sterowanie);
        sterowanie.setLayout(new GridLayout(8,1));
        status.setFont(new Font("Arial", Font.PLAIN, 30));
        warWygranej.setFont(new Font("Arial", Font.PLAIN, 30));
        zmianaZagadki.setFont(new Font("Arial", Font.PLAIN, 30));
        cofnij.setFont(new Font("Arial", Font.PLAIN, 30));
        dalej.setFont(new Font("Arial", Font.PLAIN, 30));
        zapisz.setFont(new Font("Arial", Font.PLAIN, 30));
        wczytaj.setFont(new Font("Arial", Font.PLAIN, 30));
        pomoc.setFont(new Font("Arial", Font.PLAIN, 30));
        sterowanie.add(status);
        sterowanie.add(warWygranej);
        sterowanie.add(zmianaZagadki);
        sterowanie.add(cofnij);
        sterowanie.add(dalej);
        sterowanie.add(zapisz);
        sterowanie.add(wczytaj);
        sterowanie.add(pomoc);
        warWygranej.addActionListener(new WarWygranej());
        zmianaZagadki.addActionListener(new ZmianaZagadki());
        cofnij.addActionListener(new Cofnij());
        dalej.addActionListener(new Dalej());
        zapisz.addActionListener(new Zapisz());
        wczytaj.addActionListener(new Wczytaj());
        pomoc.addActionListener(new Pomoc());
        plansza.setLayout(new GridLayout(8,8));
        inicjalizujPrzyciski();
        szachownica = new Szachownica();
        pat = new Pat(szachownica, buttonsTab);
        pat.inicjalizujSzachownice(Stale.USTAWIENIE1);
        status.setText("Zagadka nr 1");
    }

    private void inicjalizujPrzyciski() {
        for (int i=0;i<Stale.WIELK_SZACHOWNICY;i++)
            for (int j=0;j<Stale.WIELK_SZACHOWNICY;j++){
                buttonsTab[i][j] = new JButton("");
                if((i+j) % 2 == 0) (buttonsTab[i][j]).setBackground(bronze);
                plansza.add(buttonsTab[i][j]);
                (buttonsTab[i][j]).addActionListener(new SzachownicaGI.KlikPoleSzach(i,j));
            }
    }

    private void wyczyscPrzyciski() {
        for (int i=0;i<Stale.WIELK_SZACHOWNICY;i++)
            for (int j=0;j<Stale.WIELK_SZACHOWNICY;j++){
                buttonsTab[i][j].setIcon(null);
            }
    }

    class KlikPoleSzach implements ActionListener {
        private int wiersz, kolumna;
        KlikPoleSzach(int wiersz, int kolumna){this.wiersz = wiersz; this.kolumna = kolumna;}
        public void actionPerformed(ActionEvent e) {
            Figura postawionaFig = szachownica.getTabFig(wiersz, kolumna);
            if (postawionaFig.getFiguraPostawiona() && !(postawionaFig instanceof BKrol))
                new WyborFigurGI(buttonsTab, szachownica, wiersz, kolumna, postawionaFig, pat, historia);
            else {
                if(bKrol.getFiguraPostawiona()) szachownica.zdejmijFigure(bKrol, buttonsTab);
                bKrol.setPoleAtakowane(false);
                szachownica.postawFigure(wiersz, kolumna, bKrol, buttonsTab);
            }
        }
    }

    class WarWygranej implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            szachownica.atakWszystkie();
            int atakowane = szachownica.sprawdzIleAtakowanych();
            if(atakowane == wiel*wiel-1 && bKrol.getFiguraPostawiona() && !bKrol.getPoleAtakowane())
                status.setText("Wygrana!");
            else status.setText("Atakowane pola: " + Integer.toString(atakowane));
        }
    }

    class ZmianaZagadki implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            wyczyscPrzyciski();
            nrZagadki++;
            if(nrZagadki > 3) nrZagadki = 1;
            if(nrZagadki == 1) {
                pat.inicjalizujSzachownice(Stale.USTAWIENIE1);
                status.setText("Zagadka nr 1");
            }
            if(nrZagadki == 2) {
                pat.inicjalizujSzachownice(Stale.USTAWIENIE2);
                status.setText("Zagadka nr 2");
            }
            if(nrZagadki == 3) {
                pat.inicjalizujSzachownice(Stale.USTAWIENIE3);
                status.setText("Zagadka nr 3");
            }
        }
    }

    class Cofnij implements ActionListener {
        private Ruch poprzRuch;

        public void actionPerformed(ActionEvent e) {
            if(historia.getBiezInd() > 0) {
                poprzRuch = historia.getRuch(historia.getBiezInd()-1);
                szachownica.zdejmijFigure(poprzRuch.getWiersz(), poprzRuch.getKolumna(), buttonsTab);
                szachownica.postawFigure(poprzRuch.getWiersz(), poprzRuch.getKolumna(),
                        poprzRuch.getZdjetaFigura(), buttonsTab);
                historia.setBiezInd(historia.getBiezInd()-1);
                status.setText("Cofnieto");
            } else status.setText("Nie mozna cofnac");
        }
    }

    class Dalej implements ActionListener {
        private Ruch nastRuch;

        public void actionPerformed(ActionEvent e) {
            if(historia.getBiezInd() < historia.getHistoriaSize()) {
                nastRuch = historia.getRuch(historia.getBiezInd());
                szachownica.zdejmijFigure(nastRuch.getWiersz(), nastRuch.getKolumna(), buttonsTab);
                szachownica.postawFigure(nastRuch.getWiersz(), nastRuch.getKolumna(),
                        nastRuch.getPostawionaFigura(), buttonsTab);
                historia.setBiezInd(historia.getBiezInd()+1);
                status.setText("Przywrocono");
            } else status.setText("Nie mozna przywrocic");
        }
    }

    class Zapisz implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try{
                FileOutputStream fOut = new FileOutputStream("SzachownicaZapis");
                ObjectOutputStream os = new ObjectOutputStream(fOut);
                os.writeObject(szachownica);
                fOut.close();
                status.setText("Zapisano");
            } catch (IOException ex){status.setText("IOException");}
        }
    }

    class Wczytaj implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try{
                ObjectInputStream is = new ObjectInputStream(new FileInputStream("SzachownicaZapis"));
                szachownica = (Szachownica)is.readObject();
                is.close();
                szachownica.aktualizujSzachownice(buttonsTab);
                WyborFigurGI wyborFigur = new WyborFigurGI(szachownica);
                wyborFigur.aktualizujFigury();
                status.setText("Wczytano");
            } catch (IOException ex){
                status.setText("IOException");
                ex.printStackTrace();
            }catch (ClassNotFoundException nfe){status.setText("ClassNotFoundException");}
        }
    }

    class Pomoc implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new PomocGI();
        }
    }

    public static void main(String[] args) {
        JFrame f = new SzachownicaGI();
        f.setSize(1000,600);
        f.setLocation(500,200);
        f.setVisible(true);
    }
}
