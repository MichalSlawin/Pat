import javax.swing.*;

public class BKrol extends Figura {
    private ImageIcon bKrol = new ImageIcon("figury/bKrol.png");

    public BKrol() { super(Kolor.BIALY, false); }

    @Override
    public ImageIcon getIcon() {
        return bKrol;
    }

    @Override
    public void atakuj(Figura[][] tabFigur, Boolean czyAtak) { }
}
