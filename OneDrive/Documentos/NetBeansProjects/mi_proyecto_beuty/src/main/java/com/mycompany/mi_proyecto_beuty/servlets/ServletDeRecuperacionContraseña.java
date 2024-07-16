package com.mycompany.mi_proyecto_beuty.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author lauma
 */
@WebServlet(name = "ServletDeRecuperacionContraseña", urlPatterns = {"/recuperacionContraseña"})
public class ServletDeRecuperacionContraseña extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Recuperar el correo electrónico enviado desde el formulario
            String email = request.getParameter("email");
            
            // Generar un código aleatorio (aquí uso un número aleatorio simple, puedes implementar algo más robusto)
            Random random = new Random();
            int codigo = random.nextInt(900000) + 100000; // Código de 6 dígitos
            
            // Aquí deberías enviar el código por correo electrónico al usuario
            // Puedes implementar esta funcionalidad utilizando librerías como JavaMail API
            
            // Guardar el código en la sesión para validar después
            HttpSession session = request.getSession();
            session.setAttribute("codigoRecuperacion", codigo);
            session.setAttribute("emailRecuperacion", email);
            
            // Redirigir al usuario a la página donde debe ingresar el código
            response.sendRedirect(request.getContextPath() + "/ingresarCodigo.jsp");
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
        return "Servlet para manejar la recuperación de contraseña";
    }
}
