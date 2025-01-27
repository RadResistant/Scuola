-- phpMyAdmin SQL Dump
-- version 5.2.1deb1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Creato il: Gen 27, 2025 alle 15:02
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
-- Database: `saponaro_Vendite`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `Clienti`
--

CREATE TABLE `Clienti` (
  `pIva` char(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `Clienti`
--

INSERT INTO `Clienti` (`pIva`, `nome`, `cognome`) VALUES
('11223344556', 'Marco', 'Verdi'),
('12345098765', 'Giulia', 'Ricci'),
('12345852218', 'Gianni', 'Fantoni'),
('12345987612', 'Francesca', 'Bianchi'),
('13579246801', 'Giorgio', 'De Luca'),
('14725836936', 'Matteo', 'Caruso'),
('22334455667', 'Elena', 'Monti'),
('24681357912', 'Vera', 'Giordano'),
('25836914747', 'Tiziana', 'Mancini'),
('32165498711', 'Maria', 'Ferrari'),
('36914725858', 'Claudia', 'Romano'),
('36925814723', 'Luca', 'Grasso'),
('44332211098', 'Simone', 'Galli'),
('45612378969', 'Davide', 'Marchi'),
('45678912345', 'Francesco', 'Lombardi'),
('55664433211', 'Andrea', 'Puglisi'),
('55667788990', 'Paolo', 'Sartori'),
('65498732170', 'Franco', 'Bernardi'),
('75315948624', 'Sara', 'Conti'),
('78932165481', 'Alessandra', 'Giuliani'),
('78945612300', 'Antonio', 'D\'Angelo'),
('87654321098', 'Roberto', 'Pellegrini'),
('95175368425', 'Valentina', 'Corsi'),
('98765432109', 'Alessandro', 'Rossi'),
('99887766543', 'Lucia', 'Moretti');

-- --------------------------------------------------------

--
-- Struttura della tabella `Impiegati`
--

CREATE TABLE `Impiegati` (
  `cf` char(16) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) DEFAULT NULL,
  `livello` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `Impiegati`
--

INSERT INTO `Impiegati` (`cf`, `nome`, `cognome`, `livello`) VALUES
('BNCFNC70B01H501X', 'Francesca', 'Bianchi', 3),
('BNTVLL85A01L840S', 'Elena', 'Bertuzzi', 6),
('BRTMNT95A01H501P', 'Michele', 'Bertolotti', 5),
('CFTRLN85C01A001Q', 'Lorenzo', 'Frati', 4),
('CVLNNS85C01H501G', 'Andrea', 'Cavallini', 6),
('DGLGNN90C02L840B', 'Giovanni', 'Degli Angeli', 2),
('FNTLNZ90D01H501M', 'Simone', 'Fontana', 6),
('GMMCLD68H16D786X', 'Claudio', 'Giammarioli', 1),
('GRNNMA90B01H501R', 'Riccardo', 'Grani', 4),
('LFNGNN70A01L840C', 'Elena', 'Longoni', 2),
('LNSMRA85C01H501B', 'Martina', 'Lombardi', 4),
('MNTTLL70A01H501A', 'Laura', 'Montelli', 3),
('PRCCLN90B01L840X', 'Francesco', 'Pericoli', 5),
('PSSMRA85H01H501Y', 'Paolo', 'Sassone', 2),
('RSSMRA80A01H501Z', 'Marco', 'Rossi', 2),
('SNTMNL80C01H501Z', 'Alessandro', 'Santoni', 4),
('SPNGNN80D01L840X', 'Giulia', 'Spagnolo', 5),
('VLLCNS75H01D786P', 'Riccardo', 'Vallesi', 3),
('VRNLSS85T01A001A', 'Silvia', 'Vernoles', 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `Ordini`
--

CREATE TABLE `Ordini` (
  `id` int(11) NOT NULL,
  `data_a` date NOT NULL,
  `importo` double NOT NULL,
  `fk_pIva_c` char(11) DEFAULT NULL,
  `fk_cf_i` char(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `Ordini`
--

INSERT INTO `Ordini` (`id`, `data_a`, `importo`, `fk_pIva_c`, `fk_cf_i`) VALUES
(1, '2020-10-10', 2000, '11223344556', 'BNCFNC70B01H501X'),
(2, '2020-10-28', 2500, '11223344556', 'BNCFNC70B01H501X'),
(3, '2020-11-12', 1500, '99887766543', 'RSSMRA80A01H501Z'),
(4, '2020-12-01', 2200, '12345098765', 'BNCFNC70B01H501X'),
(5, '2021-01-15', 1800, '22334455667', 'DGLGNN90C02L840B'),
(6, '2021-02-10', 2500, '78945612300', 'MNTTLL70A01H501A'),
(7, '2021-03-05', 1700, '32165498711', 'GRNNMA90B01H501R'),
(8, '2021-04-20', 2100, '45678912345', 'CFTRLN85C01A001Q'),
(9, '2021-05-30', 2000, '87654321098', 'SPNGNN80D01L840X'),
(10, '2021-06-15', 2600, '95175368425', 'PSSMRA85H01H501Y'),
(11, '2021-07-10', 2300, '14725836936', 'LFNGNN70A01L840C'),
(12, '2021-08-25', 1900, '13579246801', 'CVLNNS85C01H501G'),
(13, '2021-09-15', 2100, '24681357912', 'VRNLSS85T01A001A'),
(14, '2021-10-05', 2000, '36925814723', 'BRTMNT95A01H501P'),
(15, '2021-11-10', 2400, '78932165481', 'VRNLSS85T01A001A'),
(16, '2021-12-15', 2200, '22334455667', 'SNTMNL80C01H501Z'),
(17, '2022-01-12', 2500, '99887766543', 'VLLCNS75H01D786P'),
(18, '2022-02-20', 2600, '11223344556', 'PSSMRA85H01H501Y'),
(19, '2022-03-05', 2800, '55667788990', 'GRNNMA90B01H501R'),
(20, '2022-04-18', 3000, '44332211098', 'BNCFNC70B01H501X'),
(21, '2022-05-12', 1900, '22334455667', 'FNTLNZ90D01H501M'),
(22, '2022-06-10', 2100, '99887766543', 'LNSMRA85C01H501B'),
(23, '2022-07-05', 2500, '13579246801', 'BNCFNC70B01H501X'),
(24, '2022-08-20', 2700, '22334455667', 'DGLGNN90C02L840B'),
(25, '2022-09-15', 2300, '55664433211', 'SNTMNL80C01H501Z'),
(26, '2022-10-10', 2500, '44332211098', 'BRTMNT95A01H501P'),
(27, '2022-11-15', 2100, '12345987612', 'MNTTLL70A01H501A'),
(28, '2022-12-20', 2200, '22334455667', 'BNCFNC70B01H501X'),
(29, '2023-01-05', 2600, '45678912345', 'PSSMRA85H01H501Y'),
(30, '2023-02-15', 2300, '78945612300', 'CVLNNS85C01H501G'),
(31, '2023-03-10', 2400, '99887766543', 'LFNGNN70A01L840C'),
(32, '2023-04-20', 2500, '11223344556', 'SPNGNN80D01L840X'),
(33, '2023-05-15', 2200, '12345098765', 'VRNLSS85T01A001A'),
(34, '2023-06-10', 2700, '87654321098', 'FNTLNZ90D01H501M'),
(35, '2023-07-05', 2000, '22334455667', 'BNCFNC70B01H501X'),
(36, '2023-08-25', 2300, '36925814723', 'PSSMRA85H01H501Y'),
(37, '2023-09-15', 2500, '32165498711', 'GRNNMA90B01H501R'),
(38, '2023-10-10', 2700, '13579246801', 'CVLNNS85C01H501G'),
(39, '2023-11-05', 2800, '95175368425', 'BRTMNT95A01H501P'),
(40, '2023-12-15', 3000, '14725836936', 'LNSMRA85C01H501B'),
(41, '2024-01-10', 2200, '78932165481', 'SPNGNN80D01L840X'),
(42, '2024-02-20', 2400, '22334455667', 'BNCFNC70B01H501X'),
(43, '2024-03-05', 2600, '11223344556', 'BNCFNC70B01H501X'),
(44, '2024-04-15', 2500, '99887766543', 'CVLNNS85C01H501G'),
(45, '2024-05-10', 2700, '44332211098', 'FNTLNZ90D01H501M'),
(46, '2024-06-05', 2000, '13579246801', 'PSSMRA85H01H501Y'),
(47, '2024-07-20', 2300, '78945612300', 'BRTMNT95A01H501P'),
(48, '2024-08-15', 2200, '22334455667', 'MNTTLL70A01H501A'),
(49, '2024-09-10', 2100, '12345098765', 'LFNGNN70A01L840C'),
(50, '2024-10-05', 2500, '55667788990', 'DGLGNN90C02L840B'),
(51, '2024-11-20', 2800, '36925814723', 'VLLCNS75H01D786P'),
(52, '2024-12-10', 2400, '11223344556', 'PSSMRA85H01H501Y'),
(53, '2025-01-05', 2500, '78932165481', 'SNTMNL80C01H501Z'),
(54, '2025-02-15', 2200, '22334455667', 'CVLNNS85C01H501G');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `Clienti`
--
ALTER TABLE `Clienti`
  ADD PRIMARY KEY (`pIva`);

--
-- Indici per le tabelle `Impiegati`
--
ALTER TABLE `Impiegati`
  ADD PRIMARY KEY (`cf`);

--
-- Indici per le tabelle `Ordini`
--
ALTER TABLE `Ordini`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_pIva_c` (`fk_pIva_c`),
  ADD KEY `fk_cf_i` (`fk_cf_i`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `Ordini`
--
ALTER TABLE `Ordini`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `Ordini`
--
ALTER TABLE `Ordini`
  ADD CONSTRAINT `Ordini_ibfk_1` FOREIGN KEY (`fk_pIva_c`) REFERENCES `Clienti` (`pIva`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Ordini_ibfk_2` FOREIGN KEY (`fk_cf_i`) REFERENCES `Impiegati` (`cf`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
