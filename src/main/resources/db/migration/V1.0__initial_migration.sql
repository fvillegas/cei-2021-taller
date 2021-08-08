CREATE EXTENSION "uuid-ossp";

CREATE SEQUENCE items_sq;

CREATE TABLE items
(
    id   BIGINT PRIMARY KEY,
    uuid uuid,
    name VARCHAR
);

ALTER TABLE items
    ADD CONSTRAINT identity_uuid_unique UNIQUE (uuid);

INSERT INTO items(id, uuid, name)
VALUES (nextval('items_sq'), '263fae55-715e-4725-9594-48c40d5b94e3', 'item test 1');

CREATE TABLE shopping_cart
(
    user_id uuid,
    item_id uuid,
    status boolean
);

ALTER TABLE shopping_cart
    ADD FOREIGN KEY (item_id) REFERENCES items (uuid);