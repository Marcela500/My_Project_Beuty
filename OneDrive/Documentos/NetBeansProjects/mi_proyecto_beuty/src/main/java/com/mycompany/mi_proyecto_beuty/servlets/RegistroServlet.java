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

@WebServlet(name = "RegistroServlet", urlPatterns = {"/usuario/registro"})
public class RegistroServlet extends HttpServlet {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void init() throws ServletException {
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correoElectronico");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String contrasena = request.getParameter("contrasena");

        if (nombre != null && correo != null && telefono != null && direccion != null && contrasena != null &&
            !nombre.isEmpty() && !correo.isEmpty() && !telefono.isEmpty() && !direccion.isEmpty() && !contrasena.isEmpty()) {
            
            Usuario existingUser = usuarioService.obtenerUsuarioPorCorreo(correo);
            
            if (existingUser != null) {
                request.setAttribute("errorMessage", "El correo electrónico ya está registrado.");
                request.getRequestDispatcher("registro.jsp").forward(request, response);
            } else {
                Usuario newUser = new Usuario();
                newUser.setNombre(nombre);
                newUser.setCorreoElectronico(correo);
                newUser.setTelefono(telefono);
                newUser.setDireccion(direccion);
                newUser.setContrasena(contrasena); 
                newUser.setRol("usuario");

                usuarioService.registrarUsuario(newUser);

                request.setAttribute("successMessage", "Usuario registrado correctamente. Ahora puede iniciar sesión.");
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        } else {
            request.setAttribute("errorMessage", "Por favor complete todos los campos del formulario.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }
}
