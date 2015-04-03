# Projet IAWS - Pierre de Wulf, Wladimir du Manoir, Jules Libert
## Contexte
## Architecture globale
## Technologies utilisés
## API RESTFul
| Endpoint | Description | 
| ---- | ----------------- | 
| [GET /movies](#get-movies) | Get list of movies from OMDB API |
| [GET /movie/:id](#get-movieid) | Get movie from OMDB API | 
| [GET /movie/:id/rooms](#get-movieidrooms) | Get movie from OMDB API | 
| [GET /rooms](#get-rooms) | Get list of rooms from UGMont service | 
| [POST /room/:id/movie](#post-roomidmovie) | Get list of rooms from UGMont service | 

### GET /movies


| Parameter | Required | default value | description
| --------- | -------- | ------------- |
| t					|	yes			 | ``<empty>``	 | Movie title to search for.
| y					|	no			 | ``<empty>``	 | Year of release.


### GET /movie/:id

### GET /movie/:id/rooms

| Parameter | Required | default value | description
| --------- | -------- | ------------- |
| date			|	no			 | date after today	 |
| loc 		  |	no			 | ``<empty>``	 | Localisation of the movie.
| tech 		  |	no			 | ``<empty>``	 | ex imax
| a 		  |	no			 |  true	 | todo

### GET /rooms
### POST /room/:id/movie
