package exceptii;

public class ExceptieLocatie extends Exception {
    
    public ExceptieLocatie(String mesaj) {
        
        System.out.println("ExceptieLocatie: " + mesaj);

    }
}