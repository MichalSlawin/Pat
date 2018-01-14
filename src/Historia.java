import java.util.ArrayList;
import java.util.List;

public class Historia {
    private ArrayList<Ruch> historiaRuchow = new ArrayList<Ruch>();

    private int biezInd = 0;

    public void dodajRuch(Ruch ruch) {
        historiaRuchow.add(ruch);
        biezInd++;
    }

    public Ruch getRuch(int ind) {
        return historiaRuchow.get(ind);
    }

    public void subHistoria(int pocz, int kon) {
        historiaRuchow = new ArrayList<Ruch>(historiaRuchow.subList(pocz, kon));
    }

    public int getBiezInd() {
        return biezInd;
    }

    public void setBiezInd(int biezInd) {
        this.biezInd = biezInd;
    }

    public int getHistoriaSize() {
        return historiaRuchow.size();
    }
}
