/*
Creați o clasă navă de război care are ca atribute un nume, o locație (coordonate de Locatie(lat,long)
    latitudine și longitudine) și o listă a căpitanilor săi. Fiecare căpitan este caracterizat
    prin nume, prenume, varsta și perioada în care a fost căpitan al acestei nave (data începerii contractului
    – data terminării contractului - String.

    0) Toti membrii privati si accesati cu get/set. !!! La set corectitudinea datelor
    // de facut throw.
    1) Creați o listă de nave și afișați-o
    2) Validați corectitudinea datelor atunci când sunt introduse, de ex. valorile
    pentru latitudine/longitudine, datele contractului, ...
    TEMA 3) Pentru fiecare căpitan, identificați navele și perioada/perioadele în care a fost
    căpitan pe acele nave 
    // de facut un dictionar<Capitani, dictionar<Nave, Perioada>>
    BONUS: Identificați navele din listă care se află în raza de acțiune a altei nave
 */

import obiecte.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // INCEPUT: Testarea erorilor:

        Locatie lo = null;
        Capitan ca = null;
        List<Capitan> lca = new ArrayList<>();
        
        try {
            // Locatie accepta doar valori intre (-90, 90) si intre (-180, 180).
            // Valorile neconforme genereaza erori.
            lo = new Locatie(95, 180);
        } catch (Exception ex) {
            System.out.println("Obiectul Locatie nu a fost creat.");
        }
        
        try {
            // Capitan accepta doar litere (a-z, A-Z) in nume si prenume,
            // o varsta mai mare de 17 si un contract cu formatul ZZ.LL.AAA-ZZ.LL.AAAA.
            // Valorile neconforme genereaza erori.
            ca = new Capitan("Jon", "Ionel", 18, "01.01.2000-29.10.2005");
        } catch (Exception ex) {
            System.out.println("Obiectul Capitan nu a fost creat.");
        }
        try {
            // NavaDeRazboi accepta orice ca nume atata timp cat nu este
            // un String gol "" sau doar Whitespace " ",
            // Locatia va fi mereu valida,
            // lista de capitani trebuie sa aiba cel putin un Capitan.
            // Valorile neconforme genereaza erori.
            
            // Momentan lca nu contine niciun Capitan. Pentru a evita eroarea
            // adauga un Capitan inlaturand liniile de comentare de mai jos:
            // lca.add(ca);
            NavaDeRazboi na = new NavaDeRazboi(" ", lo, lca);
        } catch (Exception ex) {
            System.out.println("Obiectul NavaDeRazboi nu a fost creat.");
        }
        // SFARSIT: Testarea erorilor.

        // Exercitiul.
        List<NavaDeRazboi> nave = new ArrayList<>();
        int nr_nave = 10;
        int capitani_per_nava = 5;

        List<Capitan> capitani = new ArrayList<>();
        int nr_capitani = 50; // 50 de capitani pentru diversitate.

        String[] nume_capitani = {"Dej", "Munteanu", "Dumitrescu", "Neacsu", "Florinescu", "Antonescu", "Grigorescu"};
        String[] prenume_capitani = {"Alexandru", "Vasile", "Ion", "Cristian", "Marius", "Adrian", "Stefan", "Luca", "Thomas"};
        String[] nume_nave = {"Barracuda", "Jeepers", "Maven", "Gradle", "J00B", "Bonfire", "Odysseus", "Trireme", "The Argo"};
        String[] perioade = {"01.01.2000-29.10.2005", "15.08.2002-16.03.2009", "12.02.2015-03.07.2017", "07.11.2017-01.01.2020"};

        Random randy = new Random(System.currentTimeMillis());
        
        for(int i = 0; i < nr_capitani; i++) {
            try {
                capitani.add(new Capitan(nume_capitani[randy.nextInt(0, nume_capitani.length)], prenume_capitani[randy.nextInt(0, prenume_capitani.length)], randy.nextInt(18, 70), perioade[randy.nextInt(0, perioade.length)]));
            } catch (Exception ex) {
                System.out.println("Obiectul Capitan nu a fost creat din cauza unei erori.");
            }
        }
        
        for(int i = 0; i < nr_nave; i++) {
            List<Capitan> lista_temporara = new ArrayList<>();
            for(int j = 0; j < randy.nextInt(1, capitani_per_nava); j++) {
                lista_temporara.add(capitani.get(randy.nextInt(0, capitani.size())));
            }
            try {
                // Fiecare NavaDeRazboi are un numar pentru a le distinge mai usor la afisare.
                nave.add(new NavaDeRazboi(nume_nave[randy.nextInt(0, nume_nave.length)] + " " + randy.nextInt(0, 3000), new Locatie(randy.nextInt(-90, 90), randy.nextInt(-180, 180)), lista_temporara));
            } catch (Exception ex) {
                System.out.println("Obiectul NavaDeRazboi nu a fost creat din cauza unei erori.");
            }
        }

        nave.forEach(System.out::println);
        
        Map<Capitan, Map<String, List<NavaDeRazboi>>> capitan_si_nave = new HashMap<>();

        for(var nava: nave) {
            for(var capitan: nava.getCapitani()) {
                if(!capitan_si_nave.containsKey(capitan)) {
                    Map<String, List<NavaDeRazboi>> nc = new HashMap<>();
                    List<NavaDeRazboi> ln = new ArrayList<>();
                    ln.add(nava);
                    nc.put(capitan.getContract(), ln);
                    capitan_si_nave.put(capitan, nc);
                }
                else {
                    capitan_si_nave.get(capitan).get(capitan.getContract()).add(nava);
                }
            }
        }
        
        // Afiseara fiecare Capitan cu fiecare contract si nava pe care a fost capitan.
        // De mentionat, fiecare Capitan are un singur contract, acelasi, dar pe 
        // mai multe nave.
        // Format de afisare:
        // capitan.getPrenume() + capitan.getNume() + (capitan.getVarsta()):\n
        // [capitan.getContract()] - nava.getNume()\n
        capitan_si_nave.forEach((k, v) -> v.forEach((i, j) -> j.forEach(w -> System.out.println(k.getPrenume() + " " + k.getNume() + " (" + k.getVarsta() + "):\n[" + i + "] - " + w.getNume() + "\n"))));
        
        // Distanta mai mica de 50.

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