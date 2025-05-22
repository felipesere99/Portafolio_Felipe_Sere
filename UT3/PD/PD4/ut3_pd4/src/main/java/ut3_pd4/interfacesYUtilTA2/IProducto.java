package ut3_pd4.interfacesYUtilTA2;

public interface IProducto{

    /**
     * Retorna el codigo del Producto.
     *
     * @return codigo del Producto.
     */
    public Comparable getCodProducto() ;

    /**
     * Retorna el precio unitario del Producto.
     *
     * @return precio del Producto.
     */
    public Integer getPrecio();

    public void setPrecio(Integer precio);

    /**
     * Retorna el stock del Producto.
     *
     * @return stock del Producto.
     */
    public Integer getStock();

    public void agregarCantidadStock(Integer cantidad);

    public void restarCantidadStock(Integer cantidad);
    /**
     * Retorna la descripcion/nombre del Producto.
     *
     * @return descripci�n del Producto.
     */
    public String getNombre();

    public void setNombre(String nombre);

}
