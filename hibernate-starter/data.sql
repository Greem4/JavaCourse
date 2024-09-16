DROP TABLE users;

CREATE TABLE users
(
    username VARCHAR(128) PRIMARY KEY ,
    firstname VARCHAR(128) ,
    lastname VARCHAR(128) ,
    birth_date DATE ,
    role VARCHAR(32),
    info jsonb

);

DROP TABLE users;

CREATE TABLE users
(
    id BIGSERIAL PRIMARY KEY ,
    username VARCHAR(128) UNIQUE ,
    firstname VARCHAR(128) ,
    lastname VARCHAR(128) ,
    birth_date DATE ,
    role VARCHAR(32),
    info jsonb

);

DROP TABLE users;

CREATE TABLE users
(
    id BIGINT PRIMARY KEY ,
    username VARCHAR(128) UNIQUE ,
    firstname VARCHAR(128) ,
    lastname VARCHAR(128) ,
    birth_date DATE ,
    role VARCHAR(32),
    info jsonb

);

-- CREATE SEQUENCE users_id_seq
-- OWNED BY users.id;

DROP TABLE users;
drop sequence users_id_seq;

create table all_sequence
(
    table_name VARCHAR(32) primary key ,
    pk_value BIGINT not null
);

CREATE TABLE users
(
    firstname VARCHAR(128) ,
    lastname VARCHAR(128) ,
    birth_date DATE ,
    username VARCHAR(128) UNIQUE ,
    role VARCHAR(32),
    info jsonb,
    primary key (firstname, lastname, birth_date)

);

DROP TABLE company;
DROP TABLE users;

CREATE TABLE company
(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE users
(
    id BIGSERIAL PRIMARY KEY ,
    firstname VARCHAR(128) ,
    lastname VARCHAR(128) ,
    birth_date DATE ,
    username VARCHAR(128) UNIQUE ,
    role VARCHAR(32),
    info jsonb,
    company_id INT REFERENCES company (id)
);

CREATE TABLE profile
(
    user_id BIGINT PRIMARY KEY REFERENCES  users (id) ,
    street VARCHAR(128) ,
    language CHAR(2)
);
