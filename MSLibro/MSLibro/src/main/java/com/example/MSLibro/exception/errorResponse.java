package com.example.MSLibro.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class errorResponse {
    private int status;
    private LocalDateTime timestamp;
    private String message;
    private String details;
}