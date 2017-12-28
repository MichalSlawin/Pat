import javax.swing.*;

public class Szachownica {
    private Figura tabFigur[][] = new Figura[8][8];
    private int krolLimit = 1, hetmanLimit = 1, wiezaLimit = 2, goniecLimit = 2, skoczekLimit = 2;
    private Boolean moznaPostawic;
    private int ileAtakowanych = 0;

    public int postawFigure(int wiersz, int kolumna, char kolor, String rodzajFigury, String rodzajPostawionejFig) {
        moznaPostawic = false;
        aktualizujLimity(rodzajFigury, -1);
        if(moznaPostawic) {
            tabFigur[wiersz][kolumna] = new Figura(kolor, rodzajFigury, wiersz, kolumna);
            aktualizujLimity(rodzajPostawionejFig, 1);
            tabFigur[wiersz][kolumna].aktualizujAtakowane(rodzajPostawionejFig, false);
            tabFigur[wiersz][kolumna].aktualizujAtakowane(rodzajFigury, true);
            return 0;
        }
        return 1;
    }

    public void postawFigure(int wiersz, int kolumna, char kolor, String rodzajFigury) {
            tabFigur[wiersz][kolumna] = new Figura(kolor, rodzajFigury, wiersz, kolumna);
    }

    private void aktualizujLimity(String rodzajFigury, int zmianaLimitu) {
        switch (rodzajFigury) {
            case "krol":
                if(krolLimit > 0 || zmianaLimitu == 1) {
                    krolLimit+=zmianaLimitu;
                    moznaPostawic = true;
                }
                break;
            case "hetman":
                if(hetmanLimit > 0 || zmianaLimitu == 1) {
                    hetmanLimit+=zmianaLimitu;
                    moznaPostawic = true;
                }
                break;
            case "wieza":
                if(wiezaLimit > 0 || zmianaLimitu == 1) {
                    wiezaLimit+=zmianaLimitu;
                    moznaPostawic = true;
                }
                break;
            case "goniec":
                if(goniecLimit > 0 || zmianaLimitu == 1) {
                    goniecLimit+=zmianaLimitu;
                    moznaPostawic = true;
                }
                break;
            case "skoczek":
                if(skoczekLimit > 0 || zmianaLimitu == 1) {
                    skoczekLimit+=zmianaLimitu;
                    moznaPostawic = true;
                }
                break;
            case "pionek":
                moznaPostawic = true;
                break;
        }
    }

    public void ustawPionki(int ustawienie[][], JButton ButtonsTab[][]) {
        for(int i = 0; i < 8; i++) {
            postawFigure(ustawienie[i][0], ustawienie[i][1], 'c',"pionek");
            ButtonsTab[ustawienie[i][0]][ustawienie[i][1]].setIcon(Stale.CZ_PIONEK);
        }
    }

    public Figura getPlanszaTabFig(int wiersz, int kolumna) {
        return tabFigur[wiersz][kolumna];
    }
}
