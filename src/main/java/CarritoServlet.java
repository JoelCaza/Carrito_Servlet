/*
 * Autor: Joel Caza
 * Fecha: 27/05/2024
 * Materia: Lenguajes de Programacion
 *
 * */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

// Servlet para manejar la lógica de agregar productos al carrito
@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {

    // Método POST para agregar productos al carrito
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener o crear la sesión
        HttpSession session = request.getSession(true);

        // Obtener o crear la lista de productos en el carrito desde la sesión
        List<Productos> carrito = (List<Productos>) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new ArrayList<>();
            session.setAttribute("carrito", carrito);
        }

        // Obtener los parámetros del formulario
        String nombreProducto = request.getParameter("nombre");
        double valorUnitario = Double.parseDouble(request.getParameter("valorUnitario"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        // Crear un nuevo producto
        Productos producto = new Productos(nombreProducto, valorUnitario, cantidad);

        // Agregar el producto al carrito
        carrito.add(producto);

        // Redirigir al usuario a la página de factura
        response.sendRedirect("FacturaServlet");
    }
}
