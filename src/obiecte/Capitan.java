package obiecte;

public class Capitan {

    String nume;
    String prenume;
    int varsta; // minim 18
    String contract;

    public Capitan(String nume_, String prenume_, int varsta_, String contract_) {
        if(nume_.matches("^[a-zA-Z0-9]*$")) {
            setNume(nume_);
        }
        else {
            System.out.println("Numele poate sa contina doar litere!");
        }

        if(prenume_.matches("^[a-zA-Z0-9]*$")) {
            setPrenume(prenume_);
        }
        else {
            System.out.println("Prenumele poate sa contina doar litere!");
        }

        if(varsta_ > 18) {
            setVarsta(varsta_);
        }
        else {
            System.out.println("Varsta trebuie sa fie mai mare de 18 ani!");
        }

        if(contract_.matches("\\d\\d\\.\\d\\d.\\d\\d\\d\\d-\\d\\d.\\d\\d.\\d\\d\\d\\d")) {
            setContract(contract_);
        }
        else {
            System.out.println("Data trebuie sa respecte formatul ZZ.LL.AAAA-ZZ.LL.AAAA!");
        }
    }

    void setNume(String valoare) {
        nume = valoare;
    }

    String getNume() {
        return nume;
    }

    void setPrenume(String valoare) {
        prenume = valoare;
    }

    String getPrenume() {
        return prenume;
    }

    void setVarsta(int valoare) {
        varsta = valoare;
    }

    int getVarsta() {
        return varsta;
    }

    void setContract(String valoare) {
        contract = valoare;
    }

    String getContract() {
        return contract;
    }

    public String toString() {
        return nume + " " + prenume + " (" + varsta + "), contract " + contract;
    }
}
