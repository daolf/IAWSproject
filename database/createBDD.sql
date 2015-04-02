DROP TABLE IF EXISTS RoomMovieAssociation;
DROP TABLE IF EXISTS Localisation;
DROP TABLE IF EXISTS Techno;
DROP TABLE IF EXISTS Room;
DROP TABLE IF EXISTS Cinema;

CREATE TABLE Cinema(
   idCinema int PRIMARY KEY,
   titleCinema text NOT NULL,
   adressCinema text
);

CREATE TABLE Room(
	idRoom int PRIMARY KEY,
	idCinema int NOT NULL,
	nbPlaceRoom int NOT NULL, 

	FOREIGN KEY(idCinema) REFERENCES Cinema(idCinema)
);

-- INSERT INTO Room(idRoom)

CREATE TABLE RoomMovieAssociation(
	idRoom int,
	idMovie text,

	nbPlaceUsed int DEFAULT 0,

	date int NOT NULL,
	idLocalisation int,
	idTechno int,

	PRIMARY KEY(idRoom, idMovie)
	FOREIGN KEY(idRoom) REFERENCES Room(idRoom),
	FOREIGN KEY(idMovie) REFERENCES Movie(idMovie),
	FOREIGN KEY(idLocalisation) REFERENCES Localisation(idLocalisation),
	FOREIGN KEY(idTechno) REFERENCES Techno(idTechno)
);


CREATE TABLE Localisation(
   idLocalisation int PRIMARY KEY,
   intituleLocalisation text
);

CREATE TABLE Techno(
   idTechno int PRIMARY KEY,
   intituleTechno text
);