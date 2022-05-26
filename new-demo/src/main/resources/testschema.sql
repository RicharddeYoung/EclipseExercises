DROP TABLE IF EXISTS `monster` CASCADE;

CREATE TABLE `monster` (
`id` INT AUTO_INCREMENT,
`species_name` VARCHAR(255) NOT NULL,
`species_family` VARCHAR(255) NOT NULL,
`species_diet` VARCHAR(255) NOT NULL,
`species_flight` BIT,
`species_swim` BIT,
`species_origin` VARCHAR(255) NOT NULL,
PRIMARY KEY(`id`)
);