package ut3_pd4.interfacesYUtilTA2;

public class Almacen extends Lista implements IAlmacen {
    private String direccion;
    private String telefono;
    private String nombre;
    protected Lista<IProducto> listaProductos;

    public Almacen(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaProductos = new Lista<>();
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public Lista<IProducto> getListaProductos() {
        return listaProductos;
    }

    @Override
    public long obtenerValorStock() {
        long valorTotal = 0;
        Nodo<IProducto> actual = listaProductos.getPrimero();
        while (actual != null) {
            valorTotal += actual.getDato().getPrecio() * actual.getDato().getStock();
            actual = actual.getSiguiente();
        }
        return valorTotal;
    }

    @Override
    public void insertarProducto(IProducto unProducto) {
        listaProductos.insertar(unProducto.getCodProducto(), unProducto);
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (primero == null) {
            return false;
        }
        if (primero.getEtiqueta().equals(clave)) {
            primero = primero.getSiguiente();
            return true;
        }
        Nodo<IProducto> actual = primero;
        while (actual.getSiguiente() != null && !actual.getSiguiente().getEtiqueta().equals(clave)) {
            actual = actual.getSiguiente();
        }
        if (actual.getSiguiente() == null) {
            return false; // No encontrado
        }
        actual.setSiguiente(actual.getSiguiente().getSiguiente());
        return true;
    }


    @Override
    public boolean eliminarProducto(Comparable codProducto) {
        return listaProductos.eliminar(codProducto);
    }

    @Override
    public String imprimirProductos() {
        return listaProductos.imprimir();
    }

    @Override
    public String imprimirSeparador(String separador) {
        return listaProductos.imprimir(separador);
    }

    @Override
    public Boolean agregarStock(Comparable codProducto, Integer cantidad) {
        IProducto producto = buscarPorCodigo(codProducto);
        if (producto != null) {
            producto.agregarCantidadStock(cantidad);
            return true;
        }
        return false;
    }

    @Override
    public Integer restarStock(Comparable codProducto, Integer cantidad) {
        IProducto producto = buscarPorCodigo(codProducto);
        if (producto != null) {
            producto.restarCantidadStock(cantidad);
            return producto.getStock();
        }
        return null;
    }

    @Override
    public IProducto buscarPorCodigo(Comparable codProducto) {
        return listaProductos.buscar(codProducto);
    }

    @Override
    public IProducto buscarPorDescripcion(String descripcion) {
        Nodo<IProducto> actual = listaProductos.getPrimero();
        while (actual != null) {
            if (actual.getDato().getNombre().equals(descripcion)) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public int cantidadProductos() {
        return listaProductos.cantElementos();
    }
}
