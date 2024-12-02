-- Tabla Ciclista
CREATE TABLE IF NOT EXISTS Ciclista (
    id SERIAL PRIMARY KEY, 
    nombrec VARCHAR(255) NOT NULL,
    nacion VARCHAR(255) NOT NULL,
    fnac DATE NOT NULL
);

-- Tabla Equipo
CREATE TABLE IF NOT EXISTS Equipo (
    id SERIAL PRIMARY KEY,
    nombree VARCHAR(255) NOT NULL,
    nacion VARCHAR(255) NOT NULL,
    direct VARCHAR(255) NOT NULL
);

-- Tabla Prueba
CREATE TABLE IF NOT EXISTS Prueba (
    id SERIAL PRIMARY KEY,
    nombrep VARCHAR(255) NOT NULL,
    año INT NOT NULL,
    etapas INT NOT NULL,
    km DOUBLE PRECISION NOT NULL 
);

-- Tabla Pertenece 
CREATE TABLE IF NOT EXISTS Pertenece (
    id SERIAL PRIMARY KEY,
    inicio DATE NOT NULL,
    fin DATE,
    ciclista_id BIGINT NOT NULL,
    equipo_id BIGINT NOT NULL,
    CONSTRAINT FK_Pertenece_Ciclista FOREIGN KEY (ciclista_id) REFERENCES Ciclista(id) ON DELETE CASCADE,
    CONSTRAINT FK_Pertenece_Equipo FOREIGN KEY (equipo_id) REFERENCES Equipo(id) ON DELETE CASCADE
);

-- Tabla Gana 
CREATE TABLE IF NOT EXISTS Gana (
    id SERIAL PRIMARY KEY,
    ciclista_id BIGINT NOT NULL,
    prueba_id BIGINT NOT NULL,
    CONSTRAINT FK_Gana_Ciclista FOREIGN KEY (ciclista_id) REFERENCES Ciclista(id) ON DELETE CASCADE,
    CONSTRAINT FK_Gana_Prueba FOREIGN KEY (prueba_id) REFERENCES Prueba(id) ON DELETE CASCADE
);

-- Tabla Participa 
CREATE TABLE IF NOT EXISTS Participa (
    id SERIAL PRIMARY KEY,
    puesto INT NOT NULL,
    ciclista_id BIGINT NOT NULL,
    prueba_id BIGINT NOT NULL,
    CONSTRAINT FK_Participa_Ciclista FOREIGN KEY (ciclista_id) REFERENCES Ciclista(id) ON DELETE CASCADE,
    CONSTRAINT FK_Participa_Prueba FOREIGN KEY (prueba_id) REFERENCES Prueba(id) ON DELETE CASCADE
);

-- Inserts para la tabla Ciclista
INSERT INTO Ciclista (nombrec, nacion, fnac) VALUES 
('Juan Pérez', 'España', '1990-05-15'),
('Mario López', 'México', '1985-07-20'),
('Ana Gómez', 'Colombia', '1992-09-10');

-- Inserts para la tabla Equipo
INSERT INTO Equipo (nombree, nacion, direct) VALUES 
('Movistar', 'España', 'Luis Martínez'),
('INEOS', 'Reino Unido', 'Carlos Ruiz'),
('EF Education', 'Estados Unidos', 'John Smith');

-- Inserts para la tabla Prueba
INSERT INTO Prueba (nombrep, año, etapas, km) VALUES 
('Tour de Francia', 2024, 21, 3400.5),
('Giro de Italia', 2023, 20, 3200.0),
('Vuelta a España', 2024, 19, 3100.0);

-- Inserts para la tabla Pertenece
INSERT INTO Pertenece (inicio, fin, ciclista_id, equipo_id) VALUES 
('2018-01-01', '2020-12-31', 1, 1),
('2021-01-01', NULL, 1, 2),
('2015-01-01', NULL, 2, 3);

-- Inserts para la tabla Gana
INSERT INTO Gana (ciclista_id, prueba_id) VALUES 
(1, 1),
(2, 2);

-- Inserts para la tabla Participa
INSERT INTO Participa (puesto, ciclista_id, prueba_id) VALUES 
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(4, 2, 2),
(1, 3, 3);
