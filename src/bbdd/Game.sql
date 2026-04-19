DROP DATABASE IF EXISTS Game;
CREATE DATABASE IF NOT EXISTS Game;

USE Game;
CREATE TABLE Socio(
id_socio INT AUTO_INCREMENT PRIMARY KEY,
punto_game INT DEFAULT 0,
fecha_registro DATE	

);

CREATE TABLE Cliente(
id_usuario INT  AUTO_INCREMENT PRIMARY KEY, 
nombre VARCHAR(64) NOT NULL,
apellido VARCHAR (64),
telefono VARCHAR(48) NOT NULL ,
email VARCHAR(58) NOT NULL UNIQUE	,
ciudad VARCHAR(48),
es_socio BOOLEAN,
fecha_nacimiento DATE,
id_socio INT,
FOREIGN KEY(id_socio) REFERENCES Socio(id_socio)
);

CREATE TABLE Producto(
id_producto INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR (64) NOT NULL,
descripcion VARCHAR (64),
precio DECIMAL (10,2) NOT NULL,
plataforma VARCHAR (58),
tipo ENUM('Videojuego','Consola','Accesorio','PC') NOT NULL
);
CREATE TABLE Tienda(
id_tienda INT AUTO_INCREMENT PRIMARY KEY


);


