/*
Created: 04/08/2017
Modified: 24/08/2017
Model: MySQL 5.7
Database: MySQL 5.7

use ad_fd9b087aa177207;
*/

use ad_fd9b087aa177207;

-- Drop relationships section -------------------------------------------------

ALTER TABLE 'BLOB_STORE' DROP FOREIGN KEY 'Relationship35'
;
ALTER TABLE 'REL_CLIENTS_BLOB' DROP FOREIGN KEY 'Relationship33'
;
ALTER TABLE 'REL_CLIENTS_BLOB' DROP FOREIGN KEY 'Relationship32'
;
ALTER TABLE 'REL_ORDERS_BLOB' DROP FOREIGN KEY 'Relationship31'
;
ALTER TABLE 'REL_ORDERS_BLOB' DROP FOREIGN KEY 'Relationship30'
;
ALTER TABLE 'ORDERS' DROP FOREIGN KEY 'Relationship28'
;
ALTER TABLE 'REL_USERS_BLOB' DROP FOREIGN KEY 'Relationship22'
;
ALTER TABLE 'REL_USERS_BLOB' DROP FOREIGN KEY 'Relationship20'
;
ALTER TABLE 'ROLES_FUNCTION' DROP FOREIGN KEY 'Relationship8'
;
ALTER TABLE 'USERS' DROP FOREIGN KEY 'Relationship6'
;




-- Drop keys for tables section -------------------------------------------------

ALTER TABLE 'TYPE_DOCUMENT' DROP PRIMARY KEY
;
ALTER TABLE 'TYPE_DOCUMENT' DROP KEY 'role'
;
ALTER TABLE 'CLIENTS_H' DROP PRIMARY KEY
;
ALTER TABLE 'ORDERS_H' DROP PRIMARY KEY
;
ALTER TABLE 'ROLES_FUNCTION_H' DROP PRIMARY KEY
;
ALTER TABLE 'ROLES_USERS_H' DROP PRIMARY KEY
;
ALTER TABLE 'USERS_H' DROP PRIMARY KEY
;
ALTER TABLE 'GEO_LOCAL' DROP PRIMARY KEY
;
-- ALTER TABLE 'CLIENTS' DROP PRIMARY KEY
-- ALTER TABLE 'ORDERS' DROP PRIMARY KEY
ALTER TABLE 'ROLES_FUNCTION' DROP PRIMARY KEY
;
ALTER TABLE 'ROLES_USERS' DROP PRIMARY KEY
;
ALTER TABLE 'ROLES_USERS' DROP KEY 'role'
;
-- ALTER TABLE 'USERS' DROP PRIMARY KEY
ALTER TABLE 'USERS' DROP KEY 'username'
;
-- ALTER TABLE 'BLOB_STORE' DROP PRIMARY KEY


-- Drop indexes section -------------------------------------------------

DROP INDEX 'IX_Relationship32' ON 'REL_CLIENTS_BLOB'
;

DROP INDEX 'IX_Relationship33' ON 'REL_CLIENTS_BLOB'
;

DROP INDEX 'IX_Relationship31' ON 'REL_ORDERS_BLOB'
;

DROP INDEX 'IX_Relationship30' ON 'REL_ORDERS_BLOB'
;

DROP INDEX 'IX_Relationship20' ON 'REL_USERS_BLOB'
;

DROP INDEX 'IX_Relationship22' ON 'REL_USERS_BLOB'
;

DROP INDEX 'IX_Relationship28' ON 'ORDERS'
;

DROP INDEX 'IX_Relationship6' ON 'USERS'
;

DROP INDEX 'IX_Relationship35' ON 'BLOB_STORE'
;


-- Drop tables section ---------------------------------------------------

DROP TABLE IF EXISTS 'REL_CLIENTS_BLOB'
;
DROP TABLE IF EXISTS 'REL_ORDERS_BLOB'
;
DROP TABLE IF EXISTS 'REL_USERS_BLOB'
;
DROP TABLE IF EXISTS 'CLIENTS_H'
;
DROP TABLE IF EXISTS 'ORDERS_H'
;
DROP TABLE IF EXISTS 'ROLES_FUNCTION_H'
;
DROP TABLE IF EXISTS 'ROLES_USERS_H'
;
DROP TABLE IF EXISTS 'USERS_H'
;
DROP TABLE IF EXISTS 'GEO_LOCAL'
;
DROP TABLE IF EXISTS 'CLIENTS'
;
DROP TABLE IF EXISTS 'ORDERS'
;
DROP TABLE IF EXISTS 'ROLES_FUNCTION'
;
DROP TABLE IF EXISTS 'TYPE_DOCUMENT'
;
DROP TABLE IF EXISTS 'ROLES_USERS'
;
DROP TABLE IF EXISTS 'USERS'
;
DROP TABLE IF EXISTS 'BLOB_STORE'
;

-- Create tables section -------------------------------------------------

-- Table BLOB_STORE

CREATE TABLE 'BLOB_STORE'
(
  'user_insert' Int NOT NULL,
  'user_update' Int,
  'time_insert' Datetime(2) NOT NULL,
  'time_update' Datetime(2),
  'id' Bigint NOT NULL AUTO_INCREMENT,
  'filename' Varchar(200) NOT NULL,
  'flag_active' Char(1) NOT NULL,
  'blob_data' Longblob NOT NULL,
  'fk_id_type' Bigint NOT NULL,
  'description' Varchar(200),
  'content_type' Varchar(100) NOT NULL,
  PRIMARY KEY ('id')
)
;

CREATE INDEX 'IX_Relationship35' ON 'BLOB_STORE' ('fk_id_type')
;

-- Table USERS

CREATE TABLE 'USERS'
(
  'username' Varchar(50) NOT NULL,
  'user_insert' Int NOT NULL,
  'user_update' Int,
  'time_insert' Datetime(2) NOT NULL,
  'time_update' Datetime(2),
  'id' Bigint NOT NULL AUTO_INCREMENT,
  'password' Varchar(20) NOT NULL,
  'first_name' Varchar(50) NOT NULL,
  'last_name' Varchar(50) NOT NULL,
  'email' Varchar(100),
  'fk_id_blob_store' Bigint,
  'fk_id_roles_users' Bigint NOT NULL,
  PRIMARY KEY ('id')
)
;

CREATE INDEX 'IX_Relationship6' ON 'USERS' ('fk_id_roles_users')
;

ALTER TABLE 'USERS' ADD UNIQUE 'username' ('username')
;

-- Table ROLES_USERS

CREATE TABLE 'ROLES_USERS'
(
  'user_insert' Int NOT NULL,
  'user_update' Int,
  'time_insert' Datetime(2) NOT NULL,
  'time_update' Datetime(2),
  'id' Bigint NOT NULL,
  'role_code' Varchar(20) NOT NULL,
  'role_description' Varchar(100) NOT NULL
)
;

ALTER TABLE 'ROLES_USERS' ADD  PRIMARY KEY ('id')
;

ALTER TABLE 'ROLES_USERS' ADD UNIQUE 'role' ('role_code')
;

-- Table TYPE_DOCUMENT

CREATE TABLE 'TYPE_DOCUMENT'
(
  'user_insert' Int NOT NULL,
  'user_update' Int,
  'time_insert' Datetime(2) NOT NULL,
  'time_update' Datetime(2),
  'id' Bigint NOT NULL,
  'type_code' Varchar(20) NOT NULL,
  'type_description' Varchar(100) NOT NULL
)
;

ALTER TABLE 'TYPE_DOCUMENT' ADD  PRIMARY KEY ('id')
;

ALTER TABLE 'TYPE_DOCUMENT' ADD UNIQUE 'role' ('type_code')
;

-- Table ROLES_FUNCTION

CREATE TABLE 'ROLES_FUNCTION'
(
  'user_insert' Int NOT NULL,
  'user_update' Int,
  'time_insert' Datetime(2) NOT NULL,
  'time_update' Datetime(2),
  'id' Bigint NOT NULL
)
;

ALTER TABLE 'ROLES_FUNCTION' ADD  PRIMARY KEY ('id')
;

-- Table ORDERS

CREATE TABLE 'ORDERS'
(
  'user_insert' Int NOT NULL,
  'user_update' Int,
  'time_insert' Datetime(2) NOT NULL,
  'time_update' Datetime(2),
  'id' Bigint NOT NULL AUTO_INCREMENT,
  'fk_id_clients' Bigint NOT NULL,
  'notes' Varchar(2000) NOT NULL,
  'code_order' Varchar(20),
  'data_scadenza' Datetime(2),
  PRIMARY KEY ('id')
)
;

CREATE INDEX 'IX_Relationship28' ON 'ORDERS' ('fk_id_clients')
;

-- Table CLIENTS

CREATE TABLE 'CLIENTS'
(
  'user_insert' Int NOT NULL,
  'user_update' Int,
  'time_insert' Datetime(2) NOT NULL,
  'time_update' Datetime(2),
  'id' Bigint NOT NULL AUTO_INCREMENT,
  'name' Varchar(100) NOT NULL,
  'piva' Varchar(16) NOT NULL,
  'address' Varchar(200) NOT NULL,
  'zipcode' Varchar(5) NOT NULL,
  'notes' Varchar(2000) NOT NULL,
  'phone' Varchar(100),
  'email' Varchar(100),
  PRIMARY KEY ('id')
)
;

-- Table GEO_LOCAL

CREATE TABLE 'GEO_LOCAL'
(
  'user_insert' Int NOT NULL,
  'user_update' Int,
  'time_insert' Datetime(2) NOT NULL,
  'time_update' Datetime(2),
  'id' Bigint NOT NULL
)
;

ALTER TABLE 'GEO_LOCAL' ADD  PRIMARY KEY ('id')
;

-- Table USERS_H

CREATE TABLE 'USERS_H'
(
  'user_insert' Int NOT NULL,
  'user_update' Int,
  'time_insert' Datetime(2) NOT NULL,
  'time_update' Datetime(2),
  'id' Bigint NOT NULL
)
;

ALTER TABLE 'USERS_H' ADD  PRIMARY KEY ('id')
;

-- Table ROLES_USERS_H

CREATE TABLE 'ROLES_USERS_H'
(
  'user_insert' Int NOT NULL,
  'user_update' Int,
  'time_insert' Datetime(2) NOT NULL,
  'time_update' Datetime(2),
  'id' Bigint NOT NULL
)
;

ALTER TABLE 'ROLES_USERS_H' ADD  PRIMARY KEY ('id')
;

-- Table ROLES_FUNCTION_H

CREATE TABLE 'ROLES_FUNCTION_H'
(
  'user_insert' Int NOT NULL,
  'user_update' Int,
  'time_insert' Datetime(2) NOT NULL,
  'time_update' Datetime(2),
  'id' Bigint NOT NULL
)
;

ALTER TABLE 'ROLES_FUNCTION_H' ADD  PRIMARY KEY ('id')
;

-- Table ORDERS_H

CREATE TABLE 'ORDERS_H'
(
  'user_insert' Int NOT NULL,
  'user_update' Int,
  'time_insert' Datetime(2) NOT NULL,
  'time_update' Datetime(2),
  'id' Bigint NOT NULL
)
;

ALTER TABLE 'ORDERS_H' ADD  PRIMARY KEY ('id')
;

-- Table CLIENTS_H

CREATE TABLE 'CLIENTS_H'
(
  'user_insert' Int NOT NULL,
  'user_update' Int,
  'time_insert' Datetime(2) NOT NULL,
  'time_update' Datetime(2),
  'id' Bigint NOT NULL
)
;

ALTER TABLE 'CLIENTS_H' ADD  PRIMARY KEY ('id')
;

-- Table REL_USERS_BLOB

CREATE TABLE 'REL_USERS_BLOB'
(
  'fk_id_users' Bigint,
  'fk_id_blob' Bigint
)
;

CREATE INDEX 'IX_Relationship20' ON 'REL_USERS_BLOB' ('fk_id_blob')
;

CREATE INDEX 'IX_Relationship22' ON 'REL_USERS_BLOB' ('fk_id_users')
;

-- Table REL_ORDERS_BLOB

CREATE TABLE 'REL_ORDERS_BLOB'
(
  'fk_id_orders' Bigint NOT NULL,
  'fk_id_blob' Bigint NOT NULL
)
;

CREATE INDEX 'IX_Relationship31' ON 'REL_ORDERS_BLOB' ('fk_id_blob')
;

CREATE INDEX 'IX_Relationship30' ON 'REL_ORDERS_BLOB' ('fk_id_orders')
;

-- Table REL_CLIENTS_BLOB

CREATE TABLE 'REL_CLIENTS_BLOB'
(
  'fk_id_clients' Bigint NOT NULL,
  'fk_id_blob' Bigint NOT NULL
)
;

CREATE INDEX 'IX_Relationship32' ON 'REL_CLIENTS_BLOB' ('fk_id_clients')
;

CREATE INDEX 'IX_Relationship33' ON 'REL_CLIENTS_BLOB' ('fk_id_blob')
;

-- Create relationships section ------------------------------------------------- 

ALTER TABLE 'USERS' ADD CONSTRAINT 'Relationship6' FOREIGN KEY ('fk_id_roles_users') REFERENCES 'ROLES_USERS' ('id') ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE 'ROLES_FUNCTION' ADD CONSTRAINT 'Relationship8' FOREIGN KEY ('id') REFERENCES 'ROLES_USERS' ('id') ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE 'REL_USERS_BLOB' ADD CONSTRAINT 'Relationship20' FOREIGN KEY ('fk_id_blob') REFERENCES 'BLOB_STORE' ('id') ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE 'REL_USERS_BLOB' ADD CONSTRAINT 'Relationship22' FOREIGN KEY ('fk_id_users') REFERENCES 'USERS' ('id') ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE 'ORDERS' ADD CONSTRAINT 'Relationship28' FOREIGN KEY ('fk_id_clients') REFERENCES 'CLIENTS' ('id') ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE 'REL_ORDERS_BLOB' ADD CONSTRAINT 'Relationship30' FOREIGN KEY ('fk_id_orders') REFERENCES 'ORDERS' ('id') ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE 'REL_ORDERS_BLOB' ADD CONSTRAINT 'Relationship31' FOREIGN KEY ('fk_id_blob') REFERENCES 'BLOB_STORE' ('id') ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE 'REL_CLIENTS_BLOB' ADD CONSTRAINT 'Relationship32' FOREIGN KEY ('fk_id_clients') REFERENCES 'CLIENTS' ('id') ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE 'REL_CLIENTS_BLOB' ADD CONSTRAINT 'Relationship33' FOREIGN KEY ('fk_id_blob') REFERENCES 'BLOB_STORE' ('id') ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE 'BLOB_STORE' ADD CONSTRAINT 'Relationship35' FOREIGN KEY ('fk_id_type') REFERENCES 'TYPE_DOCUMENT' ('id') ON DELETE RESTRICT ON UPDATE RESTRICT
;




/*
-- DML
*/



INSERT into roles_users (user_insert, user_update, time_insert, time_update, id, role_code, role_description) VALUES
(0, NULL, '2017-08-07 22:10:27.00', NULL, 1, 'ROLE_ADMIN','AMMINISTRATORE'),
(0, NULL, '2017-08-07 22:10:27.00', NULL, 2, 'ROLE_USER', 'UTENTE OPERATIVO');

INSERT INTO users (username, user_insert, user_update, time_insert, time_update, id, password, first_name, last_name, email, fk_id_blob_store, fk_id_roles_users) VALUES
('admin', 0, NULL, '2017-08-07 22:17:47.00', NULL, 1, 'password', 'admin', 'admin', NULL, NULL, 1);

INSERT INTO type_document(user_insert, user_update, time_insert, time_update, id, type_code, type_description) VALUES 
(0, NULL, '2017-08-07 22:17:47.00', NULL, 1, 'GENERIC', 'DOCUMENTO GENERICO');

