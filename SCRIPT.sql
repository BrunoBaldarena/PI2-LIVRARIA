-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


CREATE SCHEMA IF NOT EXISTS `librariadepapel` DEFAULT CHARACTER SET big5 ;
USE `librariadepapel` ;

CREATE TABLE IF NOT EXISTS `cliente` (
  `id` INT NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `sexo` VARCHAR(45) NOT NULL,
  `dataNascimento` DATETIME NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `logadouro` VARCHAR(255) NOT NULL,
  `cep` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `uf` VARCHAR(45) NOT NULL,
  `complemento` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `produto` (
  `id` INT NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(255) NOT NULL,
  `preco` DOUBLE NOT NULL,
  `quantidade` INT NOT NULL,
  `editora` VARCHAR(100) NOT NULL,
  `observacao` VARCHAR(255) NOT NULL,
  `ano` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `usuario` (
  `id` INT NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `venda` (
  `id` INT NOT NULL,
  `dataVenda` TIMESTAMP(3) NOT NULL,
  `valorTotal` DOUBLE NOT NULL,
  `quantidade` INT NOT NULL,
  `tipoPagamento` VARCHAR(45) NOT NULL,
  `descontoTotal` VARCHAR(45) NOT NULL,
  `usuario_id` INT NOT NULL,
  `cliente_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_venda_usuario_idx` (`usuario_id` ASC) ,
  INDEX `fk_venda_cliente1_idx` (`cliente_id` ASC) ,
  CONSTRAINT `fk_venda_usuario`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `librariadepapel`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `librariadepapel`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `itemVenda` (
  `id` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `valorTotal` DOUBLE NOT NULL,
  `valorUnitario` DOUBLE NOT NULL,
  `desconto` DOUBLE NOT NULL,
  `venda_id` INT NOT NULL,
  `produto_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_itemVenda_venda1_idx` (`venda_id` ASC),
  INDEX `fk_itemVenda_produto1_idx` (`produto_id` ASC),
  CONSTRAINT `fk_itemVenda_venda1`
    FOREIGN KEY (`venda_id`)
    REFERENCES `librariadepapel`.`venda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itemVenda_produto1`
    FOREIGN KEY (`produto_id`)
    REFERENCES `librariadepapel`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;