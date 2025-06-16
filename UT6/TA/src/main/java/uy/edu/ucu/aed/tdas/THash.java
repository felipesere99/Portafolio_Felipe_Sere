package uy.edu.ucu.aed.tdas;

public class THash<K, V> implements IHash<K, V> {

    // Implementación de la tabla hash
    // Aquí se pueden definir los atributos necesarios, como un array de buckets,
    // etc.
    private THashNodo<K, V>[] tabla;
    private int m; // Tamaño de la tabla

    public THash(int n) {

        int tamanio = Math.round(n / 0.9f);

        while (esPrimo(tamanio) == false) {
            tamanio += 1;
        }

        this.tabla = new THashNodo[tamanio];
        this.m = tamanio;

    };

    public int getM() {
        return this.m;
    }

    @Override
    public V buscar(K unaClave) {
        {
            int i = 0;
            int j;
            do {
                j = funcionHashing(unaClave.hashCode(), i);
                if (tabla[j] == null) {
                    return null;
                } else if (tabla[j].getClave().equals(unaClave)) {
                    return tabla[j].getValor();
                } else {
                    i++;
                }
            } while (i < m);
            return null;
        }
    }

    @Override
    public boolean insertar(K unaClave, V unValor) {
        int i = 0;
        int j;
        do {
            j = funcionHashing(unaClave.hashCode(), i);
            if (tabla[j] == null) {
                tabla[j] = new THashNodo<>(unaClave, unValor);
                return true;
            } else if (tabla[j].getClave().equals(unaClave)) {
                tabla[j].setValor(unValor);
                return true;
            } else {
                i = i + 1;
            }
        } while (i < m);
        redimensionarYRehashear();
        return insertar(unaClave, unValor);
    }

    /**
     * Función de hashing que convierte una clave en un índice de la tabla hash.
     *
     * @param unaClave la clave a convertir en índice.
     * @return el índice correspondiente a la clave.
     */
    private int funcionHashing(int k, int i) {
        return (Math.abs(k) + i) % m;
    }

    public boolean esPrimo(int unNumero) {
        if (unNumero < 2) {
            return false;
        }
        if (unNumero == 2) {
            return true;
        }
        if (unNumero % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(unNumero); i += 2) {
            if (unNumero % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void redimensionarYRehashear() {
        int nuevoTamanio = m * 2;

        while (!esPrimo(nuevoTamanio)) {
            nuevoTamanio += 1;
        }

        THashNodo<K, V>[] nuevaTabla = (THashNodo<K, V>[]) new Object[nuevoTamanio];

        for (int indice = 0; indice < this.m; indice++) {
            if (tabla[indice] != null) {
                K clave = tabla[indice].getClave();
                V valor = tabla[indice].getValor();
                int i = 0;
                int j;
                do {
                    j = (Math.abs(clave.hashCode()) + i) % nuevoTamanio;
                    if (nuevaTabla[j] == null) {
                        nuevaTabla[j] = new THashNodo<>(clave, valor);
                        break;
                    }
                    i++;
                } while (i < nuevoTamanio);
            }
        }
        tabla = nuevaTabla;
        m = nuevoTamanio;
    }
}
