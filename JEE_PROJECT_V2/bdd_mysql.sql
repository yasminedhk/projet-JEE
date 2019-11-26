-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 26 nov. 2019 à 19:36
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  jeeprj
--

-- --------------------------------------------------------

--
-- Structure de la table employes
--

DROP TABLE IF EXISTS employes;
CREATE TABLE IF NOT EXISTS employes (
  ID int(11) NOT NULL AUTO_INCREMENT,
  NOM varchar(25) DEFAULT NULL,
  PRENOM varchar(25) DEFAULT NULL,
  TELDOM varchar(10) DEFAULT NULL,
  TELPORT varchar(10) DEFAULT NULL,
  TELPRO varchar(10) DEFAULT NULL,
  ADRESSE varchar(150) DEFAULT NULL,
  CODEPOSTAL varchar(15) DEFAULT NULL,
  VILLE varchar(25) DEFAULT NULL,
  EMAIL varchar(25) DEFAULT NULL,
  PRIMARY KEY (ID)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table employes
--

INSERT INTO employes (ID, NOM, PRENOM, TELDOM, TELPORT, TELPRO, ADRESSE, CODEPOSTAL, VILLE, EMAIL) VALUES
(9, 'Bond', 'James', '0123456789', '0612345678', '0698765432', '2 avenue 007', '92700', 'Colombes', 'jbond@gmail.com'),
(10, 'Jones', 'Indiana', '0145362787', '0645362718', '0611563477', '10 rue des Aventuriers', '92270', 'Bois-colombes', 'ijones@gmail.com'),
(11, 'Bourne', 'Jason', '0187665987', '0623334256', '0654778654', '65 rue Agent Secret Perdu', '92700', 'Colombes', 'jbourne@yahoo.fr'),
(12, 'Stark', 'Arya', '0187611987', '0783334256', '0658878654', '6 rue Sans-Nom', '75016', 'Paris', 'astark@nord.com'),
(13, 'Lanister', 'Cersei', '0187384987', '0622494256', '0674178654', '5 bvd des Reines', '21000', 'Dijon', 'clanister@mail.co.uk'),
(14, 'Stark', 'Sansa', '0187611987', '0783334256', '0658878654', '6 rue Sans-Nom', '75016', 'Paris', 'astark@nord.com');

-- --------------------------------------------------------

--
-- Structure de la table users
--

DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users (
  ID int(11) NOT NULL AUTO_INCREMENT,
  LOGIN varchar(25) NOT NULL,
  PWD varchar(25) NOT NULL,
  ADMIN tinyint(1) DEFAULT NULL,
  PRIMARY KEY (ID)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table users
--

INSERT INTO users (ID, LOGIN, PWD, ADMIN) VALUES
(2, 'admin', 'admin', 1),
(3, 'empl', 'empl', 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;