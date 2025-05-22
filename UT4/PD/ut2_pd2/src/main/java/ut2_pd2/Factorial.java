package ut2_pd2;

public class Factorial {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;  // Caso base
        } else {
            return n * factorial(n - 1);  // Llamada recursiva
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(4));  // 24
        System.out.println(factorial(5));  // 120
        System.out.println(factorial(0));  // 1
    }
}
