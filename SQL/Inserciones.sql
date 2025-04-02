INSERT INTO Aldea(nombre) VALUES("Aldea de la hoja");

INSERT INTO Ninja(nombre,rango,id_aldea) VALUES("naruto","Jounin",1);

INSERT INTO Mision(descripcion,rango,recompensa) VALUES("Encontrar al gato de la señora pelos que se perdio","D",20000);

INSERT INTO habilidad(id_ninja,nombre,descripcion) VALUES(1,"Rasengan","Chacra giratorio que genera mucho daño interno al enemigo");

INSERT INTO Mision_Ninja(id_ninja,id_mision,fecha_inicio,fecha_fin) VALUES(1,1,"2025-04-01","2025-04-02");