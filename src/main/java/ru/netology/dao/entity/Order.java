package ru.netology.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ORDERS")
@Entity
@Data
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private int orderId;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne
    private Customer customer;

    @Column(name = "product_name", nullable = false, length = 55)
    private String productName;

    @Column(nullable = false)
    private int amount;
}
