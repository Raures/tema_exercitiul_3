package obiecte;
import exceptii.ExceptieNavaDeRazboi;

import java.util.List;

public class NavaDeRazboi {

    String nume;
    Locatie locatie;
    List<Capitan> capitani;

    public NavaDeRazboi(String nume_, Locatie locatie_, List<Capitan> capitani_) throws ExceptieNavaDeRazboi {
        if (nume_.isEmpty() || nume_.isBlank()) {
            throw new ExceptieNavaDeRazboi("Nava trebuie sa aiba un nume!");
        }
        else {
            setNume(nume_);
        }

        setLocatie(locatie_);

        if(!capitani_.isEmpty()) {
            setCapitani(capitani_);
        }
        else {
            throw new ExceptieNavaDeRazboi("Lista trebuie sa contina cel putin un obiect de tip Capitan!");
        }
    }

    public void setNume(String valoare) {
        nume = valoare;
    }

    public String getNume() {
        return nume;
    }

    public void setLocatie(Locatie valoare) {
        locatie = valoare;
    }

    public Locatie getLocatie() {
        return locatie;
    }

    public void setCapitani(List<Capitan> valoare) {
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
