CREATE TABLE person
(
    id serial NOT NULL PRIMARY KEY,
    name text NOT NULL UNIQUE
);

CREATE TABLE product
(
    id serial NOT NULL PRIMARY KEY,
    name text NOT NULL UNIQUE,
    price integer NOT NULL
);
CREATE TABLE person_product
(
    person_id integer NOT NULL REFERENCES person (id) ON DELETE CASCADE,
    product_id integer NOT NULL REFERENCES product (id) ON DELETE CASCADE
);