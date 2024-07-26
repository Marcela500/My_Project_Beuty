package com.mycompany.mi_proyecto_beuty.servlets;

import com.mycompany.mi_proyecto_beuty.models.Usuario;
import com.mycompany.mi_proyecto_beuty.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RegistroServlet", urlPatterns = {"/registro"})
public class RegistroServlet extends HttpServlet {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void init() throws ServletException {
        super.init();
        // Permite la inyección de dependencias en el servlet
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener los parámetros del formulario de registro
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String contrasena = request.getParameter("contrasena");

        // Verificar que todos los parámetros sean válidos
        if (nombre != null && correo != null && telefono != null && direccion != null && contrasena != null &&
            !nombre.isEmpty() && !correo.isEmpty() && !telefono.isEmpty() && !direccion.isEmpty() && !contrasena.isEmpty()) {
            
            // Verificar si el correo ya está registrado
            Usuario existingUser = usuarioService.obtenerUsuarioPorCorreo(correo);
            
            if (existingUser != null) {
                // Si el usuario ya existe, mostrar un mensaje de error
                request.setAttribute("errorMessage", "El correo electrónico ya está registrado.");
                request.getRequestDispatcher("registro.jsp").forward(request, response);
            } else {
                // Crear un nuevo usuario y registrar en el sistema
                Usuario newUser = new Usuario();
                newUser.setNombre(nombre);
                newUser.setCorreoElectronico(correo);
                newUser.setTelefono(telefono);
                newUser.setDireccion(direccion);
                newUser.setContrasena(contrasena); 

                usuarioService.registrarUsuario(newUser);

                // Redirigir a la página de inicio de sesión después del registro exitoso
                request.setAttribute("successMessage", "Usuario registrado correctamente. Ahora puede iniciar sesión.");
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        } else {
            // Mostrar un mensaje de error si algunos campos están vacíos
            request.setAttribute("errorMessage", "Por favor complete todos los campos del formulario.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }
}
