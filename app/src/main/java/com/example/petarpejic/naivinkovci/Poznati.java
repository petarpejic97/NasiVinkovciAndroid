package com.example.petarpejic.naivinkovci;

public class Poznati {
    private String ime;
    private String zanimanje;
    private int slika;

    public Poznati(String ime, String zanimanje, int slika) {
        this.ime = ime;
        this.zanimanje = zanimanje;
        this.slika = slika;
    }

    public String getIme() {
        return ime;
    }

    public String getZanimanje() {
        return zanimanje;
    }

    public int getSlika() {
        return slika;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setZanimanje(String zanimanje) {
        this.zanimanje = zanimanje;
    }

    public void setSlika(int slika) {
        this.slika = slika;
    }
}
