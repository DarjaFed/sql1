DROP TABLE IF EXISTS auth_codes;
DROP TABLE IF EXISTS cards;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id VARCHAR(50) PRIMARY KEY,
    login VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    status VARCHAR(20) NOT NULL
);

CREATE TABLE auth_codes (
    id VARCHAR(50) PRIMARY KEY,
    user_id VARCHAR(50),
    code VARCHAR(10),
    created TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE cards (
    id VARCHAR(50) PRIMARY KEY,
    user_id VARCHAR(50),
    number VARCHAR(20),
    balance_in_kopecks INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);