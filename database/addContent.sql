INSERT INTO Cinema("idCinema", "titleCinema", "adressCinema") VALUES (1, "WladMovies", "3 rues des hippies");
INSERT INTO Cinema("idCinema", "titleCinema", "adressCinema") VALUES (2, "GaumontDeWulf", "16 avenue du commit perdu");
INSERT INTO Room("idRoom", "idCinema", "nbPlaceRoom") VALUES (1, 2, 100);
INSERT INTO Room("idRoom", "idCinema", "nbPlaceRoom") VALUES (2, 2, 200);
INSERT INTO Room("idRoom", "idCinema", "nbPlaceRoom") VALUES (3, 2, 300);
INSERT INTO Room("idRoom", "idCinema", "nbPlaceRoom") VALUES (4, 2, 402);
INSERT INTO Room("idRoom", "idCinema", "nbPlaceRoom") VALUES (5, 2, 9);
INSERT INTO Room("idRoom", "idCinema", "nbPlaceRoom") VALUES (6, 2, 768);
INSERT INTO Room("idRoom", "idCinema", "nbPlaceRoom") VALUES (7, 2, 23);

INSERT INTO Room("idRoom", "idCinema", "nbPlaceRoom") VALUES (8, 1, 9);
INSERT INTO Room("idRoom", "idCinema", "nbPlaceRoom") VALUES (9, 1, 11);

INSERT INTO Localisation("idLocalisation", "intituleLocalisation") VALUES (1, "VO");
INSERT INTO Localisation("idLocalisation", "intituleLocalisation") VALUES (2, "VF");
INSERT INTO Localisation("idLocalisation", "intituleLocalisation") VALUES (3, "VOSTFR");
INSERT INTO Localisation("idLocalisation", "intituleLocalisation") VALUES (4, "VOST");
INSERT INTO Localisation("idLocalisation", "intituleLocalisation") VALUES (5, "VOSTPKSTAN");

INSERT INTO Techno("idTechno", "intituleTechno") VALUES (1, "3D");
INSERT INTO Techno("idTechno", "intituleTechno") VALUES (2, "IMAX");
INSERT INTO Techno("idTechno", "intituleTechno") VALUES (3, "LEOTECHNOLOGIES");

-- James bond
INSERT INTO RoomMovieAssociation("idRoom", "idMovie", "nbPlaceUsed", "date", "idLocalisation", "idTechno")
VALUES (1, "tt0255268" ,12, "1427478108", 2, 3);

-- Frozen
INSERT INTO RoomMovieAssociation("idRoom", "idMovie", "nbPlaceUsed", "date", "idLocalisation", "idTechno")
VALUES (1, "tt2294629" ,0, "1424378619", 2, 3);

-- 50shadegrey
INSERT INTO RoomMovieAssociation("idRoom", "idMovie", "nbPlaceUsed", "date", "idLocalisation", "idTechno")
VALUES (1, "tt2322441" ,1, "1348172976", 2, 2);


INSERT INTO RoomMovieAssociation("idRoom", "idMovie", "nbPlaceUsed", "date", "idLocalisation", "idTechno")
VALUES (1, "tt0103874" ,7, "1427478108", 2, 1);
