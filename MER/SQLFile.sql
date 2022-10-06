
CREATE TABLE EVENTO(
	ID_Evento INTEGER NOT NULL AUTO_INCREMENT,
    Nome_Evento VARCHAR(20) NOT NULL,
    Inicio_Evento DATETIME NOT NULL,
    Termino_Evento DATETIME NOT NULL,
    Num_Vagas_Evento INTEGER NOT NULL,
    Vlr_Ingresso_Evento DOUBLE NOT NULL,
    Img_Cartaz_Evento VARCHAR(200) NOT NULL,
    ID_Assentos INTEGER NOT NULL,
    PRIMARY KEY PK_Evento (ID_Evento)
);

CREATE TABLE ASSENTO(
	ID_Assento INTEGER NOT NULL AUTO_INCREMENT,
    Col_Assento INTEGER NOT NULL,
    Fil_Assento INTEGER NOT NULL,
    Situacao_Assento BOOLEAN NOT NULL,
    PRIMARY KEY (ID_Assento)
);

CREATE TABLE EVENTO_ASSENTO(
	FK_Evento INTEGER NOT NULL, 
    FK_Assento INTEGER NOT NULL,
    FOREIGN KEY (FK_Evento) REFERENCES EVENTO (ID_Evento),
    FOREIGN KEY (FK_Assento) REFERENCES ASSENTO (ID_Assento)
);

select * from evento e 
left join evento_assento ea on ea.fk_evento = e.id_evento
left join assento a on a.id_assento = ea.fk_assento












