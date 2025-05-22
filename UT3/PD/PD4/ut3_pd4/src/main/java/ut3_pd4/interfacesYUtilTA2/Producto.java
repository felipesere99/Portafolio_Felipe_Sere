package ut3_pd4.interfacesYUtilTA2;

public class Producto implements IProducto {
    private Comparable codProducto;
    private Integer precio;
    private Integer stock;
    private String nombre;

    public Producto(Comparable codProducto, String nombre, Integer precio, Integer stock) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public Comparable getCodProducto() {
        return codProducto;
    }

    @Override
    public Integer getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public Integer getStock() {
        return stock;
    }

    @Override
    public void agregarCantidadStock(Integer cantidad) {
        this.stock += cantidad;
    }

    @Override
    public void restarCantidadStock(Integer cantidad) {
        if (this.stock >= cantidad) {
            this.stock -= cantidad;
        } else {
            System.out.println("Stock insuficiente");
        }
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
