package com.mb.api_inventario.exceptions;

public class NameValueRequiredException extends RuntimeException{
    public NameValueRequiredException(String msg) {
        super(msg);
    }
}
