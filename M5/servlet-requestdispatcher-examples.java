Aquí hay algunos ejercicios de ejemplo que muestran cómo usar RequestDispatcher en servlets de Java:

Ejercicio 1: Redirigir a otra página
```java
// Servlet1.java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("/Servlet2");
    dispatcher.forward(request, response);
}
```

```java
// Servlet2.java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Procesa la solicitud y genera la respuesta
    response.getWriter().println("¡Hola desde Servlet2!");
}
```

En este ejemplo, cuando se llama a Servlet1, este redirige la solicitud a Servlet2 utilizando `request.getRequestDispatcher("/Servlet2").forward(request, response)`.

Ejercicio 2: Pasar datos entre servlets
```java
// Servlet1.java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("message", "¡Hola desde Servlet1!");
    RequestDispatcher dispatcher = request.getRequestDispatcher("/Servlet2");
    dispatcher.forward(request, response);
}
```

```java
// Servlet2.java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String message = (String) request.getAttribute("message");
    response.getWriter().println(message);
}
```

En este caso, Servlet1 establece un atributo en la solicitud (`request.setAttribute("message", "¡Hola desde Servlet1!";`)). Luego, Servlet2 recupera este atributo (`String message = (String) request.getAttribute("message");`) y lo utiliza para generar la respuesta.

Ejercicio 3: Incluir el contenido de otro servlet
```java
// Servlet1.java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("/Servlet2");
    dispatcher.include(request, response);
    response.getWriter().println("¡Hola desde Servlet1!");
}
```

```java
// Servlet2.java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.getWriter().println("¡Hola desde Servlet2!");
}
```

Aquí, Servlet1 incluye el contenido generado por Servlet2 utilizando `dispatcher.include(request, response)`. Esto permite que ambos servlets generen parte de la respuesta final.

Estos son solo algunos ejemplos básicos de cómo usar RequestDispatcher en servlets de Java. Espero que te ayuden a entender mejor este concepto. ¡No dudes en preguntar si tienes más dudas!
