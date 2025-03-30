package ut1_pd5;

public class ToStringDemo {
    public static void main(String[] args) {
        double d = 888.51;
        String s = Double.toString(d);
        int dot = s.indexOf('.');
        System.out.println(dot + " digits " +
        "before decimal point.");
        System.out.println( (s.length() - dot - 1) +
        " digits after decimal point.");
        }
}

/*
1)Salida= 
3 digits before decimal point.
2 digits after decimal point.

2) El primer dato son los numeros antes del punto, y 
el segundo son los numeros despues del punto. Para conseguir
estos datos se utilizo el indexOf de un numero con coma, y luego
los imprimio en consola indicando cuantos numeros hay antes y depues de 
la coma.
*/