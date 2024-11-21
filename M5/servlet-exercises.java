// Ejercicio 1: Servlet Simple de Saludo
@WebServlet("/saludo")
public class SaludoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Servlet Saludo</title></head>");
            out.println("<body>");
            out.println("<h1>¡Hola desde mi primer servlet!</h1>");
            out.println("</body></html>");
        }
    }
}

// Ejercicio 2: Formulario de Registro
@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Formulario de Registro</title></head>");
            out.println("<body>");
            out.println("<h2>Formulario de Registro</h2>");
            out.println("<form action='registro' method='POST'>");
            out.println("Nombre: <input type='text' name='nombre'><br><br>");
            out.println("Email: <input type='email' name='email'><br><br>");
            out.println("Edad: <input type='number' name='edad'><br><br>");
            out.println("<input type='submit' value='Registrar'>");
            out.println("</form>");
            out.println("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String edad = request.getParameter("edad");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Registro Completado</title></head>");
            out.println("<body>");
            out.println("<h2>Registro Exitoso</h2>");
            out.println("<p>Nombre: " + nombre + "</p>");
            out.println("<p>Email: " + email + "</p>");
            out.println("<p>Edad: " + edad + "</p>");
            out.println("</body></html>");
        }
    }
}

// Ejercicio 3: Calculadora Simple
@WebServlet("/calculadora")
public class CalculadoraServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Calculadora</title></head>");
            out.println("<body>");
            out.println("<h2>Calculadora Simple</h2>");
            out.println("<form action='calculadora' method='POST'>");
            out.println("Número 1: <input type='number' name='num1'><br><br>");
            out.println("Número 2: <input type='number' name='num2'><br><br>");
            out.println("Operación: <select name='operacion'>");
            out.println("<option value='suma'>Suma</option>");
            out.println("<option value='resta'>Resta</option>");
            out.println("<option value='multiplicacion'>Multiplicación</option>");
            out.println("<option value='division'>División</option>");
            out.println("</select><br><br>");
            out.println("<input type='submit' value='Calcular'>");
            out.println("</form>");
            out.println("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        String operacion = request.getParameter("operacion");
        double resultado = 0;

        switch (operacion) {
            case "suma":
                resultado = num1 + num2;
                break;
            case "resta":
                resultado = num1 - num2;
                break;
            case "multiplicacion":
                resultado = num1 * num2;
                break;
            case "division":
                resultado = num2 != 0 ? (double) num1 / num2 : 0;
                break;
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Resultado</title></head>");
            out.println("<body>");
            out.println("<h2>Resultado de la operación</h2>");
            out.println("<p>" + num1 + " " + operacion + " " + num2 + " = " + resultado + "</p>");
            out.println("<a href='calculadora'>Volver a calcular</a>");
            out.println("</body></html>");
        }
    }
}

// Ejercicio 4: Contador de Visitas
@WebServlet("/contador")
public class ContadorVisitasServlet extends HttpServlet {
    private int contador = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        contador++;
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Contador de Visitas</title></head>");
            out.println("<body>");
            out.println("<h2>Contador de Visitas</h2>");
            out.println("<p>Esta página ha sido visitada " + contador + " veces.</p>");
            out.println("<p><a href='contador'>Actualizar contador</a></p>");
            out.println("</body></html>");
        }
    }
}
