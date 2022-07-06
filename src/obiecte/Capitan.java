package obiecte;
import exceptii.ExceptieCapitan;

public class Capitan {

    String nume;
    String prenume;
    int varsta; // Minim 18.
    String contract;

    public Capitan(String nume_, String prenume_, int varsta_, String contract_) throws ExceptieCapitan {
        if(nume_.matches("^[a-zA-Z]*$")) {
            setNume(nume_);
        }
        else {
            throw new ExceptieCapitan(nume_ + " nu este permis! Numele Capitanului poate contine numai litere.");
        }

        if(prenume_.matches("^[a-zA-Z]*$")) {
            setPrenume(prenume_);
        }
        else {
            throw new ExceptieCapitan(prenume_ + " nu este permis! Prenumele Capitanului poate contine numai litere.");
        }

        if(varsta_ > 17) {
            setVarsta(varsta_);
        }
        else {
            throw new ExceptieCapitan("Varsta Capitanului nu poate fi " + varsta_ + ", fiind mai mica de 18!");
        }

        if(contract_.matches("\\d\\d\\.\\d\\d.\\d\\d\\d\\d-\\d\\d.\\d\\d.\\d\\d\\d\\d")) {
            setContract(contract_);
        }
        else {
            throw new ExceptieCapitan(contract_ + " nu respecta formatul ZZ.LL.AAAA-ZZ.LL.AAAA!");
        }
    }

    public void setNume(String valoare) {
        nume = valoare;
    }

    public String getNume() {
        return nume;
    }

    public void setPrenume(String valoare) {
        prenume = valoare;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setVarsta(int valoare) {
        varsta = valoare;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setContract(String valoare) {
        contract = valoare;
    }

    public String getContract() {
        return contract;
    }

    public String toString() {
        return nume + " " + prenume + " (" + varsta + "), contract " + contract;
    }
}
