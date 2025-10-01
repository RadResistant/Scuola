-- phpMyAdmin SQL Dump
-- version 5.2.1deb1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Creato il: Gen 22, 2025 alle 10:43
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
-- Database: `saponaro_Negozio`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `Acquisti`
--

CREATE TABLE `Acquisti` (
  `id_acquisto` int(11) NOT NULL,
  `quantita` int(11) DEFAULT NULL,
  `data_acquisto` date DEFAULT NULL,
  `fk_id_cliente` int(11) DEFAULT NULL,
  `fk_id_prodotto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `Clienti`
--

CREATE TABLE `Clienti` (
  `id_cliente` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `cognome` varchar(50) DEFAULT NULL,
  `nazione` varchar(75) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `Prodotti`
--

CREATE TABLE `Prodotti` (
  `id_prodotto` int(11) NOT NULL,
  `descrizione` varchar(100) DEFAULT NULL,
  `prezzo` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `Acquisti`
--
ALTER TABLE `Acquisti`
  ADD PRIMARY KEY (`id_acquisto`),
  ADD KEY `fk_id_prodotto` (`fk_id_prodotto`),
  ADD KEY `fk_id_cliente` (`fk_id_cliente`);

--
-- Indici per le tabelle `Clienti`
--
ALTER TABLE `Clienti`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indici per le tabelle `Prodotti`
--
ALTER TABLE `Prodotti`
  ADD PRIMARY KEY (`id_prodotto`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `Acquisti`
--
ALTER TABLE `Acquisti`
  MODIFY `id_acquisto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `Clienti`
--
ALTER TABLE `Clienti`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `Prodotti`
--
ALTER TABLE `Prodotti`
  MODIFY `id_prodotto` int(11) NOT NULL AUTO_INCREMENT;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `Acquisti`
--
ALTER TABLE `Acquisti`
  ADD CONSTRAINT `Acquisti_ibfk_1` FOREIGN KEY (`fk_id_prodotto`) REFERENCES `Prodotti` (`id_prodotto`),
  ADD CONSTRAINT `Acquisti_ibfk_2` FOREIGN KEY (`fk_id_cliente`) REFERENCES `Clienti` (`id_cliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
