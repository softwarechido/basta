# basta
Example connection DAO/TO pattern using MySQL connector 

build with mvn package

assembly with

mvn assembly:single if you require full jar to run from console

change SERVER, USERNAME, PASSWORD from model/BastaDAO class

`
CREATE TABLE bastapartida (
   letra CHAR(1) NOT NULL,
   nombre VARCHAR(100) NOT NULL,
   apellido VARCHAR(100) NOT NULL,
   florFruto VARCHAR(100) NOT NULL,
   animal VARCHAR(100) NOT NULL
);
`


