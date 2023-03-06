package ru.netology.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CUSTOMERS")
@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, length = 55)
    private String name;
    @Column(nullable = false, length = 55)
    private String surname;
    @Column(nullable = false)
    private int age;
    @Column(name = "phone_number", nullable = false, length = 11)
    private String phoneNumber;
}
