CREATE TABLE cake
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name     VARCHAR(255),
    calories DECIMAL,
    image    VARCHAR(255),
    price    DECIMAL,
    weight   DECIMAL,
    CONSTRAINT pk_cake PRIMARY KEY (id)
);
CREATE TABLE "user"
(
    id     BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name   VARCHAR(255),
    number VARCHAR(255)                            NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE "user"
    ADD CONSTRAINT uc_user_number UNIQUE (number);

CREATE TABLE "order"
(
    id               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    user_id          BIGINT                                  NOT NULL,
    delivery         INTEGER,
    status           INTEGER,
    payment          INTEGER,
    delivery_address VARCHAR(255),
    delivery_time    TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_order PRIMARY KEY (id)
);

ALTER TABLE "order"
    ADD CONSTRAINT FK_ORDER_ON_USER FOREIGN KEY (user_id) REFERENCES "user" (id);
CREATE TABLE purchase
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    cake_id  BIGINT                                  NOT NULL,
    order_id BIGINT                                  NOT NULL,
    number   INTEGER,
    CONSTRAINT pk_purchase PRIMARY KEY (id)
);

ALTER TABLE purchase
    ADD CONSTRAINT FK_PURCHASE_ON_CAKE FOREIGN KEY (cake_id) REFERENCES cake (id);

ALTER TABLE purchase
    ADD CONSTRAINT FK_PURCHASE_ON_ORDER FOREIGN KEY (order_id) REFERENCES "order" (id);

