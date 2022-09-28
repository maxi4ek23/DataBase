USE rent_platform;

# Виводить прізвище орендаря і його середню оцінку 

SELECT surname, AVG(rating) 
FROM lessee JOIN lessee_feedback 
ON lessee.id = lessee_feedback.lessee_id
GROUP BY surname
ORDER BY AVG(rating); 

# Виводить прізвище власника та кількість житла які він здає

SELECT surname, count(*) AS dweling_count 
FROM dwelling_owner JOIN dwelling 
ON dwelling_owner.id = dwelling.dwelling_owner_id
GROUP BY surname
ORDER BY count(*) DESC;

# виводить регіон і кількість житл котрі в ньому здаються

SELECT region.name, count(*) AS dwelling_count 
FROM region 
JOIN city ON region.id = city.region_id
JOIN adress ON city.id = adress.city_id
JOIN dwelling ON adress.id = dwelling.adress_id
GROUP BY region.name
ORDER BY count(*) DESC;

# Виводить фамілії користувачів платформи та знаходить чи це власник чи орендар

SELECT surname, 'true' AS is_lessee, 'false'AS is_owner 
FROM lessee
UNION
SELECT surname, 'false', 'true' 
FROM dwelling_owner
ORDER BY surname;

# Виводить всі дані про житло

SELECT CONCAT('area: ', area, ',  floor: ', floor, ',  number of rooms: '
, rooms_number, '  description: ', description) 
FROM dwelling;

# Виводить прізвище орендаря та ім'я резервації якщо план на оренду є більшим за 1 рік

SELECT surname, reservation.name 
FROM lessee JOIN reservation 
ON lessee.id = reservation.lessee_id
WHERE YEAR(how_long) - YEAR(time) >= 2 || (YEAR(how_long) - YEAR(time) = 1 && MONTH(how_long) - MONTH(time) >= 1) 
|| (YEAR(how_long) - YEAR(time) = 1 && MONTH(how_long) - MONTH(time) = 0 && DAY(how_long) - DAY(time) >= 0)
GROUP BY surname;

# виводить ім'я резервації, скільки зарезервовано житл та фулл ціна за резервацію

SELECT name, count(*) AS number_of_dwelling, sum(price) AS full_price 
FROM reservation 
JOIN cash_withdrawal_from_lessee_to_service 
ON reservation.id = cash_withdrawal_from_lessee_to_service.reservation_id
GROUP BY name
ORDER BY full_price DESC;

# Виводить табличку з повною інформацією кожного житла

SELECT region.name AS oblast, city.name AS city, adress.street, dwelling.area, dwelling.floor, dwelling.rooms_number 
FROM region 
JOIN city ON region.id = city.region_id
JOIN adress ON city.id = adress.city_id
JOIN dwelling ON adress.id = dwelling.adress_id
ORDER BY area;

# Виводить інформацію про всіх учасників платформи

SELECT name, surname, email, phone, 'lessee' AS who 
FROM lessee JOIN platform_user 
ON lessee.platform_user_id = platform_user.id
UNION
SELECT name, surname, email, phone, 'owner' 
FROM dwelling_owner JOIN platform_user 
ON dwelling_owner.platform_user_id = platform_user.id
GROUP BY email;

# Виводить фамілію користувача та показує кількість різних оцінок

SELECT surname, sum(rating = 5) AS '5-mark', sum(rating = 4) AS '4-mark', sum(rating = 3) AS '3-mark' 
FROM dwelling_owner JOIN owner_feedback 
ON dwelling_owner.id = owner_feedback.dwelling_owner_id
GROUP BY surname
UNION
SELECT surname, sum(rating = 5) AS '5-mark', sum(rating = 4) AS '4-mark', sum(rating = 3) AS '3-mark' 
FROM lessee JOIN lessee_feedback 
ON lessee.id = lessee_feedback.lessee_id
GROUP BY surname;


