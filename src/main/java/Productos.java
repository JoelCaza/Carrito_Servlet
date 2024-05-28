
public class Productos {
    private String nombre;
    private double valorUnitario;
    private int cantidad;

    public Productos(String nombre, double valorUnitario, int cantidad) {
        this.nombre = nombre;
        this.valorUnitario = valorUnitario;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getValorTotal() {
        return valorUnitario * cantidad;
    }
}
