package ru.netology.dao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.dao.advice.response.DAOResponse;
import ru.netology.dao.service.DAOService;

@RestController
public class DAOController {
    private final DAOService service;

    public DAOController(DAOService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    public DAOResponse fetchProduct(@RequestParam String name) {
        return service.fetchProduct(name);
    }
}
