-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-08-2025 a las 01:14:24
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `fixcare`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `edificio`
--

CREATE TABLE `edificio` (
  `idEdificio` int(11) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  `idUsuario` int(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `edificio`
--

INSERT INTO `edificio` (`idEdificio`, `nombre`, `idUsuario`) VALUES
(1, 'Edificio A', 1),
(2, 'Edificio B', 1),
(3, 'Edificio C', 1),
(4, 'Edificio D', 1),
(5, 'Edificio E', 1),
(6, 'Rectoria', 1),
(7, 'Cafeteria', 1),
(8, 'Biblioteca', 1),
(9, 'Pesado I', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguimiento`
--

CREATE TABLE `seguimiento` (
  `idSeguimiento` int(10) NOT NULL,
  `idTecnico` int(10) NOT NULL,
  `idTicket` int(10) NOT NULL,
  `bitacora` text NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `seguimiento`
--

INSERT INTO `seguimiento` (`idSeguimiento`, `idTecnico`, `idTicket`, `bitacora`, `fecha`) VALUES
(1, 7, 1, 'Se reemplazó empaque del lavamanos y se solucionó fuga', '2025-08-01 14:30:00'),
(2, 7, 4, 'Se reinstaló sistema operativo en computadora', '2025-08-02 16:45:00'),
(3, 8, 7, 'Pared lijada y repintada completamente', '2025-08-04 11:20:00'),
(4, 7, 10, 'Área limpiada y desinfectada', '2025-08-05 09:15:00'),
(5, 8, 13, 'Lámparas reemplazadas en estacionamiento', '2025-08-07 18:30:00'),
(6, 7, 16, 'Sistema de sonido reparado y calibrado', '2025-08-08 15:40:00'),
(7, 8, 19, 'Grieta sellada y reparada', '2025-08-10 10:10:00'),
(8, 7, 22, 'Llave reemplazada, fuga solucionada', '2025-08-11 13:25:00'),
(9, 8, 25, 'Scanner conectado y drivers actualizados', '2025-08-13 16:50:00'),
(10, 7, 28, 'Espejo reemplazado con nuevo marco', '2025-08-14 14:15:00'),
(11, 8, 31, 'Mesas limpiadas y desinfectadas', '2025-08-16 12:30:00'),
(12, 7, 34, 'Candado reemplazado por nuevo', '2025-08-17 17:20:00'),
(13, 8, 37, 'Tubos LED reemplazados en sala de lectura', '2025-08-19 15:45:00'),
(14, 7, 40, 'Ventanas selladas y burletes reemplazados', '2025-08-20 11:10:00'),
(15, 8, 43, 'Regadera reparada, empaques cambiados', '2025-08-22 14:35:00'),
(16, 7, 46, 'Router reiniciado y conexión optimizada', '2025-08-23 16:00:00'),
(17, 8, 49, 'Aula pintada completamente', '2025-08-25 10:25:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE `servicios` (
  `idServicios` int(10) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`idServicios`, `nombre`) VALUES
(1, 'Plomeria'),
(2, 'Electricidad'),
(3, 'Limpieza/Sanitización'),
(4, 'Soporte Técnico'),
(5, 'Infraestructura'),
(6, 'Seguridad'),
(7, 'Mant. General');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE `ticket` (
  `idTicket` int(10) NOT NULL,
  `idUsuario` int(10) NOT NULL,
  `idEdificio` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `idServicio` int(10) NOT NULL,
  `area` varchar(250) NOT NULL,
  `problematica` text NOT NULL,
  `estado` varchar(50) NOT NULL,
  `img` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ticket`
--

INSERT INTO `ticket` (`idTicket`, `idUsuario`, `idEdificio`, `fecha`, `idServicio`, `area`, `problematica`, `estado`, `img`) VALUES
(1, 3, 1, '2025-08-01', 1, 'Baño planta alta', 'Fuga de agua en lavamanos', 'Completo', ''),
(2, 8, 1, '2025-08-01', 2, 'Aula 101', 'Contacto eléctrico dañado', 'Proceso', ''),
(3, 3, 1, '2025-08-02', 3, 'Pasillo principal', 'Manchas en paredes', 'Pendiente', ''),
(4, 8, 1, '2025-08-02', 4, 'Sala de cómputo', 'Computadora no enciende', 'Completo', ''),
(5, 3, 1, '2025-08-03', 5, 'Escaleras emergencia', 'Barandal suelto', 'Proceso', ''),
(6, 8, 2, '2025-08-03', 6, 'Entrada principal', 'Cámara de seguridad offline', 'Pendiente', ''),
(7, 3, 2, '2025-08-04', 7, 'Aula 201', 'Pintura descarapelada', 'Completo', ''),
(8, 8, 2, '2025-08-04', 1, 'Baño profesores', 'Inodoro tapado', 'Proceso', ''),
(9, 3, 2, '2025-08-05', 2, 'Laboratorio', 'Focos fundidos', 'Pendiente', ''),
(10, 8, 2, '2025-08-05', 3, 'Aula 202', 'Basura acumulada', 'Completo', ''),
(11, 3, 3, '2025-08-06', 4, 'Oficina administrativa', 'Impresora no funciona', 'Proceso', ''),
(12, 8, 3, '2025-08-06', 5, 'Techo', 'Goteo cuando llueve', 'Pendiente', ''),
(13, 3, 3, '2025-08-07', 6, 'Estacionamiento', 'Falta iluminación', 'Completo', ''),
(14, 8, 3, '2025-08-07', 7, 'Aula 301', 'Ventana rota', 'Proceso', ''),
(15, 3, 3, '2025-08-08', 1, 'Cocina', 'Fuga en tubería', 'Pendiente', ''),
(16, 8, 4, '2025-08-08', 2, 'Auditorio', 'Sistema de sonido fallando', 'Completo', ''),
(17, 3, 4, '2025-08-09', 3, 'Baños planta baja', 'Falta papel higiénico', 'Proceso', ''),
(18, 8, 4, '2025-08-09', 4, 'Sala de juntas', 'Proyector no enciende', 'Pendiente', ''),
(19, 3, 4, '2025-08-10', 5, 'Fachada', 'Grieta en muro', 'Completo', ''),
(20, 8, 4, '2025-08-10', 6, 'Salida emergencia', 'Puerta atascada', 'Proceso', ''),
(21, 3, 5, '2025-08-11', 7, 'Aula 501', 'Pizarron dañado', 'Pendiente', ''),
(22, 8, 5, '2025-08-11', 1, 'Baño estudiantes', 'Llave goteando', 'Completo', ''),
(23, 3, 5, '2025-08-12', 2, 'Pasillo segundo piso', 'Luz intermitente', 'Proceso', ''),
(24, 8, 5, '2025-08-12', 3, 'Área común', 'Muebles sucios', 'Pendiente', ''),
(25, 3, 5, '2025-08-13', 4, 'Biblioteca', 'Scanner no funciona', 'Completo', ''),
(26, 8, 6, '2025-08-13', 5, 'Oficina rector', 'Aire acondicionado fallando', 'Proceso', ''),
(27, 3, 6, '2025-08-14', 6, 'Recepción', 'Alarma no funciona', 'Pendiente', ''),
(28, 8, 6, '2025-08-14', 7, 'Baño ejecutivo', 'Espejo roto', 'Completo', ''),
(29, 3, 6, '2025-08-15', 1, 'Cocinetta', 'Desagüe lento', 'Proceso', ''),
(30, 8, 6, '2025-08-15', 2, 'Sala de espera', 'Enchufes sobrecalentados', 'Pendiente', ''),
(31, 3, 7, '2025-08-16', 3, 'Área de comida', 'Mesas pegajosas', 'Completo', ''),
(32, 8, 7, '2025-08-16', 4, 'Caja registradora', 'Software lento', 'Proceso', ''),
(33, 3, 7, '2025-08-17', 5, 'Terraza', 'Piso resbaladizo', 'Pendiente', ''),
(34, 8, 7, '2025-08-17', 6, 'Almacén', 'Candado dañado', 'Completo', ''),
(35, 3, 7, '2025-08-18', 7, 'Cocina', 'Extractor de humo roto', 'Proceso', ''),
(36, 8, 8, '2025-08-18', 1, 'Baño público', 'Sanitario tapado', 'Pendiente', ''),
(37, 3, 8, '2025-08-19', 2, 'Sala de lectura', 'Luz muy tenue', 'Completo', ''),
(38, 8, 8, '2025-08-19', 3, 'Estanterías', 'Polvo acumulado', 'Proceso', ''),
(39, 3, 8, '2025-08-20', 4, 'Área digital', 'Computadoras lentas', 'Pendiente', ''),
(40, 8, 8, '2025-08-20', 5, 'Ventanas', 'Sellos dañados', 'Completo', ''),
(41, 9, 9, '2025-08-21', 6, 'Taller', 'Herramientas faltantes', 'Proceso', ''),
(42, 3, 9, '2025-08-21', 7, 'Aula práctica', 'Bancos dañados', 'Pendiente', ''),
(43, 8, 9, '2025-08-22', 1, 'Vestidores', 'Regadera goteando', 'Completo', ''),
(44, 3, 9, '2025-08-22', 2, 'Laboratorio', 'Toma corriente sin energía', 'Proceso', ''),
(45, 8, 9, '2025-08-23', 3, 'Área común', 'Basura no recolectada', 'Pendiente', ''),
(46, 3, 1, '2025-08-23', 4, 'Aula 102', 'Internet lento', 'Completo', ''),
(47, 8, 2, '2025-08-24', 5, 'Techo', 'Filtración agua', 'Proceso', ''),
(48, 3, 3, '2025-08-24', 6, 'Estacionamiento', 'Cámara vandalizada', 'Pendiente', ''),
(49, 8, 4, '2025-08-25', 7, 'Aula 203', 'Pintura nueva necesaria', 'Completo', ''),
(50, 3, 5, '2025-08-25', 1, 'Baño discapacitados', 'Accesibilidad bloqueada', 'Proceso', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apepat` varchar(50) NOT NULL,
  `apemat` varchar(50) NOT NULL,
  `correo` varchar(200) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `rol` varchar(30) NOT NULL,
  `user` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `img` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombre`, `apepat`, `apemat`, `correo`, `telefono`, `rol`, `user`, `password`, `img`) VALUES
(1, 'Dayana Magdiel', 'Custodio', 'Avalos', 'chatita20@fake.com', '55555555', 'Administrador', 'Day232', '123', 'C:\\Users\\erick\\OneDrive\\Escritorio\\gatito.jpg'),
(3, 'Jose Andres', 'Palma', 'Hernandez', 'andres@gmail.com', '4564468', 'Docente', 'Andy', '123', 'C:\\Users\\erick\\OneDrive\\Escritorio\\gatito.jpg'),
(7, 'Cesar', 'Adame', 'Contreras', 'cesar@gmai.com', '4546', 'Tecnico', 'cesar', '123', ''),
(8, 'Candy', 'Custodio', 'Avalos', 'candy123@gmail.com', '5464645', 'Tecnico', 'candy', '123', 'C:\\Users\\erick\\OneDrive\\Escritorio\\gatito.jpg'),
(9, 'Lau', 'Aguila', 'Que', 'lau123@hotmail.com', '445456546', 'Administrador', 'lau', '123', 'C:\\Users\\erick\\OneDrive\\Escritorio\\gatito.jpg');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `edificio`
--
ALTER TABLE `edificio`
  ADD PRIMARY KEY (`idEdificio`),
  ADD KEY `IdUsuario` (`idUsuario`);

--
-- Indices de la tabla `seguimiento`
--
ALTER TABLE `seguimiento`
  ADD PRIMARY KEY (`idSeguimiento`),
  ADD KEY `seguimiento_ibfk_1` (`idTecnico`),
  ADD KEY `seguimiento_ibfk_2` (`idTicket`);

--
-- Indices de la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD PRIMARY KEY (`idServicios`);

--
-- Indices de la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`idTicket`),
  ADD KEY `ticket_ibfk_1` (`idUsuario`),
  ADD KEY `ticket_ibfk_2` (`idEdificio`),
  ADD KEY `ticket_ibfk_3` (`idServicio`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `edificio`
--
ALTER TABLE `edificio`
  MODIFY `idEdificio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `seguimiento`
--
ALTER TABLE `seguimiento`
  MODIFY `idSeguimiento` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `servicios`
--
ALTER TABLE `servicios`
  MODIFY `idServicios` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `ticket`
--
ALTER TABLE `ticket`
  MODIFY `idTicket` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `edificio`
--
ALTER TABLE `edificio`
  ADD CONSTRAINT `IdUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `seguimiento`
--
ALTER TABLE `seguimiento`
  ADD CONSTRAINT `seguimiento_ibfk_1` FOREIGN KEY (`idTecnico`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `seguimiento_ibfk_2` FOREIGN KEY (`idTicket`) REFERENCES `ticket` (`idTicket`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`idEdificio`) REFERENCES `edificio` (`idEdificio`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`idServicio`) REFERENCES `servicios` (`idServicios`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
