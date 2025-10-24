package com.mb.api_inventario.repositories;

import com.mb.api_inventario.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria,Long> {

    boolean existsByNombre(String nombreCategoria);


}
