-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 07 juin 2020 à 21:44
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
-- Base de données :  `projet_java`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`ID`, `NOM`) VALUES
(2, 'Physique'),
(3, 'Maths'),
(4, 'Informatique');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `#ID_UTILISATEUR` int(11) NOT NULL,
  `#ID_COURS` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`#ID_UTILISATEUR`, `#ID_COURS`) VALUES
(3, 2),
(3, 3),
(8, 3),
(8, 4),
(23, 2),
(23, 4);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `#ID_UTILISATEUR` int(11) NOT NULL,
  `NUMERO` int(11) NOT NULL AUTO_INCREMENT,
  `#ID_GROUPE` int(11) NOT NULL,
  PRIMARY KEY (`#ID_UTILISATEUR`),
  UNIQUE KEY `NUMERO` (`NUMERO`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`#ID_UTILISATEUR`, `NUMERO`, `#ID_GROUPE`) VALUES
(5, 1, 1),
(4, 2, 1),
(6, 3, 2),
(7, 4, 2),
(9, 5, 3),
(10, 6, 3),
(11, 7, 4),
(12, 8, 4),
(13, 9, 5),
(14, 10, 5),
(15, 11, 6),
(16, 12, 6),
(17, 13, 7),
(18, 14, 7),
(19, 15, 8),
(20, 16, 8),
(21, 17, 9),
(22, 18, 9);

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  `#ID_PROMOTION` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`ID`, `NOM`, `#ID_PROMOTION`) VALUES
(1, 'GRP1', 1),
(2, 'GRP2', 1),
(3, 'GRP3', 1),
(4, 'GRP1', 2),
(5, 'GRP2', 2),
(6, 'GRP3', 2),
(7, 'GRP1', 3),
(8, 'GRP2', 3),
(9, 'GRP3', 3);

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `promotion`
--

INSERT INTO `promotion` (`ID`, `NOM`) VALUES
(1, '2021'),
(2, '2022'),
(3, '2023');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  `CAPACITE` int(11) NOT NULL,
  `#ID_SITE` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`ID`, `NOM`, `CAPACITE`, `#ID_SITE`) VALUES
(1, 'P1', 3, 1),
(2, 'P2', 6, 1),
(3, 'Em 10', 9, 2),
(4, 'Em 9', 9, 2),
(5, 'Sc10', 6, 3),
(6, 'Sc20', 6, 3);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SEMAINE` int(11) NOT NULL,
  `DATE` date NOT NULL,
  `HEURE_DEBUT` time NOT NULL,
  `HEURE_FIN` time NOT NULL,
  `ETAT` varchar(255) NOT NULL,
  `#ID_COURS` int(11) NOT NULL,
  `#ID_TYPE` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance`
--

INSERT INTO `seance` (`ID`, `SEMAINE`, `DATE`, `HEURE_DEBUT`, `HEURE_FIN`, `ETAT`, `#ID_COURS`, `#ID_TYPE`) VALUES
(14, 10, '2020-06-01', '17:15:00', '18:45:00', 'validee', 2, 1),
(13, 10, '2020-03-06', '08:30:00', '10:00:00', 'validee', 2, 1),
(20, 3, '2020-06-08', '15:30:00', '15:30:00', 'en cours de validation', 4, 5);

-- --------------------------------------------------------

--
-- Structure de la table `seance_enseignants`
--

DROP TABLE IF EXISTS `seance_enseignants`;
CREATE TABLE IF NOT EXISTS `seance_enseignants` (
  `#ID_SEANCE` int(11) NOT NULL,
  `#ID_ENSEIGNANT` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance_enseignants`
--

INSERT INTO `seance_enseignants` (`#ID_SEANCE`, `#ID_ENSEIGNANT`) VALUES
(13, 23),
(20, 8),
(14, 23),
(13, 3);

-- --------------------------------------------------------

--
-- Structure de la table `seance_groupes`
--

DROP TABLE IF EXISTS `seance_groupes`;
CREATE TABLE IF NOT EXISTS `seance_groupes` (
  `#ID_SEANCE` int(11) NOT NULL,
  `#ID_GROUPE` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance_groupes`
--

INSERT INTO `seance_groupes` (`#ID_SEANCE`, `#ID_GROUPE`) VALUES
(13, 1),
(13, 2),
(13, 3),
(14, 1),
(14, 2),
(14, 3),
(20, 1);

-- --------------------------------------------------------

--
-- Structure de la table `seance_salles`
--

DROP TABLE IF EXISTS `seance_salles`;
CREATE TABLE IF NOT EXISTS `seance_salles` (
  `#ID_SEANCE` int(11) NOT NULL,
  `#ID_SALLE` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance_salles`
--

INSERT INTO `seance_salles` (`#ID_SEANCE`, `#ID_SALLE`) VALUES
(13, 1),
(13, 2),
(13, 3),
(14, 1),
(14, 2),
(14, 3),
(20, 4);

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `site`
--

INSERT INTO `site` (`ID`, `NOM`) VALUES
(1, 'E1'),
(2, 'E2'),
(3, 'E3');

-- --------------------------------------------------------

--
-- Structure de la table `type_cours`
--

DROP TABLE IF EXISTS `type_cours`;
CREATE TABLE IF NOT EXISTS `type_cours` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type_cours`
--

INSERT INTO `type_cours` (`ID`, `NOM`) VALUES
(1, 'Interactif'),
(2, 'Magistral'),
(3, 'TD'),
(4, 'TP'),
(5, 'Projet'),
(6, 'Soutien');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(255) NOT NULL,
  `PASSWD` varchar(255) NOT NULL,
  `NOM` varchar(255) NOT NULL,
  `PRENOM` varchar(255) NOT NULL,
  `DROIT` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID`, `EMAIL`, `PASSWD`, `NOM`, `PRENOM`, `DROIT`) VALUES
(1, 'nabil.chebili@edu.ece.fr', 'nabs1999', 'Chebili', 'Nabil', 1),
(2, 'pierre.woj@edu.ece.fr', 'pierre1999', 'Wojciechowski', 'Pierre', 2),
(3, 'jean-michel@gmail.com', 'Michel78', 'jean', 'michel', 3),
(4, 'quentinnormand@gmail.com', 'Normand92', 'normand', 'quentin', 4),
(5, 'ajouxclement@gmail.com', 'LajouxC', 'ajoux', 'clement', 4),
(6, 'debandevincent@gmail.com', 'Debande', 'debande', 'vincent', 4),
(7, 'jimmylucas@gmail.com', 'Jimmy21', 'jimmy', 'lucas', 4),
(8, 'marcelYves@gmail.com', 'MarcelYves', 'Yves', 'Marcel', 3),
(9, 'boulangersylvie@gmail.com', 'BoulangerSyl', 'boulanger', 'sylvi', 4),
(10, 'marchenry@gmail.com', 'Henry66', 'marc', 'henry', 4),
(11, 'josephrichard@edu.ece.fr', 'joseph99', 'joseph', 'richard', 4),
(12, 'françoisjibert@edu.ece.fr', 'jib55', 'jibert', 'françois', 4),
(13, 'samy.bouche@edu.ece.fr', 'bouche88', 'bouche', 'samy', 4),
(14, 'nicolaslacroix@edu.ece.fr', 'nico99', 'lacroix', 'nicolas', 4),
(15, 'kevin.rabou@edu.ece.fr', 'kevin785', 'rabou', 'kevin', 4),
(16, 'pierre.duong@edu.ece.fr', 'pierredu', 'duong', 'pierre ', 4),
(17, 'Danieldome@edu.ece.fr', 'daniel645', 'dome', 'Daniel', 4),
(18, 'francispate@edu.ece.fr', 'francis561', 'pate', 'francis', 4),
(19, 'jeanphilippesmet@edu.ece.fr', 'jp456', 'smet', 'jeanphilippe', 4),
(20, 'leablancheret@edu.ece.fr', 'lea465', 'blancheret', 'lea', 4),
(21, 'clairedoule@edu.ece.fr', 'claire5632', 'doule', 'claire', 4),
(22, 'clarabilly@edu.ece.fr', 'clara77', 'billy', 'clara', 4),
(23, 'JaquesRichard@edu.ece.fr', 'Jaques66', 'Richard', 'Jaques', 3);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
