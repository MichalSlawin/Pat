import javax.swing.*;

public class Pat {
    private Szachownica szachownica;
    private JButton buttonsTab[][];

    public Pat(Szachownica szachownica, JButton buttonsTab[][]) {
        this.szachownica = szachownica;
        this.buttonsTab = buttonsTab;
    }

    public void inicjalizujSzachownice(int ustawienie[][]) {
        for (int i=Stale.POCZ_SZACHOWNICY;i<Stale.WIELK_SZACHOWNICY;i++)
            for (int j=Stale.POCZ_SZACHOWNICY;j<Stale.WIELK_SZACHOWNICY;j++){
                if(szachownica.getTabFig(i, j) != null)
                    szachownica.getTabFig(i, j).setFiguraPostawiona(false);
                szachownica.postawPustePole(i, j);
            }
        ustawPionki(ustawienie, buttonsTab);
    }

    private void ustawPionki(int ustawienie[][], JButton buttonsTab[][]) {
        for(int i = Stale.POCZ_SZACHOWNICY; i < Stale.WIELK_SZACHOWNICY; i++) {
            szachownica.postawFigure(ustawienie[i][0], ustawienie[i][1], new Pionek(Kolor.CZARNY), buttonsTab);
        }
    }
}