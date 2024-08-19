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
where number1 < 1000 and number1 > 90000;