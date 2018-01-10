import javax.swing.*;

public class Pionek extends Figura {
    private ImageIcon czPionek = new ImageIcon("figury/czPionek.png");
    private int wiersz;
    private int kolumna;

    public Pionek(Kolor kolor) {
        super(kolor, true);
    }

    @Override
    public ImageIcon getIcon() {
        return czPionek;
    }

    @Override
    public void atakuj(Figura[][] tabFigur, Boolean czyAtak) {
        wiersz = super.getWiersz();
        kolumna = super.getKolumna();
        tabFigur[wiersz][kolumna].setPoleAtakowane(czyAtak);
    }

    public static ImageIcon getDefaultIcon() {
        return new ImageIcon("figury/czPionek.png");
    }
}