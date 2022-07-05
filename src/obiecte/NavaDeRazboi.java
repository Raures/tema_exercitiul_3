package obiecte;

import java.util.List;

public class NavaDeRazboi {

    String nume;
    Locatie locatie;
    List<Capitan> capitani;
    boolean validare = true;

    public NavaDeRazboi(String nume_, Locatie locatie_, List<Capitan> capitani_) {
        setNume(nume_);

        if(locatie_ instanceof Locatie) {
            setLocatie(locatie_);
        }
        else {
            System.out.println("Locatia trebuie sa fie de tip <Locatie>!");
        }

        for(Capitan c: capitani_) {
            if(!(c instanceof Capitan)) {
                System.out.println("Elementul " + c + " nu este de tip <Capitan>!");
                validare = false;
            }
            if(!validare) {
                break;
            }
        }

        if(validare) {
            setCapitani(capitani_);
        }
    }

    void setNume(String valoare) {
        nume = valoare;
    }

    public String getNume() {
        return nume;
    }

    void setLocatie(Locatie valoare) {
        locatie = valoare;
    }

    public Locatie getLocatie() {
        return locatie;
    }

    void setCapitani(List<Capitan> valoare) {
        capitani = valoare;
    }

    public List<Capitan> getCapitani() {
        return capitani;
    }

    @Override
    public String toString() {
        return "Nava " + nume + " (locatie: " + locatie + "), capitani " + capitani + ".";
    }

}
