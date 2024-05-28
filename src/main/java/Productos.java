/*
 * Autor: Joel Caza
 * Fecha: 27/05/2024
 * Materia: Lenguajes de Programacion
 *
 * */

// Clase para representar un producto en el carrito de compras
public class Productos {
    private String nombre;          // Nombre del producto
    private double valorUnitario;   // Valor unitario del producto
    private int cantidad;           // Cantidad del producto en el carrito

    // Constructor para inicializar un producto con su nombre, valor unitario y cantidad
    public Productos(String nombre, double valorUnitario, int cantidad) {
        this.nombre = nombre;
        this.valorUnitario = valorUnitario;
        this.cantidad = cantidad;
    }

    // Método para obtener el nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Método para obtener el valor unitario del producto
    public double getValorUnitario() {
        return valorUnitario;
    }

    // Método para obtener la cantidad del producto en el carrito
    public int getCantidad() {
        return cantidad;
    }

    // Método para calcular el valor total del producto (valor unitario * cantidad)
    public double getValorTotal() {
        return valorUnitario * cantidad;
    }
}
