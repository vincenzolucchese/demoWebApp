-- Create triggers for table USER
use demo;
/*
drop trigger Trigger_pre_insert;
drop trigger Trigger_pre_update;
drop trigger Trigger_pre_delete;
*/

DELIMITER //
CREATE or replace  TRIGGER `Trigger_pre_insert`
  BEFORE
  INSERT
  ON `USER`
  FOR EACH ROW
  BEGIN
    INSERT INTO user_h 
    (username, 
    user_insert, 
    user_update, 
    time_insert, 
    time_update, 
    id, password, 
    first_name, 
    last_name, 
    email, 
    fk_id_blob_store, 
    fk_id_role_user,
    year_refer,
    crud_type
    ) 
    VALUES
    (new.username, 
    new.user_insert, 
    new.user_update, 
    new.time_insert, 
    new.time_update, 
    new.id, 
    new.password, 
    new.first_name, 
    new.last_name, 
    new.email, 
    new.fk_id_blob_store, 
    new.fk_id_role_user,
    new.year_refer,
    'I'
    );
END //
DELIMITER;
/*
DELIMITER  //
CREATE or replace  TRIGGER `Trigger_pre_update`
  BEFORE
  UPDATE
  ON `USER`
  FOR EACH ROW
  BEGIN
   INSERT INTO user_h 
    (username, 
    user_insert, 
    user_update, 
    time_insert, 
    time_update, 
    id, password, 
    first_name, 
    last_name, 
    email, 
    fk_id_blob_store, 
    fk_id_role_user,
    year_refer,
    crud_type
    ) 
    VALUES
    (new.username, 
    new.user_insert, 
    new.user_update, 
    new.time_insert, 
    new.time_update, 
    new.id, 
    new.password, 
    new.first_name, 
    new.last_name, 
    new.email, 
    new.fk_id_blob_store, 
    new.fk_id_role_user,
    new.year_refer,
    'U'
    );
END
;
//
DELIMITER;

DELIMITER //
CREATE or replace  TRIGGER `Trigger_pre_delete`
  BEFORE
  DELETE
  ON `USER`
  FOR EACH ROW
  BEGIN
    INSERT INTO user_h 
    (username, 
    user_insert, 
    user_update, 
    time_insert, 
    time_update, 
    id, password, 
    first_name, 
    last_name, 
    email, 
    fk_id_blob_store, 
    fk_id_role_user,
    year_refer,
    crud_type
    ) 
    VALUES
    (old.username, 
    old.user_insert, 
    old.user_update, 
    old.time_insert, 
    old.time_update, 
    old.id, 
    old.password, 
    old.first_name, 
    old.last_name, 
    old.email, 
    old.fk_id_blob_store, 
    old.fk_id_role_user,
    old.year_refer,
    'D'
    );
END
;
//
DELIMITER;

