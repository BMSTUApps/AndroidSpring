CREATE TABLE IF NOT EXISTS "user"
(
    id       SERIAL PRIMARY KEY,
    login    TEXT UNIQUE,
    password TEXT
);

CREATE TABLE IF NOT EXISTS "users_history"
(
    id         SERIAL PRIMARY KEY,
    user_id    int REFERENCES "user" (id),
    point_from int,
    point_to   int
);

CREATE TABLE IF NOT EXISTS "map_stairs"
(
    id    SERIAL PRIMARY KEY,
    x     int,
    y     int,
    level int,
    open  boolean
);

CREATE TABLE IF NOT EXISTS "map_stairs_link"
(
    id      SERIAL PRIMARY KEY,
    id_from int references map_stairs (id),
    id_to   int references map_stairs (id),
    weight  int,
    open    boolean
);

CREATE TABLE IF NOT EXISTS "map_level_walls"
(
    id       SERIAL PRIMARY KEY,
    level    int DEFAULT 0 NOT NULL,
    x_first  int DEFAULT 0 NOT NULL,
    y_first  int DEFAULT 0 NOT NULL,
    x_second int DEFAULT 0 NOT NULL,
    y_second int DEFAULT 0 NOT NULL
);

CREATE TABLE IF NOT EXISTS "news"
(
    id      SERIAL PRIMARY KEY,
    title   TEXT                      NOT NULL,
    time    TIMESTAMPTZ DEFAULT now() NOT NULL,
    payload TEXT                      NOT NULL
);

INSERT INTO map_stairs (x, y, level, open)
VALUES (50, 50, 1, true);
INSERT INTO map_stairs (x, y, level, open)
VALUES (25, 60, 1, true);
INSERT INTO map_stairs (x, y, level, open)
VALUES (75, 60, 1, true);
INSERT INTO map_stairs (x, y, level, open)
VALUES (50, 50, 2, true);
INSERT INTO map_stairs (x, y, level, open)
VALUES (25, 60, 2, true);
INSERT INTO map_stairs (x, y, level, open)
VALUES (75, 60, 2, true);

INSERT INTO map_stairs_link (id_from, id_to, weight, open)
VALUES (1, 2, 1, true);
INSERT INTO map_stairs_link (id_from, id_to, weight, open)
VALUES (1, 3, 1, true);
INSERT INTO map_stairs_link (id_from, id_to, weight, open)
VALUES (2, 3, 1, true);
INSERT INTO map_stairs_link (id_from, id_to, weight, open)
VALUES (1, 4, 1, true);
INSERT INTO map_stairs_link (id_from, id_to, weight, open)
VALUES (2, 5, 1, true);
INSERT INTO map_stairs_link (id_from, id_to, weight, open)
VALUES (3, 6, 1, true);
INSERT INTO map_stairs_link (id_from, id_to, weight, open)
VALUES (6, 4, 1, true);
INSERT INTO map_stairs_link (id_from, id_to, weight, open)
VALUES (4, 5, 1, true);
INSERT INTO map_stairs_link (id_from, id_to, weight, open)
VALUES (5, 6, 1, true);