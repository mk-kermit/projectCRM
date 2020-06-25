Use forcrm;
INSERT INTO users (user_name, user_password, user_first_name, user_surname, user_enabled, user_role) VALUES ('user', '$2y$12$sOCPhGBklIWnFpZu8Jnkme1bXxU9KwsOERC5kqFbcIpHlZy5xYxie', 'Maciej', 'Nowak' ,1, 'ROLE_USER');
INSERT INTO users (user_name, user_password, user_first_name, user_surname, user_enabled, user_role) VALUES ('admin', '$2y$12$hyFXzRfOTD6p1c0NXX8KxetwR4m3WYlGHQxnezRaftmAH.rRe6rwm', 'Karol', 'Kowalski',1, 'ROLE_ADMIN');
INSERT INTO users (user_name, user_password, user_first_name, user_surname, user_enabled, user_role) VALUES ('leader', '$2y$12$3KF9V9rBdC0UttSJyTwp4.ChfKT5.8o2SPHoIwrhMzK4pdVxZ/yTu', 'Anna', 'Kowal',1, 'ROLE_LEADER');
INSERT INTO tasks (task_title, task_description, task_status) values ('Sprzatanie lazienki', 'Rutynowe sprzatanie lazienek przed rozpoczeciem pracy', 'STATUS_OPEN');
INSERT INTO tasks (task_title, task_description, task_status) values ('Sprzatanie kuchni', 'Rutynowe sprzatanie kuchni po skonczonej zmianie', 'STATUS_OPEN');
INSERT INTO tasks (task_title, task_description, task_status) values ('Rozliczenie zmiany', 'Rozliczenie zmiany wraz z napiwkami oraz informacja zwrotna dla szefostwa o dziennym utargu', 'STATUS_OPEN');
INSERT INTO users_tasks (user_id, tasks_id) VALUES (1, 1);