DROP TABLE IF EXISTS `conygre`.`compact_discs`;
CREATE TABLE  `conygre`.`compact_discs` (
  `id` int(11) NOT NULL,
  `artist` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
DROP TABLE IF EXISTS `conygre`.`tracks`;
CREATE TABLE  `conygre`.`tracks` (
  `id` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `disc_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCC6638887CA400C` (`disc_id`),
  CONSTRAINT `FKCC6638887CA400C` FOREIGN KEY (`disc_id`) REFERENCES `compact_discs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
