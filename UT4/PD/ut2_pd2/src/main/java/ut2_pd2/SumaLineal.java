package ut2_pd2;

public class SumaLineal {
    public static int sumaLineal(int[] A, int n) {
        if (n == 0) {
            return 0;  // Caso base
        } else {
            return A[n - 1] + sumaLineal(A, n - 1);  // Llamada recursiva
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(sumaLineal(A, A.length));  // 15
    }
}
