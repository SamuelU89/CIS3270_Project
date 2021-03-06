-- MySQL Script generated by MySQL Workbench
-- 12/16/15 01:02:02
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `zip` DECIMAL(5) NOT NULL,
  `state` VARCHAR(2) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `SSN` DECIMAL(9) NOT NULL,
  `securityQuestion` VARCHAR(45) NOT NULL,
  `securityAnswer` VARCHAR(45) NOT NULL,
  `admin` DECIMAL(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `idUser_UNIQUE` (`idUser` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `SSN_UNIQUE` (`SSN` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Plane`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Plane` (
  `idPlane` INT NOT NULL,
  `planeNum` VARCHAR(45) NOT NULL,
  `airlineName` VARCHAR(45) NOT NULL,
  `capacity` DECIMAL(10,0) NOT NULL,
  PRIMARY KEY (`idPlane`),
  UNIQUE INDEX `planeNum_UNIQUE` (`planeNum` ASC),
  UNIQUE INDEX `idPlane_UNIQUE` (`idPlane` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Flight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Flight` (
  `idFlight` INT NOT NULL AUTO_INCREMENT,
  `idPlane` INT NOT NULL,
  `flightFrom` VARCHAR(45) NOT NULL,
  `flightTo` VARCHAR(45) NOT NULL,
  `flightDeparture` DATETIME NOT NULL,
  `flightArrival` DATETIME NOT NULL,
  PRIMARY KEY (`idFlight`),
  UNIQUE INDEX `idFlight_UNIQUE` (`idFlight` ASC),
  INDEX `idPlane_idx` (`idPlane` ASC),
  CONSTRAINT `idPlane`
    FOREIGN KEY (`idPlane`)
    REFERENCES `mydb`.`Plane` (`idPlane`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Reserve`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Reserve` (
  `idFlight` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `reserveDateTime` DATETIME NOT NULL,
  PRIMARY KEY (`idFlight`),
  INDEX `username_idx` (`username` ASC),
  CONSTRAINT `idFlight`
    FOREIGN KEY (`idFlight`)
    REFERENCES `mydb`.`Flight` (`idFlight`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `username`
    FOREIGN KEY (`username`)
    REFERENCES `mydb`.`User` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
