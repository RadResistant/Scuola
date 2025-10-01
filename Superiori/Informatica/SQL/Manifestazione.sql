-- phpMyAdmin SQL Dump
-- version 5.2.1deb1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Creato il: Gen 10, 2025 alle 08:50
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
-- Database: `saponaro_manifestazioni`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `Manifestazione`
--

CREATE TABLE `Manifestazione` (
  `Descrizione` varchar(35) NOT NULL,
  `Data` date NOT NULL,
  `Luogo` varchar(35) NOT NULL,
  `Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `Manifestazione`
--

INSERT INTO `Manifestazione` (`Descrizione`, `Data`, `Luogo`, `Id`) VALUES
('Torneo di Calcio', '2024-12-01', 'Stadio San Siro', 1),
('Campionato di Basket', '2024-12-02', 'Palestra Olimpica', 2),
('Gara di Atletica', '2024-12-03', 'Campo Sportivo Olimpico', 3),
('Torneo di Pallavolo', '2024-12-04', 'Palestra Comunale', 4),
('Competizione di Nuoto', '2024-12-05', 'Piscina Nazionale', 5);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `Manifestazione`
--
ALTER TABLE `Manifestazione`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `Manifestazione`
--
ALTER TABLE `Manifestazione`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
