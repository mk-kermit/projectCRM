INSERT INTO forcrm.roles (role_name) VALUES ("ROLE_ADMIN");
INSERT INTO forcrm.roles (role_name) values ("ROLE_USER");
INSERT INTO forcrm.users (user_name, user_password, user_enabled) VALUES ("user", "user123", 1);
INSERT INTO forcrm.users (user_name, user_password, user_enabled) VALUES ("admin", "admin123", 1);
INSERT INTO forcrm.user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO forcrm.user_role (user_id, role_id) VALUES (2, 1);