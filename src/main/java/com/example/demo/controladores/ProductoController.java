package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelos.Producto;
import com.example.demo.servicios.interfaces.IProductoServicio;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoServicio productoServicio;

    @GetMapping("")
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoServicio.obtenerTodos());
        return "productos/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("producto", new Producto());
        return "productos/formulario";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoServicio.guardar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Producto producto = productoServicio.obtenerPorId(id);
        if (producto != null) {
            model.addAttribute("producto", producto);
            return "productos/formulario";
        }
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        if (productoServicio.existePorId(id)) {
            productoServicio.eliminar(id);
        }
        return "redirect:/productos";
    }
}
