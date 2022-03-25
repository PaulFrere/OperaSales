package controller;

import dto.ExceptionDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({
            Exception.class
    })
    @ResponseBody
    public ExceptionDto handler (Exception err){
        return new ExceptionDto(111, "Something went wrong", err.getMessage());
    }
}
