# jcconf-2020-quarkus-demo
Quarkus demo apps for JCConf 2020.
- [slide](https://www2.slideshare.net/RICHLEE11/jcconftw-2020-building-cloudnative-applications-with-quarkus-239269931)

## [Demo1: Book Service](./book-service)
- a basic REST API using RESTeasy, JPA & PostgreSQL
- unit test
- build container image
- remote debug in a container

## [Demo2: User Service]((./user-service))
- deploy app on K8S
- read env variables from K8S Secret
- liveness & readiness probe