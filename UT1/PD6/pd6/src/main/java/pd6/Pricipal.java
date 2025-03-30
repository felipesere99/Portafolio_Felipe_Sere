package pd6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Pricipal {

    // Ejercicio 1
    public static void imprimirTablero(int largo, int ancho) {
        for (int i = 0; i < largo; i++) {
            for (int v = 0; v < ancho; v++) {
                System.out.print("#");
            }
            System.out.println("");
        }
    }

    // Ejercicio 2
    public static void leerEntradaArchivo(String rutaArchivo) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea = "";
        try {
            archivo = new File(rutaArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        }

        // Ejercicio 2 parte b
        public static void leerEntradaStdin() {
            try {
                System.out.println("Escribir el radio de una cincurferencia: ");

                int entrada = System.in.read();
                /*Perímetro = pi por diámetro.
                Perímetro = 2(pi) por radio.
                Área = pi por radio al cuadrado. */

                System.out.println("Area: " + (entrada*entrada)*3.14);
                System.out.println("Perimetro: " + entrada*(3.14*2));
            } catch (IOException e) {
                System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingresa un número válido.");
            }
        };

    // Ejercicio 3

    private static final Map<Character, String> t9Map = new HashMap<>();

    static {
        t9Map.put('0', " ");
        t9Map.put('1', ".");
        t9Map.put('2', "ABC");
        t9Map.put('3', "DEF");
        t9Map.put('4', "GHI");
        t9Map.put('5', "JKL");
        t9Map.put('6', "MNO");
        t9Map.put('7', "PQRS");
        t9Map.put('8', "TUV");
        t9Map.put('9', "WXYZ");
    }

    public static void transformarTextoT9(String rutaArchivo){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String rutaSalida = "C:\\AED2\\UT1\\PD\\PD6\\pd6\\src\\main\\resources\\salida.txt";
        File archivoSalida = null;
        BufferedWriter bw = null;
        FileWriter fw = null;
        String linea = "";
        StringBuilder salida = new StringBuilder();
        try {
            archivo = new File(rutaArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            archivoSalida = new File(rutaSalida);
            fw = new FileWriter(archivoSalida);
            bw = new BufferedWriter(fw);
            int contador = 0;
            while ((linea = br.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    char charr = linea.charAt(i);
                    String tecla = t9Map.getOrDefault(charr," ");
                    if ((Character.isDigit(charr)) && ((i+1) < linea.length())) {
                        
                        if (charr == (linea.charAt(i+1))) {
                            contador += 1;
                        } else {
                            char letra = tecla.charAt(contador);
                            salida.append(letra);
                            contador = 0;
                        }
                    } else if ((Character.isDigit(charr)) && (i < linea.length())) {
                        if (charr == (linea.charAt(i-1))) {
                            char letra = tecla.charAt(contador);
                            salida.append(letra);
                        } else {
                            contador = 0;
                            char letra = tecla.charAt(contador);
                            salida.append(letra);
                        }
                    }
                }                
            }
            System.out.println(salida);
            bw.write(salida.toString());
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (br != null) br.close();
                if (bw != null) bw.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };

    public static void main(String[] args) {

        imprimirTablero(7, 7);

        String rutaString = "C:\\AED2\\UT1\\PD\\PD6\\pd6\\src\\main\\resources\\entrada.txt";
        leerEntradaArchivo(rutaString);

        leerEntradaStdin();

        String rutaString2 = "C:\\AED2\\UT1\\PD\\PD6\\pd6\\src\\main\\resources\\entrada2.txt";
        transformarTextoT9(rutaString2);
    }
}