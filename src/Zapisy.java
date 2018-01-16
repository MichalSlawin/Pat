import java.util.ArrayList;

public class Zapisy {
    private ArrayList<Zapis> zapisyList = new ArrayList<Zapis>();

    public void dodajZapis(Zapis zapis) {
        zapisyList.add(zapis);
    }

    public Zapis getZapis(String nazwa) {
        int ind = znajdzZapis(nazwa);
        if(ind != -1) {
            return zapisyList.get(ind);
        }
        return null;
    }

    public Zapis getZapis(int ind) {
        return zapisyList.get(ind);
    }

    public int getZapisySize() {
        return zapisyList.size();
    }

    private int znajdzZapis(String nazwa) {
        for(int i = 0; i < zapisyList.size(); i++) {
            if(zapisyList.get(i).getNazwa().equals(nazwa)) {
                return i;
            }
        }
        return -1;
    }
}
