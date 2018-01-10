import javax.swing.*;
import java.awt.*;

public class PomocGI extends JFrame {
    JTextArea pomocText = new JTextArea();

    public PomocGI() {
        setTitle("Pomoc");
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout()) ;
        pomocText.setFont(new Font("Arial", Font.PLAIN, 22));
        pomocText.setText("W lamiglowce Pat zadaniem gracza jest postawienie czarnych figur na miejscu\n"+
        "czarnych pionkow w taki sposob, aby atakowane byly wszystkie pola szachownicy oprocz jednego.\n"+
        "Na ostatnim nieatakowanym polu musi znalezc sie bialy krol.\n"+
        "Aby postawic czarna figure nalezy kliknac na pionka i wybrac ja z listy.\n"+
        "Aby postawic bialego krola wystarczy kliknac na dowolne niezajete pole szachownicy.\n"+
        "Aby poddac ocenie nasze rozwiazanie nalezy kliknac przycisk Status Zagadki.\n"+
        "Przyciski Cofnij i Dalej pozwalaja nam na powrot do naszych poprzednich ruchow.\n"+
        "Zapisz i Wczytaj pozwala na zachowanie i powrot do ustawionej wczesniej pozycji.\n");
        pomocText.setPreferredSize(new Dimension(950,500));
        cp.add(pomocText);
        setSize(1000,500) ;
        setLocation(500,200);
        setVisible(true) ;
    }
}
