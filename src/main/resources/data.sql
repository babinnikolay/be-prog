INSERT INTO chapter (id, name) values (1, 'Chapter 1');
INSERT INTO chapter (id, name) values (2, 'Chapter 2');

INSERT INTO lesson (id, name, chapter_id, content_path) values (1, 'lesson 1', 1, '1.html');
INSERT INTO lesson (id, name, chapter_id, content_path) values (2, 'lesson 2', 1, '2.html');
INSERT INTO lesson (id, name, chapter_id, content_path) values (3, 'lesson 3', 1, '3.html');
INSERT INTO lesson (id, name, chapter_id, content_path) values (4, 'lesson 4', 1, '4.html');

INSERT INTO lesson (id, name, chapter_id) values (5, 'lesson 5', 2);
INSERT INTO lesson (id, name, chapter_id) values (6, 'lesson 6', 2);
INSERT INTO lesson (id, name, chapter_id) values (7, 'lesson 7', 2);
INSERT INTO lesson (id, name, chapter_id) values (8, 'lesson 8', 2);
