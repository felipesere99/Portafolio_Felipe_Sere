package ut1_pd5;

public class ContadorVocCons {
    
    public static String Metodo(String frase) {
        int vocalesInt = 0;
        int consonantesInt = 0;
        String o = frase.toUpperCase();
        for (int i = 0; i < frase.length(); i++) {
            char c = o.charAt(i);
            boolean bool = false;
            for (Vocales vocales : Vocales.values()) {
                if (c == vocales.name().charAt(0)) {
                    bool = true;
                }
            }
            if (bool) {
                vocalesInt += 1;
            } else {
                consonantesInt += 1;
            }
            
        }
        return "Cantidad de vocales: "+vocalesInt+ "  Cantidad de consonantes: " + consonantesInt;
    }

    public static void main(String[] args) {
        String frase = "frase";
        System.out.println(Metodo(frase));
    }
}

enum Vocales {
    A, E, I ,O, U
}