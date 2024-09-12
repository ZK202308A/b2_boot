package org.zerock.b2.board.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
@Log4j2
public class BoardControllerAdvice {

    @ExceptionHandler(NoSuchElementException.class )
    public String notFound(NoSuchElementException exception) {

        log.error("Not found", exception.getMessage());
        log.error("Not found", exception.getMessage());
        log.error("Not found", exception.getMessage());
        log.error("Not found", exception.getMessage());

        return "redirect:/404.html";
    }
}
