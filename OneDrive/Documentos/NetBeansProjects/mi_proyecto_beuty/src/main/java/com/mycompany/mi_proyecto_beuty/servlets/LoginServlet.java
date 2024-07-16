package Servletcom.mycompany.mi_proyecto_beuty.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/mitienda");
        } catch (NamingException ex) {
            throw new ServletException("Error en la configuración del recurso JDBC", ex);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Obtiene los parámetros del formulario de inicio de sesión
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado del inicio de sesión</title>");
            out.println("</head>");
            out.println("<body>");

            // Verifica las credenciales
            if (authenticateUser(email, password)) {
                // Guarda el correo electrónico del usuario en la sesión
                request.getSession().setAttribute("user", email);
                // Redirige a la página principal después del inicio de sesión exitoso
                response.sendRedirect("index.jsp");
            } else {
                // Muestra un mensaje de error si las credenciales son incorrectas
                out.println("<h1>Error: Credenciales incorrectas</h1>");
                out.println("<p><a href='login.jsp'>Volver al inicio de sesión</a></p>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para autenticar usuarios";
    }

    private boolean authenticateUser(String email, String password) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT contrasena FROM usuarios WHERE correo_electronico = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("contrasena");
                return storedPassword.equals(password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
