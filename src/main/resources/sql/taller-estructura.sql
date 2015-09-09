create table ALUMNO (
    ID bigint auto_increment, 
    NOMBRE varchar(80),
    NRO_LEGAJO int,
    PRIMARY KEY (ID)
);
CREATE TABLE DOCENTE (
    ID bigint auto_increment, 
    NOMBRE varchar(80),
    SALARIO double,
    FECHA_CONTRATACION date,
    PRIMARY KEY (ID)
);
CREATE TABLE CURSO  (
    id bigint auto_increment, 
    NOMBRE varchar(80),
    CREDITOS int,
    ID_DOCENTE int ,
    CREDITOS_REQUERIDOS int,
    CUPO_MAXIMO int,
    TIPO_CURSO char(1) not null,
    FOREIGN KEY (ID_DOCENTE) REFERENCES DOCENTE(ID),
    PRIMARY KEY (ID)
);
CREATE TABLE CURSO_ALUMNO  (
    id bigint auto_increment, 
    ID_CURSO int,
    ID_ALUMNO int, 
    FOREIGN KEY (ID_CURSO) REFERENCES CURSO(ID),
    FOREIGN KEY (ID_ALUMNO) REFERENCES ALUMNO(ID),
    PRIMARY KEY (ID)
);