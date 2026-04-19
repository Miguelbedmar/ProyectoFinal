DROP DATABASE IF EXISTS Game;
CREATE DATABASE IF NOT EXISTS Game;

USE Game;


CREATE TABLE usuario(
id_usuario INT  AUTO_INCREMENT PRIMARY KEY, 
nombre VARCHAR(64),
apellido VARCHAR (64),
telefono VARCHAR(48),
email VARCHAR(58),
ciudad VARCHAR(48),
fecha_nacimiento DATE
);



