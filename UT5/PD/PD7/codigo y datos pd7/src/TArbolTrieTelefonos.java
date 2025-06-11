import java.util.LinkedList;


public class TArbolTrieTelefonos implements IArbolTrieTelefonos {

    private TNodoTrieTelefonos raiz;

    @Override
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        LinkedList abonados = new LinkedList();
        String primerosDigitos = pais + area;
        if (raiz == null)
            return abonados;
        else
            raiz.buscarTelefonos(primerosDigitos, abonados);
        return abonados;    
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        if(raiz == null){
            raiz = new TNodoTrieTelefonos();
        }else{
            raiz.insertar(unAbonado);
        }    
    }

 
    
}
