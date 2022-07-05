
/*
Creați o clasă navă de război care are ca atribute un nume, o locație (coordonate de Locatie(lat,long)
            latitudine și longitudine) și o listă a căpitanilor săi. Fiecare căpitan este caracterizat
            prin nume, prenume, varsta și perioada în care a fost căpitan al acestei nave (data începerii contractului
            – data terminării contractului - String.

            0) Toti membrii privati si accesati cu get/set. !!! La set corectitudinea datelor
            1) Creați o listă de nave și afișați-o
            2) Validați corectitudinea datelor atunci când sunt introduse, de ex. valorile
            pentru latitudine/longitudine, datele contractului, ...
            TEMA 3) Pentru fiecare căpitan, identificați navele și perioada/perioadele în care a fost
            // de facut un dictionar<Capitani, dictionar<Nave, Perioada>>
            căpitan pe acele nave
            BONUS: Identificați navele din listă care se află în raza de acțiune a altei nave

            // de facut throw.
 */

import obiecte.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<NavaDeRazboi> nave = new ArrayList<>();
        int nr_nave = 10;
        int capitani_per_nava = 5;

        List<Capitan> capitani = new ArrayList<>();
        int nr_capitani = 4;

        String[] nume_capitani = {"Dej", "Munteanu", "Dumitrescu", "Neacsu", "Florinescu"};
        String[] nume_nave = {"Barracuda 101", "Jeepers 7", "Maven", "Gradle", "J00B"};
        String[] prenume = {"Alexandru", "Vasile", "Ion", "Cristian", "Marius", "Adrian"};
        String[] perioade = {"01.01.2000-29.10.2005", "15.08.2002-16.03.2009", "12.02.2015-03.07.2017", "07.11.2017-01.01.2020"};

        Random randy = new Random(System.currentTimeMillis());

        for(int i = 0; i < nr_capitani; i++) {
            capitani.add(new Capitan(nume_capitani[randy.nextInt(0, nume_capitani.length)], prenume[randy.nextInt(0, prenume.length)], randy.nextInt(18, 70), perioade[randy.nextInt(0, perioade.length)]));
        }

        for(int i = 0; i < nr_nave; i++) {
            List<Capitan> lista_temporara = new ArrayList<>();
            for(int j = 0; j < randy.nextInt(1, capitani_per_nava); j++) {
                lista_temporara.add(capitani.get(randy.nextInt(0, capitani.size())));
            }

            nave.add(new NavaDeRazboi(nume_nave[randy.nextInt(0, nume_nave.length)], new Locatie(randy.nextInt(-90, 90), randy.nextInt(-180, 180)), lista_temporara));
        }

        nave.forEach(System.out::println);

        Map<Capitan, List<NavaDeRazboi>> capitan_si_nave = new HashMap<>();

        for(var nava: nave) {
            for(var capitan: nava.getCapitani()) {
                if(!capitan_si_nave.containsKey(capitan)) {
                    List<NavaDeRazboi> n = new ArrayList<>();
                    n.add(nava);
                    capitan_si_nave.put(capitan, n);
                }
                else {
                    capitan_si_nave.get(capitan).add(nava);
                }
            }
        }

        // distanta mai mica de 50

        System.out.println("\n");
        for(NavaDeRazboi n: nave) {
            for(NavaDeRazboi m: nave) {
                if(Locatie.distanta(n.getLocatie(), m.getLocatie()) < 25) {
                    System.out.println("Nava " + n.getNume() + " in raza navei " + m.getNume() + ".");
                }
            }
         }
    }
}
