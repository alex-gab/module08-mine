1. Download postgresql image from [Postgres - Official Image](https://hub.docker.com/_/postgres?tab=description).
2. Run a Docker container:
```bash
docker run --name postgresql -e POSTGRES_USER=puser -e POSTGRES_PASSWORD=ppass -p 5432:5432 -v /Users/Alex/programming/db/postgresql/data:/var/lib/postgresql/data -d postgres
```
3. Connect to the running Docker container:
```bash
docker exec -it postgresql bash
```
4. Connect to the database server using the _psql_ client and root user (_puser_):
```bash
psql -h localhost -U puser
```
5. Execute these scripts to create the database, the application user (_spring-tutorial_) and grant privileges:
```postgresql
CREATE DATABASE "spring-tutorial";
CREATE USER "spring-tutorial" WITH ENCRYPTED PASSWORD 'spring-tutorial';
GRANT ALL PRIVILEGES ON DATABASE "spring-tutorial" TO "spring-tutorial";
```
6. Connect to the database server using the _psql_ client and application user (_spring-tutorial_):
```bash
psql -h localhost -U spring-tutorial
```
7. Execute the following scripts to create the _guests_ and _rooms_ tables in the _spring-tutorial_ database:
```postgresql
\c spring-tutorial
create table rooms
(
    id      SERIAL PRIMARY KEY,
    name    varchar(32),
    section varchar(32)
);

create table guests
(
    id         SERIAL PRIMARY KEY,
    first_name varchar(32),
    last_name  varchar(32)
);
```
8. Misc commands using _psql_ client:
* List databases
```postgresql
\l
```
* List tables
```postgresql
\dt
```
* Connect to database
```postgresql
\c spring-tutorial
```
* Quit
```postgresql
\q
```