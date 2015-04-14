DROP TABLE IF EXISTS RoomMovieAssociation;
DROP TABLE IF EXISTS Localisation;
DROP TABLE IF EXISTS Techno;
DROP TABLE IF EXISTS Room;
DROP TABLE IF EXISTS Cinema;

CREATE TABLE Cinema(
   idCinema INTEGER PRIMARY KEY AUTOINCREMENT,
   titleCinema text NOT NULL,
   adressCinema text
);

CREATE TABLE Room(
	idRoom INTEGER PRIMARY KEY AUTOINCREMENT,
	idCinema INTEGER NOT NULL,
	nbPlaceRoom INTEGER NOT NULL, 

	FOREIGN KEY(idCinema) REFERENCES Cinema(idCinema)
);

-- INSERT INTO Room(idRoom)

CREATE TABLE RoomMovieAssociation(
	idRoom INTEGER,
	idMovie text,

	nbPlaceUsed INTEGER DEFAULT 0,

	date INTEGER NOT NULL,
	idLocalisation INTEGER,
	idTechno INTEGER,

	PRIMARY KEY(idRoom, idMovie)
	FOREIGN KEY(idRoom) REFERENCES Room(idRoom),
	FOREIGN KEY(idMovie) REFERENCES Movie(idMovie),
	FOREIGN KEY(idLocalisation) REFERENCES Localisation(idLocalisation),
	FOREIGN KEY(idTechno) REFERENCES Techno(idTechno)
);


CREATE TABLE Localisation(
   idLocalisation INTEGER PRIMARY KEY AUTOINCREMENT,
   intituleLocalisation text
);

CREATE TABLE Techno(
   idTechno INTEGER PRIMARY KEY AUTOINCREMENT,
   intituleTechno text
);