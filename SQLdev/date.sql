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
    company_id INT REFERENCES company (id),
    salary     INT,
    UNIQUE (first_name, last_name)
--     FOREIGN KEY (company_id) REFERENCES company(id)
);

INSERT INTO employee (first_name, last_name, salary, company_id)
values ('Ivan', 'Sidorov', 500, 1),
       ('Ivan', 'Ivanov', 1000, 2),
       ('Arny', 'Paramonov', null, 2),
       ('Petr', 'Petrov', 2000, 3),
       ('Sveta', 'Svetikova', 1500, NULL);

SELECT DISTINCT id,
                first_name f_name,
                last_name  l_name,
                salary
FROM employee empl
WHERE salary IN (1000, 1100, 2000)
   OR (first_name LIKE '%Iv%'
    AND last_name ILIKE '%ov%')
ORDER BY first_name, salary DESC;

SELECT count(*)
from employee;

SELECT upper(first_name),
       now()
FROM employee empl;

SELECT first_name
FROM employee
WHERE company_id IS NOT NULL
UNION
SELECT
    first_name
FROM employee
WHERE salary IS NULL;

SELECT
    avg(emp.salary)
FROM (SELECT
          *
      FROM employee
      ORDER BY salary
      LIMIT 2) emp;

SELECT
    *
FROM employee
ORDER BY salary
LIMIT 2;

select *,
       (select max(salary) from employee) - salary dif
from employee;

select *
from employee
where company_id IN (select company_id from company where date > '2000-01-01');

SELECT * FROM (SELECT * FROM (VALUES (1, 'Google', '2001-01-01'),
       (2, 'Apple', '2002-10-29'),
       (3, 'Facebook', '1998-03-13')) t) y;