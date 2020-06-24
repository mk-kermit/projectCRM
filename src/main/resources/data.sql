Use forcrm;
INSERT INTO users (user_name, user_password, user_first_name, user_surname, user_enabled, user_role) VALUES ('user', '$2y$12$sOCPhGBklIWnFpZu8Jnkme1bXxU9KwsOERC5kqFbcIpHlZy5xYxie', 'Maciej', 'Nowak' ,1, 0);
INSERT INTO users (user_name, user_password, user_first_name, user_surname, user_enabled, user_role) VALUES ('admin', '$2y$12$hyFXzRfOTD6p1c0NXX8KxetwR4m3WYlGHQxnezRaftmAH.rRe6rwm', 'Karol', 'Kowalski',1, 2);
INSERT INTO users (user_name, user_password, user_first_name, user_surname, user_enabled, user_role) VALUES ('leader', '$2y$12$3KF9V9rBdC0UttSJyTwp4.ChfKT5.8o2SPHoIwrhMzK4pdVxZ/yTu', 'Anna', 'Kowal',1, 1);
INSERT INTO tasks (task_title, task_description, task_status) values ('Sprzątanie łazienki', 'Rutynowe sprzątanie łazienek przed rozpoczęciem pracy', 0);
INSERT INTO tasks (task_title, task_description, task_status) values ('Sprzątanie kuchni', 'Rutynowe sprzątanie kuchni po skończonej zmianie', 0);
INSERT INTO tasks (task_title, task_description, task_status) values ('Rozliczenie zmiany', 'Rozliczenie zmiany wraz z napiwkami oraz informacja zwrotna dla szefostwa o dziennym utargu', 0);
INSERT INTO users_tasks (user_id, tasks_id) VALUES (1, 1);