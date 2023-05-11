package Models;

import java.io.Serializable;
import java.util.Date;

public class Ljepilo extends Proizvod implements PrikazProizvoda, Serializable {

    private Date rokTrajanja;

    public Ljepilo (String naziv, double cijena, int kolicina, int sifra, String proizvodac, Date rokTrajanja) {
        super(naziv, cijena, kolicina, sifra, proizvodac);
        setRokTrajanja(rokTrajanja);
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

    public Date getRokTrajanja() {
        return rokTrajanja;
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

    public void setRokTrajanja(Date rokTrajanja) {
        this.rokTrajanja = rokTrajanja;
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
        return this.getNaziv() + "," + this.getCijena() + "," + this.getKolicina() + "," + this.getSifra() + "," + this.getProizvodac() + "," + this.getRokTrajanja();
    }
}
