package ut1_pd1;

public class Alumno {
    private String nombre;

    public Alumno () {
     nombre = null;
    }

    public String getNombreAdmiracion() {
        return nombre.concat("!");
    }
    public static void main(String[] args) {
        Alumno alumno = new Alumno();
        System.out.println(alumno.getNombreAdmiracion());
    }
    public static int recorrer (String cadena) {
        int res = 0;
        for (int i = 1; i <= cadena.length(); i++) {
            if (cadena.charAt(i) != ' ') {
                res++;
            }
        }
        return res;
    }
    public static int getValor() {
        int vector[] = { 6, 16, 26,36,46,56,66,76 };
        int idx = 8;
        return vector[idx];
    }
    public static char getPrimerCaracter(String palabra) {
        String string[] = new String[5];
        return (string[1].charAt(1));
    }
    public static String paraAString(int a) {
        Object x1 = new Integer(a);
        return (String) (x1) ;
    }
}

