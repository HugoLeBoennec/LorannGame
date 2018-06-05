SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `lorann`
--

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `findAllElements` (IN `level` INT)  NO SQL
SELECT x, y, `type`
FROM levels$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findElementByPos` (IN `level` INT, IN `x` INT, IN `y` INT)  NO SQL
SELECT x, y, `type`
FROM levels
WHERE levels.x = x
AND levels.y = y$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `levels`
--

CREATE TABLE `levels` (
  `x` int(8) NOT NULL,
  `y` int(8) NOT NULL,
  `level` int(8) NOT NULL,
  `type` char(1) NOT NULL
) ENGINE=InnoDB;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `levels`
--
ALTER TABLE `levels`
  ADD PRIMARY KEY (`x`, `y`, `level`);
  
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
