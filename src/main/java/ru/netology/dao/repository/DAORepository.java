package ru.netology.dao.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.netology.dao.advice.exceptions.UnableToReadFileSql;
import ru.netology.dao.advice.response.DAOResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

@Repository
public class DAORepository {
    @Value("${sql.get.product.request}")
    String fileSqlUri;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DAOResponse fetchProduct(String name) {
        String request = read(fileSqlUri);
        HashMap<String, String> parameter = new HashMap<>();
        parameter.put("name", name);
        List<String> response = namedParameterJdbcTemplate
                .query(request, parameter, (rs, rowNum) -> rs.getString(1));
        String products = String.join(", ", response);
        return new DAOResponse(products);
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
