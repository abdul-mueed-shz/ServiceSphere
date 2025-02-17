package com.abdul.toolkit.common.info;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorInfo {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
}