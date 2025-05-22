package ut3_pd9;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Expresion expresion = new Expresion();

        List<Character> lista1 = Arrays.asList('{', '}', '{', '{', '}', '}');
        System.out.println("Caso 1: " + expresion.controlCorchetes(lista1));

        List<Character> lista2 = Arrays.asList('{', '{', '}', '{', '{', '}');
        System.out.println("Caso 2: " + expresion.controlCorchetes(lista2)); 

        List<Character> lista3 = Arrays.asList();
        System.out.println("Caso 3: " + expresion.controlCorchetes(lista3));
        
        List<Character> lista4 = Arrays.asList('{', '}', '}', '}');
        System.out.println("Caso 4: " + expresion.controlCorchetes(lista4)); 

        List<Character> lista5 = Arrays.asList('{', '{', '{', '}');
        System.out.println("Caso 5: " + expresion.controlCorchetes(lista5)); 
    }
}
