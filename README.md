# EndPoints Tellix

## Capitulos

- getAll: http://127.0.0.1:5000/api/tellix/capitulos/
- getAll Paged: http://127.0.0.1:5000/api/tellix/capitulos/paged?page=0&size=3&sort=id,asc
- getOne: http://127.0.0.1:5000/api/tellix/capitulos/2
- create: http://127.0.0.1:5000/api/tellix/capitulos/
- delete: http://127.0.0.1:5000/api/tellix/capitulos/1
- update: http://127.0.0.1:5000/api/tellix/capitulos/1

## Categorias

- getAll: http://127.0.0.1:5000/api/tellix/categorias/
- getAll Paged: http://127.0.0.1:5000/api/tellix/categorias/paged?page=0&size=2&sort=id,asc
- getOne: http://127.0.0.1:5000/api/tellix/categorias/2
- create: http://127.0.0.1:5000/api/tellix/categorias/
- delete: http://127.0.0.1:5000/api/tellix/categorias/12
- update: http://127.0.0.1:5000/api/tellix/categorias/1
- Search By Name: http://127.0.0.1:5000/api/tellix/categorias/search?name=Accion
- Search By Name Paged: http://194.164.170.62:5000/api/tellix/categorias/search/paged?name=Accion&page=0&size=5&sort=id,asc

## Peliculas

- getAll: http://127.0.0.1:5000/api/tellix/peliculas/
- getAll Paged: http://127.0.0.1:5000/api/tellix/peliculas/paged?page=0&size=21&sort=id,asc
- getOne: http://127.0.0.1:5000/api/tellix/peliculas/2
- create: http://127.0.0.1:5000/api/tellix/peliculas/
- delete: http://127.0.0.1:5000/api/tellix/peliculas/1
- update: http://127.0.0.1:5000/api/tellix/peliculas/12
- Search by category: http://127.0.0.1:5000/api/tellix/peliculas/searchCat?catID=2
- Search by category paged: http://127.0.0.1:5000/api/tellix/peliculas/searchCat/paged?catID=2&page=0&size=2&sort=id,asc
- Search by name: http://127.0.0.1:5000/api/tellix/peliculas/search?name=C
- Search by name paged: http://127.0.0.1:5000/api/tellix/peliculas/search/paged?name=C&page=0&size=2&sort=id,asc
- addCategory: http://127.0.0.1:5000/api/tellix/peliculas/addCat?peliculaID&catID
- Add Family: http://127.0.0.1:5000/api/tellix/peliculas/addFam?peliculaID&famID

## Perfil

- getAll: http://127.0.0.1:5000/api/tellix/perfiles/
- getAll paged: http://127.0.0.1:5000/api/tellix/perfiles/paged?page=0&size=5&sort=id,asc
- getOne: http://127.0.0.1:5000/api/tellix/perfiles/3
- create: http://127.0.0.1:5000/api/tellix/perfiles/
- delete: http://127.0.0.1:5000/api/tellix/perfiles/5
- update: http://127.0.0.1:5000/api/tellix/perfiles/2
- getAll by usuarios: http://127.0.0.1:5000/api/tellix/perfiles/profiles?usuID=4
- add series: http://127.0.0.1:5000/api/tellix/perfiles/watchList/add/serie?perfilID=3&serieID=2
- remove series: http://127.0.0.1:5000/api/tellix/perfiles/watchList/delete/serie?perfilID=22&serieID=2
- add film: http://127.0.0.1:5000/api/tellix/perfiles/watchList/add/film?perfilID=3&peliculaID=1
- remove film: http://127.0.0.1:5000/api/tellix/perfiles/watchList/delete/film?perfilID=22&peliculaID=1

## Series

- getAll: http://127.0.0.1:5000/api/tellix/series/
- getAll Page: http://127.0.0.1:5000/api/tellix/series/paged?page=0&size=10&sort=id,asc
- getOne: http://127.0.0.1:5000/api/tellix/series/2
- create: http://127.0.0.1:5000/api/tellix/series/
- Delete: http://127.0.0.1:5000/api/tellix/series/1
- update: http://127.0.0.1:5000/api/tellix/series/1
- Search by Category: http://127.0.0.1:5000/api/tellix/series/searchCat?catID=1
- Search by category paged: http://127.0.0.1:5000/api/tellix/series/searchCat/paged?catID=1&page=0&size=5&sort=id,asc
- Search by name: http://127.0.0.1:5000/api/tellix/series/search?name=C
- Search by name Paged: http://127.0.0.1:5000/api/tellix/series/search/paged?name=da&page=0&size=5&sort=id,asc
- Count seasons: http://127.0.0.1:5000/api/tellix/series/temp?id=1
- Add Category: http://127.0.0.1:5000/api/tellix/series/addCat?serieID&catID
- Add Season: http://127.0.0.1:5000/api/tellix/series/addTemp?serieID=&temporadaID=
- Add family: http://127.0.0.1:5000/api/tellix/series/addFam?serieID&famID

## Temporadas

- getAll: http://127.0.0.1:5000/api/tellix/temporadas/
- getAll paged: http://127.0.0.1:5000/api/tellix/temporadas/paged?page=0&size=5&sort=id,asc
- getOne: http://127.0.0.1:5000/api/tellix/temporadas/2
- create: http://127.0.0.1:5000/api/tellix/temporadas/paged?page=0&size=5&sort=id,asc
- delete: http://127.0.0.1:5000/api/tellix/temporadas/1
- update: http://127.0.0.1:5000/api/tellix/temporadas/6
- count chapter: http://127.0.0.1:5000/api/tellix/temporadas/cap?id=1
- add chapter: http://127.0.0.1:5000/api/tellix/temporadas/addChapter?temporadaID&capituloID

## Usuarios

- getAll: http://127.0.0.1:5000/api/tellix/usuarios/
- getAll paged: http://127.0.0.1:5000/api/tellix/usuarios/paged?page=0&size=5&sort=id,desc
- getOne: http://127.0.0.1:5000/api/tellix/usuarios/2
- create: http://127.0.0.1:5000/api/tellix/usuarios/
- delete: http://127.0.0.1:5000/api/tellix/usuarios/1
- update: http://127.0.0.1:5000/api/tellix/usuarios/1
- login: http://127.0.0.1:5000/api/tellix/usuarios/login?mail=acurrosolla@gmail.com&password=1234
- add perfil: http://127.0.0.1:5000/api/tellix/usuarios/addPerfil?usuID=6&perfilID=36
- remove perfil: http://127.0.0.1:5000/api/tellix/usuarios/removePerfil?perfilID=34
- bloq: http://127.0.0.1:5000/api/tellix/usuarios/bloq?usuID=11&bloqStatus=true
- suscription: http://127.0.0.1:5000/api/tellix/usuarios/suscription?usuID=2&susStatus=true

## Familias (Grupos de películas)

- getAll: http://127.0.0.1:5000/api/tellix/familias/
- getAll paged: http://127.0.0.1:5000/api/tellix/familias/paged?page=0&size=2&sort=id,asc
- getOne: http://127.0.0.1:5000/api/tellix/familias/2
- Search by film ID: http://127.0.0.1:5000/api/tellix/familias/search/film/2
- Search by serie ID: http://127.0.0.1:5000/api/tellix/familias/search/serie/2
- create: http://127.0.0.1:5000/api/tellix/familias/
- delete: http://127.0.0.1:5000/api/tellix/familias/1
- update: http://127.0.0.1:5000/api/tellix/familias/1
- Search by name: http://127.0.0.1:5000/api/tellix/familias/search?name=Accion
- Search by name paged: http://127.0.0.1:5000/api/tellix/familias/search/paged?name=Accion&page=0&size=5&sort=id,asc
