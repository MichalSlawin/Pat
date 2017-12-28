public class Figura {
    private char kolorFigury;
    private String rodzajFigury;
    private int wiersz;
    private int kolumna;
    private Boolean poleAtakowane = false;
    private static int POCZ_SZACHOWNICY = 0;
    private static int KON_SZACHOWNICY = 7;
    private int i, j;

    public Figura(char kolorFigury, String rodzajFigury, int wiersz, int kolumna) {
        this.kolorFigury = kolorFigury;
        this.rodzajFigury = rodzajFigury;
        this.wiersz = wiersz;
        this.kolumna = kolumna;
    }

    public void aktualizujAtakowane(String rodzajFigury, Boolean dodawanieAtakowanych) {
        switch (rodzajFigury) {
            case "krol":

                break;
            case "hetman":
                setPoleAtakowane(dodawanieAtakowanych);
                for(i = 1; i <= 7; i++) {
                    if(wiersz + i >= 0 && wiersz + i <= 7 && kolumna + i >= 0 && kolumna + i <= 7)
                        setPoleAtakowane(dodawanieAtakowanych);
                    if(wiersz - i >= 0 && wiersz - i <= 7 && kolumna - i >= 0 && kolumna - i <= 7)
                        setPoleAtakowane(dodawanieAtakowanych);
                    if(wiersz + i >= 0 && wiersz + i <= 7 && kolumna - i >= 0 && kolumna - i <= 7)
                        setPoleAtakowane(dodawanieAtakowanych);
                    if(wiersz - i >= 0 && wiersz - i <= 7 && kolumna + i >= 0 && kolumna + i <= 7)
                        setPoleAtakowane(dodawanieAtakowanych);
                }
                for(i = -7; i <= 7; i++) {
                    if(wiersz + i >= 0 && wiersz + i <= 7)
                        setPoleAtakowane(dodawanieAtakowanych);
                    if(kolumna + i >= 0 && kolumna + i <= 7)
                        setPoleAtakowane(dodawanieAtakowanych);
                }
                break;
            case "wieza":
                for(i = -7; i <= 7; i++) {
                    if(wiersz + i >= 0 && wiersz + i <= 7)
                        setPoleAtakowane(dodawanieAtakowanych);
                    if(kolumna + i >= 0 && kolumna + i <= 7)
                        setPoleAtakowane(dodawanieAtakowanych);
                }
                break;
            case "goniec":
                setPoleAtakowane(dodawanieAtakowanych);
                for(i = 1; i <= 7; i++) {
                    if(wiersz + i >= 0 && wiersz + i <= 7 && kolumna + i >= 0 && kolumna + i <= 7)
                        setPoleAtakowane(dodawanieAtakowanych);
                    if(wiersz - i >= 0 && wiersz - i <= 7 && kolumna - i >= 0 && kolumna - i <= 7)
                        setPoleAtakowane(dodawanieAtakowanych);
                    if(wiersz + i >= 0 && wiersz + i <= 7 && kolumna - i >= 0 && kolumna - i <= 7)
                        setPoleAtakowane(dodawanieAtakowanych);
                    if(wiersz - i >= 0 && wiersz - i <= 7 && kolumna + i >= 0 && kolumna + i <= 7)
                        setPoleAtakowane(dodawanieAtakowanych);
                }
                break;
            case "skoczek":
                setPoleAtakowane(dodawanieAtakowanych);
                for(i = -2; i <= 2; i += 4) {
                    for(j = -1; j <= 1; j += 2) {
                        setPoleAtakowane(dodawanieAtakowanych);
                    }
                }
                setPoleAtakowane(dodawanieAtakowanych);
                setPoleAtakowane(dodawanieAtakowanych);
                setPoleAtakowane(dodawanieAtakowanych);
                setPoleAtakowane(dodawanieAtakowanych);
                setPoleAtakowane(dodawanieAtakowanych);

                break;
        }
    }

    private void atakKrol(Boolean dodawanieAtakowanych) {
        for(i = -1; i <= 1; i++)
            for(j = -1; j <= 1; j++)
                if(wiersz + i >= POCZ_SZACHOWNICY && wiersz + i <= KON_SZACHOWNICY &&
                        kolumna + j >= POCZ_SZACHOWNICY && kolumna + j <= KON_SZACHOWNICY)
                    setPoleAtakowane(dodawanieAtakowanych);
    }

    public void setPoleAtakowane(Boolean war) {
        poleAtakowane = war;
    }

    public char getKolorFigury() {
        return kolorFigury;
    }

    public String getRodzajFigury() { return rodzajFigury; }

    public int getWiersz() { return wiersz; }

    public int getKolumna() { return kolumna; }
}
