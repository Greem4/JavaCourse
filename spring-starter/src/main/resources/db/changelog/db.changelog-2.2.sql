--liquibase formatted sql

--changeset Greem4:1
ALTER TABLE users_aud
    DROP CONSTRAINT users_aud_username_key;

--changeset Greem4:2
ALTER TABLE users_aud
    ALTER COLUMN username DROP NOT NULL;