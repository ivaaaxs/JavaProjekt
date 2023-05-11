package Models;

abstract public class Proizvod {

    private String naziv;
    private double cijena;
    private int kolicina;
    private int sifra;
    private String proizvodac;

    public Proizvod (String naziv, double cijena, int kolicina, int sifra, String proizvodac) {
        setNaziv(naziv);
        setCijena(cijena);
        setKolicina(kolicina);
        setSifra(sifra);
        setProizvodac(proizvodac);
    }

    public String getNaziv() {
        return naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public int getSifra() {
        return sifra;
    }

    public String getProizvodac() {
        return proizvodac;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public void setProizvodac(String proizvodac) {
        this.proizvodac = proizvodac;
    }
}
