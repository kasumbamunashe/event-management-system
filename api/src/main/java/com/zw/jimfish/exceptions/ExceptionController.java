package com.zw.jimfish.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class ExceptionController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(FileDoesNotExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    Error fileDoesNotExist(FileDoesNotExistsException e) {
        LOGGER.info("File does not exist error: {}", e.getMessage());
        return Error.of(400, e.getMessage());
    }
    @ExceptionHandler(FileAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    Error recordAlreadyExistError(FileAlreadyExistsException e) {
        LOGGER.info("File already exist error: {}", e.getMessage());
        return Error.of(400, e.getMessage());
    }
    @ExceptionHandler(IncorrectUsernameOrPasswordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    Error incorrectUsernameOrPassword(IncorrectUsernameOrPasswordException e){
        LOGGER.info("Incorrect username or password: {}",e.getMessage());
        return Error.of(400, e.getMessage());
    }
    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    Error recordNotFound(RecordNotFoundException e){
        LOGGER.info("Record not found: {}",e.getMessage());
        return Error.of(400, e.getMessage());
    }
    @ExceptionHandler(DocumentNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    Error documentNotFound(DocumentNotFoundException e){
        LOGGER.info("Document not found : {}",e.getMessage());
        return Error.of(400, e.getMessage());

    }
    @ExceptionHandler(FileDoesNotExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    Error fileDoesNotExists(FileDoesNotExistsException e){
        LOGGER.info("File does not exists: {}",e.getMessage());
        return Error.of(400, e.getMessage());
    }




}
