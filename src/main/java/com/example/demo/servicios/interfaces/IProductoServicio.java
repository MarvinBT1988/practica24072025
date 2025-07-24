package com.example.demo.servicios.interfaces;

import java.util.List;

import com.example.demo.modelos.Producto;

public interface IProductoServicio {
    List<Producto> obtenerTodos();
    Producto obtenerPorId(Long id);
    Producto guardar(Producto producto);
    void eliminar(Long id);
    boolean existePorId(Long id);
}
