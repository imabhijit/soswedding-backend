CREATE TABLE user (
  id BIGINT PRIMARY KEY,
  firstName VARCHAR(256) NOT NULL,
  lastName VARCHAR(256)
);

INSERT into user (id, firstName) VALUES (1, "admin");
