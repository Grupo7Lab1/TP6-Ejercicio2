/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DeTodoS;

import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;


public class ProductoRepositorio {
    private TreeSet<Producto> productos;

    public ProductoRepositorio(TreeSet<Producto> productos) {
        this.productos = productos;
    }


    public boolean agregar(Producto p) {
        return productos.add(p);
    }


    public Producto buscarPorCodigo(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }


    public boolean eliminar(int codigo) {
        Producto p = buscarPorCodigo(codigo);
        if (p == null) {
            return false;
        }
        return productos.remove(p);
    }


    public boolean actualizar(int codigoOriginal, Producto datosNuevos) {
        Producto existente = buscarPorCodigo(codigoOriginal);
        if (existente == null) {
            return false;
        }
        productos.remove(existente);
        productos.add(datosNuevos);
        return true;
    }


    public java.util.List<Producto> listarPorRubro(Rubro rubro) {
        java.util.List<Producto> resultado = new java.util.ArrayList<>();
        for (Producto p : productos) {
            if (p.getRubro() == rubro) {
                resultado.add(p);
            }
        }
        return resultado;
    }


    public List<Producto> listarPorNombre(String texto) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getDescripcion().contains(texto)) {
                resultado.add(p);
            }
        }
        return resultado;
    }


    public List<Producto> listarPorRangoPrecio(double desde, double hasta) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getPrecio() >= desde && p.getPrecio() <= hasta) {
                resultado.add(p);
            }
        }
        return resultado;
    }


    public List<Producto> listarTodos() {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : productos) {
            resultado.add(p);
        }
        return resultado;
    }
}
