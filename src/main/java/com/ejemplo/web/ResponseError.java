package com.ejemplo.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime time;

    private HttpStatus status;

    private String message;

    private Object errors;

    public static ResponseEntity<ResponseError> ErrorResponse(HttpStatus status, String message, Object errors) {
        ResponseError response = new ResponseError(LocalDateTime.now(), status, message, errors);
        return new ResponseEntity<ResponseError>(response, status);
    }

}
