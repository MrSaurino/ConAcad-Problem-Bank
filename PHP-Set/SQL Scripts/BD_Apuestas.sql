-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-05-2024 a las 17:18:47
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `apuestas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bancos`
--

CREATE TABLE `bancos` (
  `Id` int(11) NOT NULL,
  `Banco` char(25) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `bancos`
--

INSERT INTO `bancos` (`Id`, `Banco`) VALUES
(1, 'BBVA'),
(2, 'BANAMEX'),
(3, 'Scotia Bank'),
(4, 'HSBC'),
(5, 'Banorte'),
(6, 'BanRegio'),
(7, 'MercadoPago'),
(8, 'SPEI'),
(9, 'Amazon');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bd_apuesta`
--

CREATE TABLE `bd_apuesta` (
  `Id` int(11) NOT NULL,
  `Retador` char(13) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `Invitado` char(13) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `Apuesta` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `IdGanador` char(13) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `bd_apuesta`
--

INSERT INTO `bd_apuesta` (`Id`, `Retador`, `Invitado`, `Apuesta`, `Fecha`, `IdGanador`) VALUES
(1, 'user1', 'user2', 200, '2024-05-09', 'user1'),
(2, 'user2', 'user3', 300, '2024-05-08', 'user3'),
(3, 'user3', 'user1', 150, '2024-05-07', 'user1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas_bancarias`
--

CREATE TABLE `cuentas_bancarias` (
  `Id` int(11) NOT NULL,
  `IdUser` char(13) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `IdBanco` int(11) NOT NULL,
  `Saldo` int(11) NOT NULL,
  `CLABE` char(19) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cuentas_bancarias`
--

INSERT INTO `cuentas_bancarias` (`Id`, `IdUser`, `IdBanco`, `Saldo`, `CLABE`) VALUES
(1, 'user1', 1, 10000, '123456789012345678'),
(2, 'user2', 2, 5000, '234567890123456789'),
(3, 'user3', 3, 7500, '345678901234567890');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `Usuario` char(13) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `Clave` char(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `Nombre` char(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `Apellidos` char(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Usuario`, `Clave`, `Nombre`, `Apellidos`) VALUES
('user1', 'clave123', 'Juan', 'Pérez'),
('user2', 'password456', 'María', 'González'),
('user3', 'qwerty789', 'Carlos', 'López');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bancos`
--
ALTER TABLE `bancos`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `bd_apuesta`
--
ALTER TABLE `bd_apuesta`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `IdUser1` (`Retador`),
  ADD KEY `IdUser2` (`Invitado`),
  ADD KEY `IdGanador` (`IdGanador`);

--
-- Indices de la tabla `cuentas_bancarias`
--
ALTER TABLE `cuentas_bancarias`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `IdUser` (`IdUser`,`IdBanco`),
  ADD UNIQUE KEY `CLABE` (`CLABE`),
  ADD KEY `IdBanco` (`IdBanco`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`Usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bancos`
--
ALTER TABLE `bancos`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `bd_apuesta`
--
ALTER TABLE `bd_apuesta`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `cuentas_bancarias`
--
ALTER TABLE `cuentas_bancarias`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bd_apuesta`
--
ALTER TABLE `bd_apuesta`
  ADD CONSTRAINT `BD_Apuesta_ibfk_1` FOREIGN KEY (`Retador`) REFERENCES `usuarios` (`Usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `BD_Apuesta_ibfk_2` FOREIGN KEY (`Invitado`) REFERENCES `usuarios` (`Usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `BD_Apuesta_ibfk_3` FOREIGN KEY (`IdGanador`) REFERENCES `usuarios` (`Usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `cuentas_bancarias`
--
ALTER TABLE `cuentas_bancarias`
  ADD CONSTRAINT `Cuentas_Bancarias_ibfk_1` FOREIGN KEY (`IdBanco`) REFERENCES `bancos` (`Id`),
  ADD CONSTRAINT `Cuentas_Bancarias_ibfk_2` FOREIGN KEY (`IdUser`) REFERENCES `usuarios` (`Usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
