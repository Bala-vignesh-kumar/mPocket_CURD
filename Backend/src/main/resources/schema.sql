create table contacts
(
    id           INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name   VARCHAR(50),
    last_name    VARCHAR(50),
    phone_number VARCHAR(20),
    status       BOOLEAN DEFAULT 1
)