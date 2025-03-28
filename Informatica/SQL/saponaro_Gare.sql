-- phpMyAdmin SQL Dump
-- version 5.2.1deb1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Creato il: Gen 20, 2025 alle 14:29
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

--
-- Dump dei dati per la tabella `Atleti`
--

INSERT INTO `Atleti` (`id_atleta`, `cognome`, `nome`, `nazione`) VALUES
(1, 'Pierotti', 'Alessandro', 'Albania'),
(2, 'Mars', 'Adam', 'Marocco'),
(3, 'Mohammadi', 'Zohair', 'Marocco'),
(4, 'Arteaga', 'Jostyn', 'Ecuador'),
(5, 'Urbanelli', 'Gianluca', 'Italia'),
(6, 'Fagiani', 'Cristian', 'Estonia'),
(7, 'Troiani', 'Francesco', 'USA'),
(8, 'De Benedetti', 'Matteo', 'Zimbawe'),
(9, 'Hu', 'Rui Jian', 'Cina'),
(10, 'Spigarelli', 'Davide', 'Sigillo'),
(11, 'Polenta', 'Michele', 'CCagli'),
(12, 'Giulietti', 'Matteo', 'USA'),
(13, 'Campanino', 'Mattia', 'Italia'),
(14, 'Clementi', 'Ludovico', 'Inghilterra'),
(15, 'Urbani', 'Mattia', 'Italia'),
(16, 'Cannone', 'Matteo', 'USA'),
(17, 'Becchetti', 'Giuseppe', 'Inghilterra'),
(18, 'Nardoni', 'Filippo', 'Inghilterra'),
(19, 'Mosca', 'Lucrezia', 'Italia'),
(20, 'Saponaro', 'Raffaele', 'Mongolia'),
(21, 'Ghiandoni', 'Paola', 'Germany'),
(22, 'Roncigli', 'Letizia', 'Spain');

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

--
-- Dump dei dati per la tabella `Atleti_Gare`
--

INSERT INTO `Atleti_Gare` (`id_GareAtleti`, `posizione`, `anno`, `fk_id_g`, `fk_id_a`) VALUES
(1, 1, 2024, 1, 20),
(2, 2, 2024, 1, 14),
(3, 3, 2024, 1, 5),
(4, 1, 2008, 5, 1),
(5, 1, 2008, 5, 2),
(6, 1, 2008, 5, 3),
(7, 1, 2008, 5, 4),
(8, 1, 2008, 5, 5),
(9, 1, 2008, 5, 6),
(10, 1, 2008, 5, 7),
(11, 1, 2008, 5, 8),
(12, 1, 2008, 5, 9),
(13, 2, 2008, 5, 10),
(14, 2, 2008, 5, 11),
(15, 2, 2008, 5, 12),
(16, 2, 2008, 5, 13),
(17, 2, 2008, 5, 14),
(18, 2, 2008, 5, 15),
(19, 2, 2008, 5, 16),
(20, 2, 2008, 5, 17),
(21, 2, 2008, 5, 18),
(22, 1, 2020, 5, 11),
(23, 1, 2020, 5, 1),
(24, 1, 2020, 5, 2),
(25, 1, 2020, 5, 3),
(26, 1, 2020, 5, 4),
(27, 2, 2020, 5, 5),
(28, 2, 2020, 5, 6),
(29, 2, 2020, 5, 7),
(30, 2, 2020, 5, 8),
(31, 2, 2020, 5, 9),
(32, 3, 2020, 5, 10),
(33, 3, 2020, 5, 11),
(34, 3, 2020, 5, 12),
(35, 3, 2020, 5, 13),
(36, 3, 2020, 5, 14),
(37, 1, 2004, 2, 19),
(38, 2, 2004, 2, 21),
(39, 3, 2004, 2, 22),
(40, 1, 2012, 3, 7),
(41, 2, 2012, 3, 4),
(42, 3, 2012, 3, 3),
(43, 1, 2016, 4, 7),
(44, 2, 2016, 4, 6),
(45, 3, 2016, 4, 5),
(46, 1, 2016, 7, 21),
(47, 2, 2016, 7, 19),
(48, 3, 2016, 7, 22),
(49, 1, 2020, 8, 22),
(50, 2, 2020, 8, 21),
(51, 3, 2020, 8, 19);

-- --------------------------------------------------------

--
-- Struttura della tabella `Gare`
--

CREATE TABLE `Gare` (
  `id_gare` int(11) NOT NULL,
  `descrizione` varchar(100) DEFAULT NULL,
  `genere` varchar(50) DEFAULT NULL,
  `fk_id_s` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `Gare`
--

INSERT INTO `Gare` (`id_gare`, `descrizione`, `genere`, `fk_id_s`) VALUES
(1, 'Arrampicata Sportiva Cobassano ', 'M', 1),
(2, 'Atletica Gubbio ', 'F', 2),
(3, 'Badminton Perugia ', 'M', 3),
(4, 'Baseball 5 Cagli ', 'M', 4),
(5, 'Baseball softball Parigi ', 'M', 5),
(6, 'Pallanuoto Gualdo Tadino ', 'M', 41),
(7, 'Pallanuoto Fabriano', 'F', 41),
(8, 'Calcio Roma', 'F', 11);

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
(25, 'Futsal'),
(26, 'Ginnastica Acrobatica'),
(27, 'Ginnastica Artistica'),
(28, 'Ginnastica Ritmica'),
(29, 'Golf'),
(30, 'Hockey'),
(31, 'Hockey su ghiaccio'),
(32, 'Judo'),
(33, 'Karate'),
(34, 'Lacrosse'),
(35, 'Lotta'),
(36, 'Nuoto'),
(37, 'Nuoto Artistico'),
(38, 'Nuoto di Fondo'),
(39, 'Pallacanestro'),
(40, 'Pallamano'),
(41, 'Pallanuoto'),
(42, 'Pallavolo'),
(43, 'Pattinaggio di figura'),
(44, 'Pattinaggio di velocità'),
(45, 'Pattinaggio di velocità in linea'),
(46, 'Pentathlon Moderno'),
(47, 'Pugilato'),
(48, 'Rugby a 7'),
(49, 'Salto con gli sci'),
(50, 'Scherma'),
(51, 'Sci alpinismo'),
(52, 'Sci alpino'),
(53, 'Sci di fondo'),
(54, 'Sci Freestyle'),
(55, 'Short track'),
(56, 'Skateboard'),
(57, 'Skeleton'),
(58, 'Slittino'),
(59, 'Snowboard'),
(60, 'Sollevamento Pesi'),
(61, 'Sport Equestri'),
(62, 'Squash'),
(63, 'Surf'),
(64, 'Taekwondo'),
(65, 'Tennis'),
(66, 'Tennistavolo'),
(67, 'Tiro con l\'Arco'),
(68, 'Tiro sportivo'),
(69, 'Trampolino Elastico'),
(70, 'Triathlon'),
(71, 'Tuffi'),
(72, 'Vela'),
(73, 'Wushu');

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
  MODIFY `id_atleta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT per la tabella `Atleti_Gare`
--
ALTER TABLE `Atleti_Gare`
  MODIFY `id_GareAtleti` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT per la tabella `Gare`
--
ALTER TABLE `Gare`
  MODIFY `id_gare` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT per la tabella `Specialità`
--
ALTER TABLE `Specialità`
  MODIFY `id_specialita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;

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
