DROP DATABASE IF EXISTS Game;
CREATE DATABASE IF NOT EXISTS Game;

USE Game;
CREATE TABLE Socio(
id_socio INT AUTO_INCREMENT PRIMARY KEY,
punto_game INT DEFAULT 0,
fecha_registro DATE	
);

CREATE TABLE Cliente(
id_cliente INT  AUTO_INCREMENT PRIMARY KEY, 
nombre VARCHAR(64) NOT NULL,
apellido VARCHAR (64),
contrasenia VARCHAR (225) NOT NULL,
telefono VARCHAR(48) NOT NULL ,
email VARCHAR(58) NOT NULL UNIQUE	,
ciudad VARCHAR(48),
es_socio BOOLEAN,
fecha_nacimiento DATE,
id_socio INT , 
FOREIGN KEY(id_socio) REFERENCES Socio(id_socio)ON DELETE SET NULL
);

CREATE TABLE Producto(
id_producto INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR (64) NOT NULL,
descripcion VARCHAR (255),
precio DECIMAL (10,2) NOT NULL,
plataforma VARCHAR (58),
tipo ENUM('Videojuego','Consola','Accesorio','PC') NOT NULL
);
CREATE TABLE Tienda(
id_tienda INT AUTO_INCREMENT PRIMARY KEY,
ciudad VARCHAR(64),
codigo_postal VARCHAR(52),
direccion VARCHAR(168)
);

CREATE TABLE Cliente_Tienda(
id_cliente INT,
id_tienda INT,
FOREIGN KEY (id_cliente)REFERENCES Cliente (id_cliente),
FOREIGN KEY (id_tienda)REFERENCES Tienda (id_tienda)
);
CREATE TABLE Venta(
id_venta INT AUTO_INCREMENT PRIMARY KEY,
fecha_venta DATE NOT NULL,
id_cliente INT,
id_tienda INT,
FOREIGN KEY(id_cliente)REFERENCES Cliente (id_cliente),
FOREIGN KEY(id_tienda)REFERENCES Tienda (id_tienda)
);

CREATE TABLE Almacen(
id_almacen INT AUTO_INCREMENT PRIMARY KEY,
id_producto INT,
id_tienda INT,
stock_almacen INT,
FOREIGN KEY (id_producto) REFERENCES Producto (id_producto),
FOREIGN KEY (id_tienda) REFERENCES Tienda (id_tienda)
);
CREATE TABLE Detalle_Venta(
id_detalle_venta INT AUTO_INCREMENT PRIMARY KEY ,
id_venta INT,
id_producto INT,
precio_unidad DECIMAL (10,2),
cantidad INT,
FOREIGN KEY (id_venta) REFERENCES Venta(id_venta),
FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);


