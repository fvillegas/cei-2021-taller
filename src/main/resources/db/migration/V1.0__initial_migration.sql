CREATE SEQUENCE items_sq;

CREATE TABLE items (
  id BIGINT PRIMARY KEY,
  name VARCHAR
);

INSERT INTO items(id, name) VALUES (nextval('items_sq'), 'item test 1');
