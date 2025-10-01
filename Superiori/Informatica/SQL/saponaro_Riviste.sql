-- phpMyAdmin SQL Dump
-- version 5.2.1deb1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Creato il: Dic 17, 2024 alle 12:25
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
-- Database: `saponaro_Riviste`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `abbonamento`
--

CREATE TABLE `abbonamento` (
  `id` int(11) NOT NULL,
  `prezzo` decimal(10,2) DEFAULT NULL,
  `FK_R_id` int(11) DEFAULT NULL,
  `FK_A_cf` char(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `abbonato`
--

CREATE TABLE `abbonato` (
  `CF` char(16) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `cognome` varchar(50) DEFAULT NULL,
  `FK_C_Cap` char(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `citta`
--

CREATE TABLE `citta` (
  `cap` char(5) NOT NULL,
  `nome` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `rivista`
--

CREATE TABLE `rivista` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `FK_T_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `tipologia`
--

CREATE TABLE `tipologia` (
  `id` int(11) NOT NULL,
  `descrizione` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `abbonamento`
--
ALTER TABLE `abbonamento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_A_cf` (`FK_A_cf`),
  ADD KEY `FK_R_id` (`FK_R_id`);

--
-- Indici per le tabelle `abbonato`
--
ALTER TABLE `abbonato`
  ADD PRIMARY KEY (`CF`),
  ADD KEY `FK_C_Cap` (`FK_C_Cap`);

--
-- Indici per le tabelle `citta`
--
ALTER TABLE `citta`
  ADD PRIMARY KEY (`cap`);

--
-- Indici per le tabelle `rivista`
--
ALTER TABLE `rivista`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_T_id` (`FK_T_id`);

--
-- Indici per le tabelle `tipologia`
--
ALTER TABLE `tipologia`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `abbonamento`
--
ALTER TABLE `abbonamento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `rivista`
--
ALTER TABLE `rivista`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `tipologia`
--
ALTER TABLE `tipologia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `abbonamento`
--
ALTER TABLE `abbonamento`
  ADD CONSTRAINT `abbonamento_ibfk_1` FOREIGN KEY (`FK_A_cf`) REFERENCES `abbonato` (`CF`),
  ADD CONSTRAINT `abbonamento_ibfk_2` FOREIGN KEY (`FK_R_id`) REFERENCES `rivista` (`id`);

--
-- Limiti per la tabella `abbonato`
--
ALTER TABLE `abbonato`
  ADD CONSTRAINT `abbonato_ibfk_1` FOREIGN KEY (`FK_C_Cap`) REFERENCES `citta` (`cap`);

--
-- Limiti per la tabella `rivista`
--
ALTER TABLE `rivista`
  ADD CONSTRAINT `rivista_ibfk_1` FOREIGN KEY (`FK_T_id`) REFERENCES `tipologia` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
