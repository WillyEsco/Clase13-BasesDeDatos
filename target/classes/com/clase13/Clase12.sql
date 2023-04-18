# Ejercicio 1 : ver Readme.md
# Archivo *.sql para crear la base de datos y las tablas para tener a mano en la programacion

# Ejercicio 2
CREATE DATABASE QATAR2023;

SET SQL_SAFE_UPDATES = 0; -- Para poder aplicar updates

CREATE TABLE empleados(
 empleadoID int PRIMARY KEY auto_increment,
 apellido varchar(255),
 nombre varchar(255),
 nacionalidad varchar(100),
 departamentoID int
 );
 
 CREATE TABLE departamento(
 departamentoID int PRIMARY KEY,
 departamento_nombre varchar(255),
 presupuesto  double
 );
 
INSERT INTO qatar2023.departamento(departamentoID,departamento_nombre,presupuesto) 
VALUES (1,"logística", 452222);

INSERT INTO qatar2023.departamento(departamentoID,departamento_nombre,presupuesto) 
VALUES (2,"Sistemas", 457878);

INSERT INTO qatar2023.departamento(departamentoID,departamento_nombre,presupuesto) 
VALUES (3,"compras", 86868768);

INSERT INTO qatar2023.departamento(departamentoID,departamento_nombre,presupuesto) 
VALUES (4,"Planificacion", 8448768);

# Ejercicio 4

INSERT INTO qatar2023.empleados(apellido,nombre,nacionalidad,departamentoID) 
VALUES ("Trujillo","Diego","colombiano",1);

INSERT INTO qatar2023.empleados(apellido,nombre,nacionalidad,departamentoID) 
VALUES ("Esco","Willy","argentino",2);

INSERT INTO qatar2023.empleados(apellido,nombre,nacionalidad,departamentoID) 
VALUES ("Donalicio","Erio","español",3);

INSERT INTO QATAR2023.departamento(departamentoID,departamento_nombre,presupuesto) 
VALUES (5, "Planificacion", 868687687);

# Ejercicio 5

UPDATE empleados
SET nacionalidad = "argentino"
WHERE apellido = "Donalicio"and nombre="Erio";

# Ejercicio 6

DELETE FROM departamento
WHERE departamentoID = 4;

# Ejercicio 7

SELECT nombre, apellido FROM EMPLEADOS WHERE departamentoID=1;

SELECT * FROM EMPLEADOS AS A 
JOIN departamento as B 
ON A.departamentoID = B.departamentoID
WHERE departamento_nombre= "Sistemas";

SELECT A.nombre, a.apellido, b.departamento_nombre FROM EMPLEADOS AS A 
JOIN departamento as B 
ON A.departamentoID = B.departamentoID
WHERE departamento_nombre= "Sistemas";

# Ejercicio 8

SELECT departamentoID, departamento_nombre, presupuesto  
FROM departamento ORDER BY	departamento_nombre ASC;
