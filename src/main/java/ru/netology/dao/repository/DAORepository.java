package ru.netology.dao.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.netology.dao.advice.exceptions.UnableToReadFileSql;
import ru.netology.dao.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Repository
public class DAORepository {
    @PersistenceContext
    EntityManager entityManager;
    @Value("${sql.get.product.request}")
    String fileSqlUri;

    public List<Order> fetchProduct(String name) {
        String request = read(fileSqlUri);
        Query query = entityManager
                .createNativeQuery(request, Order.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    private String read(String fileUri) {
        String request;
        try {
            request = Files.readString(Path.of(fileUri));
        } catch (IOException e) {
            throw new UnableToReadFileSql(e.getMessage());
        }
        return request;
    }
}
