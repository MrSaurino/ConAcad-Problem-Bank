-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 07-06-2021 a las 11:52:36
-- Versión del servidor: 10.3.27-MariaDB-0+deb10u1
-- Versión de PHP: 7.3.27-1~deb10u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prueba`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `BD_Elecciones_Candidato`
--

CREATE TABLE `BD_Elecciones_Candidato` (
  `IdPartido` int(11) NOT NULL,
  `IdPersona` char(13) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `BD_Elecciones_Candidato`
--

INSERT INTO `BD_Elecciones_Candidato` (`IdPartido`, `IdPersona`) VALUES
(2, 'homero'),
(3, 'barnie'),
(4, 'krusty'),
(5, 'edna');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `BD_Elecciones_Distrito`
--

CREATE TABLE `BD_Elecciones_Distrito` (
  `IdDistrito` int(11) NOT NULL,
  `Nombre` char(30) NOT NULL,
  `Rango_Papeleta` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `BD_Elecciones_Distrito`
--

INSERT INTO `BD_Elecciones_Distrito` (`IdDistrito`, `Nombre`, `Rango_Papeleta`) VALUES
(1, 'University', '0-300'),
(2, 'City Hall', '301-600'),
(3, 'Market', '601-900'),
(4, 'Industry', '901-1200');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `BD_Elecciones_Partido`
--

CREATE TABLE `BD_Elecciones_Partido` (
  `IdPartido` int(11) NOT NULL,
  `Nombre` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `BD_Elecciones_Partido`
--

INSERT INTO `BD_Elecciones_Partido` (`IdPartido`, `Nombre`) VALUES
(1, 'PDEM'),
(2, 'PREP'),
(3, 'PTTW'),
(4, 'PFYO'),
(5, 'PPPP');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `BD_Elecciones_Voto`
--

CREATE TABLE `BD_Elecciones_Voto` (
  `IdVoto` int(11) NOT NULL,
  `IdPartido` int(11) NOT NULL,
  `IdDistrito` int(11) NOT NULL,
  `IdPapeleta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `BD_Elecciones_Voto`
--

INSERT INTO `BD_Elecciones_Voto` (`IdVoto`, `IdPartido`, `IdDistrito`, `IdPapeleta`) VALUES
(1, 2, 3, 1054),
(2, 1, 3, 754),
(3, 2, 4, 1108),
(4, 1, 1, 10),
(5, 3, 1, 144),
(6, 3, 1, 33),
(7, 3, 1, 21),
(8, 4, 1, 71),
(9, 2, 4, 367),
(10, 2, 3, 662),
(11, 1, 2, 386),
(12, 2, 4, 637),
(13, 4, 1, 192),
(14, 1, 2, 429),
(15, 1, 4, 1059),
(16, 3, 2, 453),
(17, 2, 2, 125),
(18, 2, 1, 263),
(19, 2, 4, 197),
(20, 3, 4, 209),
(21, 4, 4, 1135),
(22, 2, 4, 841),
(23, 1, 1, 75),
(24, 2, 2, 612),
(25, 2, 4, 464),
(26, 3, 4, 1296),
(27, 3, 4, 357),
(28, 2, 1, 254),
(29, 3, 4, 1093),
(30, 1, 1, 148),
(31, 3, 3, 387),
(32, 1, 1, 66),
(33, 4, 2, 1017),
(34, 2, 1, 115),
(35, 3, 1, 196),
(36, 4, 4, 504),
(37, 2, 3, 185),
(38, 4, 1, 127),
(39, 4, 4, 718),
(40, 2, 3, 324),
(41, 1, 3, 874),
(42, 2, 2, 852),
(43, 1, 1, 47),
(44, 1, 1, 601),
(45, 2, 2, 394),
(46, 3, 3, 1001),
(47, 4, 3, 3),
(48, 2, 3, 685),
(49, 2, 2, 279),
(50, 2, 4, 550),
(51, 3, 1, 80),
(52, 1, 2, 54),
(53, 2, 2, 442),
(54, 3, 1, 154),
(55, 4, 4, 845),
(56, 4, 2, 542),
(57, 2, 3, 1097),
(58, 2, 4, 408),
(59, 2, 1, 171),
(60, 2, 3, 582),
(61, 3, 3, 790),
(62, 2, 2, 756),
(63, 4, 1, 16),
(64, 2, 4, 1002),
(65, 3, 1, 130),
(66, 2, 4, 954),
(67, 2, 4, 1111),
(68, 3, 3, 713),
(69, 3, 2, 736),
(70, 1, 1, 236),
(71, 2, 3, 65),
(72, 1, 4, 988),
(73, 1, 3, 477),
(74, 2, 2, 696),
(75, 2, 4, 1161),
(76, 1, 1, 183),
(77, 4, 3, 291),
(78, 3, 1, 56),
(79, 3, 1, 220),
(80, 2, 1, 726),
(81, 1, 4, 120),
(82, 4, 4, 245),
(83, 3, 3, 799),
(84, 4, 2, 1194),
(85, 1, 2, 184),
(86, 2, 2, 2),
(87, 3, 2, 433),
(88, 4, 1, 621),
(89, 2, 2, 1016),
(90, 2, 1, 1006),
(91, 4, 2, 114),
(92, 3, 3, 306),
(93, 1, 2, 369),
(94, 2, 3, 1106),
(95, 4, 1, 81),
(96, 2, 2, 551),
(97, 1, 2, 513),
(98, 2, 2, 27),
(99, 2, 3, 1171),
(100, 1, 4, 936),
(101, 1, 2, 296),
(102, 1, 2, 396),
(103, 3, 4, 1060),
(104, 2, 3, 761),
(105, 1, 2, 165),
(106, 1, 2, 323),
(107, 3, 1, 128),
(108, 3, 4, 645),
(109, 1, 3, 1131),
(110, 2, 4, 1110),
(111, 2, 3, 937),
(112, 4, 2, 568),
(113, 4, 4, 1175),
(114, 3, 4, 1139),
(115, 2, 1, 177),
(116, 4, 4, 751),
(117, 4, 1, 55),
(118, 3, 2, 598),
(119, 2, 2, 493),
(120, 3, 2, 1129),
(121, 4, 1, 214),
(122, 2, 2, 5),
(123, 3, 3, 979),
(124, 3, 1, 94),
(125, 1, 2, 454),
(126, 3, 4, 943),
(127, 2, 2, 164),
(128, 2, 3, 691),
(129, 2, 1, 549),
(130, 3, 3, 288),
(131, 4, 1, 18),
(132, 1, 4, 833),
(133, 4, 1, 444),
(134, 2, 1, 867),
(135, 1, 3, 432),
(136, 3, 1, 1043),
(137, 1, 1, 4),
(138, 2, 2, 274),
(139, 2, 4, 1026),
(140, 2, 3, 524),
(141, 4, 2, 555),
(142, 2, 1, 316),
(143, 1, 3, 650),
(144, 2, 2, 587),
(145, 3, 2, 496),
(146, 3, 1, 1005),
(147, 4, 4, 134),
(148, 1, 2, 666),
(149, 4, 2, 580),
(150, 1, 2, 132),
(151, 1, 2, 884),
(152, 4, 4, 25),
(153, 2, 3, 505),
(154, 3, 2, 507),
(155, 2, 4, 966),
(156, 2, 4, 1090),
(157, 2, 1, 149),
(158, 1, 3, 672),
(159, 2, 2, 381),
(160, 4, 3, 1140),
(161, 3, 3, 333),
(162, 4, 1, 198),
(163, 3, 1, 52),
(164, 2, 4, 61),
(165, 2, 2, 968),
(166, 4, 2, 770),
(167, 3, 3, 865),
(168, 3, 3, 670),
(169, 1, 1, 871),
(170, 4, 3, 1083),
(171, 1, 2, 227),
(172, 3, 1, 160),
(173, 4, 1, 891),
(174, 2, 3, 1078),
(175, 2, 4, 419),
(176, 4, 3, 105),
(177, 2, 3, 559),
(178, 3, 2, 1159),
(179, 1, 2, 655),
(180, 2, 3, 201),
(181, 1, 2, 266),
(182, 3, 4, 195),
(183, 2, 2, 486),
(184, 1, 1, 111),
(185, 3, 4, 1128),
(186, 1, 4, 1075),
(187, 4, 1, 272),
(188, 4, 3, 615),
(189, 3, 4, 565),
(190, 1, 2, 409),
(191, 3, 3, 181),
(192, 3, 1, 760),
(193, 1, 4, 100),
(194, 2, 2, 97),
(195, 3, 1, 595),
(196, 2, 4, 658),
(197, 1, 1, 500),
(198, 4, 3, 807),
(199, 2, 1, 1050),
(200, 4, 3, 762);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuarios`
--

CREATE TABLE `Usuarios` (
  `Usuario` char(13) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `Clave` char(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `Nombre` char(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `Apellidos` char(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `Usuarios`
--

INSERT INTO `Usuarios` (`Usuario`, `Clave`, `Nombre`, `Apellidos`) VALUES
('barnie', '*EB4DA40C76BBD5356EEE09BC24B0B1224CB3EC24', 'Barnie', 'Gomez'),
('burns', '*180B80B7C81004BFCF88BE28E49EEB07BBA780EC', 'Mongomery', 'Burns'),
('edna', '*93B3469F232395004A618CD8146B6387935394F6', 'Edna', 'Krabappel'),
('homero', '*40E689863FC43674A1A793375C76A002F4126C35', 'Homero', 'Simpson'),
('krusty', '*1C8E4F98556D50A0DCD901AB1B556DA0A165C1CE', 'Krusty', 'El Payaso'),
('marge', '*47F4B7E3C1C4028B11AEEC3564A6D1A04A8481A1', 'Marge', 'Simpson'),
('selma', '*F4CEC2F94A4026F4D33BDABFF719459309B6CD50', 'Selma', 'Bouvier');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `BD_Elecciones_Candidato`
--
ALTER TABLE `BD_Elecciones_Candidato`
  ADD PRIMARY KEY (`IdPartido`,`IdPersona`),
  ADD UNIQUE KEY `IdPersona` (`IdPersona`),
  ADD UNIQUE KEY `IdPartido` (`IdPartido`);

--
-- Indices de la tabla `BD_Elecciones_Distrito`
--
ALTER TABLE `BD_Elecciones_Distrito`
  ADD PRIMARY KEY (`IdDistrito`);

--
-- Indices de la tabla `BD_Elecciones_Partido`
--
ALTER TABLE `BD_Elecciones_Partido`
  ADD PRIMARY KEY (`IdPartido`);

--
-- Indices de la tabla `BD_Elecciones_Voto`
--
ALTER TABLE `BD_Elecciones_Voto`
  ADD PRIMARY KEY (`IdVoto`),
  ADD UNIQUE KEY `IdPapeleta` (`IdPapeleta`),
  ADD KEY `IdDistrito` (`IdDistrito`),
  ADD KEY `IdPartido` (`IdPartido`);

--
-- Indices de la tabla `Usuarios`
--
ALTER TABLE `Usuarios`
  ADD PRIMARY KEY (`Usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `BD_Elecciones_Distrito`
--
ALTER TABLE `BD_Elecciones_Distrito`
  MODIFY `IdDistrito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `BD_Elecciones_Partido`
--
ALTER TABLE `BD_Elecciones_Partido`
  MODIFY `IdPartido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `BD_Elecciones_Voto`
--
ALTER TABLE `BD_Elecciones_Voto`
  MODIFY `IdVoto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=201;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `BD_Elecciones_Candidato`
--
ALTER TABLE `BD_Elecciones_Candidato`
  ADD CONSTRAINT `BD_Elecciones_Candidato_ibfk_1` FOREIGN KEY (`IdPartido`) REFERENCES `BD_Elecciones_Partido` (`IdPartido`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `BD_Elecciones_Candidato_ibfk_2` FOREIGN KEY (`IdPersona`) REFERENCES `Usuarios` (`Usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `BD_Elecciones_Voto`
--
ALTER TABLE `BD_Elecciones_Voto`
  ADD CONSTRAINT `BD_Elecciones_Voto_ibfk_1` FOREIGN KEY (`IdDistrito`) REFERENCES `BD_Elecciones_Distrito` (`IdDistrito`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `BD_Elecciones_Voto_ibfk_2` FOREIGN KEY (`IdPartido`) REFERENCES `BD_Elecciones_Partido` (`IdPartido`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
