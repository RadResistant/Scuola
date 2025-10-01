-- phpMyAdmin SQL Dump
-- version 5.2.1deb1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 25, 2024 at 02:47 PM
-- Server version: 10.11.6-MariaDB-0+deb12u1
-- PHP Version: 8.2.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `saponaro_farmaci`
--

-- --------------------------------------------------------

--
-- Table structure for table `farmaco`
--

CREATE TABLE `farmaco` (
  `codice_farmaco` char(10) NOT NULL,
  `nome_farmaco` varchar(50) DEFAULT NULL,
  `FK_ditta` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `farmaco`
--

INSERT INTO `farmaco` (`codice_farmaco`, `nome_farmaco`, `FK_ditta`) VALUES
('A01', 'Parodontax', NULL),
('B02', 'Aspirina', NULL),
('C03', 'Lasix', NULL),
('D04', 'Betadine', NULL),
('E05', 'Synthroid', NULL),
('F10', 'Prozac', NULL),
('G02', 'Depakote', NULL),
('H01', 'Prednisone', NULL),
('J01', 'Amoxicillina', NULL),
('L01', 'Taxol', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `farmaco`
--
ALTER TABLE `farmaco`
  ADD PRIMARY KEY (`codice_farmaco`),
  ADD KEY `FK_ditta` (`FK_ditta`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `farmaco`
--
ALTER TABLE `farmaco`
  ADD CONSTRAINT `farmaco_ibfk_1` FOREIGN KEY (`FK_ditta`) REFERENCES `ditta` (`codice_ditta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
