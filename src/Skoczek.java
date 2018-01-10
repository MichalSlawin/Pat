import javax.swing.*;

public class Skoczek extends Figura {
    private ImageIcon czSkoczek = new ImageIcon("figury/czSkoczek.png");
    private int wielk = Stale.WIELK_SZACHOWNICY;
    private int pocz = Stale.POCZ_SZACHOWNICY;
    private int wiersz;
    private int kolumna;

    public Skoczek(Kolor kolor) {
        super(kolor, true);
    }

    @Override
    public ImageIcon getIcon() {
        return czSkoczek;
    }

    @Override
    public void atakuj(Figura[][] tabFigur, Boolean czyAtak) {
        atakSkoczek(2, 1, tabFigur, czyAtak);
        atakSkoczek(2, -1, tabFigur, czyAtak);
        atakSkoczek(1, 2, tabFigur, czyAtak);
        atakSkoczek(-1, 2, tabFigur, czyAtak);
        atakSkoczek(-2, 1, tabFigur, czyAtak);
        atakSkoczek(-2, -1, tabFigur, czyAtak);
        atakSkoczek(1, -2, tabFigur, czyAtak);
        atakSkoczek(-1, -2, tabFigur, czyAtak);
    }

    public void atakSkoczek(int znak1, int znak2, Figura tabFigur[][], Boolean czyAtak) {
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
        return new ImageIcon("figury/czSkoczek.png");
    }
}