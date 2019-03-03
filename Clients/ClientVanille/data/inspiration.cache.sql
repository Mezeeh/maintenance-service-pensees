PRAGMA foreign_keys = 0;

CREATE TABLE sqlitestudio_temp_table AS SELECT *
                                          FROM pensee;

DROP TABLE pensee;

CREATE TABLE pensee (
    id      INTEGER      PRIMARY KEY AUTOINCREMENT,
    auteur  STRING (255),
    message TEXT,
    source  TEXT
);

INSERT INTO pensee (
                       id,
                       auteur,
                       message
                   )
                   SELECT id,
                          auteur,
                          message
                     FROM sqlitestudio_temp_table;

DROP TABLE sqlitestudio_temp_table;

PRAGMA foreign_keys = 1;