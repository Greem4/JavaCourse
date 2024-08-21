EXPLAIN
SELECT *
FROM ticket
where passenger_name like 'Иван%'
  and seat_no = 'B1';

EXPLAIN
SELECT flight_id, count(*), sum(cost)
FROm ticket
group by flight_id;

SELECT avg(bit_length(passenger_no) / 8),
       avg(bit_length(passenger_name) / 8),
       avg(bit_length(seat_no) / 8)
from ticket;

SELECT reltuples,
       relkind,
       relpages
FROM pg_class
where relname = 'ticket';

EXPLAIN
SELECT *
FROM ticket
WHERE id = 25;

create table test1
(
    id      SERIAL PRIMARY KEY,
    number1 INT         NOT NULL,
    number2 INT         NOT NULL,
    value   VARCHAR(32) NOT NULL
);

create index test1_number1_idx ON test1 (number1);
create index test1_number2_idx ON test1 (number2);

insert into test1 (number1, number2, value)
select random() * generate_series,
       random() * generate_series,
       generate_series
from generate_series(1, 100000);

SELECT relname,
       reltuples,
       relkind,
       relpages
FROM pg_class
where relname like 'test1%';

analyse test1;

explain
select *
from test1
where number1 < 1000
  and number1 > 90000;

EXPLAIN ANALYSE
SELECT *
from test1
where number1 < 1000;

CREATE TABLE test2
(
    id       SERIAL PRIMARY KEY,
    test1_id INT REFERENCES test1 (id) NOT NULL,
    number1  INT                       NOT NULL,
    number2  INT                       NOT NULL,
    value    VARCHAR(32)               NOT NULL
);

INSERT INTO test2 (test1_id, number1, number2, value)
SELECT id,
       random() * number1,
       random() * number2,
       value
FROM test1;

create index test2_number1_idx ON test2 (number1);
create index test2_number2_idx ON test2 (number2);
create index test2_test1_id_idx ON test2 (test1_id);

ANALYSE test2;

EXPLAIN ANALYSE
SELECT *
FROM test1 t1
-- JOIN (SELECT * FROM test2 ORDER BY test1_id) t2
         JOIN test2 t2
              on t1.id = t2.test1_id;

CREATE TABLE audit
(
    id         INT,
    table_name TEXT,
    date       TIMESTAMP
);

CREATE OR REPLACE FUNCTION audit_function() RETURNS TRIGGER
    LANGUAGE plpgsql
AS
$$
begin
    insert into audit (id, table_name, date)
    values (new.id, tg_table_name, now());
    return null;
end;

$$;

CREATE TRIGGER audit_aircraft_trigger
    AFTER UPDATE OR INSERT OR DELETE
    ON aircraft
    FOR EACH ROW
EXECUTE FUNCTION audit_function();

insert into aircraft (model)
values ('новый боинг');

select *
from audit;