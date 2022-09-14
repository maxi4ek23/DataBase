-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema new_schema1
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema rent_platform
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema rent_platform
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rent_platform` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `rent_platform` ;

-- -----------------------------------------------------
-- Table `rent_platform`.`region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rent_platform`.`region` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rent_platform`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rent_platform`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(35) NOT NULL,
  `region_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `city_region` (`region_id` ASC) VISIBLE,
  CONSTRAINT `city_region`
    FOREIGN KEY (`region_id`)
    REFERENCES `rent_platform`.`region` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rent_platform`.`adress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rent_platform`.`adress` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NOT NULL,
  `house_number` INT NULL DEFAULT NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `adress_city` (`city_id` ASC) VISIBLE,
  CONSTRAINT `adress_city`
    FOREIGN KEY (`city_id`)
    REFERENCES `rent_platform`.`city` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rent_platform`.`platform_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rent_platform`.`platform_user` (
  `id` INT NOT NULL,
  `email` VARCHAR(100) NULL,
  `phone` VARCHAR(12) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rent_platform`.`lessee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rent_platform`.`lessee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(25) NOT NULL,
  `surname` VARCHAR(50) NOT NULL,
  `platform_user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `lessee_platform_user` (`platform_user_id` ASC) VISIBLE,
  CONSTRAINT `lessee_platform_user`
    FOREIGN KEY (`platform_user_id`)
    REFERENCES `rent_platform`.`platform_user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rent_platform`.`reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rent_platform`.`reservation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `is_possible` TINYINT(1) NOT NULL,
  `lessee_id` INT NOT NULL,
  `name` VARCHAR(35) NULL DEFAULT NULL,
  `time` TIMESTAMP NOT NULL,
  `how_long` TIME NOT NULL,
  `is_confirmed` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `reservation_lessee` (`lessee_id` ASC) VISIBLE,
  CONSTRAINT `reservation_lessee`
    FOREIGN KEY (`lessee_id`)
    REFERENCES `rent_platform`.`lessee` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rent_platform`.`cash_withdrawal_from_lessee_to_service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rent_platform`.`cash_withdrawal_from_lessee_to_service` (
  `id` INT NOT NULL,
  `price` INT NOT NULL,
  `reservation_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `cash_withdrawal_from_lessee_to_service_reservation` (`reservation_id` ASC) VISIBLE,
  CONSTRAINT `cash_withdrawal_from_lessee_to_service_reservation`
    FOREIGN KEY (`reservation_id`)
    REFERENCES `rent_platform`.`reservation` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rent_platform`.`cash_withdrawal_from_service_to_owner`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rent_platform`.`cash_withdrawal_from_service_to_owner` (
  `id` INT NOT NULL,
  `price` INT NOT NULL,
  `cash_withdrawal_from_lessee_to_service_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `withdrawal_service_owner_cash_withdrawal_from_lessee_to_service` (`cash_withdrawal_from_lessee_to_service_id` ASC) VISIBLE,
  CONSTRAINT `withdrawal_service_owner_cash_withdrawal_from_lessee_to_service`
    FOREIGN KEY (`cash_withdrawal_from_lessee_to_service_id`)
    REFERENCES `rent_platform`.`cash_withdrawal_from_lessee_to_service` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rent_platform`.`dwelling_owner`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rent_platform`.`dwelling_owner` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(25) NOT NULL,
  `surname` VARCHAR(50) NOT NULL,
  `platform_user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `dwelling_owner_platform_user` (`platform_user_id` ASC) VISIBLE,
  CONSTRAINT `dwelling_owner_platform_user`
    FOREIGN KEY (`platform_user_id`)
    REFERENCES `rent_platform`.`platform_user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rent_platform`.`dwelling`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rent_platform`.`dwelling` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `area` INT NOT NULL,
  `floor` INT NOT NULL,
  `rooms_number` INT NOT NULL,
  `adress_id` INT NOT NULL,
  `dwelling_owner_id` INT NOT NULL,
  `reservation_id` INT NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `dwelling_adress` (`adress_id` ASC) VISIBLE,
  INDEX `dwelling_dwelling_owner` (`dwelling_owner_id` ASC) VISIBLE,
  INDEX `dwelling_reservation` (`reservation_id` ASC) VISIBLE,
  CONSTRAINT `dwelling_adress`
    FOREIGN KEY (`adress_id`)
    REFERENCES `rent_platform`.`adress` (`id`),
  CONSTRAINT `dwelling_dwelling_owner`
    FOREIGN KEY (`dwelling_owner_id`)
    REFERENCES `rent_platform`.`dwelling_owner` (`id`),
  CONSTRAINT `dwelling_reservation`
    FOREIGN KEY (`reservation_id`)
    REFERENCES `rent_platform`.`reservation` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rent_platform`.`dwelling_photo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rent_platform`.`dwelling_photo` (
  `id` INT NOT NULL,
  `dwelling_id` INT NULL DEFAULT NULL,
  `name` VARCHAR(35) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `dwelling_photo_dwelling` (`dwelling_id` ASC) VISIBLE,
  CONSTRAINT `dwelling_photo_dwelling`
    FOREIGN KEY (`dwelling_id`)
    REFERENCES `rent_platform`.`dwelling` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rent_platform`.`lessee_feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rent_platform`.`lessee_feedback` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rating` INT NOT NULL,
  `response` VARCHAR(100) NOT NULL,
  `lessee_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `lessee_feedback_lessee` (`lessee_id` ASC) VISIBLE,
  CONSTRAINT `lessee_feedback_lessee`
    FOREIGN KEY (`lessee_id`)
    REFERENCES `rent_platform`.`lessee` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rent_platform`.`owner_feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rent_platform`.`owner_feedback` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rating` INT NOT NULL,
  `response` VARCHAR(100) NOT NULL,
  `dwelling_owner_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `owner_feedback_dwelling_owner` (`dwelling_owner_id` ASC) VISIBLE,
  CONSTRAINT `owner_feedback_dwelling_owner`
    FOREIGN KEY (`dwelling_owner_id`)
    REFERENCES `rent_platform`.`dwelling_owner` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
