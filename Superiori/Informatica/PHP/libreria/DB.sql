-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Apr 10, 2025 alle 02:58
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `saponaro_libreria`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `autori`
--

CREATE TABLE `autori` (
  `cf` char(16) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `cognome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `autori`
--

INSERT INTO `autori` (`cf`, `nome`, `cognome`) VALUES
('HLEHLR89D20Z102D', 'Adolf', 'Hitler'),
('RKAHHK60H07Z219Y', 'Hirohiko', 'Araki');

-- --------------------------------------------------------

--
-- Struttura della tabella `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `descrizione` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `categorie`
--

INSERT INTO `categorie` (`id`, `descrizione`) VALUES
(1, 'Per bambini'),
(2, 'Fantasy');

-- --------------------------------------------------------

--
-- Struttura della tabella `libri`
--

CREATE TABLE `libri` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `libri`
--

INSERT INTO `libri` (`id`, `nome`) VALUES
(1, 'Mein Kampf - La mia battaglia'),
(2, 'JoJo\'s Bizzarre Adventure');

-- --------------------------------------------------------

--
-- Struttura della tabella `libri_autori`
--

CREATE TABLE `libri_autori` (
  `id` int(11) NOT NULL,
  `fk_autori` char(16) NOT NULL,
  `fk_libri` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `libri_autori`
--

INSERT INTO `libri_autori` (`id`, `fk_autori`, `fk_libri`) VALUES
(3, 'HLEHLR89D20Z102D', 1),
(4, 'RKAHHK60H07Z219Y', 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `libri_categorie`
--

CREATE TABLE `libri_categorie` (
  `id` int(11) NOT NULL,
  `fk_categorie` int(11) NOT NULL,
  `fk_libri` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `libri_categorie`
--

INSERT INTO `libri_categorie` (`id`, `fk_categorie`, `fk_libri`) VALUES
(1, 1, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `utenti`
--

CREATE TABLE `utenti` (
  `email` varchar(255) NOT NULL,
  `password` char(60) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `cognome` varchar(255) DEFAULT NULL,
  `is_gestore` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `utenti`
--

INSERT INTO `utenti` (`email`, `password`, `nome`, `cognome`, `is_gestore`) VALUES
('raffaele.saponaro@iisgubbio.edu.it', '$2y$10$9TmBRsApE.a0HHg31c2EAONnt4YFjaocEt3UBIFNNixwwEOZE42Qu', 'Raffaele', 'Saponaro', 1);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `autori`
--
ALTER TABLE `autori`
  ADD PRIMARY KEY (`cf`);

--
-- Indici per le tabelle `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `libri`
--
ALTER TABLE `libri`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `libri_autori`
--
ALTER TABLE `libri_autori`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_autori` (`fk_autori`),
  ADD KEY `fk_libri` (`fk_libri`);

--
-- Indici per le tabelle `libri_categorie`
--
ALTER TABLE `libri_categorie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_categorie` (`fk_categorie`),
  ADD KEY `fk_libri` (`fk_libri`);

--
-- Indici per le tabelle `utenti`
--
ALTER TABLE `utenti`
  ADD PRIMARY KEY (`email`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `libri`
--
ALTER TABLE `libri`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `libri_autori`
--
ALTER TABLE `libri_autori`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `libri_categorie`
--
ALTER TABLE `libri_categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `libri_autori`
--
ALTER TABLE `libri_autori`
  ADD CONSTRAINT `libri_autori_ibfk_1` FOREIGN KEY (`fk_autori`) REFERENCES `autori` (`cf`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `libri_autori_ibfk_2` FOREIGN KEY (`fk_libri`) REFERENCES `libri` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `libri_categorie`
--
ALTER TABLE `libri_categorie`
  ADD CONSTRAINT `libri_categorie_ibfk_1` FOREIGN KEY (`fk_categorie`) REFERENCES `categorie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `libri_categorie_ibfk_2` FOREIGN KEY (`fk_libri`) REFERENCES `libri` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
