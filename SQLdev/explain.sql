EXPLAIN
SELECT *
FROM ticket
where passenger_name like 'Иван%'
  and seat_no = 'B1';

EXPLAIN
SELECT flight_id, count(*), sum(cost)
FROm ticket
group by flight_id ;

SELECT reltuples,
       relkind,
       relpages
FROM pg_class
where relname = 'ticket';

SELECT avg(bit_length(passenger_no) / 8),
       avg(bit_length(passenger_name) / 8),
       avg(bit_length(seat_no) / 8)
from ticket;