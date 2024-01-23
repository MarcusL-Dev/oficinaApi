package dev.marcus.oficina.infra;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestErrorMessage {
    private HttpStatus status;
    private String message;
}