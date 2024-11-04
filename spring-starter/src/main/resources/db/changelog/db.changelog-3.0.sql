--liquibase formatted sql

--changeset Greem4:1
ALTER TABLE users
    ADD COLUMN image VARCHAR(64);


--changeset Greem4:2
ALTER TABLE users_aud
    ADD COLUMN image VARCHAR(64);