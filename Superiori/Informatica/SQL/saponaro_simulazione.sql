-- phpMyAdmin SQL Dump
-- version 5.2.1deb1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Creato il: Mar 12, 2025 alle 10:43
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
-- Database: `saponaro_simulazione`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `allergeni`
--

CREATE TABLE `allergeni` (
  `id` int(11) NOT NULL,
  `nome` varchar(75) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `allergeni_merende`
--

CREATE TABLE `allergeni_merende` (
  `id` int(11) NOT NULL,
  `fk_id_allergeni` int(11) DEFAULT NULL,
  `fk_id_merende` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `merende`
--

CREATE TABLE `merende` (
  `id` int(11) NOT NULL,
  `nome` varchar(75) NOT NULL,
  `grassi` int(11) NOT NULL,
  `zuccheri` int(11) NOT NULL,
  `proteine` int(11) NOT NULL,
  `prezzo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `ordini`
--

CREATE TABLE `ordini` (
  `id` int(11) NOT NULL,
  `data` date NOT NULL,
  `nRicreazione` enum('1','2') NOT NULL,
  `fk_id_utente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `ordini_merende`
--

CREATE TABLE `ordini_merende` (
  `id` int(11) NOT NULL,
  `fk_id_ordini` int(11) DEFAULT NULL,
  `fk_id_merende` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `utenti`
--

CREATE TABLE `utenti` (
  `id` int(11) NOT NULL,
  `nome` varchar(75) NOT NULL,
  `cognome` varchar(75) NOT NULL,
  `tipo` enum('gestore','rappresentante','studente') NOT NULL,
  `classe` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `utenti`
--

INSERT INTO `utenti` (`id`, `nome`, `cognome`, `tipo`, `classe`) VALUES
(1, 'raffaele', 'saponaro', 'studente', '5I'),
(2, 'lucia', 'verdi', 'studente', '5I'),
(3, 'antonio', 'neri', 'studente', '5I'),
(4, 'carla', 'gialli', 'studente', '5I'),
(5, 'alessandro', 'azzurri', 'studente', '5I'),
(6, 'valentina', 'bianchi', 'studente', '5I'),
(7, 'michele', 'marrone', 'studente', '5I'),
(8, 'chiara', 'bianchi', 'studente', '5I'),
(9, 'matteo', 'romano', 'studente', '4B'),
(10, 'francesca', 'blandino', 'studente', '4B'),
(11, 'andrea', 'rossi', 'studente', '4B'),
(12, 'sara', 'verdi', 'studente', '4B'),
(13, 'giorgio', 'gialli', 'studente', '4B'),
(14, 'laura', 'ferrari', 'studente', '4B'),
(15, 'simone', 'rinaldi', 'studente', '4B'),
(16, 'elena', 'bianchi', 'studente', '4B'),
(17, 'luca', 'ricci', 'studente', '4B'),
(18, 'federico', 'galli', 'studente', '3E'),
(19, 'claudia', 'martini', 'studente', '3E'),
(20, 'tommaso', 'maggioni', 'studente', '3E'),
(21, 'valerio', 'santoro', 'studente', '3E'),
(22, 'elisa', 'scotti', 'studente', '3E'),
(23, 'alessandra', 'neri', 'studente', '3E'),
(24, 'dario', 'verdi', 'studente', '3E'),
(25, 'gabriele', 'romani', 'studente', '3E'),
(26, 'paola', 'rossi', 'studente', '3E'),
(27, 'martina', 'bianchi', 'studente', '2A'),
(28, 'gioia', 'manzoni', 'studente', '2A'),
(29, 'alberto', 'rossi', 'studente', '2A'),
(30, 'diana', 'gialli', 'studente', '2A'),
(31, 'mario', 'moretti', 'studente', '2A'),
(32, 'loretta', 'fiore', 'studente', '2A'),
(33, 'giovanni', 'neri', 'studente', '2A'),
(34, 'tiziana', 'de luca', 'studente', '2A'),
(35, 'alessandro', 'sanna', 'studente', '2A'),
(36, 'marco', 'ferrari', 'rappresentante', '4B'),
(37, 'elena', 'bianchi', 'rappresentante', '4B'),
(38, 'giovanni', 'rossi', 'rappresentante', '3E'),
(39, 'francesca', 'santoro', 'rappresentante', '3E'),
(40, 'luca', 'moretti', 'rappresentante', '2A'),
(41, 'giulia', 'neri', 'rappresentante', '2A');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `allergeni`
--
ALTER TABLE `allergeni`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `allergeni_merende`
--
ALTER TABLE `allergeni_merende`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_allergeni` (`fk_id_allergeni`),
  ADD KEY `fk_id_merende` (`fk_id_merende`);

--
-- Indici per le tabelle `merende`
--
ALTER TABLE `merende`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `ordini`
--
ALTER TABLE `ordini`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_utente` (`fk_id_utente`);

--
-- Indici per le tabelle `ordini_merende`
--
ALTER TABLE `ordini_merende`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_ordini` (`fk_id_ordini`),
  ADD KEY `fk_id_merende` (`fk_id_merende`);

--
-- Indici per le tabelle `utenti`
--
ALTER TABLE `utenti`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `allergeni`
--
ALTER TABLE `allergeni`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `allergeni_merende`
--
ALTER TABLE `allergeni_merende`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `merende`
--
ALTER TABLE `merende`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `ordini`
--
ALTER TABLE `ordini`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `ordini_merende`
--
ALTER TABLE `ordini_merende`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `utenti`
--
ALTER TABLE `utenti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `allergeni_merende`
--
ALTER TABLE `allergeni_merende`
  ADD CONSTRAINT `allergeni_merende_ibfk_1` FOREIGN KEY (`fk_id_allergeni`) REFERENCES `allergeni` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `allergeni_merende_ibfk_2` FOREIGN KEY (`fk_id_merende`) REFERENCES `merende` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `ordini`
--
ALTER TABLE `ordini`
  ADD CONSTRAINT `ordini_ibfk_1` FOREIGN KEY (`fk_id_utente`) REFERENCES `utenti` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `ordini_merende`
--
ALTER TABLE `ordini_merende`
  ADD CONSTRAINT `ordini_merende_ibfk_1` FOREIGN KEY (`fk_id_ordini`) REFERENCES `ordini` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ordini_merende_ibfk_2` FOREIGN KEY (`fk_id_merende`) REFERENCES `merende` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
