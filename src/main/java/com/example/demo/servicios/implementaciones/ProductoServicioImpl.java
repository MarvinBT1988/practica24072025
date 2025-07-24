package com.example.demo.servicios.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.Producto;
import com.example.demo.repositorios.ProductoRepositorio;
import com.example.demo.servicios.interfaces.IProductoServicio;

@Service
public class ProductoServicioImpl implements IProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> obtenerTodos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto obtenerPorId(Long id) {
        return productoRepositorio.findById(id).orElse(null);
    }

    @Override
    public Producto guardar(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public void eliminar(Long id) {
        productoRepositorio.deleteById(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return productoRepositorio.existsById(id);
    }
}
