-- MySQL Script generated by MySQL Workbench
-- 06/07/17 14:31:56
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
-- Table `mydb`.`Zanr`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Zanr` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Zanr` (
  `idZanr` INT NOT NULL AUTO_INCREMENT,
  `nazivZanra` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idZanr`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Film`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Film` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Film` (
  `idFilma` INT NOT NULL AUTO_INCREMENT,
  `naslov` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(45) NOT NULL,
  `datumProizvodnjeFilma` DATE NOT NULL,
  `produkcijskaKuca` VARCHAR(45) NOT NULL,
  `Zanr_idZanr` INT NOT NULL,
  PRIMARY KEY (`idFilma`),
  INDEX `fk_Film_Zanr_idx` (`Zanr_idZanr` ASC),
  CONSTRAINT `fk_Film_Zanr`
    FOREIGN KEY (`Zanr_idZanr`)
    REFERENCES `mydb`.`Zanr` (`idZanr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Serija`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Serija` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Serija` (
  `idSerija` INT NOT NULL AUTO_INCREMENT,
  `naslov` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(45) NOT NULL,
  `godinaProizvodnjeSerije` DATE NOT NULL,
  `produkcijsaKuca` VARCHAR(45) NOT NULL,
  `brojEpizodaSerije` INT NOT NULL,
  `Zanr_idZanr` INT NOT NULL,
  PRIMARY KEY (`idSerija`),
  INDEX `fk_Serija_Zanr1_idx` (`Zanr_idZanr` ASC),
  CONSTRAINT `fk_Serija_Zanr1`
    FOREIGN KEY (`Zanr_idZanr`)
    REFERENCES `mydb`.`Zanr` (`idZanr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PrimerakFilm`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`PrimerakFilm` ;

CREATE TABLE IF NOT EXISTS `mydb`.`PrimerakFilm` (
  `invBrojFilma` INT NOT NULL AUTO_INCREMENT,
  `Film_idFilma` INT NOT NULL,
  PRIMARY KEY (`invBrojFilma`),
  INDEX `fk_PrimerakFilm_Film1_idx` (`Film_idFilma` ASC),
  CONSTRAINT `fk_PrimerakFilm_Film1`
    FOREIGN KEY (`Film_idFilma`)
    REFERENCES `mydb`.`Film` (`idFilma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PrimerakSerija`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`PrimerakSerija` ;

CREATE TABLE IF NOT EXISTS `mydb`.`PrimerakSerija` (
  `invBrojSerije` INT NOT NULL AUTO_INCREMENT,
  `Serija_idSerija` INT NOT NULL,
  PRIMARY KEY (`invBrojSerije`),
  INDEX `fk_PrimerakSerija_Serija1_idx` (`Serija_idSerija` ASC),
  CONSTRAINT `fk_PrimerakSerija_Serija1`
    FOREIGN KEY (`Serija_idSerija`)
    REFERENCES `mydb`.`Serija` (`idSerija`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Kategorija`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Kategorija` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Kategorija` (
  `idKategorija` INT NOT NULL AUTO_INCREMENT,
  `nazivKategorije` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idKategorija`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Clan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Clan` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Clan` (
  `idClan` INT NOT NULL AUTO_INCREMENT,
  `ime` VARCHAR(45) NOT NULL,
  `prezime` VARCHAR(45) NOT NULL,
  `adresa` VARCHAR(45) NOT NULL,
  `datumRodjenja` DATE NOT NULL,
  `datumUpisa` DATE NOT NULL,
  `Kategorija_idKategorija` INT NOT NULL,
  PRIMARY KEY (`idClan`),
  INDEX `fk_Clan_Kategorija1_idx` (`Kategorija_idKategorija` ASC),
  CONSTRAINT `fk_Clan_Kategorija1`
    FOREIGN KEY (`Kategorija_idKategorija`)
    REFERENCES `mydb`.`Kategorija` (`idKategorija`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ZaduzenjeFilma`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ZaduzenjeFilma` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ZaduzenjeFilma` (
  `idZaduzenjaFilma` INT NOT NULL AUTO_INCREMENT,
  `datumZaduzenjaFIlma` DATE NOT NULL,
  `datumVracanjaFilma` DATE NOT NULL,
  PRIMARY KEY (`idZaduzenjaFilma`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ZaduzenjeSerije`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ZaduzenjeSerije` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ZaduzenjeSerije` (
  `idZaduzenjaSerije` INT NOT NULL AUTO_INCREMENT,
  `datumZaduzenja` DATE NOT NULL,
  `datumVracanjaSerije` DATE NOT NULL,
  PRIMARY KEY (`idZaduzenjaSerije`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
