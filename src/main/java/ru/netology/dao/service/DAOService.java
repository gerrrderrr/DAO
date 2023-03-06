package ru.netology.dao.service;

import org.springframework.stereotype.Service;
import ru.netology.dao.advice.response.DAOResponse;
import ru.netology.dao.entity.Order;
import ru.netology.dao.repository.DAORepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DAOService {
    private final DAORepository repository;

    public DAOService(DAORepository repository) {
        this.repository = repository;
    }

    public DAOResponse fetchProduct(String name) {
        List<Order> products = repository.fetchProduct(name);
        String result = products.stream()
                .map(Order::getProductName)
                .collect(Collectors.joining(", "));
        return new DAOResponse(result);
    }
}
