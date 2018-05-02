-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 02-Maio-2018 às 20:29
-- Versão do servidor: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbtestback`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_customer_account`
--

DROP TABLE IF EXISTS `tb_customer_account`;
CREATE TABLE IF NOT EXISTS `tb_customer_account` (
  `id_customer` int(11) NOT NULL,
  `nm_customer` varchar(30) CHARACTER SET utf8 NOT NULL,
  `cpf_cnpj` varchar(14) CHARACTER SET utf8 NOT NULL,
  `is_active` char(1) CHARACTER SET utf8 NOT NULL,
  `vl_total` double NOT NULL,
  PRIMARY KEY (`id_customer`),
  UNIQUE KEY `cpf_cnpj` (`cpf_cnpj`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tb_customer_account`
--

INSERT INTO `tb_customer_account` (`id_customer`, `nm_customer`, `cpf_cnpj`, `is_active`, `vl_total`) VALUES
(1400, 'Cliente1', '123.456.789-10', 'n', 700),
(1501, 'Cliente2', '123.456.789-11', 's', 561),
(2000, 'Cliente3', '123.456.789-12', 'n', 480),
(2500, 'Cliente4', '123.456.789-13', 's', 1200),
(1600, 'Cliente5', '123.456.789-14', 'n', 2100);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
