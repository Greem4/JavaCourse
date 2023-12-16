DROP TABLE IF EXISTS cm_contact;

CREATE TABLE cm_contact
(
    contact_id serial                 NOT NULL,
    sur_name   character varying(255) not null,
    given_name character varying(255) not null,
    email      character varying(255) not null,
    phone      character varying(255) not null,
    CONSTRAINT cm_contact_pkey PRIMARY KEY (contact_id)
);

INSERT INTO cm_contact (sur_name, given_name, email, phone)
VALUES ('Петров', 'Иван', 'ivan@google.com', '+7 (916)-123-45-67');
INSERT INTO cm_contact (sur_name, given_name, email, phone)
VALUES ('Петров', 'Виктор', 'viktor@google.com', '1234567');
INSERT INTO cm_contact (sur_name, given_name, email, phone)
VALUES ('Сидоров', 'Василий', 'iv@google.com', '7654321');
INSERT INTO cm_contact (sur_name, given_name, email, phone)
VALUES ('Sidorov', 'Василий', 'ivan@google.com', '+7 (923)-124-45-67');
INSERT INTO cm_contact (sur_name, given_name, email, phone)
VALUES ('Васильев','Андрей','vas@pisem.net','123-45-67')

