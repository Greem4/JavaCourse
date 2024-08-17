create database company_repository;

CREATE SCHEMA company_storage;

DROP SCHEMA company_storage;

CREATE TABLE company_storage.company
(
    id   INT,
    name varchar(128),
    date DATE
);

CREATE TABLE company
(
    id   INT,
    name varchar(128) UNIQUE NOT NULL,
    date DATE                NOT NULL CHECK ( date > '1995-01-01' AND date < '2020-01-01'),
    PRIMARY KEY (id),
    UNIQUE (name, date)
);
DROP TABLE company;
-- DROP TABLE public.company;

INSERT INTO company(id, name, date)
VALUES (1, 'Google', '2001-01-01'),
       (2, 'Apple', '2002-10-29'),
       (3, 'Facebook', '1998-03-13');

DROP TABLE employee;

CREATE TABLE employee
(
    id         SERIAL PRIMARY KEY,
    first_name varchar(128) NOT NULL,
    last_name  varchar(128) NOT NULL,
    salary     INT,
    UNIQUE (first_name, last_name)
);

INSERT INTO employee (first_name, last_name, salary)
values ('Ivan', 'Sidorov', 500),
       ('Ivan', 'Ivanov', 1000),
       ('Petr', 'Petrov', 2000),
       ('Sveta', 'Svetikova', 1500);

SELECT DISTINCT id,
                first_name f_name,
                last_name  l_name,
                salary
FROM employee empl
WHERE salary IN (1000, 1100, 2000)
   OR (first_name LIKE '%Iv%'
    AND last_name ILIKE '%ov%')
ORDER BY first_name, salary DESC;





