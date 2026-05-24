package org.example.laboratorio02.ExceptionHandler;

import lombok.RequiredArgsConstructor;
import org.example.laboratorio02.Model.DTOs.Responses.GenericResponse;
import org.example.laboratorio02.Utils.ErrorTool;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final ErrorTool errorTool;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return GenericResponse.builder()
                .data(errorTool.mapErrors(ex.getBindingResult().getFieldErrors()))
                .status(HttpStatus.BAD_REQUEST)
                .build().buildResponse();

    }

    @ExceptionHandler(UsuarioEncontrado.class)
    public ResponseEntity<GenericResponse> usuarioEncontradoFuncion(UsuarioEncontrado ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                java.time.LocalDateTime.now(),
                ex.getMessage()
        );
        return GenericResponse.builder()
                .data(errorResponse)
                .status(HttpStatus.BAD_REQUEST).build().buildResponse();

    }

    @ExceptionHandler(DireccionNoEncontrada.class)
    public ResponseEntity<GenericResponse> direccionNoEncontrada(DireccionNoEncontrada ex){
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                java.time.LocalDateTime.now(),
                ex.getMessage()
        );

        return GenericResponse.builder()
                .data(errorResponse)
                .status(HttpStatus.BAD_REQUEST).build().buildResponse();
    }
}