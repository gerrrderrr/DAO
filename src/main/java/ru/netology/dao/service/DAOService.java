package ru.netology.dao.service;

import org.springframework.stereotype.Service;
import ru.netology.dao.advice.response.DAOResponse;
import ru.netology.dao.repository.DAORepository;

@Service
public class DAOService {
    private final DAORepository repository;

    public DAOService(DAORepository repository) {
        this.repository = repository;
    }

    public DAOResponse fetchProduct(String name) {
        return repository.fetchProduct(name);
    }
}
