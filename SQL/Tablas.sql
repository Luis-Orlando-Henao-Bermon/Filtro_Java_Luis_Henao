CREATE TABLE Aldea(
    id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

CREATE TABLE Ninja(
    id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    rango VARCHAR(255),
    id_aldea INT,
    FOREIGN KEY (id_aldea) REFERENCES Aldea(id)
);
CREATE TABLE Mision(
    id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255),
    rango VARCHAR(255),
    recompensa BIGINT
);
CREATE TABLE Mision_Ninja(
    id_ninja INT  NOT NULL ,
    id_mision INT  NOT NULL ,
    fecha_inicio VARCHAR(255) ,
    fecha_fin VARCHAR(255),
    FOREIGN KEY (id_ninja) REFERENCES Ninja(id),
    FOREIGN KEY (id_mision) REFERENCES Mision(id)
);
CREATE TABLE habilidad(
    id_ninja INT,
    nombre VARCHAR(255) ,
    descripcion VARCHAR(255),
    FOREIGN KEY (id_ninja) REFERENCES Ninja(id)
);