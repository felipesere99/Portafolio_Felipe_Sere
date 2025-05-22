package ut2_pd2;

import java.util.Arrays;

public class InvertirVector {
    public static void invertir(int[] A, int inicio, int fin) {
        if (inicio >= fin) {
            return;  // Caso base
        }
        int temp = A[inicio];
        A[inicio] = A[fin];
        A[fin] = temp;
        invertir(A, inicio + 1, fin - 1);  // Llamada recursiva
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        invertir(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));  // [5, 4, 3, 2, 1]
    }
}
