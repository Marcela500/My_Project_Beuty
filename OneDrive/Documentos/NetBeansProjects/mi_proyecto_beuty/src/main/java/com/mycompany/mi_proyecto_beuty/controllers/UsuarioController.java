package com.mycompany.mi_proyecto_beuty.controllers;

import com.mycompany.mi_proyecto_beuty.models.Usuario;
import com.mycompany.mi_proyecto_beuty.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuario/registro")
    public String registrarUsuario(@RequestParam String nombre,
                                   @RequestParam String correoElectronico,
                                   @RequestParam String telefono,
                                   @RequestParam String direccion,
                                   @RequestParam String contrasena,
                                   @RequestParam(value = "terms", defaultValue = "false") boolean terms,
                                   Model model) {
        // Validar si los términos y condiciones están aceptados
        if (!terms) {
            model.addAttribute("errorMessage", "Debes aceptar los términos y condiciones.");
            return "registro";
        }

        // Verificar si el correo electrónico ya está registrado
        Usuario existingUser = usuarioService.obtenerUsuarioPorCorreo(correoElectronico);
        if (existingUser != null) {
            model.addAttribute("errorMessage", "El correo electrónico ya está registrado.");
            return "registro";
        }

        // Crear un nuevo usuario y guardarlo
        Usuario newUser = new Usuario();
        newUser.setNombre(nombre);
        newUser.setCorreoElectronico(correoElectronico);
        newUser.setTelefono(telefono);
        newUser.setDireccion(direccion);
        newUser.setContrasena(contrasena); // Contraseña debería ser encriptada

        usuarioService.registrarUsuario(newUser);

        model.addAttribute("successMessage", "Usuario registrado correctamente.");
        return "registro";
    }
}
