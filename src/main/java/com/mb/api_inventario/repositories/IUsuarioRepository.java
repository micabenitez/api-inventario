package com.mb.api_inventario.repositories;

import com.mb.api_inventario.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {
}
