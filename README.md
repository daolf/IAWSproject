# Projet IAWS - [Pierre de Wulf](https://github.com/daolf), [Wladimir du Manoir](https://github.com/WladimirDuManoir), [Jules Libert](https://github.com/blqke)
## Context

Project realized for University Toulouse III Paul Sabatier in Interoperability and Web Application course.

## Global architecture

![alt text](https://github.com/DCLL-MDL/IAWS-JlibPdewWdum-ProjetWS/blob/master/iaws.png)

## Tools

|           Use                   | Version                               |
|  --------------                 |                ---------------        |
| IDE                             | IntelliJ v13.1.1 or higher            |
| Test framework                  | Jersey-test version v2.17 for web part and JUnit 4 for all the other                   |
| SGBDR                           | sqlite                                |
| Test coverage                   | Plugin coverage 2.0.3-3 (Cobertura)   |
| JSON library                    | Jackson v1.9.0                        | 
| VCS                             | Git                                   |
| Shared Git repository           | Github                                |




## API RESTFul
| Endpoint | Description       | 
| ----     | ----------------- | 
| [GET /movies](#get-movies)   | Get list of movies from OMDB API |
| [GET /movie/:id](#get-movieid) | Get movie from OMDB API | 
| [GET /movie/:id/rooms](#get-movieidrooms) | Get movie from OMDB API | 
| [GET /room/:id](#get-roomid) | Get room from db | 
| [GET /rooms](#get-rooms) | Get list of rooms from UGMont service | 
| [POST /room/:id/movie](#post-roomidmovie) | Get list of rooms from UGMont service | 

### GET /movies


| Parameter | Required | default value | description |
| --------- | -------- | ------------- | ----------- |
| t         | yes      | ``<empty>``   | Movie title to search for.|
| y         | no       | ``<empty>``   | Year of release. |


### GET /movie/:id

return the movie with the given omdb id

### GET /movie/:id/rooms

| Parameter | Required | default value | description                      |
| --------- | -------- | ------------- | ----------                       |
| date      | no       | date after today  |                              |
| loc       | no       | ``<empty>``   | Localisation of the movie.       |
| tech      | no       | ``<empty>``   | ex imax                          |
| a         | no       |  true         | If places are still available    |

### GET /room/:id 

Return the room with the given id

### GET /rooms

 Returns a list of rooms which match the specified criteria.

| Parameter | Required | default value | description                      |
| --------- | -------- | ------------- | ----------                       |
| loc       | no*      | ``<empty>``   | exemple "VO"                     |
| tech      | no*      | ``<empty>``   | ex imax                          |
| nb        | no*      | ``<empty>``   | minimum number of seat in the room |

``*`` at least one parameter is necessary


### POST /room/:id/movie
| Parameter | Required | default value | description |
| --------- | -------- | ------------- | ----------  |
| id        | yes      | ``<empty>``   | The id of the movie on omdb |
| date      | no       | today         |             |
| loc       | no       | ``<empty>``   | Localisation of the movie. ("VO" ...)|
| tech      | no       | ``<empty>``   | ex imax     |

Create a movie seance where the movie referenced by his is projected in the room referenced by hid id.

## Deployment

To start the REST part, launch JlibPdewWdum.api.core.Main, for the soap part launch JlibPdewWdum.soap.Application .  You need to create the database first using ...