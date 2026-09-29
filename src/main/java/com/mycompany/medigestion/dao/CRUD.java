package com.mycompany.medigestion.dao;

import java.util.List;

/**
 *
 * @author gabri
 */
public interface CRUD<T> {
    public boolean insertar(T objeto);
    public boolean modificar(T objeto);
    public boolean eliminar(int id);
    public List<T> listar();
}
