import javax.swing.*;
import java.io.Serializable;

public class Szachownica implements Serializable {
    private int pocz = Stale.POCZ_SZACHOWNICY;
    private int wielk = Stale.WIELK_SZACHOWNICY;
    private Figura tabFigur[][] = new Figura[wielk][wielk];
    private int ileAtakowanych = 0;

    public void postawFigure(int wiersz, int kolumna, Figura figura, JButton buttonsTab[][]) {
        tabFigur[wiersz][kolumna] = figura;
        if(figura != null) {
            figura.setFiguraPostawiona(true, wiersz, kolumna);
            if(buttonsTab != null)
                buttonsTab[wiersz][kolumna].setIcon(figura.getIcon());
            figura.atakuj(tabFigur, true);
        }
    }

    public void aktualizujSzachownice(JButton buttonsTab[][]) {
        for(int i = pocz; i < wielk; i++)
            for(int j = pocz; j < wielk; j++)
                buttonsTab[i][j].setIcon(tabFigur[i][j].getIcon());
    }

    public int aktualizujFigury(Class<? extends Figura> klasa, JButton buttonsTab[][], Figura... figura) {
        int ileFigur = 0;
        for(int i = pocz; i < wielk; i++)
            for(int j = pocz; j < wielk; j++) {
                if(tabFigur[i][j].getClass() == klasa) {
                    postawFigure(i, j, figura[ileFigur], buttonsTab);
                    ileFigur++;
                }
            }
        return ileFigur;
    }

    public int sprawdzIleAtakowanych() {
        ileAtakowanych = 0;
        for(int i = pocz; i < wielk; i++)
            for(int j = pocz; j < wielk; j++)
                if(tabFigur[i][j].getPoleAtakowane()) ileAtakowanych++;
        return ileAtakowanych;
    }

    public void postawPustePole(int wiersz, int kolumna) {
        tabFigur[wiersz][kolumna] = new PustePole();
        tabFigur[wiersz][kolumna].setFiguraPostawiona(false, wiersz, kolumna);
    }

    public void zdejmijFigure(Figura figura, JButton buttonsTab[][]) {
        int wiersz = figura.getWiersz();
        int kolumna = figura.getKolumna();
        Boolean czyAtak;
        czyAtak = figura.getPoleAtakowane();
        tabFigur[wiersz][kolumna] = new PustePole();
        tabFigur[wiersz][kolumna].setPoleAtakowane(czyAtak);
        figura.setFiguraPostawiona(false);
        buttonsTab[wiersz][kolumna].setIcon(null);
        figura.atakuj(tabFigur, false);
    }

    public void zdejmijFigure(int wiersz, int kolumna, JButton buttonsTab[][]) {
        Boolean czyAtak = tabFigur[wiersz][kolumna].getPoleAtakowane();
        tabFigur[wiersz][kolumna].atakuj(tabFigur, false);
        tabFigur[wiersz][kolumna].setFiguraPostawiona(false);
        tabFigur[wiersz][kolumna] = new PustePole();
        tabFigur[wiersz][kolumna].setPoleAtakowane(czyAtak);
        buttonsTab[wiersz][kolumna].setIcon(null);
    }

    public void atakWszystkie() {
        for(int i = pocz; i < wielk; i++)
            for(int j = pocz; j < wielk; j++)
                if(tabFigur[i][j].getFiguraPostawiona()) tabFigur[i][j].atakuj(tabFigur, true);
    }

    public Figura getTabFig(int wiersz, int kolumna) {
        return tabFigur[wiersz][kolumna];
    }
}
