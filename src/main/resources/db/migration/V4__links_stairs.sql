
CREATE TABLE IF NOT EXISTS "user" (
  id SERIAL PRIMARY KEY,
  login TEXT UNIQUE,
  password TEXT
);

CREATE TABLE IF NOT EXISTS "users_history" (
  id SERIAL PRIMARY KEY,
  user_id int REFERENCES "user"(id),
  point_from int,
  point_to int
);

CREATE TABLE IF NOT EXISTS "map_stairs" (
  id SERIAL PRIMARY KEY,
  x int,
  y int,
  level int,
  open boolean
);

CREATE TABLE IF NOT EXISTS "map_stairs_link" (
  id SERIAL PRIMARY KEY,
  id_from int references map_stairs(id),
  id_to int references map_stairs(id),
  weight int,
  open boolean
);
