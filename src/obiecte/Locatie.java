package obiecte;
import exceptii.ExceptieLocatie;

public class Locatie {

    double latitudine; // Valori acceptate (-90, 90).
    double longitudine; // Valori acceptate (-180, 180).

    public Locatie(double latitudine_, double longitudine_) throws ExceptieLocatie {
        if(latitudine_ < -90 || latitudine_ > 90)  {
            throw new ExceptieLocatie("Latitudinea trebuie sa fie intre -90 si 90, nu " + latitudine_ + "!");
        }
        else {
            setLatitudine(latitudine_);
        }

        if(longitudine_ < -180 || longitudine_ > 180) {
            throw new ExceptieLocatie("Longitudinea trebuie sa fie intre -180 si 180, nu " + longitudine_ + "!");
        }
        else {
            setLongitudine(longitudine_);
        }
    }

    public void setLatitudine(double valoare) {
        latitudine = valoare;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public void setLongitudine(double valoare) {
        longitudine = valoare;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public String toString() {
        return "<latitudine: " + latitudine + "; longitudine: " + longitudine + ">";
    }

    public static double distanta(Locatie l1, Locatie l2) {
        return Math.sqrt(Math.pow((l1.getLatitudine() - l2.getLatitudine()), 2) + Math.pow((l1.getLongitudine() - l2.getLongitudine()), 2));
    }

}
