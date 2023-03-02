CREATE SCHEMA if not exists netology;
CREATE TABLE if not exists netology.CUSTOMERS
(
    id           SERIAL PRIMARY KEY,
    name         varchar(33) not null,
    surname      varchar(33) not null,
    age          int         not null,
    phone_number varchar(11) not null
);

INSERT INTO netology.CUSTOMERS
(name, surname, age, phone_number)
VALUES ('Anna', 'Smith', 23, 79998887766),
       ('Brian', 'Warner', 44, 76665554433),
       ('Vi', 'Unknown', 25, 74443332211),
       ('Tomas', 'Edison', 67, 71112223344),
       ('Alexey', 'Edison', 80, 71112223344),
       ('John', 'Almond', 4, 71112223344),
       ('Emma', 'Mug', 22, 71112223344),
       ('Arthur', 'Morgan', 36, 74446669900);

CREATE TABLE if not exists netology.ORDERS
(
    id           SERIAL PRIMARY KEY,
    date         DATE,
    customer_id  int,
    product_name varchar(33),
    amount       int,
    FOREIGN KEY (customer_id) references netology.CUSTOMERS (id)
);

INSERT INTO netology.ORDERS
(product_name, amount, customer_id, date)
VALUES ('Coconut milk', 2, 2, now()),
       ('Potato', 20, 7, now()),
       ('Water', 4, 3, now()),
       ('Water', 6, 7, now()),
       ('Apples', 6, 5, now()),
       ('Tea', 1, 5, now()),
       ('Bread', 2, 6, now());