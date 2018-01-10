import javax.swing.*;

public class Hetman extends Figura {
    private ImageIcon czHetman = new ImageIcon("figury/czHetman.png");

    public Hetman(Kolor kolor) {
        super(kolor, true);
    }

    @Override
    public ImageIcon getIcon() {
        return czHetman;
    }

    @Override
    public void atakuj(Figura[][] tabFigur, Boolean czyAtak) {
        atak(0, 1, tabFigur, czyAtak);
        atak(0, -1, tabFigur, czyAtak);
        atak(1, 0, tabFigur, czyAtak);
        atak(-1, 0, tabFigur, czyAtak);
        atak(1, 1, tabFigur, czyAtak);
        atak(1, -1, tabFigur, czyAtak);
        atak(-1, 1, tabFigur, czyAtak);
        atak(-1, -1, tabFigur, czyAtak);
    }

    public static ImageIcon getDefaultIcon() {
        return new ImageIcon("figury/czHetman.png");
    }
}
