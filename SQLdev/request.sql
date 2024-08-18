SELECT *
from book;

-- 4.	Написать запрос, выбирающий: название книги, год и имя автора,
-- отсортированные по году издания книги в возрастающем порядке.
--       Написать тот же запрос, но для убывающего порядка.

SELECT b.name,
       b.year,
       (SELECT a.first_name FROM author a where a.id = b.author_id)
FROM book b
ORDER BY b.year DESC;

-- 5.	Написать запрос, выбирающий количество книг у заданного автора.

SELECT count(*)
FROM book
where author_id IN (SELECT id from author where first_name = 'Кей');

-- 6.	Написать запрос, выбирающий книги,
-- у которых количество страниц больше среднего количества страниц по всем книгам

select *
from book
where pages > (SELECT avg(pages)
               from book);

-- 7.	Написать запрос, выбирающий 5 самых старых книг
-- Дополнить запрос и посчитать суммарное количество страниц среди этих книг

select sum(t.pages)
from (select pages
      from book
      ORDER BY year
      LIMIT 5) t;

select *
from book
ORDER BY year
LIMIT 5;

-- 8.	Написать запрос, изменяющий количество страниц у одной из книг

UPDATE book
SET pages = pages + 5
WHERE id = 2
RETURNING name, year, pages;

-- 9.	Написать запрос, удаляющий автора, который написал самую большую книгу

DELETE
FROM book
WHERE author_id = (SELECT author_id
                   FROM book
                   WHERE pages = (SELECT max(pages)
                                  FROM book));

DELETE
FROM author
WHERE id = 1
RETURNING *;

SELECT author_id
FROM book
WHERE pages = (SELECT max(pages)
               FROM book);

SELECT max(pages)
FROM book;