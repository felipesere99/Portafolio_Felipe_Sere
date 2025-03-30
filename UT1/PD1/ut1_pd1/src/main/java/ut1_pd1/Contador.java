package ut1_pd1;

public class Contador {
    final int MAX_CONT = 50;
    int contador = 1;
    int incremento = 1;

    public void displayCount() {
        while(contador <= MAX_CONT) {
            System.out.println(contador);
            contador += incremento;
        }
    }

    public void displayCount2() {
        do {
            System.out.println(contador);
            contador += incremento;
        } while(contador <= MAX_CONT);
    }

    public void displayCount3() {
        for (; contador <= MAX_CONT; ) {
            System.out.println(contador);
            contador += incremento;
        }
    }

    public static void main(String[] args) {
        Contador contador = new Contador();
        /* contador.displayCount();
        contador.displayCount2(); */
        contador.displayCount3();
    }
}
