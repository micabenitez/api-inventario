package com.mb.api_inventario.dtos;

import com.mb.api_inventario.enums.RolUsuario;
import com.mb.api_inventario.models.Movimiento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String username;
    private String password;
    private RolUsuario rol;
    private List<MovimientoDTO> movimientos;
}
