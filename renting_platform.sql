-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-12 14:31:40.494

-- tables
-- Table: adress
CREATE TABLE adress (
    id int NOT NULL AUTO_INCREMENT,
    street varchar(45) NOT NULL,
    house_number int NULL,
    city_id int NOT NULL,
    CONSTRAINT adress_pk PRIMARY KEY (id)
);

-- Table: cash_withdrawal_from_lessee_to_service
CREATE TABLE cash_withdrawal_from_lessee_to_service (
    id int NOT NULL,
    price int NOT NULL,
    reservation_id int NOT NULL,
    CONSTRAINT cash_withdrawal_from_lessee_to_service_pk PRIMARY KEY (id)
);

-- Table: cash_withdrawal_from_service_to_owner
CREATE TABLE cash_withdrawal_from_service_to_owner (
    id int NOT NULL,
    price int NOT NULL,
    cash_withdrawal_from_lessee_to_service_id int NOT NULL,
    CONSTRAINT cash_withdrawal_from_service_to_owner_pk PRIMARY KEY (id)
);

-- Table: city
CREATE TABLE city (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(35) NOT NULL,
    region_id int NOT NULL,
    CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: dwelling
CREATE TABLE dwelling (
    id int NOT NULL AUTO_INCREMENT,
    area int NOT NULL,
    floor int NOT NULL,
    rooms_number int NOT NULL,
    adress_id int NOT NULL,
    dwelling_owner_id int NOT NULL,
    reservation_id int NOT NULL,
    description varchar(100) NOT NULL,
    CONSTRAINT dwelling_pk PRIMARY KEY (id)
);

-- Table: dwelling_owner
CREATE TABLE dwelling_owner (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(25) NOT NULL,
    surname varchar(50) NOT NULL,
    phome varchar(12) NOT NULL,
    email varchar(35) NOT NULL,
    CONSTRAINT dwelling_owner_pk PRIMARY KEY (id)
);

-- Table: dwelling_photo
CREATE TABLE dwelling_photo (
    id int NOT NULL,
    dwelling_id int NULL,
    name varchar(35) NULL,
    CONSTRAINT dwelling_photo_pk PRIMARY KEY (id)
);

-- Table: lessee
CREATE TABLE lessee (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(25) NOT NULL,
    surname varchar(50) NOT NULL,
    phone varchar(12) NOT NULL,
    email varchar(35) NOT NULL,
    CONSTRAINT lessee_pk PRIMARY KEY (id)
);

-- Table: lessee_feedback
CREATE TABLE lessee_feedback (
    rating int NOT NULL AUTO_INCREMENT,
    response varchar(100) NOT NULL,
    lessee_id int NULL,
    CONSTRAINT lessee_feedback_pk PRIMARY KEY (rating)
);

-- Table: owner_feedback
CREATE TABLE owner_feedback (
    rating int NOT NULL AUTO_INCREMENT,
    response varchar(100) NOT NULL,
    dwelling_owner_id int NULL,
    CONSTRAINT owner_feedback_pk PRIMARY KEY (rating)
);

-- Table: region
CREATE TABLE region (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    CONSTRAINT region_pk PRIMARY KEY (id)
);

-- Table: reservation
CREATE TABLE reservation (
    id int NOT NULL AUTO_INCREMENT,
    is_possible bool NOT NULL,
    lessee_id int NOT NULL,
    name varchar(35) NULL,
    time timestamp NOT NULL,
    how_long time NOT NULL,
    is_confirmed bool NOT NULL,
    CONSTRAINT reservation_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: adress_city (table: adress)
ALTER TABLE adress ADD CONSTRAINT adress_city FOREIGN KEY adress_city (city_id)
    REFERENCES city (id);

-- Reference: cash_withdrawal_from_lessee_to_service_reservation (table: cash_withdrawal_from_lessee_to_service)
ALTER TABLE cash_withdrawal_from_lessee_to_service ADD CONSTRAINT cash_withdrawal_from_lessee_to_service_reservation FOREIGN KEY cash_withdrawal_from_lessee_to_service_reservation (reservation_id)
    REFERENCES reservation (id);

-- Reference: city_region (table: city)
ALTER TABLE city ADD CONSTRAINT city_region FOREIGN KEY city_region (region_id)
    REFERENCES region (id);

-- Reference: dwelling_adress (table: dwelling)
ALTER TABLE dwelling ADD CONSTRAINT dwelling_adress FOREIGN KEY dwelling_adress (adress_id)
    REFERENCES adress (id);

-- Reference: dwelling_dwelling_owner (table: dwelling)
ALTER TABLE dwelling ADD CONSTRAINT dwelling_dwelling_owner FOREIGN KEY dwelling_dwelling_owner (dwelling_owner_id)
    REFERENCES dwelling_owner (id);

-- Reference: dwelling_photo_dwelling (table: dwelling_photo)
ALTER TABLE dwelling_photo ADD CONSTRAINT dwelling_photo_dwelling FOREIGN KEY dwelling_photo_dwelling (dwelling_id)
    REFERENCES dwelling (id);

-- Reference: dwelling_reservation (table: dwelling)
ALTER TABLE dwelling ADD CONSTRAINT dwelling_reservation FOREIGN KEY dwelling_reservation (reservation_id)
    REFERENCES reservation (id);

-- Reference: lessee_feedback_lessee (table: lessee_feedback)
ALTER TABLE lessee_feedback ADD CONSTRAINT lessee_feedback_lessee FOREIGN KEY lessee_feedback_lessee (lessee_id)
    REFERENCES lessee (id);

-- Reference: owner_feedback_dwelling_owner (table: owner_feedback)
ALTER TABLE owner_feedback ADD CONSTRAINT owner_feedback_dwelling_owner FOREIGN KEY owner_feedback_dwelling_owner (dwelling_owner_id)
    REFERENCES dwelling_owner (id);

-- Reference: reservation_lessee (table: reservation)
ALTER TABLE reservation ADD CONSTRAINT reservation_lessee FOREIGN KEY reservation_lessee (lessee_id)
    REFERENCES lessee (id);

-- Reference: withdrawal_service_owner_cash_withdrawal_from_lessee_to_service (table: cash_withdrawal_from_service_to_owner)
ALTER TABLE cash_withdrawal_from_service_to_owner ADD CONSTRAINT withdrawal_service_owner_cash_withdrawal_from_lessee_to_service FOREIGN KEY withdrawal_service_owner_cash_withdrawal_from_lessee_to_service (cash_withdrawal_from_lessee_to_service_id)
    REFERENCES cash_withdrawal_from_lessee_to_service (id);

-- End of file.