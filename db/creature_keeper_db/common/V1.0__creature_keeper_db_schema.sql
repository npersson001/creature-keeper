DROP TABLE IF EXISTS `creatures`;
CREATE TABLE `creatures` (
  `id` int AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(25) NOT NULL,
  `species` varchar(100) NOT NULL,
  `age` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
