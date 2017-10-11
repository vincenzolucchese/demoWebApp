/*
-- DML
*/

use demo_test;

INSERT INTO d_role_user (user_insert, user_update, time_insert, time_update, id, role_code, role_description, year_refer) VALUES
(0, NULL, '2017-08-07 22:10:27.00', NULL, 1, 'ROLE_ADMIN','AMMINISTRATORE', STR_TO_DATE('01-01-2017', '%d-%m-%Y') ),
(0, NULL, '2017-08-07 22:10:27.00', NULL, 2, 'ROLE_USER', 'UTENTE OPERATIVO', STR_TO_DATE('01-01-2017', '%d-%m-%Y') );

INSERT INTO d_user_app (username, user_insert, user_update, time_insert, time_update, id, password, first_name, last_name, email, 
fk_id_blob_store, fk_id_role_user, year_refer) VALUES
('admin', 0, NULL, '2017-08-07 22:17:47.00', NULL, 1, 'password', 'admin', 'admin', NULL, NULL, 1, STR_TO_DATE('01-01-2017', '%d-%m-%Y') );

INSERT INTO d_type_document(user_insert, user_update, time_insert, time_update, id, type_code, type_description, year_refer) VALUES 
(0, NULL, '2017-08-07 22:17:47.00', NULL, 1, 'GENERIC', 'DOCUMENTO GENERICO', STR_TO_DATE('01-01-2017', '%d-%m-%Y'));

insert into d_system_props ( user_insert, user_update, time_insert, time_update, id, year_refer, key_prop, value_prop) 
VALUES 
('system', NULL, '2017-08-07 22:17:47.00', NULL, 1, STR_TO_DATE('01-01-2017', '%d-%m-%Y'), 'YEAR', '2017');