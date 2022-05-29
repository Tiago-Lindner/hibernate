-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Tempo de geração: 17-Maio-2022 às 23:47
-- Versão do servidor: 10.4.21-MariaDB
-- versão do PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `clinicaquiro`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `consulta`
--

CREATE TABLE `consulta` (
  `idconsulta` int(30) NOT NULL,
  `data` date DEFAULT NULL,
  `horario` time DEFAULT NULL,
  `idpaciente` int(11) DEFAULT NULL,
  `idquiro` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `paciente`
--

CREATE TABLE `paciente` (
  `idpaciente` int(30) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `cpf` int(11) DEFAULT NULL,
  `telefone` int(11) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `idpessoa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `idpessoa` int(11) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `senha` varchar(50) DEFAULT NULL,
  `tipopessoa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `quiropraxista`
--

CREATE TABLE `quiropraxista` (
  `idquiro` int(30) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `crm` int(30) DEFAULT NULL,
  `telefone` int(11) NOT NULL,
  `idpessoa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipopessoa`
--

CREATE TABLE `tipopessoa` (
  `idtipo` int(30) NOT NULL,
  `nome` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`idconsulta`),
  ADD KEY `idpaciente` (`idpaciente`),
  ADD KEY `idquiro` (`idquiro`);

--
-- Índices para tabela `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`idpaciente`),
  ADD KEY `idpessoa` (`idpessoa`);

--
-- Índices para tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`idpessoa`),
  ADD KEY `tipopessoa` (`tipopessoa`);

--
-- Índices para tabela `quiropraxista`
--
ALTER TABLE `quiropraxista`
  ADD PRIMARY KEY (`idquiro`),
  ADD KEY `idpessoa` (`idpessoa`);

--
-- Índices para tabela `tipopessoa`
--
ALTER TABLE `tipopessoa`
  ADD PRIMARY KEY (`idtipo`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `consulta`
--
ALTER TABLE `consulta`
  MODIFY `idconsulta` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `paciente`
--
ALTER TABLE `paciente`
  MODIFY `idpaciente` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `idpessoa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `quiropraxista`
--
ALTER TABLE `quiropraxista`
  MODIFY `idquiro` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tipopessoa`
--
ALTER TABLE `tipopessoa`
  MODIFY `idtipo` int(30) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `consulta`
--
ALTER TABLE `consulta`
  ADD CONSTRAINT `consulta_ibfk_1` FOREIGN KEY (`idpaciente`) REFERENCES `paciente` (`idpaciente`),
  ADD CONSTRAINT `consulta_ibfk_2` FOREIGN KEY (`idquiro`) REFERENCES `quiropraxista` (`idquiro`);

--
-- Limitadores para a tabela `paciente`
--
ALTER TABLE `paciente`
  ADD CONSTRAINT `paciente_ibfk_1` FOREIGN KEY (`idpessoa`) REFERENCES `pessoa` (`idpessoa`);

--
-- Limitadores para a tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD CONSTRAINT `pessoa_ibfk_1` FOREIGN KEY (`tipopessoa`) REFERENCES `tipopessoa` (`idtipo`),
  ADD CONSTRAINT `pessoa_ibfk_2` FOREIGN KEY (`tipopessoa`) REFERENCES `tipopessoa` (`idtipo`),
  ADD CONSTRAINT `pessoa_ibfk_3` FOREIGN KEY (`tipopessoa`) REFERENCES `tipopessoa` (`idtipo`);

--
-- Limitadores para a tabela `quiropraxista`
--
ALTER TABLE `quiropraxista`
  ADD CONSTRAINT `quiropraxista_ibfk_1` FOREIGN KEY (`idpessoa`) REFERENCES `pessoa` (`idpessoa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
