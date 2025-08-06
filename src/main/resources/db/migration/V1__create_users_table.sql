CREATE TABLE users
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
    username           VARCHAR(50)  NOT NULL UNIQUE,
    email              VARCHAR(100) NOT NULL UNIQUE,
    password           VARCHAR(255) NOT NULL,
    status             VARCHAR(20)  NOT NULL DEFAULT 'INACTIVE',
    is_verified        BOOLEAN      NOT NULL DEFAULT FALSE,
    verification_token VARCHAR(255),
    verified_at        DATETIME,
    created_at         DATETIME              DEFAULT CURRENT_TIMESTAMP,
    updated_at         DATETIME              DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
