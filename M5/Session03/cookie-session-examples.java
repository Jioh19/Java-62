// CookieServlet.java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Setting a cookie
        Cookie userCookie = new Cookie("username", "john_doe");
        userCookie.setMaxAge(24 * 60 * 60); // 24 hours
        response.addCookie(userCookie);

        // Reading cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    String username = cookie.getValue();
                    // Use the username value
                }
            }
        }

        // Delete a cookie
        Cookie deleteCookie = new Cookie("username", "");
        deleteCookie.setMaxAge(0);
        response.addCookie(deleteCookie);
    }
}

// SessionServlet.java
@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Get or create session
        HttpSession session = request.getSession();
        
        // Set session attributes
        session.setAttribute("user_id", "12345");
        session.setAttribute("login_time", System.currentTimeMillis());
        
        // Set session timeout (in seconds)
        session.setMaxInactiveInterval(1800); // 30 minutes
        
        // Get session attributes
        String userId = (String) session.getAttribute("user_id");
        
        // Remove session attribute
        session.removeAttribute("login_time");
        
        // Invalidate session
        session.invalidate();
    }
}

<!-- login.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <%
        // Check if user is already logged in using session
        if (session.getAttribute("user_id") != null) {
            response.sendRedirect("dashboard.jsp");
            return;
        }
    %>
    
    <form action="login" method="post">
        <input type="text" name="username" required>
        <input type="password" name="password" required>
        <label>
            <input type="checkbox" name="remember_me"> Remember me
        </label>
        <button type="submit">Login</button>
    </form>
</body>
</html>

<!-- dashboard.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <%
        // Session check
        if (session.getAttribute("user_id") == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        // Reading cookies
        String username = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                    break;
                }
            }
        }
    %>
    
    <h1>Welcome <%= username %></h1>
    <p>Your session ID is: <%= session.getId() %></p>
    
    <form action="logout" method="post">
        <button type="submit">Logout</button>
    </form>
</body>
</html>

// web.xml configuration
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee 
         http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <session-config>
        <session-timeout>30</session-timeout>
    </session-config>
</web-app>
