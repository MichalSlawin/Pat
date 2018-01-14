public class Ruch {
    private Figura zdjetaFigura;
    private Figura postawionaFigura;
    private int wiersz;
    private int kolumna;

    public Ruch(Figura zdjetaFigura, Figura postawionaFigura, int wiersz, int kolumna) {
        this.zdjetaFigura = zdjetaFigura;
        this.postawionaFigura = postawionaFigura;
        this.wiersz = wiersz;
        this.kolumna = kolumna;
    }

    public Figura getZdjetaFigura() {
        return zdjetaFigura;
    }

    public Figura getPostawionaFigura() {
        return postawionaFigura;
    }

    public int getWiersz() {
        return wiersz;
    }

    public int getKolumna() {
        return kolumna;
    }
}
