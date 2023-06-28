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
public class ResponseOk {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime time;

    private HttpStatus status;

    private String message;

    private Object data;

    public static ResponseEntity<ResponseOk> createResponse(HttpStatus status, String message, Object data) {
        ResponseOk response = new ResponseOk(LocalDateTime.now(), status, message, data);

        return new ResponseEntity<ResponseOk>(response, status);
    }



}
