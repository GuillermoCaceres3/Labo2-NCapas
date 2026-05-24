package org.example.laboratorio02.ExceptionHandler;

import java.time.LocalDateTime;

public record CustomErrorResponse(
        LocalDateTime timestamp,
        String message
) {
}