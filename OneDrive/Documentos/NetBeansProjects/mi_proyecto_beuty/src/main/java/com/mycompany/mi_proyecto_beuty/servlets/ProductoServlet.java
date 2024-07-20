package com.mycompany.mi_proyecto_beuty.servlets;

import com.mycompany.dao.ProductoDAO;
import com.mycompany.mi_proyecto_beuty.models.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {

    private ProductoDAO productoDAO;

    @Override
    public void init() throws ServletException {
        productoDAO = new ProductoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "listar";
        }

        switch (action) {
            case "nuevo" -> mostrarFormularioNuevo(request, response);
            case "editar" -> mostrarFormularioEditar(request, response);
            case "eliminar" -> eliminarProducto(request, response);
            default -> listarProductos(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "listar";
        }

        switch (action) {
            case "guardar" -> guardarProducto(request, response);
            case "actualizar" -> actualizarProducto(request, response);
            default -> listarProductos(request, response);
        }
    }

    private void listarProductos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Producto> productos = productoDAO.obtenerTodosLosProductos();
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("productos.jsp").forward(request, response);
    }

    private void mostrarFormularioNuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("producto", new Producto());
        request.getRequestDispatcher("producto_formulario.jsp").forward(request, response);
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Producto producto = (Producto) productoDAO.obtenerProductoPorId(id);
        request.setAttribute("producto", producto);
        request.getRequestDispatcher("producto_formulario.jsp").forward(request, response);
    }

    private void guardarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String marca = request.getParameter("marca");
        double precio = Double.parseDouble(request.getParameter("precio"));
        String color = request.getParameter("color");
        String tipo = request.getParameter("tipo");
        String descripcion = request.getParameter("descripcion");

        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setMarca(marca);
        producto.setPrecio(precio);
        producto.setColor(color);
        producto.setTipo(tipo);
        producto.setDescripcion(descripcion);

        productoDAO.agregarProducto(producto);

        response.sendRedirect("ProductoServlet");
    }

    private void actualizarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String marca = request.getParameter("marca");
        double precio = Double.parseDouble(request.getParameter("precio"));
        String color = request.getParameter("color");
        String tipo = request.getParameter("tipo");
        String descripcion = request.getParameter("descripcion");

        Producto producto = new Producto();
        producto.setId(id);
        producto.setNombre(nombre);
        producto.setMarca(marca);
        producto.setPrecio(precio);
        producto.setColor(color);
        producto.setTipo(tipo);
        producto.setDescripcion(descripcion);

        productoDAO.actualizarProducto(producto);

        response.sendRedirect("ProductoServlet");
    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productoDAO.eliminarProducto(id);
        response.sendRedirect("ProductoServlet");
    }
}
