package com.example;

public class TClasificador {
	public static final int METODO_CLASIFICACION_INSERCION = 1;
	public static final int METODO_CLASIFICACION_SHELL = 2;
	public static final int METODO_CLASIFICACION_BURBUJA = 3;
	public static final int METODO_CLASIFICACION_QUICK = 4;

	/**
	 * Punto de entrada al clasificador
	 *
	 * @param metodoClasificacion
	 * @param orden
	 * @param tamanioVector
	 * @return Un vector del tam. solicitado, ordenado por el algoritmo solicitado
	 */
	public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
		switch (metodoClasificacion) {
			case METODO_CLASIFICACION_INSERCION:
				return ordenarPorInsercion(datosParaClasificar);
			case METODO_CLASIFICACION_SHELL:
				return ordenarPorShell(datosParaClasificar);
			case METODO_CLASIFICACION_BURBUJA:
				return ordenarPorBurbuja(datosParaClasificar);
			case METODO_CLASIFICACION_QUICK:
				return ordenarPorQuicksort(datosParaClasificar);
			default:
				System.err.println("Este codigo no deberia haberse ejecutado");
				break;
		}
		return datosParaClasificar;
	}

	private void intercambiar(int[] vector, int pos1, int pos2) {
		int temp = vector[pos2];
		vector[pos2] = vector[pos1];
		vector[pos1] = temp;
	}

	/**
	 * @param datosParaClasificar
	 * @return
	 */
	private int[] ordenarPorShell(int[] datosParaClasificar) {
		int j, inc;
		int[] incrementos = new int[] { 3223, 358, 51, 10, 3, 1 };

		for (int posIncrementoActual = 1; posIncrementoActual < incrementos.length; posIncrementoActual++) {
			inc = incrementos[posIncrementoActual];
			if (inc < (datosParaClasificar.length / 2)) {
				for (int i = inc; i < datosParaClasificar.length; i = i + inc) {
					j = i;
					while ((j > 0) && (datosParaClasificar[j - 1] > datosParaClasificar[j])) {
						intercambiar(datosParaClasificar, j, j - 1);
						j--;
					}
				}
			}
		}
		return datosParaClasificar;
	}

	/**
	 * @param datosParaClasificar
	 * @return
	 */
	protected int[] ordenarPorInsercion(int[] datosParaClasificar) { // O(N^2)
		if (datosParaClasificar != null) {
			for (int i = 1; i < datosParaClasificar.length; i++) {
				int j = i;
				while ((j > 0) && (datosParaClasificar[j - 1] > datosParaClasificar[j])) {
					intercambiar(datosParaClasificar, j, j - 1);
					j--;
				}
			}
			return datosParaClasificar;
		}
		return null;
	}

	private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
		if (datosParaClasificar != null) {
			int n = datosParaClasificar.length - 1;
			for (int i = 0; i <= n; i++) {
				for (int j = n; j >= (i + 1); j--) {
					if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
						intercambiar(datosParaClasificar, j - 1, j);
					}
				}
			}
			return datosParaClasificar;
		}
		return null;
	}

	public int particion(int i, int j, int pivote, int[] V) {
		int L = i;
		int R = j;
		while (L <= R) { // Utilizar un bucle while en lugar de do-while
			while (V[L] < pivote) {
				L++;
			}
			while (V[R] > pivote) { // Cambiar ">=" a ">" para evitar intercambiar el pivote repetidamente
				R--;
			}
			if (L <= R) {
				intercambiar(V, L, R);
				L++;
				R--;
			}
		}
		return L;
	}

	public int encuentraPivote2(int i, int j, int[] entrada) {
		// calcula la median del array
		int mediana = 0;
		for (int m = i; m < j; m++) {
			mediana += entrada[m];
		}
		mediana = mediana / entrada.length;

		// busca el elemento que minimiza la diferencia con la mediana
		int minDiferencia = Integer.MAX_VALUE;
		int pivot = entrada[0];
		for (int p = i; p < j; p++) {
			int diferencia = Math.abs(entrada[p] - mediana);
			if (diferencia < minDiferencia) {
				minDiferencia = diferencia;
				pivot = p;
			}
		}
		return pivot;
	}

	public int encuentraPivote1(int i, int j, int[] v) {
		int posicion = (i + j) / 2; // Calcular la posición del pivote correctamente
		if (posicion >= i && posicion <= j) {
			return posicion;
		} else if (i >= posicion && i <= j) {
			return i;
		} else {
			return j;
		}
	}

	private int[] ordenarPorQuicksort(int[] datosParaClasificar) {
		int i = 0;
		int j = datosParaClasificar.length - 1;
		return ordenarPorQuicksort(datosParaClasificar, i, j);
	}

	private int[] ordenarPorQuicksort(int[] V, int i, int j) {
		if (i < j) { // Verificar que i sea menor que j para evitar bucle infinito
			int indicePivote = encuentraPivote1(i, j, V);
			int pivote = V[indicePivote];
			int k = particion(i, j, pivote, V);
			ordenarPorQuicksort(V, i, k - 1);
			ordenarPorQuicksort(V, k, j);
		}
		return V;
	}

	public boolean estaOrdenado(int[] datosParaClasificar) {
		for (int i = 0; i < datosParaClasificar.length - 1; i++) {
			if (datosParaClasificar[i] > datosParaClasificar[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
        TClasificador clasif = new TClasificador();

        int[] vector = { 7, 6, 5, 3, 2 };

        // Prueba del método de Inserción Directa
        int[] insercion = clasif.clasificar(vector.clone(), METODO_CLASIFICACION_INSERCION);
        System.out.print("Inserción Directa: ");
        for (int i = 0; i < insercion.length; i++) {
            System.out.print(insercion[i] + " ");
        }
        System.out.println("\nOrdenado: " + clasif.estaOrdenado(insercion));

        // Prueba del método Shellsort
        int[] shell = clasif.clasificar(vector.clone(), METODO_CLASIFICACION_SHELL);
        System.out.print("Shellsort: ");
        for (int i = 0; i < shell.length; i++) {
            System.out.print(shell[i] + " ");
        }
        System.out.println("\nOrdenado: " + clasif.estaOrdenado(shell));

        // Prueba del método Burbuja
        int[] burbuja = clasif.clasificar(vector.clone(), METODO_CLASIFICACION_BURBUJA);
        System.out.print("Burbuja: ");
        for (int i = 0; i < burbuja.length; i++) {
            System.out.print(burbuja[i] + " ");
        }
        System.out.println("\nOrdenado: " + clasif.estaOrdenado(burbuja));

        // Prueba del método Quicksort
        int[] quick = clasif.clasificar(vector.clone(), METODO_CLASIFICACION_QUICK);
        System.out.print("Quicksort: ");
        for (int i = 0; i < quick.length; i++) {
            System.out.print(quick[i] + " ");
        }
        System.out.println("\nOrdenado: " + clasif.estaOrdenado(quick));
    }
}
