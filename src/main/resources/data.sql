Use forcrm;
ALTER DATABASE forcrm
    DEFAULT CHARSET utf8 DEFAULT COLLATE utf8_general_ci;
INSERT INTO users (user_name, user_password, user_first_name, user_surname, user_enabled, user_role) VALUES ('user', '$2y$12$sOCPhGBklIWnFpZu8Jnkme1bXxU9KwsOERC5kqFbcIpHlZy5xYxie', 'Maciej', 'Nowak' ,1, 'ROLE_USER');
INSERT INTO users (user_name, user_password, user_first_name, user_surname, user_enabled, user_role) VALUES ('admin', '$2y$12$hyFXzRfOTD6p1c0NXX8KxetwR4m3WYlGHQxnezRaftmAH.rRe6rwm', 'Karol', 'Kowalski',1, 'ROLE_ADMIN');
INSERT INTO users (user_name, user_password, user_first_name, user_surname, user_enabled, user_role) VALUES ('leader', '$2y$12$3KF9V9rBdC0UttSJyTwp4.ChfKT5.8o2SPHoIwrhMzK4pdVxZ/yTu', 'Anna', 'Kowal',1, 'ROLE_LEADER');
INSERT INTO users (user_name, user_password, user_first_name, user_surname, user_enabled, user_role) VALUES ('user1', '$2y$12$mQ4hqYy0RYNpVUs4frD4yOnMmC7lgg9P.VwKS1mZyi5HWRNB27EMO', 'Ola', 'Rawa' ,1, 'ROLE_USER');
INSERT INTO tasks (task_title, task_description, task_status) values ('Sprzątanie łazienki', 'Rutynowe sprzątanie łazienki przed rozpoczęciem pracy', 'STATUS_OPEN');
INSERT INTO tasks (task_title, task_description, task_status) values ('Sprzątanie kuchni', 'Rutynowe sprzątanie kuchni po skończonej zmianie', 'STATUS_OPEN');
INSERT INTO tasks (task_title, task_description, task_status) values ('Rozliczenie zmiany', 'Rozliczenie zmiany wraz z napiwkami oraz informacją zwrotną dla szefostwa o dziennym utargu', 'STATUS_OPEN');
INSERT INTO users_tasks (user_id, tasks_id) VALUES (1, 1);
INSERT INTO users_tasks (user_id, tasks_id) VALUES (1, 2);
INSERT INTO users_tasks (user_id, tasks_id) VALUES (2, 3);
