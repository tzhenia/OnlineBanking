-- MySQL Workbench Synchronization
-- Generated: 2018-12-16 21:15
-- Model: New Model
-- Version: 1.0
-- Project: onlineBanking
-- Author: Evhenii Taranukha

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `onlineBanking` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `onlineBanking`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(50) NOT NULL,
  `phone` INT(12) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `first_name` VARCHAR(20) NOT NULL,
  `last_name` VARCHAR(20) NOT NULL,
  `father_name` VARCHAR(20) NOT NULL,
  `birthday` DATE NOT NULL,
  `id_user_role` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_role_idx` (`id_user_role` ASC) VISIBLE,
  CONSTRAINT `fk_user_role_id`
  FOREIGN KEY (`id_user_role`)
  REFERENCES `onlineBanking`.`user_role` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `onlineBanking`.`card` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_user` INT(11) NOT NULL,
  `number` INT(16) NOT NULL,
  `id_card_type` INT(99) NOT NULL,
  `card_name` VARCHAR(20) NOT NULL,
  `balance` DECIMAL(13,2) NOT NULL DEFAULT 0,
  `credit_limit` DECIMAL(13,2) NOT NULL,
  `expiry_date` DATE NOT NULL,
  `sum_of_credit` DECIMAL(13,2) NOT NULL DEFAULT 0,
  `percent_value` DECIMAL(4,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_card_user_idx` (`id_user` ASC) VISIBLE,
  INDEX `fk_card_card_type1_idx` (`id_card_type` ASC) VISIBLE,
  INDEX `fx_card_number_idx` (`number` ASC) VISIBLE,
  CONSTRAINT `fk_card_id_user`
  FOREIGN KEY (`id_user`)
  REFERENCES `onlineBanking`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT `fk_card_card_type`
  FOREIGN KEY (`id_card_type`)
  REFERENCES `onlineBanking`.`card_type` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `onlineBanking`.`card_type` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `onlineBanking`.`user_role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `onlineBanking`.`transfer` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_card_from` INT(16) NOT NULL,
  `id_card_to` INT(16) NOT NULL,
  `sum` DECIMAL(13,2) NOT NULL,
  `note` VARCHAR(200) NOT NULL,
  `id_transfer_type` INT(11) NOT NULL,
  `id_status` INT(11) NOT NULL,
  `time` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_transfer_transfer_type1_idx` (`id_transfer_type` ASC) VISIBLE,
  INDEX `id_transfer_status_idx` (`id_status` ASC) VISIBLE,
  INDEX `fk_transfer_from_idx` (`id_card_from` ASC) VISIBLE,
  INDEX `fk_transfer_to_idx` (`id_card_to` ASC) VISIBLE,
  CONSTRAINT `fk_transfer_from`
  FOREIGN KEY (`id_card_from`)
  REFERENCES `onlineBanking`.`card` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT `fk_transfer_to`
  FOREIGN KEY (`id_card_to`)
  REFERENCES `onlineBanking`.`card` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT `fk_transfer_transfer_type`
  FOREIGN KEY (`id_transfer_type`)
  REFERENCES `onlineBanking`.`transfer_type` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT `id_transfer_status`
  FOREIGN KEY (`id_status`)
  REFERENCES `onlineBanking`.`status` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `onlineBanking`.`transfer_type` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `onlineBanking`.`status` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `onlineBanking`.`credit_limit_request` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_card` INT(11) NOT NULL,
  `credit_limit` DECIMAL NOT NULL,
  `id_status` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_credit_limit_request_card1_idx` (`id_card` ASC) VISIBLE,
  INDEX `fk_request_id_status_idx` (`id_status` ASC) VISIBLE,
  CONSTRAINT `fk_credit_limit_request_id_card`
  FOREIGN KEY (`id_card`)
  REFERENCES `onlineBanking`.`card` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_id_status`
  FOREIGN KEY (`id_status`)
  REFERENCES `onlineBanking`.`status` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;