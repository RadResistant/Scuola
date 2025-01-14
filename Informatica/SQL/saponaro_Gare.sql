-- phpMyAdmin SQL Dump
-- version 5.2.1deb1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Creato il: Gen 14, 2025 alle 12:18
-- Versione del server: 10.11.6-MariaDB-0+deb12u1
-- Versione PHP: 8.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `saponaro_Gare`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `Atleti`
--

CREATE TABLE `Atleti` (
  `id_atleta` int(11) NOT NULL,
  `cognome` varchar(50) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `nazione` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `Atleti_Gare`
--

CREATE TABLE `Atleti_Gare` (
  `id_GareAtleti` int(11) NOT NULL,
  `posizione` int(11) DEFAULT NULL,
  `anno` int(11) DEFAULT NULL,
  `fk_id_g` int(11) DEFAULT NULL,
  `fk_id_a` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `Gare`
--

CREATE TABLE `Gare` (
  `id_gare` int(11) NOT NULL,
  `descrzione` varchar(100) DEFAULT NULL,
  `genere` varchar(50) DEFAULT NULL,
  `fk_id_s` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `Specialità`
--

CREATE TABLE `Specialità` (
  `id_specialita` int(11) NOT NULL,
  `descrzione` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `Specialità`
--

INSERT INTO `Specialità` (`id_specialita`, `descrzione`) VALUES
(1, 'Arrampicata Sportiva'),
(2, 'Atletica'),
(3, 'Badminton'),
(4, 'Baseball 5'),
(5, 'Baseball Softball'),
(6, 'Basket 3x3'),
(7, 'Beach Handball'),
(8, 'Beach Volley'),
(9, 'Bob'),
(10, 'Breaking'),
(11, 'Calcio'),
(12, 'Canoa Slalom'),
(13, 'Canoa Sprint'),
(14, 'Canottaggio'),
(15, 'Canottaggio Costiero'),
(16, 'Ciclismo BMX freestyle'),
(17, 'Ciclismo BMX racing'),
(18, 'Ciclismo Mountain Bike'),
(19, 'Ciclismo su pista'),
(20, 'Ciclismo su strada'),
(21, 'Combinata nordica'),
(22, 'Cricket'),
(23, 'Curling'),
(24, 'Flag Football'),
(25, 'Futsal');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `Atleti`
--
ALTER TABLE `Atleti`
  ADD PRIMARY KEY (`id_atleta`);

--
-- Indici per le tabelle `Atleti_Gare`
--
ALTER TABLE `Atleti_Gare`
  ADD PRIMARY KEY (`id_GareAtleti`),
  ADD KEY `fk_id_g` (`fk_id_g`),
  ADD KEY `fk_id_a` (`fk_id_a`);

--
-- Indici per le tabelle `Gare`
--
ALTER TABLE `Gare`
  ADD PRIMARY KEY (`id_gare`),
  ADD KEY `fk_id_s` (`fk_id_s`);

--
-- Indici per le tabelle `Specialità`
--
ALTER TABLE `Specialità`
  ADD PRIMARY KEY (`id_specialita`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `Atleti`
--
ALTER TABLE `Atleti`
  MODIFY `id_atleta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `Atleti_Gare`
--
ALTER TABLE `Atleti_Gare`
  MODIFY `id_GareAtleti` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `Gare`
--
ALTER TABLE `Gare`
  MODIFY `id_gare` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `Specialità`
--
ALTER TABLE `Specialità`
  MODIFY `id_specialita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `Atleti_Gare`
--
ALTER TABLE `Atleti_Gare`
  ADD CONSTRAINT `Atleti_Gare_ibfk_1` FOREIGN KEY (`fk_id_g`) REFERENCES `Gare` (`id_gare`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Atleti_Gare_ibfk_2` FOREIGN KEY (`fk_id_a`) REFERENCES `Atleti` (`id_atleta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `Gare`
--
ALTER TABLE `Gare`
  ADD CONSTRAINT `Gare_ibfk_1` FOREIGN KEY (`fk_id_s`) REFERENCES `Specialità` (`id_specialita`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
