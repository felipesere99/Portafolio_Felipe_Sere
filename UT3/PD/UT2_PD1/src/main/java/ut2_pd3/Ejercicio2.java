package ut2_pd3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ejercicio2 {

    public static void contador(String file) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        int contador = 0;

        try {
            archivo = new File(file);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            int N = Integer.parseInt(br.readLine().trim());
            int[] arreglo = new int[N];

            for (int i = 0; i < N; i++) {
                arreglo[i] = Integer.parseInt(br.readLine().trim());
            }

            for (int i = 1; i < N; i++) {
                for (int j = N - 1; j >= i; j--) {
                    if (arreglo[j] < arreglo[j - 1]) {
                        int temp = arreglo[j];
                        arreglo[j] = arreglo[j - 1];
                        arreglo[j - 1] = temp;
                        contador += 1;
                    }
                }
            }
            
            System.out.println("N: " + N);
            System.out.println("Contador de sentencias 'si': " + contador);
            System.out.println("Primero: " + arreglo[0]);
            System.out.println("Último: " + arreglo[N - 1]);

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


    public static void main(String[] args) {
        String file = "C:\\AED2\\Portafolio\\UT3\\PD\\ut2_pd1\\src\\main\\resources\\numeros.txt";
        contador(file);
    }
}