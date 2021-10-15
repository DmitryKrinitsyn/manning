DROP TABLE IF EXISTS testdb.public.user_profile;

CREATE TABLE IF NOT EXISTS testdb.public.user_profile (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL
    );