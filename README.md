<h1 align="center">
  Luiza Labs Api
</h1>
<p align="center">
  <img alt="Repository size" src="https://img.shields.io/github/repo-size/gustavocarvalhoti/quarkus-luiza-labs?color=15c3d6"/>
  <a href="https://github.com/gustavocarvalhoti/quarkus-luiza-labs/commits/main">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/gustavocarvalhoti/quarkus-luiza-labs?color=15c3d6"/>
  </a>
 <br>
  <a href="https://www.linkedin.com/in/gustavocarvalho-ti/">
      <img alt="LinkedIn link" src="https://img.shields.io/badge/-Gustavo%20Carvalho-0077B5?style=flat&amp;logo=Linkedin&amp;logoColor=white" height="25px">
  </a> 
</p>
<strong>
<br>
<p align="center">
  <a href="#bookmark-sobre">Sobre</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#computer-tecnologias">Tecnologia</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#wrench-ferramentas">Ferramentas</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#package-instalação">Instalação</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#memo-license">License</a>
</p>
</strong>
<br>

<p align="center">
    <img alt="Screens" src=".github/luizalabs.png" height="350px" />
</p>

## :bookmark: Sobre

**luizalabs-api** é uma plataforma de comunicação. <br><br>
Endpoints disponíveis: <br>
Get: <br>
http://localhost:8080 <br>
http://localhost:8080/scheduling-notification <br>

Post:<br>
http://localhost:8080/scheduling-notification

````
{
   "sendDate":"2021-04-25 01:00:00",
   "message":"SuperApp tá super - 24x mais frete gratis!",
   "type":"whatsapp",
   "receivers":[
      {
         "name":"Marli",
         "whatsapp":"+55 19991676181"
      },
		 {
         "name":"Michelle",
         "whatsapp":"+55 19991676181"
      }
   ]
}
````

Patch:<br>
http://localhost:8080/scheduling-notification/cancel/{id} <br>
http://localhost:8080/scheduling-notification/send/{id}

<br>

## :computer: Tecnologias

- **[Quarkus](https://quarkus.io/)**
- **[Java 11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)**
- **[GraalVM](https://www.graalvm.org/)**
- **[Maven](https://maven.apache.org/)**
- **[Quarkus Flyway](https://quarkus.io/)**
- **[Docker](https://www.docker.com/)**
- **[Docker Compose](https://docs.docker.com/compose/install/)**
- **[Docker Hub](https://hub.docker.com/)**
- **[MySQL](https://www.mysql.com/)**
- **[Quarkus Resteasy](https://quarkus.io/)**
- **[Quarkus Junit5 e Mokito](https://quarkus.io/)**
- **[Rest Assured](https://quarkus.io/)**
- **[Quarkus Panache](https://quarkus.io/)**

<br>

## :wrench: Ferramentas

- **[IntelliJ](https://www.jetbrains.com/)**
- **[Insomnia](https://insomnia.rest/)**
- **[Google Chrome](https://www.google.com/chrome/)**

<br>

## :package: Instalação

### :heavy_check_mark: **Pré-requisito**

Instalar os softwares abaixo:

- **[Git](https://git-scm.com/)**
- **[Maven](https://maven.apache.org/)**
- **[Docker](https://www.docker.com/)**
- **[Docker Compose](https://docs.docker.com/compose/install/)**
- **[GraalVM](https://www.graalvm.org/) (Somente no modo desenvolvedor)**

<br>

### :arrow_down: **Clonando o repositório**

```sh
  $ git clone https://github.com/gustavocarvalhoti/quarkus-luiza-labs.git
```

<br>

### :arrow_forward: **Executando a aplicação**

- :package: API

```sh
  $ cd quarkus-luiza-labs
  $ docker-compose up
```

### :arrow_forward: **Executando a aplicação no modo desenvolvedor**

- :package: API

```sh
  $ cd quarkus-luiza-labs
```

#### Configurando no IntelliJ

##### Se você rodou o docker compose antes ele criou o container do MySQL - quarkusluizalabs_mysql-luizalabs_1

```sh
  # Verificar
  $ docker ps -a
  # Se não possui vc pode rodar o seguinte comando:
  $ docker run --name quarkusluizalabs_mysql-luizalabs_1 --network host -e MYSQL_ROOT_PASSWORD=root -d gustavocarvalhoti/luizalabs-db:3
```

##### Apontar para o Java do GraalVM

![img.png](.github/img.png)

##### Alterar o application.properties

![img.png](.github/img_4.png)

##### Iniciar a aplicação

![img_1.png](.github/img_1.png)

##### Utilizei o Maven 3.6.3 para executar todos os comandos

![img_3.png](.github/img_3.png)

##### Gerar a imagem compilada pelo Graal VM, fica muito mais rápido o start do servidor

![img_2.png](.github/img_2.png)


<br>

## :memo: License

This project is under the **MIT** license.