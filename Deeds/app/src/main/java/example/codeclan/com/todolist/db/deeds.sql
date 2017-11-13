DROP TABLE IF EXISTS deeds;

CREATE TABLE deeds (
    id INTEGER PRIMARY KEY NOT NULL,
    title VARCHAR (50),
    due_date DATE DEFAULT "0000-00-00",
    details VARCHAR (300),
    priority VARCHAR (20),
    type VARCHAR (20),
    complete INTEGER,
);