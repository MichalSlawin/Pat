import javax.swing.*;

abstract public class Figura {
    private Kolor kolor;
    private Boolean poleAtakowane = false;
    private Boolean figuraPostawiona = false;
    private int wiersz;
    private int kolumna;
    private int wielk = Stale.WIELK_SZACHOWNICY;
    private int pocz = Stale.POCZ_SZACHOWNICY;

    public Figura(Kolor kolor, Boolean poleAtakowane) {
        this.kolor = kolor;
        this.poleAtakowane = poleAtakowane;
    }

    public void setPoleAtakowane(Boolean war) {
        poleAtakowane = war;
    }

    public void setFiguraPostawiona(Boolean war) { figuraPostawiona = war; }

    public void setFiguraPostawiona(Boolean war, int wiersz, int kolumna) {
        figuraPostawiona = war;
        this.wiersz = wiersz;
        this.kolumna = kolumna;
    }

    public Boolean getPoleAtakowane() { return poleAtakowane; }

    public Boolean getFiguraPostawiona() { return figuraPostawiona; }

    public Kolor getKolor() {
        return kolor;
    }

    public int getWiersz() { return wiersz; }

    public int getKolumna() { return kolumna; }

    abstract public ImageIcon getIcon();

    abstract public void atakuj(Figura tabFigur[][], Boolean czyAtak);

    public void atak(int znak1, int znak2, Figura tabFigur[][], Boolean czyAtak) {
        Figura figura;
        for(int i = pocz+1; i < wielk; i++) {
            if(wiersz+i*znak1 >= pocz && kolumna+i*znak2 >= pocz && wiersz+i*znak1 < wielk && kolumna+i*znak2 < wielk) {
                figura = tabFigur[wiersz+i*znak1][kolumna+i*znak2];
                if(figura.getFiguraPostawiona() && !(figura instanceof BKrol)) break;
                figura.setPoleAtakowane(czyAtak);
            }
        }
    }
}
