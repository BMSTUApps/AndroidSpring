
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
)