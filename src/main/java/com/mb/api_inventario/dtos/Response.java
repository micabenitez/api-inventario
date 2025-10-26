package com.mb.api_inventario.dtos;

import com.mb.api_inventario.enums.RolUsuario;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Response {
    private int status;
    private String message;
    private String token;
    private RolUsuario rolUsuario;

}
