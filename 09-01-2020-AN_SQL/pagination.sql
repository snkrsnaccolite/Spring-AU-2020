-- STORED PROCEDURE
CREATE DEFINER=`root`@`localhost` PROCEDURE `pagination`(IN page INT, IN rowcount INT)
BEGIN
	DECLARE start INT;
	SET start = page - 1;
	SET start = start * rowcount;
	SELECT * FROM employee LIMIT start,rowcount;
END

-- SQL QUERY
CALL pagination(3, 13);
