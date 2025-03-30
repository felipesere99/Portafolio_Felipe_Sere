package ut1_ta2;

public class Main {
    // Ejercicio 1
    public static int factorial(int num){
        int result = 1;
        int nume = num;
        for (; nume > 0 ;){ 
            result = result * nume;
            nume = nume - 1;
        }
        return result;
    }

    // Ejercicio 2
    public static boolean isPrime(long n) {
        boolean prime = true;
        for (long i = 3; i <= Math.sqrt(n); i += 2)
        if (n % i == 0) {
            prime = false;
            break;
        }
        if (( n%2 !=0 && prime && n > 2) || n == 2) {
            return true;
        } else {
            return false;
        }
    }

    public static int SumaDeNumeros(int n) {
        int Result = 0;
        if (isPrime(n)) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    Result += i;
                }
            }
            System.out.println("Es primo"); 
        } else {
            for (int i = 0; i < n; i++) {
                if (!(i % 2 == 0)) {
                    Result += i;
                }
            }
            System.out.println("No es primo"); 
        }
        return Result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(3));
        System.out.println(SumaDeNumeros(10));
    }
    
}