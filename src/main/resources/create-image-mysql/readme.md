# Create image on the docker hub

````
cd create-image-mysql
docker login
docker build -t gustavocarvalhoti/luizalabs-db .
docker push gustavocarvalhoti/luizalabs-db
````