package objetos;

import java.util.Date;

/**
 *
 * @author David
 */
public class Venta {

    private Date fechaVenta;
    private int numeroUnidades;
    private float importe;
    private Producto producto;

    public Venta(Date fechaVenta, int numeroUnidades, Producto producto) {
        this.fechaVenta = fechaVenta;
        this.numeroUnidades = numeroUnidades;
        this.importe = producto.getPrecioUnitario()* numeroUnidades;
        this.producto = producto;
        producto.calcularStock(numeroUnidades);
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    
    public int getNumeroUnidades() {
        return numeroUnidades;
    }

    public void setNumeroUnidades(int numeroUnidades) {
        this.numeroUnidades = numeroUnidades;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
}
