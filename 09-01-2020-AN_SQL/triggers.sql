-- BEFORE INSERT

DELIMITER $$
CREATE TRIGGER before_insert
BEFORE INSERT
ON employee FOR EACH ROW
	INSERT INTO emp_join_log
	SET id = new.id, name = new.name, time = NOW();

-- BEFORE DELETE

CREATE TRIGGER before_delete
BEFORE DELETE
ON employee FOR EACH ROW
	INSERT INTO emp_leave_log
	SET id = old.id, name = old.name, time = NOW();

-- BEFORE UPDATE

CREATE TRIGGER before_update
BEFORE UPDATE
ON employee FOR EACH ROW
	INSERT INTO emp_update_log
	SET id = old.id, name = old.name, dept = new.dept, time = NOW();

