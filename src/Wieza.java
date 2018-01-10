import javax.swing.*;

public class Wieza extends Figura {
    private ImageIcon czWieza = new ImageIcon("figury/czWieza.png");

    public Wieza(Kolor kolor) {
        super(kolor, true);
    }

    @Override
    public ImageIcon getIcon() {
        return czWieza;
    }

    @Override
    public void atakuj(Figura tabFigur[][], Boolean czyAtak) {
        atak(0, 1, tabFigur, czyAtak);
        atak(0, -1, tabFigur, czyAtak);
        atak(1, 0, tabFigur, czyAtak);
        atak(-1, 0, tabFigur, czyAtak);
    }

    public static ImageIcon getDefaultIcon() {
        return new ImageIcon("figury/czWieza.png");
    }
}
