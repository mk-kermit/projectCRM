USE forcrm;
INSERT INTO roles (role_name) value ('ROLE_USER');
INSERT INTO roles (role_name) values ('ROLE_ADMIN');
INSERT INTO users (user_name, user_password, user_enabled) VALUES ('user', '$2y$12$uWknoEP7zDdgt8yToVn52epp6fZo.wYT4yfXMQOUdqE7WlL4OIO2G', 1);
INSERT INTO users (user_name, user_password, user_enabled) VALUES ('admin', '$2y$12$hsSnWeiQn/yQ5ANbnaAMYubB4x8G5PeZ4vAuQfdpJNgihlHwYjwf6', 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);