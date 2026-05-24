package org.example.laboratorio02.ExceptionHandler;

public class UsuarioEncontrado extends RuntimeException{
    public UsuarioEncontrado(String message){
        super(message);
    }
}
