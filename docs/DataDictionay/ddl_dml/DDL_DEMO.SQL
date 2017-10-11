/*
Created: 04/08/2017
Modified: 08/10/2017
Model: MySQL 5.7
Database: MySQL 5.7
*/
drop database demo;
create database demo;
use demo;

-- Create tables section -------------------------------------------------

-- Table D_BLOB_STORE

CREATE TABLE `D_BLOB_STORE`
(
  `user_insert` Varchar(100) NOT NULL,
  `user_update` Varchar(100),
  `time_insert` Datetime(2) NOT NULL,
  `time_update` Datetime(2),
  `id` Bigint NOT NULL AUTO_INCREMENT,
  `filename` Varchar(200) NOT NULL,
  `flag_active` Char(1) NOT NULL,
  `blob_data` Longblob NOT NULL,
  `fk_id_type` Bigint NOT NULL,
  `description` Varchar(200),
  `content_type` Varchar(100) NOT NULL,
  `year_refer` Date NOT NULL,
  PRIMARY KEY (`id`)
)
;

CREATE INDEX `IX_Relationship35` ON `D_BLOB_STORE` (`fk_id_type`)
;

-- Table D_USER_APP

CREATE TABLE `D_USER_APP`
(
  `username` Varchar(100) NOT NULL,
  `user_insert` Varchar(100) NOT NULL,
  `user_update` Varchar(100),
  `time_insert` Datetime(2) NOT NULL,
  `time_update` Datetime(2),
  `id` Bigint NOT NULL AUTO_INCREMENT,
  `password` Varchar(20) NOT NULL,
  `first_name` Varchar(50) NOT NULL,
  `last_name` Varchar(50) NOT NULL,
  `email` Varchar(100),
  `fk_id_blob_store` Bigint,
  `fk_id_role_user` Bigint NOT NULL,
  `year_refer` Date NOT NULL,
  `address` Varchar(2000),
  PRIMARY KEY (`id`)
)
;

CREATE INDEX `IX_Relationship6` ON `D_USER_APP` (`fk_id_role_user`)
;

ALTER TABLE `D_USER_APP` ADD UNIQUE `username` (`username`)
;

-- Table D_BLOB_STORE_H

CREATE TABLE `D_BLOB_STORE_H`
(
  `user_insert` Int,
  `user_update` Int,
  `time_insert` Datetime(2),
  `time_update` Datetime(2),
  `id` Bigint,
  `filename` Varchar(200),
  `flag_active` Char(1),
  `blob_data` Longblob,
  `fk_id_type` Bigint,
  `description` Varchar(200),
  `content_type` Varchar(100),
  `year_refer` Date NOT NULL,
  `crud_type` Char(1) NOT NULL
)
;

CREATE INDEX `IX_Relationship35` ON `D_BLOB_STORE_H` (`fk_id_type`)
;

-- Table D_ROLE_USER

CREATE TABLE `D_ROLE_USER`
(
  `user_insert` Varchar(100) NOT NULL,
  `user_update` Varchar(100),
  `time_insert` Datetime(2) NOT NULL,
  `time_update` Datetime(2),
  `id` Bigint NOT NULL,
  `role_code` Varchar(20) NOT NULL,
  `role_description` Varchar(100) NOT NULL,
  `year_refer` Date NOT NULL
)
;

ALTER TABLE `D_ROLE_USER` ADD  PRIMARY KEY (`id`)
;

ALTER TABLE `D_ROLE_USER` ADD UNIQUE `role` (`role_code`)
;

-- Table D_TYPE_DOCUMENT

CREATE TABLE `D_TYPE_DOCUMENT`
(
  `user_insert` Varchar(100) NOT NULL,
  `user_update` Varchar(100),
  `time_insert` Datetime(2) NOT NULL,
  `time_update` Datetime(2),
  `id` Bigint NOT NULL,
  `type_code` Varchar(20) NOT NULL,
  `type_description` Varchar(100) NOT NULL,
  `year_refer` Date NOT NULL
)
;

ALTER TABLE `D_TYPE_DOCUMENT` ADD  PRIMARY KEY (`id`)
;

ALTER TABLE `D_TYPE_DOCUMENT` ADD UNIQUE `role` (`type_code`)
;

-- Table D_USER_H

CREATE TABLE `D_USER_H`
(
  `username` Varchar(50),
  `user_insert` Varchar(100),
  `user_update` Varchar(100),
  `time_insert` Datetime(2),
  `time_update` Datetime(2),
  `id` Bigint,
  `password` Varchar(20),
  `first_name` Varchar(50),
  `last_name` Varchar(50),
  `email` Varchar(100),
  `fk_id_blob_store` Bigint,
  `fk_id_role_user` Bigint,
  `year_refer` Date NOT NULL,
  `crud_type` Char(1) NOT NULL
)
;

-- Table D_ROLE_FUNCTION

CREATE TABLE `D_ROLE_FUNCTION`
(
  `user_insert` Varchar(100) NOT NULL,
  `user_update` Varchar(100),
  `time_insert` Datetime(2) NOT NULL,
  `time_update` Datetime(2),
  `id` Bigint NOT NULL AUTO_INCREMENT,
  `year_refer` Date NOT NULL,
  PRIMARY KEY (`id`)
)
;

-- Table D_SYSTEM_PROPS

CREATE TABLE `D_SYSTEM_PROPS`
(
  `user_insert` Varchar(100) NOT NULL,
  `user_update` Varchar(100),
  `time_insert` Datetime(2) NOT NULL,
  `time_update` Datetime(2),
  `id` Bigint NOT NULL AUTO_INCREMENT,
  `year_refer` Date NOT NULL,
  `key_prop` Varchar(20) NOT NULL,
  `value_prop` Varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
)
;

ALTER TABLE `D_SYSTEM_PROPS` ADD UNIQUE `key_prop` (`key_prop`)
;

-- Table D_SYSTEM_PROPS_H

CREATE TABLE `D_SYSTEM_PROPS_H`
(
  `user_insert` Varchar(100) NOT NULL,
  `user_update` Varchar(100),
  `time_insert` Datetime(2) NOT NULL,
  `time_update` Datetime(2),
  `id` Bigint NOT NULL AUTO_INCREMENT,
  `year_refer` Date NOT NULL,
  `key_prop` Varchar(20) NOT NULL,
  `value_prop` Varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
)
;

ALTER TABLE `D_SYSTEM_PROPS_H` ADD UNIQUE `key_prop` (`key_prop`)
;

-- Table D_ORDER_JOB

CREATE TABLE `D_ORDER_JOB`
(
  `user_insert` Varchar(100) NOT NULL,
  `user_update` Varchar(100),
  `time_insert` Datetime(2) NOT NULL,
  `time_update` Datetime(2),
  `id` Bigint NOT NULL AUTO_INCREMENT,
  `fk_id_client` Bigint NOT NULL,
  `notes` Varchar(2000) NOT NULL,
  `code_order` Varchar(20),
  `data_scadenza` Datetime(2),
  `year_refer` Date NOT NULL,
  `pre_amount` Decimal(10,2),
  `final_amount` Decimal(10,2),
  `flag_active` Char(1),
  `address` Varchar(2000),
  PRIMARY KEY (`id`)
)
;

CREATE INDEX `IX_Relationship28` ON `D_ORDER_JOB` (`fk_id_client`)
;

-- Table D_ORDER_JOB_H

CREATE TABLE `D_ORDER_JOB_H`
(
  `user_insert` Varchar(100),
  `user_update` Varchar(100),
  `time_insert` Datetime(2),
  `time_update` Datetime(2),
  `id` Bigint,
  `fk_id_client` Bigint,
  `notes` Varchar(2000),
  `code_order` Varchar(20),
  `data_scadenza` Datetime(2),
  `year_refer` Date NOT NULL,
  `pre_amount` Decimal(10,2),
  `final_amount` Decimal(10,2),
  `flag_active` Char(1),
  `crud_type` Char(1) NOT NULL,
  `address` Varbinary(200)
)
;

-- Table D_CLIENT_APP

CREATE TABLE `D_CLIENT_APP`
(
  `user_insert` Varchar(100) NOT NULL,
  `user_update` Varchar(100),
  `time_insert` Datetime(2) NOT NULL,
  `time_update` Datetime(2),
  `id` Bigint NOT NULL AUTO_INCREMENT,
  `name` Varchar(100) NOT NULL,
  `piva` Varchar(16) NOT NULL,
  `address` Varchar(2000) NOT NULL,
  `zipcode` Varchar(5) NOT NULL,
  `notes` Varchar(2000) NOT NULL,
  `phone` Varchar(100),
  `email` Varchar(100),
  `year_refer` Date NOT NULL,
  PRIMARY KEY (`id`)
)
;

-- Table D_TYPE_DOCUMENT_H

CREATE TABLE `D_TYPE_DOCUMENT_H`
(
  `user_insert` Int,
  `user_update` Int,
  `time_insert` Datetime(2),
  `time_update` Datetime(2),
  `id` Bigint,
  `type_code` Varchar(20),
  `type_description` Varchar(100),
  `year_refer` Date NOT NULL,
  `crud_type` Char(1) NOT NULL
)
;

-- Table D_GEO_LOCAL

CREATE TABLE `D_GEO_LOCAL`
(
  `user_insert` Varchar(100) NOT NULL,
  `user_update` Varchar(100),
  `time_insert` Datetime(2) NOT NULL,
  `time_update` Datetime(2),
  `id` Bigint NOT NULL,
  `year_refer` Date NOT NULL
)
;

ALTER TABLE `D_GEO_LOCAL` ADD  PRIMARY KEY (`id`)
;

-- Table D_ROLE_USER_H

CREATE TABLE `D_ROLE_USER_H`
(
  `user_insert` Int,
  `user_update` Int,
  `time_insert` Datetime(2),
  `time_update` Datetime(2),
  `id` Bigint,
  `role_code` Varchar(20),
  `role_description` Varchar(100),
  `year_refer` Date NOT NULL,
  `crud_type` Char(1) NOT NULL
)
;

-- Table D_ROLE_FUNCTION_H

CREATE TABLE `D_ROLE_FUNCTION_H`
(
  `user_insert` Int,
  `user_update` Int,
  `time_insert` Datetime(2),
  `time_update` Datetime(2),
  `id` Bigint,
  `year_refer` Date NOT NULL,
  `crud_type` Char(1) NOT NULL
)
;

-- Table D_REL_USER_BLOB

CREATE TABLE `D_REL_USER_BLOB`
(
  `fk_id_user` Bigint NOT NULL,
  `fk_id_blob` Bigint NOT NULL,
  `id` Bigint NOT NULL AUTO_INCREMENT,
  `user_insert` Varchar(100) NOT NULL,
  `user_update` Varchar(100),
  `time_update` Datetime(2),
  `time_insert` Datetime(2) NOT NULL,
  `year_refer` Date NOT NULL,
  PRIMARY KEY (`id`)
)
;

CREATE INDEX `IX_Relationship20` ON `D_REL_USER_BLOB` (`fk_id_blob`)
;

CREATE INDEX `IX_Relationship22` ON `D_REL_USER_BLOB` (`fk_id_user`)
;

-- Table D_CLIENT_H

CREATE TABLE `D_CLIENT_H`
(
  `user_insert` Int,
  `user_update` Int,
  `time_insert` Datetime(2),
  `time_update` Datetime(2),
  `id` Bigint,
  `name` Varchar(100),
  `piva` Varchar(16),
  `address` Varchar(200),
  `zipcode` Varchar(5),
  `notes` Varchar(2000),
  `phone` Varchar(100),
  `email` Varchar(100),
  `year_refer` Date NOT NULL,
  `crud_type` Char(1) NOT NULL
)
;

-- Table D_REL_ORDER_BLOB

CREATE TABLE `D_REL_ORDER_BLOB`
(
  `fk_id_order` Bigint NOT NULL,
  `fk_id_blob` Bigint NOT NULL,
  `id` Bigint NOT NULL AUTO_INCREMENT,
  `user_insert` Varchar(100) NOT NULL,
  `user_update` Varchar(100),
  `time_insert` Datetime(2) NOT NULL,
  `time_update` Datetime(2),
  `year_refer` Date NOT NULL,
  PRIMARY KEY (`id`)
)
;

CREATE INDEX `IX_Relationship31` ON `D_REL_ORDER_BLOB` (`fk_id_blob`)
;

CREATE INDEX `IX_Relationship30` ON `D_REL_ORDER_BLOB` (`fk_id_order`)
;

-- Table D_REL_CLIENT_BLOB

CREATE TABLE `D_REL_CLIENT_BLOB`
(
  `fk_id_client` Bigint NOT NULL,
  `fk_id_blob` Bigint NOT NULL,
  `time_insert` Datetime(2) NOT NULL,
  `time_update` Datetime(2),
  `user_insert` Varchar(100) NOT NULL,
  `user_update` Varchar(100),
  `id` Bigint NOT NULL AUTO_INCREMENT,
  `year_refer` Date NOT NULL,
  PRIMARY KEY (`id`)
)
;

CREATE INDEX `IX_Relationship32` ON `D_REL_CLIENT_BLOB` (`fk_id_client`)
;

CREATE INDEX `IX_Relationship33` ON `D_REL_CLIENT_BLOB` (`fk_id_blob`)
;

-- Table D_GEO_LOCAL_H

CREATE TABLE `D_GEO_LOCAL_H`
(
  `user_insert` Int,
  `user_update` Int,
  `time_insert` Datetime(2),
  `time_update` Datetime(2),
  `id` Bigint,
  `year_refer` Date NOT NULL,
  `crud_type` Char(1) NOT NULL
)
;

-- Create tables section -------------------------------------------------

-- Table D_REL_USER_BLOB_H

CREATE TABLE `D_REL_USER_BLOB_H`
(
  `fk_id_user` Bigint,
  `fk_id_blob` Bigint,
  `id` Bigint,
  `user_insert` Varbinary(100),
  `user_update` Varchar(100),
  `time_update` Datetime(2),
  `time_insert` Datetime(2),
  `year_refer` Date NOT NULL,
  `crud_type` Char(1) NOT NULL
)
;

CREATE INDEX `IX_Relationship20` ON `D_REL_USER_BLOB_H` (`fk_id_blob`)
;

CREATE INDEX `IX_Relationship22` ON `D_REL_USER_BLOB_H` (`fk_id_user`)
;

-- Table D_REL_CLIENT_BLOB_H

CREATE TABLE `D_REL_CLIENT_BLOB_H`
(
  `fk_id_client` Bigint,
  `fk_id_blob` Bigint,
  `time_insert` Datetime(2),
  `time_update` Datetime(2),
  `user_insert` Varchar(100),
  `user_update` Varchar(100),
  `id` Bigint,
  `year_refer` Date NOT NULL,
  `crud_type` Char(1) NOT NULL
)
;

CREATE INDEX `IX_Relationship32` ON `D_REL_CLIENT_BLOB_H` (`fk_id_client`)
;

CREATE INDEX `IX_Relationship33` ON `D_REL_CLIENT_BLOB_H` (`fk_id_blob`)
;

-- Table D_REL_ORDER_BLOB_H

CREATE TABLE `D_REL_ORDER_BLOB_H`
(
  `fk_id_order` Bigint,
  `fk_id_blob` Bigint,
  `id` Bigint,
  `user_insert` Varchar(100),
  `user_update` Varchar(100),
  `time_insert` Datetime(2),
  `time_update` Datetime(2),
  `year_refer` Date NOT NULL,
  `crud_type` Char(1) NOT NULL
)
;

CREATE INDEX `IX_Relationship31` ON `D_REL_ORDER_BLOB_H` (`fk_id_blob`)
;

CREATE INDEX `IX_Relationship30` ON `D_REL_ORDER_BLOB_H` (`fk_id_order`)
;
-- Create relationships section ------------------------------------------------- 


ALTER TABLE `D_USER_APP` ADD CONSTRAINT `Relationship6` FOREIGN KEY (`fk_id_role_user`) REFERENCES `D_ROLE_USER` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `D_ROLE_FUNCTION` ADD CONSTRAINT `Relationship8` FOREIGN KEY (`id`) REFERENCES `D_ROLE_USER` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `D_REL_USER_BLOB` ADD CONSTRAINT `Relationship20` FOREIGN KEY (`fk_id_blob`) REFERENCES `D_BLOB_STORE` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `D_REL_USER_BLOB` ADD CONSTRAINT `Relationship22` FOREIGN KEY (`fk_id_user`) REFERENCES `D_USER_APP` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `D_ORDER_JOB` ADD CONSTRAINT `Relationship28` FOREIGN KEY (`fk_id_client`) REFERENCES `D_CLIENT_APP` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `D_REL_ORDER_BLOB` ADD CONSTRAINT `Relationship30` FOREIGN KEY (`fk_id_order`) REFERENCES `D_ORDER_JOB` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `D_REL_ORDER_BLOB` ADD CONSTRAINT `Relationship31` FOREIGN KEY (`fk_id_blob`) REFERENCES `D_BLOB_STORE` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `D_REL_CLIENT_BLOB` ADD CONSTRAINT `Relationship32` FOREIGN KEY (`fk_id_client`) REFERENCES `D_CLIENT_APP` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `D_REL_CLIENT_BLOB` ADD CONSTRAINT `Relationship33` FOREIGN KEY (`fk_id_blob`) REFERENCES `D_BLOB_STORE` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `D_BLOB_STORE` ADD CONSTRAINT `Relationship35` FOREIGN KEY (`fk_id_type`) REFERENCES `D_TYPE_DOCUMENT` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;


