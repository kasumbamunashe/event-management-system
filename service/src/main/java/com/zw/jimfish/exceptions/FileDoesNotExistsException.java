package com.zw.jimfish.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Terrance Nyamfukudza
 * @date 11/Jul/2023
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FileDoesNotExistsException extends RuntimeException {
    public FileDoesNotExistsException(String message) {
        super(message);
    }
}
