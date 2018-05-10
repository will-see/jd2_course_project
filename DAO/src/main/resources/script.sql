USE libhib_db;

INSERT INTO libhib_db.roles (ROLE_ID, ROLE_NAME) VALUES (1, 'admin');
INSERT INTO libhib_db.roles (ROLE_ID, ROLE_NAME) VALUES (2, 'admin');
INSERT INTO libhib_db.roles (ROLE_ID, ROLE_NAME) VALUES (3, 'admin');
INSERT INTO libhib_db.roles (ROLE_ID, ROLE_NAME) VALUES (4, 'user');
INSERT INTO libhib_db.roles (ROLE_ID, ROLE_NAME) VALUES (5, 'user');
INSERT INTO libhib_db.roles (ROLE_ID, ROLE_NAME) VALUES (6, 'user');

INSERT INTO libhib_db.authors (authorId, country, name, year) VALUES (1, 'Rusia', 'Puskin1', 1901);
INSERT INTO libhib_db.authors (authorId, country, name, year) VALUES (2, 'Rusia', 'Puskin2', 1902);
INSERT INTO libhib_db.authors (authorId, country, name, year) VALUES (3, 'Rusia', 'Puskin3', 1903);
INSERT INTO libhib_db.authors (authorId, country, name, year) VALUES (4, 'Rusia', 'Puskin4', 1904);
INSERT INTO libhib_db.authors (authorId, country, name, year) VALUES (5, 'Rusia', 'Puskin5', 1905);
INSERT INTO libhib_db.authors (authorId, country, name, year) VALUES (6, 'Rusia', 'Puskin6', 1906);
INSERT INTO libhib_db.authors (authorId, country, name, year) VALUES (7, 'Rusia', 'Lermontov', 1907);
INSERT INTO libhib_db.authors (authorId, country, name, year) VALUES (8, 'Rusia', 'Tolstoj', 1908);

INSERT INTO libhib_db.books (bookId, bookCount, ganr, pages, title, AUTHOR_ID) VALUES (1, 10, 'skazka', 101, 'lukomore1', 1);
INSERT INTO libhib_db.books (bookId, bookCount, ganr, pages, title, AUTHOR_ID) VALUES (2, 10, 'skazka', 102, 'lukomore2', 2);
INSERT INTO libhib_db.books (bookId, bookCount, ganr, pages, title, AUTHOR_ID) VALUES (3, 10, 'skazka', 103, 'lukomore3', 3);
INSERT INTO libhib_db.books (bookId, bookCount, ganr, pages, title, AUTHOR_ID) VALUES (4, 10, 'skazka', 104, 'lukomore4', 4);
INSERT INTO libhib_db.books (bookId, bookCount, ganr, pages, title, AUTHOR_ID) VALUES (5, 10, 'skazka', 105, 'lukomore5', 5);
INSERT INTO libhib_db.books (bookId, bookCount, ganr, pages, title, AUTHOR_ID) VALUES (6, 10, 'skazka', 106, 'lukomore6', 6);
INSERT INTO libhib_db.books (bookId, bookCount, ganr, pages, title, AUTHOR_ID) VALUES (7, 10, 'unknown', 105, 'book1', 7);
INSERT INTO libhib_db.books (bookId, bookCount, ganr, pages, title, AUTHOR_ID) VALUES (8, 10, 'unknown', 106, 'book2', 8);

INSERT INTO libhib_db.users (USER_ID, AGE, LOGIN, FIRST_NAME, PASSWORD, SEX, ROLE_ID) VALUES (1, 100, 'admin', 'admin', 'admin', 'male', 1);
INSERT INTO libhib_db.users (USER_ID, AGE, LOGIN, FIRST_NAME, PASSWORD, SEX, ROLE_ID) VALUES (2, 20, 'admin2', 'admin2', 'admin2', 'male', 2);
INSERT INTO libhib_db.users (USER_ID, AGE, LOGIN, FIRST_NAME, PASSWORD, SEX, ROLE_ID) VALUES (3, 30, 'admin3', 'admin3', 'admin3', 'male', 3);
INSERT INTO libhib_db.users (USER_ID, AGE, LOGIN, FIRST_NAME, PASSWORD, SEX, ROLE_ID) VALUES (4, 40, 'user', 'user', 'user', 'male', 4);
INSERT INTO libhib_db.users (USER_ID, AGE, LOGIN, FIRST_NAME, PASSWORD, SEX, ROLE_ID) VALUES (5, 50, 'user2', 'user2', 'user2', 'male', 5);
INSERT INTO libhib_db.users (USER_ID, AGE, LOGIN, FIRST_NAME, PASSWORD, SEX, ROLE_ID) VALUES (6, 60, 'user3', 'user3', 'user3', 'male', 6);

INSERT INTO libhib_db.formulars (FORMULAR_ID, USER_ID) VALUES (1, 1);
INSERT INTO libhib_db.formulars (FORMULAR_ID, USER_ID) VALUES (2, 1);
INSERT INTO libhib_db.formulars (FORMULAR_ID, USER_ID) VALUES (3, 2);
INSERT INTO libhib_db.formulars (FORMULAR_ID, USER_ID) VALUES (4, 4);
INSERT INTO libhib_db.formulars (FORMULAR_ID, USER_ID) VALUES (5, 4);
INSERT INTO libhib_db.formulars (FORMULAR_ID, USER_ID) VALUES (6, 4);
INSERT INTO libhib_db.formulars (FORMULAR_ID, USER_ID) VALUES (7, 4);
INSERT INTO libhib_db.formulars (FORMULAR_ID, USER_ID) VALUES (8, 4);
INSERT INTO libhib_db.formulars (FORMULAR_ID, USER_ID) VALUES (9, 4);
INSERT INTO libhib_db.formulars (FORMULAR_ID, USER_ID) VALUES (10, 4);
INSERT INTO libhib_db.formulars (FORMULAR_ID, USER_ID) VALUES (11, 4);
INSERT INTO libhib_db.formulars (FORMULAR_ID, USER_ID) VALUES (12, 4);
INSERT INTO libhib_db.formulars (FORMULAR_ID, USER_ID) VALUES (13, 4);
INSERT INTO libhib_db.formulars (FORMULAR_ID, USER_ID) VALUES (14, 4);
INSERT INTO libhib_db.formulars (FORMULAR_ID, USER_ID) VALUES (15, 4);

INSERT INTO libhib_db.formular_book (bookId, FORMULAR_ID) VALUES (6, 4);
INSERT INTO libhib_db.formular_book (bookId, FORMULAR_ID) VALUES (5, 6);
INSERT INTO libhib_db.formular_book (bookId, FORMULAR_ID) VALUES (4, 8);
INSERT INTO libhib_db.formular_book (bookId, FORMULAR_ID) VALUES (3, 10);
INSERT INTO libhib_db.formular_book (bookId, FORMULAR_ID) VALUES (2, 2);
INSERT INTO libhib_db.formular_book (bookId, FORMULAR_ID) VALUES (2, 3);
INSERT INTO libhib_db.formular_book (bookId, FORMULAR_ID) VALUES (2, 12);
INSERT INTO libhib_db.formular_book (bookId, FORMULAR_ID) VALUES (1, 1);
INSERT INTO libhib_db.formular_book (bookId, FORMULAR_ID) VALUES (1, 14);