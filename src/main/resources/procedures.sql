use rent;

delimiter //

-- Написати користувацьку функцію, яка буде шукати 
-- Avg для стовпця довільної таблиці у БД. Написати процедуру, яка буде у SELECT викликати цю функцію.

drop procedure if exists get_avg_population_procedure //
create procedure get_avg_population_procedure()
begin
	SELECT get_avg_population() AS average_salary;
end //

-- Забезпечити параметризовану вставку нових значень у довільну таблицю.

drop procedure if exists add_country //
create procedure add_country(in country_name varchar(50)) 
begin
	insert into country (name) values
    (country_name);
end //

-- Створити пакет, який вставляє 10 стрічок у довільну таблицю БД

drop procedure if exists insert_10row_into_country //
create procedure insert_10row_into_country()
begin
	declare max_id int;
    declare iter int;
    set iter = 1;
    select count(id) + 1 into max_id from country;
    label1: while iter < 11 DO
		insert into country(name) values
        (concat("Noname_", max_id));
        set iter = iter + 1;
        set max_id = max_id + 1;
        ITERATE label1;
	END WHILE;
end //

drop procedure if exists create_user_dwelling_relationship //
create procedure create_user_dwelling_relationship(
	in dwell_id int,
    in user_id int)
begin
	insert into user_dwelling (dwelling_id, platform_user_id) values
    (dwell_id, user_id);
end //

DROP PROCEDURE IF EXISTS create_tables_with_cursor //
CREATE PROCEDURE create_tables_with_cursor()
BEGIN
	DECLARE done BOOL DEFAULT false;
    DECLARE country_name VARCHAR(50);
    DECLARE my_cursor CURSOR
    FOR SELECT name FROM `country`;

    DECLARE CONTINUE HANDLER
	FOR NOT FOUND SET done = true;

    OPEN my_cursor;
    my_loop: LOOP
		FETCH my_cursor INTO country_name;
        IF (done = true) THEN LEAVE my_loop;
        END IF;
        SET @temp_query = CONCAT('CREATE TABLE IF NOT EXISTS ', country_name, DATE_FORMAT(NOW(), "_%Y_%m_%d_%H_%i_%s"), ' (', country_name, '1 INT, ', country_name, '2 BOOL);');
		PREPARE my_query FROM @temp_query;
        EXECUTE my_query;
        DEALLOCATE PREPARE my_query;
    END LOOP;
    CLOSE my_cursor;
END //


delimiter ;
