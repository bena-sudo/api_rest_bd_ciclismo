-- VACIAR TODAS LAS TABLAS RESPETANDO LAS DEPENDENCIAS
TRUNCATE TABLE Participa RESTART IDENTITY CASCADE;
TRUNCATE TABLE Gana RESTART IDENTITY CASCADE;
TRUNCATE TABLE Prueba RESTART IDENTITY CASCADE;
TRUNCATE TABLE Equipo RESTART IDENTITY CASCADE;
TRUNCATE TABLE Ciclista RESTART IDENTITY CASCADE;

-- INSERTS PARA LA TABLA CICLISTA (20 registros)
INSERT INTO Ciclista (nombrec, nacion, fnac) VALUES 
('Juan Pérez', 'España', '1990-05-15'),
('Mario López', 'México', '1985-07-20'),
('Ana Gómez', 'Colombia', '1992-09-10'),
('Luis García', 'España', '1995-03-10'),
('Carlos Hernández', 'Argentina', '1988-12-25'),
('Diego Rivera', 'Chile', '1993-07-01'),
('Paula Martínez', 'Uruguay', '1991-11-11'),
('Rosa Sánchez', 'Perú', '1994-06-21'),
('Fernando Álvarez', 'Ecuador', '1987-09-30'),
('Martina Torres', 'Colombia', '1990-02-15'),
('Santiago Paredes', 'España', '1985-08-09'),
('Laura Gómez', 'México', '1997-10-12'),
('Ricardo Díaz', 'Chile', '1992-04-05'),
('Isabel Ramírez', 'Argentina', '1989-11-19'),
('Miguel Ángel', 'Colombia', '1986-02-20'),
('Julia Fernández', 'Perú', '1998-03-23'),
('Tomás Morales', 'Uruguay', '1993-12-31'),
('Camila Rojas', 'España', '1990-01-07'),
('Roberto Castillo', 'México', '1984-07-14'),
('Andrea Herrera', 'Chile', '1995-05-29');

-- INSERTS PARA LA TABLA EQUIPO (20 registros)
INSERT INTO Equipo (nombree, nacion, direct) VALUES 
('Movistar', 'España', 'Luis Martínez'),
('INEOS', 'Reino Unido', 'Carlos Ruiz'),
('EF Education', 'Estados Unidos', 'John Smith'),
('Quick-Step', 'Bélgica', 'Peter Sagan'),
('Trek-Segafredo', 'Italia', 'Marco Rossi'),
('Bora-Hansgrohe', 'Alemania', 'Hans Berger'),
('Jumbo-Visma', 'Países Bajos', 'Jan de Vries'),
('Astana', 'Kazajistán', 'Dmitry Petrov'),
('Cofidis', 'Francia', 'Jean Dupont'),
('Bahrain Victorious', 'Bahréin', 'Ali Hassan'),
('AG2R Citroën', 'Francia', 'Claude Renault'),
('Groupama-FDJ', 'Francia', 'Pierre Giraud'),
('Alpecin-Deceuninck', 'Bélgica', 'Lucas Van Damme'),
('Israel Start-Up Nation', 'Israel', 'David Cohen'),
('UAE Team Emirates', 'Emiratos Árabes', 'Mohammed Al-Farsi'),
('Lotto Soudal', 'Bélgica', 'Erik Janssen'),
('Caja Rural-Seguros RGA', 'España', 'José Navarro'),
('Arkéa-Samsic', 'Francia', 'René Martin'),
('B&B Hotels', 'Francia', 'Charles Petit'),
('BikeExchange-Jayco', 'Australia', 'Chris Walker');

-- INSERTS PARA LA TABLA PRUEBA (20 registros)
INSERT INTO Prueba (nombrep, año, etapas, km) VALUES 
('Tour de Francia', 2024, 21, 3400.5),
('Giro de Italia', 2023, 20, 3200.0),
('Vuelta a España', 2024, 19, 3100.0),
('París-Roubaix', 2024, 1, 257.0),
('Milán-San Remo', 2023, 1, 298.0),
('Critérium du Dauphiné', 2023, 8, 1200.5),
('Amstel Gold Race', 2024, 1, 250.0),
('Flecha Valona', 2023, 1, 200.0),
('Lieja-Bastoña-Lieja', 2023, 1, 260.0),
('Tour de Flandes', 2024, 1, 240.0),
('Strade Bianche', 2023, 1, 184.0),
('Clásica de San Sebastián', 2024, 1, 220.0),
('Giro de Lombardía', 2023, 1, 245.0),
('Tour de Suiza', 2023, 9, 1300.0),
('E3 Saxo Bank Classic', 2024, 1, 205.0),
('Omloop Het Nieuwsblad', 2023, 1, 200.0),
('Dwars door Vlaanderen', 2024, 1, 180.0),
('Volta a Catalunya', 2024, 7, 1100.0),
('Tirreno-Adriático', 2023, 7, 1000.0),
('Tour Down Under', 2023, 5, 700.0);

-- INSERTS PARA LA TABLA GANA (20 registros)
INSERT INTO Gana (ciclista_id, prueba_id) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14),
(15, 15),
(16, 16),
(17, 17),
(18, 18),
(19, 19),
(20, 20);

-- INSERTS PARA LA TABLA PARTICIPA (20 registros)
INSERT INTO Participa (puesto, ciclista_id, prueba_id) VALUES 
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 7),
(8, 8, 8),
(9, 9, 9),
(10, 10, 10),
(11, 11, 11),
(12, 12, 12),
(13, 13, 13),
(14, 14, 14),
(15, 15, 15),
(16, 16, 16),
(17, 17, 17),
(18, 18, 18),
(19, 19, 19);