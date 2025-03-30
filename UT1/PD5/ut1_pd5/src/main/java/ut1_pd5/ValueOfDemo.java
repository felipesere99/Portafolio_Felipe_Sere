package ut1_pd5;

public class ValueOfDemo {
    public static void main(String[] args) {
        // this program requires two
        // arguments on the command line
        if (args.length == 2) {
            // convert strings to numbers
            float a = (Float.valueOf(args[0])).floatValue();
            float b = (Float.valueOf(args[1])).floatValue();
            // do some arithmetic
            System.out.println("a + b = " +
            (a + b));
            System.out.println("a - b = " +
            (a - b));
            System.out.println("a * b = " +
            (a * b));
            System.out.println("a / b = " +
            (a / b));
            System.out.println("a % b = " +
            (a % b));
        } else {
            System.out.println("This program " +
            "requires two command-line arguments.");
        }
    }
    
}

/*
javac ValueOfDemo.java
java ValueOfDemo "13.4" "66.1"
Salida: a + b = 79.5
a - b = -52.699997
a * b = 885.7399
a / b = 0.20272315
a % b = 13.4 */

/*2) ¿cómo debería modificarse el código si los parámetros de línea de comando fueran
solamente enteros positivos? 

public class ValueOfDemo {
public static void main(String[] args) {
// this program requires two
// arguments on the command line
if (args.length == 3) {
// convert strings to numbers
int a = Integer.valueOf(args[0]);
int b = Integer.valueOf(args[1]);
// do some arithmetic
System.out.println("a + b = " +
(a + b));
System.out.println("a - b = " +
(a - b));
System.out.println("a * b = " +
(a * b));
System.out.println("a / b = " +
(a / b));
System.out.println("a % b = " +
(a % b));
} else {
System.out.println("This program " +
"requires two command-line arguments.");
}
}
}

*/