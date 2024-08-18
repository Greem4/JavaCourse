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

INSERT INTO company(id, name, date)
VALUES (1, 'Google', '2001-01-01'),
       (2, 'Apple', '2002-10-29'),
       (3, 'Facebook', '1998-03-13'),
       (4, 'Amazon', '2005-06-17');

DROP TABLE employee;

CREATE TABLE employee
(
    id         SERIAL PRIMARY KEY,
    first_name varchar(128) NOT NULL,
    last_name  varchar(128) NOT NULL,
    company_id INT REFERENCES company (id) ON DELETE CASCADE,
    salary     INT,
    UNIQUE (first_name, last_name)
);

INSERT INTO employee (first_name, last_name, salary, company_id)
values ('Ivan', 'Sidorov', 500, 1),
       ('Ivan', 'Ivanov', 1000, 2),
       ('Arny', 'Paramonov', null, 2),
       ('Petr', 'Petrov', 2000, 3),
       ('Sveta', 'Svetikova', 1500, NULL),
       ('Ivan', 'Petrov', 2000, 2),
       ('Serg', 'Sidarov', 2000, 3),
       ('Ala', 'Brown', 1500, 1);
select *
from employee;

CREATE TABLE contact
(
    id     BIGSERIAL PRIMARY KEY,
    number VARCHAR(128) NOT NULL,
    type   VARCHAR(128)
);

insert into contact (number, type)
values ('234-56-78', 'домашний'),
       ('987-65-43', 'рабочий'),
       ('565-25-91', 'мобильный'),
       ('332-55-67', NULL),
       ('465-11-22', NULL);

create table employee_contact
(
    employee_id BIGINT REFERENCES employee (id),
    contact_id  BIGINT REFERENCES contact (id),
    PRIMARY KEY (employee_id, contact_id)
);

insert into employee_contact (employee_id, contact_id)
values (1, 1),
       (1, 2),
       (2, 2),
       (2, 3),
       (3, 4),
       (4, 5);


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
SELECT first_name
FROM employee
WHERE salary IS NULL;

SELECT avg(emp.salary)
FROM (SELECT *
      FROM employee
      ORDER BY salary
      LIMIT 2) emp;

SELECT *
FROM employee
ORDER BY salary
LIMIT 2;

select *,
       (select max(salary) from employee) - salary dif
from employee;

select *
from employee
where company_id IN (select company_id from company where date > '2000-01-01');

SELECT *
FROM (SELECT *
      FROM (VALUES (1, 'Google', '2001-01-01'),
                   (2, 'Apple', '2002-10-29'),
                   (3, 'Facebook', '1998-03-13')) t) y;

DELETE
FROM employee
WHERE salary is NULL;

DELETE
FROM employee
WHERE salary = (SELECT max(salary) FROM employee);

DELETE
FROM company
where id = 2;

DELETE
FROM employee
WHERE company_id = 2;

SELECT *
from employee;

UPDATE employee
SET company_id = 1,
    salary     = 1700
where id = 10
   or id = 9
RETURNING id, first_name || ' ' || last_name fio;

SELECT company.name,
       employee.first_name || employee.last_name fio
from employee,
     company
where employee.company_id = company.id;

SELECT c.name,
       employee.first_name || ' ' || employee.last_name fio,
       ec.contact_id,
       c2.number
FROM employee
         JOIN company c
              ON employee.company_id = c.id
         join employee_contact ec
              on employee.id = ec.employee_id
         join contact c2
              on ec.contact_id = c2.id;

SELECT *
from employee
         cross join company;


-- INNER JOIN
-- CROSS JOIN
-- LEFT  JOIN
-- FULL  JOIN

SELECT c.name,
       e.first_name
from company c
         LEFT JOIN employee e
                   ON c.id = e.company_id;

select c.name,
       e.first_name
from employee e
         FULL JOIN company c
                   on e.company_id = c.id;

select company.name,
       count(e.id)
from company
         LEFT JOIN employee e
                   on company.id = e.company_id
-- where company.name = 'Amazon'
GROUP BY company.id, company.name
HAVING count(e.id) > 0;


CREATE VIEW  employee_view AS
select company.name,
       e.last_name,
       e.salary,
--        count(e.id) OVER (),
       max(e.salary) OVER (PARTITION BY company.name),
       min(e.salary) OVER (PARTITION BY company.name),
       lag(e.salary) OVER (ORDER BY e.salary) - e.salary
--        avg(e.salary) OVER (),
--        row_number() over (partition by company.name),
--        dense_rank() OVER (partition by company.name ORDER BY e.salary nulls first )
from company
         left join employee e
                   on company.id = e.company_id
order by company.name;

select *
from employee_view
where name = 'Facebook';

CREATE MATERIALIZED VIEW m_employee_view AS
select company.name,
       e.last_name,
       e.salary,
--        count(e.id) OVER (),
       max(e.salary) OVER (PARTITION BY company.name),
       min(e.salary) OVER (PARTITION BY company.name),
       lag(e.salary) OVER (ORDER BY e.salary) - e.salary
--        avg(e.salary) OVER (),
--        row_number() over (partition by company.name),
--        dense_rank() OVER (partition by company.name ORDER BY e.salary nulls first )
from company
         left join employee e
                   on company.id = e.company_id
order by company.name;

select *
from m_employee_view;

select *
from employee_view;

refresh materialized view m_employee_view;