package ru.netology.dao.advice.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DAOResponse {
    private final String message;

    public DAOResponse(String message) {
        this.message = message;
    }
}
