import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/FacturaServlet")
public class FacturaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener la sesión
        HttpSession session = request.getSession();
        List<Productos> carrito = (List<Productos>) session.getAttribute("carrito");

        // Configurar la respuesta
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Escribir la factura en HTML
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Factura</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; }");
        out.println("table { width: 100%; border-collapse: collapse; }");
        out.println("th, td { padding: 10px; text-align: left; border-bottom: 1px solid #ddd; }");
        out.println("th { background-color: #f2f2f2; }");
        out.println("tfoot { font-weight: bold; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Factura</h1>");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>Nombre del Producto</th>");
        out.println("<th>Valor Unitario</th>");
        out.println("<th>Cantidad</th>");
        out.println("<th>Valor Total</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        double totalFactura = 0;

        if (carrito != null) {
            for (Productos producto : carrito) {
                out.println("<tr>");
                out.println("<td>" + producto.getNombre() + "</td>");
                out.println("<td>$" + producto.getValorUnitario() + "</td>");
                out.println("<td>" + producto.getCantidad() + "</td>");
                double valorTotalProducto = producto.getValorTotal();
                out.println("<td>$" + valorTotalProducto + "</td>");
                out.println("</tr>");
                totalFactura += valorTotalProducto;
            }
        } else {
            out.println("<tr>");
            out.println("<td colspan='4'>El carrito está vacío.</td>");
            out.println("</tr>");
        }

        out.println("</tbody>");
        out.println("<tfoot>");
        out.println("<tr>");
        out.println("<td colspan='3'>Subtotal:</td>");
        out.println("<td>$" + totalFactura + "</td>");
        out.println("</tr>");
        double iva = totalFactura * 0.12;
        double totalConIVA = totalFactura + iva;
        out.println("<tr>");
        out.println("<td colspan='3'>IVA (12%):</td>");
        out.println("<td>$" + iva + "</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td colspan='3'>Total con IVA:</td>");
        out.println("<td>$" + totalConIVA + "</td>");
        out.println("</tr>");
        out.println("</tfoot>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

    }
}
