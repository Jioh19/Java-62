import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Register")
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String lastName = req.getParameter("lastName");
//        String email = req.getParameter("email");
//        String password = req.getParameter("password");
//        String rut = req.getParameter("rut");
//        PrintWriter pw = resp.getWriter();
//        pw.println(name);
//        pw.println(lastName);
//        pw.println(email);
//        pw.println(password);
//        pw.println(rut);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> errores = new HashMap<>();
        String name = req.getParameter("name");
        if(name.trim().length() < 3) {
            errores.put("name", "Ingrese un nómbre válido");
        }
        String lastName = req.getParameter("lastName");
        if(lastName.trim().length() < 2) {
            errores.put("lastName", "Ingrese un apellido válido");
        }
        String email = req.getParameter("email");
        if(email.trim().length() < 4) {
            errores.put("email", "Ingrese un email válido");
        }
        String password = req.getParameter("password");
        String rut = req.getParameter("rut");
        if(rut.trim().length() < 4) {
            errores.put("rut", "Ingrese un rut válido");
        }
        if(errores.isEmpty()) {
            req.getRequestDispatcher("/exito.jsp").forward(req, resp);
        } else {
            req.setAttribute("errores", errores);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
//        PrintWriter pw = resp.getWriter();
//        pw.println(name);
//        pw.println(lastName);
//        pw.println(email);
//        pw.println(password);
//        pw.println(rut);

    }
}
