# Servlets en Java: Guía Completa

## Introducción
Los Servlets son componentes fundamentales de Java EE (Enterprise Edition) que se ejecutan del lado del servidor para extender las capacidades de los servidores web. Permiten generar contenido dinámico y manejar peticiones HTTP de manera eficiente.

## Características Principales
- Independientes de la plataforma
- Alto rendimiento
- Orientados a peticiones/respuestas
- Seguros y robustos
- Extensibles

## Ciclo de Vida de un Servlet
1. **Inicialización** (`init()`)
   - Se ejecuta una única vez cuando el servlet es cargado
   - Configura recursos iniciales
   - Establece conexiones a bases de datos

2. **Servicio** (`service()`)
   - Maneja todas las peticiones
   - Direcciona a los métodos específicos (doGet, doPost, etc.)
   - Se ejecuta en múltiples hilos

3. **Destrucción** (`destroy()`)
   - Se ejecuta cuando el servlet es destruido
   - Libera recursos
   - Cierra conexiones

## Estructura Básica de un Servlet

```java
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class MiServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        // Código de inicialización
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Mi Primer Servlet</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Manejar peticiones POST
    }

    @Override
    public void destroy() {
        // Código de limpieza
    }
}
```

## Configuración en web.xml
```xml
<web-app>
    <servlet>
        <servlet-name>MiServlet</servlet-name>
        <servlet-class>com.ejemplo.MiServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>MiServlet</servlet-name>
        <url-pattern>/miservlet</url-pattern>
    </servlet-mapping>
</web-app>
```

## Manejo de Peticiones y Respuestas

### HttpServletRequest
- Obtener parámetros: `request.getParameter("nombre")`
- Obtener headers: `request.getHeader("User-Agent")`
- Manejar sesiones: `request.getSession()`
- Obtener cookies: `request.getCookies()`

### HttpServletResponse
- Establecer tipo de contenido: `response.setContentType("text/html")`
- Enviar respuestas: `response.getWriter().println()`
- Manejar redirecciones: `response.sendRedirect("nueva-url")`
- Establecer cookies: `response.addCookie(new Cookie("nombre", "valor"))`

## Mejores Prácticas
1. **Seguridad**
   - Validar todas las entradas del usuario
   - Usar HTTPS para datos sensibles
   - Implementar control de acceso

2. **Rendimiento**
   - Minimizar el uso de variables de instancia
   - Cerrar correctamente los recursos
   - Implementar el pooling de conexiones

3. **Mantenibilidad**
   - Seguir el patrón MVC
   - Documentar el código
   - Manejar excepciones apropiadamente

## Características Avanzadas

### Filtros
```java
public class MiFiltro implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response,
                        FilterChain chain) throws IOException, ServletException {
        // Código antes de la petición
        chain.doFilter(request, response);
        // Código después de la petición
    }
}
```

### Listeners
```java
public class MiListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        // Código al iniciar la aplicación
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // Código al detener la aplicación
    }
}
```

## Conclusión
Los Servlets son una tecnología fundamental en el desarrollo web con Java, proporcionando una base robusta para construir aplicaciones web escalables y seguras. Su integración con otras tecnologías Java EE los hace especialmente valiosos en el desarrollo empresarial.
