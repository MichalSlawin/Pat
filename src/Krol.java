import javax.swing.*;

public class Krol extends Figura {
    private ImageIcon czKrol = new ImageIcon("figury/czKrol.png");
    private int wielk = Stale.WIELK_SZACHOWNICY;
    private int pocz = Stale.POCZ_SZACHOWNICY;
    private int wiersz;
    private int kolumna;

    public Krol(Kolor kolor) {
        super(kolor, true);
    }

    @Override
    public ImageIcon getIcon() {
        return czKrol;
    }

    @Override
    public void atakuj(Figura[][] tabFigur, Boolean czyAtak) {
        atakKrol(0, 1, tabFigur, czyAtak);//!
        atakKrol(0, -1, tabFigur, czyAtak);
        atakKrol(1, 0, tabFigur, czyAtak);//!
        atakKrol(-1, 0, tabFigur, czyAtak);
        atakKrol(1, 1, tabFigur, czyAtak);//!
        atakKrol(1, -1, tabFigur, czyAtak);
        atakKrol(-1, 1, tabFigur, czyAtak);
        atakKrol(-1, -1, tabFigur, czyAtak);
    }

    public void atakKrol(int znak1, int znak2, Figura tabFigur[][], Boolean czyAtak) {
        int i = 1;
        wiersz = super.getWiersz();
        kolumna = super.getKolumna();
        if (wiersz + i * znak1 >= pocz && kolumna + i * znak2 >= pocz && wiersz + i * znak1 < wielk && kolumna + i * znak2 < wielk) {
            Figura figura = tabFigur[wiersz + i * znak1][kolumna + i * znak2];
            if(!figura.getFiguraPostawiona() || figura instanceof BKrol)
                figura.setPoleAtakowane(czyAtak);
        }
    }

    public static ImageIcon getDefaultIcon() {
        return new ImageIcon("figury/czKrol.png");
    }
}