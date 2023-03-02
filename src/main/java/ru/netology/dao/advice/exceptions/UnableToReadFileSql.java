package ru.netology.dao.advice.exceptions;

public class UnableToReadFileSql extends RuntimeException {
    public UnableToReadFileSql(String message) {
        super(message);
    }
}
