package obiecte;

public class Locatie {

    double latitudine; // -90 - 90
    double longitudine; // -180 - 180

    public Locatie(double latitudine_, double longitudine_) {
        if(latitudine_ > -90 || latitudine_ < 90)  {
            setLatitudine(latitudine_);
        }
        else {
            System.out.println("Latitudinea trebuie sa fie intre (-90; 90)!");
        }

        if(longitudine_ > -180 || longitudine_ < 180) {
            setLongitudine(longitudine_);
        }
        else {
            System.out.println("Longitudinea trebuie sa fie intre (-180; 180)!");
        }
    }

    void setLatitudine(double valoare) {
        latitudine = valoare;
    }

    public double getLatitudine() {
        return latitudine;
    }

    void setLongitudine(double valoare) {
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
