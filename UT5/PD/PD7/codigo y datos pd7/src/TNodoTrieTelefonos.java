

import java.util.LinkedList;

public class TNodoTrieTelefonos implements INodoTrieTelefonos {

    private TAbonado abonado;
    private TNodoTrieTelefonos[] telefono;
    private boolean finNumero;

    public TNodoTrieTelefonos() {
        telefono = new TNodoTrieTelefonos[10];
        finNumero = false;
    }

    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        buscar(primerosDigitos, abonados, buscarNodo(primerosDigitos));
    }
    private TNodoTrieTelefonos buscarNodo(String primerosDigitos) {
        TNodoTrieTelefonos nodo = this;
        for (int i = 0; i < primerosDigitos.length(); i++) {
            int indice = primerosDigitos.charAt(i) - '0';
            if (nodo.telefono[indice] == null) {
                return null;
            }
            nodo = nodo.telefono[indice];
        }
        return nodo;
    }
    @Override
    public void insertar(TAbonado unAbonado) {
        String tel = unAbonado.getTelefono();
        TNodoTrieTelefonos nodo = this;
        
        for (int i = 0; i < tel.length(); i++) {
            int num = tel.charAt(i) - '0';   
            if(nodo.telefono[num]==null){
                nodo.telefono[num] = new TNodoTrieTelefonos();
            }
            nodo = nodo.telefono[num];
            
        }
        
        nodo.finNumero = true;
        nodo.abonado = unAbonado;
    }
    
    private void buscar(String primerosDigitos, LinkedList<TAbonado> abonados, TNodoTrieTelefonos nodo) {
        if (nodo != null) {
            if (nodo.finNumero) {
                abonados.add(nodo.abonado);
            }
            for (int i = 0; i < 10; i++) {
                if (nodo.telefono[i] != null) {
                    buscar(primerosDigitos + (char)(i + '0'),abonados, nodo.telefono[i]);
                }
            }
        }
    }

    
}
