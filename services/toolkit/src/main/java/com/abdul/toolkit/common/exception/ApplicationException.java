package com.abdul.toolkit.common.exception;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@Getter
@Setter
public class ApplicationException extends RuntimeException {

    private final LocalDateTime timestamp;
    private final int status;
    private final String error;
    private final String message;

    public ApplicationException(LocalDateTime timestamp, int status, String error, String message) {
        super(message);
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public ApplicationException(String message) {
        super(message);
        this.timestamp = LocalDateTime.now();
        this.status = HttpStatus.BAD_REQUEST.value();
        this.error = message;
        this.message = message;
    }

    public ApplicationException(String message, String error) {
        super(message);
        this.timestamp = LocalDateTime.now();
        this.status = HttpStatus.BAD_REQUEST.value();
        this.error = error;
        this.message = message;
    }

    public ApplicationException(String message, Integer status) {
        super(message);
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = message;
        this.message = message;
    }
}
