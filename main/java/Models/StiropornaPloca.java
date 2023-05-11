package Models;

import java.io.Serializable;

public class StiropornaPloca extends Proizvod implements PrikazProizvoda, Serializable {

    private int komPoPakiranju; //32 ili 50 -> malo/veliko pakiranje

    public StiropornaPloca (String naziv, double cijena, int kolicina, int sifra, String proizvodac, int komPoPakiranju) {
        super(naziv, cijena, kolicina, sifra, proizvodac);
        setKomPoPakiranju(komPoPakiranju);
    }

    @Override
    public String getNaziv() {
        return super.getNaziv();
    }

    @Override
    public double getCijena() {
        return super.getCijena();
    }

    @Override
    public int getKolicina() {
        return super.getKolicina();
    }

    @Override
    public int getSifra() {
        return super.getSifra();
    }

    @Override
    public String getProizvodac() {
        return super.getProizvodac();
    }

    public int getKomPoPakiranju() {
        return komPoPakiranju;
    }

    @Override
    public void setNaziv(String naziv) {
        super.setNaziv(naziv);
    }

    @Override
    public void setCijena(double cijena) {
        super.setCijena(cijena);
    }

    @Override
    public void setKolicina(int kolicina) {
        super.setKolicina(kolicina);
    }

    @Override
    public void setSifra(int sifra) {
        super.setSifra(sifra);
    }

    @Override
    public void setProizvodac(String proizvodac) {
        super.setProizvodac(proizvodac);
    }

    public void setKomPoPakiranju(int komPoPakiranju) {
        this.komPoPakiranju = komPoPakiranju;
    }

    @Override
    public void prikazi() {
        System.out.println(this);
    }

    @Override
    public void prikaziKolicinu() {
        System.out.println(getKolicina());
    }

    @Override
    public String toString() {
        return this.getNaziv() + "," + this.getCijena() + "," + this.getKolicina() + "," + this.getSifra() + "," + this.getProizvodac() + "," + this.getKomPoPakiranju();
    }
}
