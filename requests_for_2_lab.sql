USE labor_sql;

SELECT maker, type FROM product 
WHERE product.type = "Printer" 
ORDER BY product.maker ASC;

SELECT * FROM trip 
WHERE TIME(time_out) BETWEEN "12:00" and "17:00";

SELECT maker, type, product.model, speed 
FROM product
JOIN laptop ON product.model = laptop.model 
WHERE laptop.speed >= 600;

SELECT distinct maker FROM product
WHERE maker = ANY(SELECT maker FROM product WHERE type = "PC")
AND maker = ANY(SELECT maker FROM product WHERE type = "Laptop");

SELECT ships.name, launched, displacement
FROM ships JOIN classes ON ships.class = classes.class
WHERE launched > 1922 AND displacement > 35000;

SELECT CONCAT('code: ', code, ',  model: ', model, ',  speed: '
, speed, '  ram: ', ram, '  hd: ', hd, '  cd: ', cd, '  price: ', price) FROM pc;

SELECT date, count(*) 
FROM pass_in_trip JOIN trip ON pass_in_trip.trip_no = trip.trip_no
WHERE town_to = "Moscow"
GROUP BY date;

SELECT speed, AVG(price) FROM pc
GROUP BY speed
HAVING speed > 600;

SELECT maker,
CASE WHEN
( SELECT COUNT(*)
FROM Product WHERE type='printer' GROUP BY maker HAVING maker=P.maker )IS NOT NULL THEN 
concat('yes(', 
(SELECT COUNT(*)
FROM Product WHERE type='printer' GROUP BY maker HAVING maker=P.maker ), ')') ELSE 'no'
END AS printers FROM Product P GROUP BY maker;

SELECT class, count(class) AS ships_count FROM Ships GROUP BY class;
	



