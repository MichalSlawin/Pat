import javax.swing.*;

public class Goniec extends Figura {
    private ImageIcon czGoniec = new ImageIcon("figury/czGoniec.png");
    private int wielk = Stale.WIELK_SZACHOWNICY;
    private int pocz = Stale.POCZ_SZACHOWNICY;
    private int wiersz = super.getWiersz();
    private int kolumna = super.getKolumna();

    public Goniec(Kolor kolor) {
        super(kolor, true);
    }

    @Override
    public ImageIcon getIcon() {
        return czGoniec;
    }

    @Override
    public void atakuj(Figura tabFigur[][], Boolean czyAtak) {
        atak(1, 1, tabFigur, czyAtak);
        atak(1, -1, tabFigur, czyAtak);
        atak(-1, 1, tabFigur, czyAtak);
        atak(-1, -1, tabFigur, czyAtak);
    }

    public static ImageIcon getDefaultIcon() {
        return new ImageIcon("figury/czGoniec.png");
    }
}