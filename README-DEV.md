# For developers

## Set Up for coding
> Install Postgres with docker

Assuming that you have Docker service installed on Linux or Docker desktop in Windows 10/11
use the next command for Install and run postgres-pos-admin in the first time:

```shell
docker run --name postgres-pos-admin \
-e POSTGRES_USER=postgres \
-e POSTGRES_PASSWORD=postgres \
-e POSTGRES_DB=pos_admin \
-p 5432:5432 -d postgres:latest
```

For stop **postgres-pos-admin** use de next command:
```shell
docker stop postgres-pos-admin
```

For start again **postgres-pos-admin** use de next command:
```shell
docker start postgres-pos-admin
```
Now you should have the BD for test!

## Set up for use 
> Build package app

You should be in the path from the app to execute the next command:
```shell
mvn clean package
```

Move the package to docker directory:
```shell
cp target/Backend-0.0.1-SNAPSHOT.jar src/main/docker
```

Now we start the application with docker compose
```shell
docker compose up
```