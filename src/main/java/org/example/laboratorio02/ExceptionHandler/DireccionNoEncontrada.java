package org.example.laboratorio02.ExceptionHandler;

public class DireccionNoEncontrada extends RuntimeException{
    public DireccionNoEncontrada(String message){
        super(message);
    }
}
