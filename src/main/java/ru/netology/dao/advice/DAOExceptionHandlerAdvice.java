package ru.netology.dao.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.dao.advice.exceptions.UnableToReadFileSql;
import ru.netology.dao.advice.response.DAOResponse;

@RestControllerAdvice
public class DAOExceptionHandlerAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UnableToReadFileSql.class)
    public DAOResponse unableToReadSql(UnableToReadFileSql e) {
        return new DAOResponse(e.getMessage());
    }
}
