package ut2_pd2;

public class Potencia {
    public static int potencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;  // Caso base
        } else {
            return base * potencia(base, exponente - 1);  // Llamada recursiva
        }
    }

    public static void main(String[] args) {
        System.out.println(potencia(2, 3));  // 8
        System.out.println(potencia(5, 0));  // 1
    }
}
