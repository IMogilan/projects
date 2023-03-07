CREATE TABLE IF NOT EXISTS employees (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR (30) NOT NULL,
    last_name VARCHAR (400) NOT NULL,
    email VARCHAR (254) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR (30) NOT NULL,
    last_name VARCHAR (400) NOT NULL,
    email VARCHAR (254) NOT NULL UNIQUE,
    password VARCHAR (255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS roles (
    id BIGSERIAL PRIMARY KEY ,
    name VARCHAR (30) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS users_roles (
    user_id BIGINT REFERENCES users (id),
    role_id BIGINT REFERENCES roles (id)
)









