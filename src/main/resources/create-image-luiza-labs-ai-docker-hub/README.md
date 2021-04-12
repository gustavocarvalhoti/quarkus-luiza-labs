# Create image on the docker hub

````
docker login
docker build -f src/main/docker/Dockerfile.jvm -t gustavocarvalhoti/luizalabs-api:1  .
docker push gustavocarvalhoti/luizalabs-api:1
````