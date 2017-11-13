DROP TABLE IF EXISTS tasks;

CREATE TABLE tasks(
    id INTEGER PRIMARY KEY NOT NULL,
    title VARCHAR (50),
    due_date VARCHAR DEFAULT "0000-00-00",
    details VARCHAR (300),
    priority VARCHAR (20),
    type VARCHAR (20),
    complete INTEGER
);